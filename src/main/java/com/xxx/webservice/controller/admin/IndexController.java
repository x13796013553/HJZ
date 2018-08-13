package com.xxx.webservice.controller.admin;

import com.xxx.webservice.interceptor.Auth;
import com.xxx.webservice.pojo.XMenu;
import com.xxx.webservice.pojo.XMessage;
import com.xxx.webservice.pojo.XUser;
import com.xxx.webservice.redis.RedisUtils;
import com.xxx.webservice.service.MenuService;
import com.xxx.webservice.service.MessageService;
import com.xxx.webservice.service.UserService;
import com.xxx.webservice.utils.CookieUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private RedisUtils redisUtils;

    // 后台主页
    @Auth
    @RequestMapping("admin")
    public String showDefaultPage(Model model) {

        String userId = null;
        XUser user = new XUser();
        // 用户id
        if(redisUtils.exists("userId")){
            userId = (String) redisUtils.get("userId");
        }else{
            redisUtils.set("userId",CookieUtil.getCookie("userId"),1l, TimeUnit.HOURS);
            userId = (String) redisUtils.get("userId");
        }

        // 用户信息
        if(redisUtils.exists("user")){
            user = (XUser) redisUtils.get("user");
        }else{
            redisUtils.set("user",userService.getUserByUserId(userId),1l,TimeUnit.HOURS);
            user = (XUser) redisUtils.get("user");
        }

        model.addAttribute("user", user);

        // 获取未读取信息
        model.addAttribute("msgCount",messageService.getUnreadMessage().size());

        return "admin/index";
    }

    @RequestMapping("/login")
    public String showLoginPage() {
        return "admin/login";
    }

    @Auth
    @RequestMapping("/loginOut")
    @ResponseBody
    public Map exitLogin() {
        Map map = new HashMap();
        // 销毁Cookie
        String ret = CookieUtil.removeCookie("userId");
        redisUtils.remove("userId","user","msgCount");
        if(!"1".equalsIgnoreCase(ret)){
            map.put("msg", ret);
            return map;
        }else{
            map.put("status", "1");
            return map;
        }
    }


    //  加载菜单
    @RequestMapping(value = "/loadData",produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String loadIndexPageData() throws Exception{
        String userId = (String) redisUtils.get("userId");

        Map menuMap = menuService.getMenuByUserId(userId);

        if(redisUtils.exists("menuMap")){
            menuMap = (Map) redisUtils.get("menuMap");
        }else {
            redisUtils.set("menuMap",menuService.getMenuByUserId(userId),1l,TimeUnit.MINUTES);
            menuMap = (Map) redisUtils.get("menuMap");
        }

        List<XMenu> plMenu = (ArrayList)menuMap.get("parentList");
        List<XMenu> clMenu = (ArrayList)menuMap.get("childList");

        // 拼接字符串
        String plJson = "{\"data\": [";
        String clJson = "[";
        for (int i = 0; i < plMenu.size(); i++) {
            clJson = "[";
            for (int j = 0; j < clMenu.size(); j++) {
                if(clMenu.get(j).getParentId() == plMenu.get(i).getMenuId()){
                    clJson += "{\"text\":\"" + clMenu.get(j).getMenuName() + "\",\"icon\":\"&#xe621;\",\"href\":\"" + clMenu.get(j).getMenuUrl() + "\" },";
                }
            }
            if(clJson.length() > 2){
                clJson = clJson.substring(0,clJson.length()-1);
            }
            clJson += "]";
            plJson += "{\"text\":\"" + plMenu.get(i).getMenuName() + "\",\"icon\":\"&#xe620;\",\"subset\":" + clJson + "},";
        }
        plJson = plJson.substring(0,plJson.length()-1);
        plJson += "]}";
        plJson = java.net.URLDecoder.decode(plJson , "UTF-8");
        JSONObject postJson=JSONObject.fromObject(plJson);
        return postJson.toString();
    }

}
