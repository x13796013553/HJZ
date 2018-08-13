package com.xxx.webservice.controller.admin;

import com.xxx.webservice.interceptor.Auth;
import com.xxx.webservice.pojo.XMenu;
import com.xxx.webservice.service.GroupService;
import com.xxx.webservice.service.MenuService;
import com.xxx.webservice.utils.CookieUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 菜单Controller
@Auth
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private GroupService groupService;

    // 跳转到菜单列表
    @RequestMapping("/admin/menu")
    public String showMenuPage() {
        return "admin/menu";
    }

    // 分页获取菜单数据
    @RequestMapping(value = "/menu/getMenuList", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getMenuList(int page, int limit, Integer parentId) {

        int before = limit * (page - 1);
        int after = limit;
        //带参数从数据库里查询出来放到eilist的集合里
        List<XMenu> menuList = menuService.getPageMenuList(before, after, parentId);
        int count = menuService.getMenuCount();
        //用json来传值
        JSONArray json = JSONArray.fromObject(menuList);
        String js = json.toString();
        //*****转为layui需要的json格式，必须要这一步，博主也是没写这一步，在页面上数据就是数据接口异常
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":" + count + ",\"data\":" + js + "}";
        return jso;
    }

    //获取树的信息
    @RequestMapping(value = "/menu/getTree", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getTreeList() {
        // 获取所有父菜单集合
        List<XMenu> menuList = menuService.getAllParentMenu();
        //用json来传值
        //*****转为layui需要的json格式，必须要这一步，博主也是没写这一步，在页面上数据就是数据接口异常

        String jso = "[";

        for (XMenu menu : menuList) {
            jso += "{\"id\":\"" + menu.getMenuId() + "\",\"name\":\"" + menu.getMenuName()
                    + " <a style='width:40px;font-size:12px;' href='javascript:deleteData(" + menu.getMenuId() + ");'>删除</a>"
                    + " <a style='width:40px;font-size:12px;' href='javascript:editData(" + menu.getMenuId() + ");'>编辑</a>"
                    + "\"},";
        }
        jso = jso.substring(0, jso.length() - 1);
        jso += "]";

        return jso;
    }

    // 弹出新增菜单窗口
    @RequestMapping("/menu/addMenu")
    public String showAddWin() {
        return "admin/addMenu";
    }

    // 获取父菜单
    @RequestMapping("/menu/getParentMenu")
    @ResponseBody
    public List<XMenu> getParentMenu() {
        List<XMenu> parentMenu = menuService.getAllParentMenu();
        return parentMenu;
    }

    // 新增菜单
    @RequestMapping("/menu/exeAddMenu")
    @ResponseBody
    public Map exeAdd(XMenu menu) {
        return menuService.addMenu(menu);
    }

    // 删除菜单
    @RequestMapping("/menu/deleteMenuById")
    @ResponseBody
    public Map deleteMenuById(Integer menuId) {
        // 删除菜单
        return menuService.deleteMenuByMenuId(menuId);
    }

    // 编辑菜单窗口
    @RequestMapping("/menu/editMenu")
    public String showEditMenu(Integer menuId,Model model){
        model.addAttribute("menuId",menuId);
        return "admin/editMenu";
    }

    // 根据menuId获取单个数据用于编辑
    @RequestMapping("/menu/getMenuById")
    @ResponseBody
    public Map getMenuById(Integer menuId){
        Map map = new HashMap();
        XMenu menu = menuService.getMenuById(menuId);
        List<XMenu> parentMenu = menuService.getAllParentMenu();
        map.put("menu",menu);
        map.put("parentMenu",parentMenu);
        return map;
    }

    // 执行编辑
    @RequestMapping("/menu/exeEditMenu")
    @ResponseBody
    public Map exeEditMenu(XMenu menu){
       return menuService.updateMenu(menu);
    }
}
