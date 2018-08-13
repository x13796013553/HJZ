package com.xxx.webservice.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.xxx.webservice.pojo.XMenu;
import com.xxx.webservice.pojo.XRights;
import com.xxx.webservice.pojo.XUser;
import com.xxx.webservice.service.GroupService;
import com.xxx.webservice.service.MenuService;
import com.xxx.webservice.service.RightsService;
import com.xxx.webservice.service.UserService;
import com.xxx.webservice.utils.*;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private MenuService menuService;

    // 用户管理页面
    @RequestMapping("admin/user")
    public String showUserPage() {
        return "admin/user";
    }

    // 检查用户登录
    @RequestMapping("login/checkUser")
    @ResponseBody
    public String checkUser(String username, String password, HttpServletRequest request) {
        try {
            String ret = userService.checkUserLogin(username, password);
            String lastAddress;
            System.out.println(ret);
            if (!"-1".equalsIgnoreCase(ret)) {
                // userId保存到cookie中
                CookieUtil.addCookie("userId", ret);

                // 登录次数等数据更新
                XUser user = userService.getUserByUserId(ret);
                user.setLoginTimes(user.getLoginTimes() + 1);
                user.setLastIp(AddressUtils.getIpAddr(request));
                lastAddress = AddressUtils.getAddresses("ip=" + AddressUtils.getIpAddr(request), "GBK");
                System.out.println("ip是:" + AddressUtils.getIpAddr(request));
                user.setLastAddress(lastAddress);

                user.setLastDatetime(ConvertUtil.getNowDate("yyyy-MM-dd HH:mm:ss"));
                userService.updateUserForLogin(user); // 更新，返回1成功，反则返回错误信息
                return "1";
            } else {
                return ret;
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // 获取用户分页列表
    @RequestMapping(value = "/user/getUserList", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getUserList(int page, int limit) {
        if (page == 0) {
            page = 1;
        }
        int before = limit * (page - 1);
        int after = limit;
        //带参数从数据库里查询出来放到eilist的集合里
        List<XUser> userList = userService.getPageUserList(before, after);
        int count = userService.getUserCount();
        //用json来传值
        JSONArray json = JSONArray.fromObject(userList);
        String js = json.toString();
        //*****转为layui需要的json格式，必须要这一步，博主也是没写这一步，在页面上数据就是数据接口异常
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":" + count + ",\"data\":" + js + "}";
        return jso;
    }

    // 新增用户界面
    @RequestMapping("/user/addUser")
    public String showAddUserPage() {
        return "admin/addUser";
    }

    // 新增用户
    @RequestMapping("/user/exeAddUser")
    @ResponseBody
    public Map exeAddUser(XUser user) throws Exception {
        // 获取userId
//        String userId = CookieUtil.getCookie("userId");
        return userService.addUser(user);
    }

    // 跳转到用户权限
    @RequestMapping("user/showUserRights")
    public String showUserRights(String userId) {
        // 把需要修改的userId放到cookie中
        CookieUtil.addCookie("rigUserId", userId);
        return "admin/rights";
    }


    // 根据id获取单个用户信息
    @RequestMapping("user/getUserByUserId")
    @ResponseBody
    public Map getUserByUserId(String userId) {
        Map map = new HashMap<>();
        try {
            XUser user = userService.getUserByUserId(userId);
            // 获取权限组
            map.put("status", "1");
            map.put("group", groupService.getGroupList());
            map.put("user", user);
            return map;
        } catch (Exception e) {
            // TODO: handle exception
            map.put("status", "-1");
            map.put("msg", e.getMessage());
            return map;
        }
    }

    // 执行编辑用户
    @RequestMapping("/user/exeEditUser")
    @ResponseBody
    public Map exeEditUser(XUser user) {
        return userService.updateUser(user);
    }

    // 删除单个用户
    @RequestMapping("/user/deleteUser")
    @ResponseBody
    public Map deleteOneUser(String userId) {
        // 删除用户基本信息
        return userService.deleteUser(userId);
    }


    // 编辑用户页面
    @RequestMapping("/user/editUser")
    public String showEditUserPage(String userId, Model model) {
        model.addAttribute("userId", userId);
        return "admin/editUser";
    }
}
