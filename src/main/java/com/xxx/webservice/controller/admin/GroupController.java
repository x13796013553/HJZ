package com.xxx.webservice.controller.admin;

import com.xxx.webservice.pojo.XArticleClass;
import com.xxx.webservice.pojo.XGroup;
import com.xxx.webservice.pojo.XMenu;
import com.xxx.webservice.service.ArticleClassService;
import com.xxx.webservice.service.GroupService;
import com.xxx.webservice.service.MenuService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限分组控制器
 */
@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private ArticleClassService articleClassService;

    /**
     * 分组页面
     */
    @RequestMapping("/admin/group")
    public String showGroupList(){
        return "admin/group";
    }

    /**
     * 获取分组列表
     */
    @RequestMapping(value = "/group/getGroupList",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getGroupList(){
        List<XGroup> groupList = groupService.getGroupList();
        JSONArray jsonArray = JSONArray.fromObject(groupList);
        String json = jsonArray.toString();
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":\"\",\"data\":"+json+"}";
        return jso;

    }

    // 新增分组页面
    @RequestMapping("/group/addGroup")
    public String addGroup(Model model){
        model.addAttribute("menu",menuService.getAllMenu());
        model.addAttribute("articleClass",articleClassService.getAllArticleClass());

        return "admin/addGroup";
    }

    // 执行新增
    @RequestMapping("/group/exeAddGroup")
    @ResponseBody
    public Map exeAddGroup(XGroup group){
        return groupService.AddGroup(group);
    }

    // 编辑页面
    @RequestMapping("/group/editGroup")
    public String showEditGroupPage(String groupId,Model model){

        model.addAttribute("groupId",groupId);
        return "admin/editGroup";
    }

    // 获取group数据
    @RequestMapping("/group/getGroupById")
    @ResponseBody
    public Map getGroupById(String groupId){
        Map map  = new HashMap();
        XGroup group = groupService.getGroupByGroupId(groupId);
        map.put("group",group);
        // 获取所有菜单信息
        List<XMenu> allMenu = menuService.getAllMenu();
        map.put("menu",allMenu);

        // 获取所有文章分类
        List<XArticleClass> allArticleClass = articleClassService.getAllArticleClass();
        map.put("allArticleClass",allArticleClass);
        return map;
    }

    // 执行编辑
    @RequestMapping("/group/exeEditGroup")
    @ResponseBody
    public Map exeEditGroup(XGroup xGroup){
        return groupService.updateXGroup(xGroup);
    }

    //  获取所有去权限组
    @RequestMapping("/group/getAllGroup")
    @ResponseBody
    public List<XGroup> getAllGroup(){
        return groupService.getGroupList();
    }

    // 删除角色
    @RequestMapping("/group/deleteGroup")
    @ResponseBody
    public Map deleteGroup(String groupId){
        return groupService.deleteGroup(groupId);
    }

}
