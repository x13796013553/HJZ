package com.xxx.webservice.service.impl;

import com.xxx.webservice.dao.XGroupMapper;
import com.xxx.webservice.dao.XUserMapper;
import com.xxx.webservice.pojo.XGroup;
import com.xxx.webservice.pojo.XUser;
import com.xxx.webservice.service.GroupService;
import com.xxx.webservice.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限分组service层
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private XGroupMapper groupMapper;

    @Autowired
    private XUserMapper userMapper;

    // 获取分组信息List
    @Override
    public List<XGroup> getGroupList() {
        List<XGroup> groupList = groupMapper.selectByExample(null);
        return groupList;
    }

    // 新增
    @Override
    public Map AddGroup(XGroup group) {
        Map map = new HashMap();
        try {
            // 检查权限
            // 执行新增
            group.setGroupId(IDUtils.uuid());
            // 把所有中文逗号全换成英文逗号
            group.setSelectMenu(group.getSelectMenu().replace("，", ","));
            group.setAddMenu(group.getAddMenu().replace("，", ","));
            group.setDeleteMenu(group.getDeleteMenu().replace("，", ","));
            group.setUpdateMenu(group.getUpdateMenu().replace("，", ","));

            groupMapper.insertSelective(group);

            map.put("status", "1");
            return map;
        } catch (Exception e) {
            System.out.println("错误信息" + e.getMessage());
            map.put("msg", e.getMessage());
            return map;
        }

    }

    // 根据id获取group对象
    @Override
    public XGroup getGroupByGroupId(String groupId) {

        try {
            XGroup xGroup = groupMapper.selectByPrimaryKey(groupId);
            return xGroup;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    // 执行编辑
    @Override
    public Map updateXGroup(XGroup xGroup) {
        Map map = new HashMap();

        try {
            xGroup.getSelectMenu().replace("，", ",");
            xGroup.getDeleteMenu().replace("，", ",");
            xGroup.getAddMenu().replace("，", ",");
            xGroup.getUpdateMenu().replace("，", ",");

            groupMapper.updateByPrimaryKeySelective(xGroup);
            map.put("status", "1");
            return map;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            map.put("msg", e.getMessage());
            return map;
        }

    }

    // 用户查看菜单权限
    @Override
    public String[] checkSelectGroup(XUser user) {
        XGroup xGroup = groupMapper.selectByPrimaryKey(user.getGroupId());
        // 查分数组
        String[] groups = xGroup.getSelectMenu().split(",");
        return groups;
    }

    // 用户新增菜单权限
    @Override
    public String[] checkAddGroup(XUser user) {
        XGroup xGroup = groupMapper.selectByPrimaryKey(user.getGroupId());
        // 查分数组
        String[] groups = xGroup.getAddMenu().split(",");
        return groups;
    }

    // 用户删除菜单权限
    @Override
    public String[] checkDeleteGroup(XUser user) {
        XGroup xGroup = groupMapper.selectByPrimaryKey(user.getGroupId());
        // 查分数组
        String[] groups = xGroup.getDeleteMenu().split(",");
        return groups;
    }

    // 用户修改菜单权限
    @Override
    public String[] checkUpdateGroup(XUser user) {
        XGroup xGroup = groupMapper.selectByPrimaryKey(user.getGroupId());
        // 查分数组
        String[] groups = xGroup.getUpdateMenu().split(",");
        return groups;
    }

    // 检查用户是否有某一权限
    @Override
    public boolean checkUserRights(String userId, Integer menuId, String kind) {
        XUser user = userMapper.selectByPrimaryKey(userId);
        XGroup group = groupMapper.selectByPrimaryKey(user.getGroupId());

        if ("SELECT".equalsIgnoreCase(kind.toUpperCase())) {
            // 查询权限
            String[] selectMenu = group.getSelectMenu().split(",");
            for (String select : selectMenu) {
                if (select.equalsIgnoreCase(menuId.toString())) {
                    return true;
                } else {
                    continue;
                }
            }
        } else if ("DELETE".equalsIgnoreCase(kind.toUpperCase())) {
            // 删除权限
            String[] deleteMenu = group.getDeleteMenu().split(",");
            for (String delete : deleteMenu) {
                if (delete.equalsIgnoreCase(menuId.toString())) {
                    return true;
                } else {
                    continue;
                }
            }
        } else if ("ADD".equalsIgnoreCase(kind.toUpperCase())) {
            // 查询权限
            String[] addMenu = group.getAddMenu().split(",");
            for (String add : addMenu) {
                if (add.equalsIgnoreCase(menuId.toString())) {
                    return true;
                } else {
                    continue;
                }
            }
        } else if ("UPDATE".equalsIgnoreCase(kind.toUpperCase())) {
            // 查询权限
            String[] updateMenu = group.getUpdateMenu().split(",");
            for (String update : updateMenu) {
                if (update.equalsIgnoreCase(menuId.toString())) {
                    return true;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    // 删除菜单后对角色的权限进行调整
    @Override
    public String deleteGroupMenu(Integer menuId) {
        // 取出所有的角色
        String Menu = null;
        String[] Array = null;
        String newMenu = null;
        try {
            List<XGroup> list = groupMapper.selectByExample(null);
            for (XGroup group : list) {
                // 查询权限:开始
                Menu = "";
                Array = null;
                newMenu = "";

                Menu = group.getSelectMenu();
                Array = Menu.split(",");
                for (int i = 0; i < Array.length; i++) {
                    if (!menuId.toString().equalsIgnoreCase(Array[i])) {
                        newMenu += Array[i] + ",";
                    }
                }
                newMenu = newMenu.substring(0, newMenu.length() - 1);
                group.setSelectMenu(newMenu);
                // 查询权限：结束

                // 删除权限:开始
                Menu = "";
                Array = null;
                newMenu = "";

                Menu = group.getDeleteMenu();
                Array = Menu.split(",");
                for (int i = 0; i < Array.length; i++) {
                    if (!menuId.toString().equalsIgnoreCase(Array[i])) {
                        newMenu += Array[i] + ",";
                    }
                }
                newMenu = newMenu.substring(0, newMenu.length() - 1);
                group.setDeleteMenu(newMenu);
                // 删除权限：结束

                // 修改权限:开始
                Menu = "";
                Array = null;
                newMenu = "";

                Menu = group.getUpdateMenu();
                Array = Menu.split(",");
                for (int i = 0; i < Array.length; i++) {
                    if (!menuId.toString().equalsIgnoreCase(Array[i])) {
                        newMenu += Array[i] + ",";
                    }
                }
                newMenu = newMenu.substring(0, newMenu.length() - 1);
                group.setUpdateMenu(newMenu);
                // 修改权限：结束

                // 新增权限:开始
                Menu = "";
                Array = null;
                newMenu = "";

                Menu = group.getAddMenu();
                Array = Menu.split(",");
                for (int i = 0; i < Array.length; i++) {
                    if (!menuId.toString().equalsIgnoreCase(Array[i])) {
                        newMenu += Array[i] + ",";
                    }
                }
                newMenu = newMenu.substring(0, newMenu.length() - 1);
                group.setAddMenu(newMenu);
                // 新增权限：结束

                // 更新新的角色
                groupMapper.updateByPrimaryKeySelective(group);

            }
            return "1";

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    // 删除角色
    @Override
    public Map deleteGroup(String groupId) {
        Map map = new HashMap();
        try{
            groupMapper.deleteByPrimaryKey(groupId);
            map.put("status","1");
            return map;
        }catch (Exception e){
            map.put("msg",e.getMessage());
            return map;
        }
    }

}
