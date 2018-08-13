package com.xxx.webservice.service;


import com.xxx.webservice.pojo.XGroup;
import com.xxx.webservice.pojo.XUser;

import java.util.List;
import java.util.Map;

/**
 * 分组方法接口
 */
public interface GroupService {

    // 获取分组信息List
    public List<XGroup> getGroupList();

    // 新增
    public Map AddGroup(XGroup group);

    // 根据id获取group对象
    public XGroup getGroupByGroupId(String groupId);

    // 执行编辑
    public Map updateXGroup(XGroup xGroup);

    // 用户查看菜单权限
    public String[] checkSelectGroup(XUser user);

    // 用户新增菜单权限
    public String[] checkAddGroup(XUser user);

    // 用户删除菜单权限
    public String[] checkDeleteGroup(XUser user);

    // 用户修改菜单权限
    public String[] checkUpdateGroup(XUser user);

    // 查看用户是否有某一条件
    public boolean checkUserRights(String userId,Integer menuId,String kind);

    // 删除菜单后对角色的权限进行调整
    public String deleteGroupMenu(Integer menuId);

    // 删除角色
    public Map deleteGroup(String groupId);

}
