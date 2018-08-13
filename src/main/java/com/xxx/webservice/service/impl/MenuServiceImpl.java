package com.xxx.webservice.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xxx.webservice.dao.XGroupMapper;
import com.xxx.webservice.dao.XMenuMapper;
import com.xxx.webservice.dao.XRightsMapper;
import com.xxx.webservice.dao.XUserMapper;
import com.xxx.webservice.pojo.*;
import com.xxx.webservice.service.GroupService;
import com.xxx.webservice.service.MenuService;
import com.xxx.webservice.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜单服务管理
 *
 * @author Administrator
 */
@Service
public class MenuServiceImpl implements MenuService {

    // 菜单映射
    @Autowired
    private XMenuMapper menuMapper;

    @Autowired
    private XGroupMapper groupMapper;

    // 用户映射
    @Autowired
    private XUserMapper userMapper;

    @Autowired
    private GroupService groupService;


    // 获取所有菜单
    @Override
    public List<XMenu> getAllMenu() {
        List<XMenu> list = menuMapper.selectByExample(null);
        return list;
    }

    // 获取所有父菜单
    @Override
    public List<XMenu> getAllParentMenu() {
        XMenuExample example = new XMenuExample();
        XMenuExample.Criteria criteria = example.createCriteria();
        criteria.andIsParentEqualTo(true);
        List<XMenu> list = menuMapper.selectByExample(example);
        return list;
    }

    // 获取所有子菜单
    @Override
    public List<XMenu> getAllChildMenu() {
        XMenuExample example = new XMenuExample();
        XMenuExample.Criteria criteria = example.createCriteria();
        criteria.andIsParentEqualTo(false);
        List<XMenu> menuList = menuMapper.selectByExample(example);
        return menuList;
    }

    // 获取一共有多少条菜单
    @Override
    public Integer getMenuCount() {
        XMenuExample example = new XMenuExample();
        int countByExample = menuMapper.countByExample(example);
        return countByExample;
    }

    // 分页获取菜单列表
    @Override
    public List<XMenu> getPageMenuList(Integer before, Integer after, Integer parentId) {
        Map map = new HashMap();
        map.put("before", before);
        map.put("after", after);
        map.put("parentId", parentId);
        List<XMenu> menuList = menuMapper.selectAllMenu(map);

        return menuList;
    }

    // 根据id获取菜单对象
    @Override
    public XMenu getMenuById(Integer id) {
        // 根据id获取菜单对象
        XMenu menu = menuMapper.selectByPrimaryKey(id);
        return menu;
    }

    // 更新菜单icoURL的地址
    @Override
    public String updateIcoUrl(Integer id, String url) {
        try {
            XMenuExample example = new XMenuExample();
            XMenu menu = new XMenu();

            XMenuExample.Criteria criteria = example.createCriteria();
            criteria.andMenuIdEqualTo(id);
            menu.setIconUrl(url);

            menuMapper.updateByExampleSelective(menu, example);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }

    }

    // 更新菜单
    @Override
    public Map updateMenu(XMenu menu) {
        Map map = new HashMap();
        try {
            menuMapper.updateByPrimaryKeySelective(menu);
            map.put("status","1");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
            return map;
        }

    }


    // 根据父菜单id获取所有子菜单
    @Override
    public Integer getChildrenMenus(Integer parentId) {
        XMenuExample example = new XMenuExample();
        XMenuExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        menuMapper.countByExample(example);
        return menuMapper.countByExample(example);
    }

    // 执行新增菜单
    @Override
    public Map addMenu(XMenu menu) {
        Map map = new HashMap<>();
        try {
            // 查看是否有权限
            String userId = CookieUtil.getCookie("userId");

            menu.setLastChangeDatetime(new Date()); // 设置最后修改菜单表时间

            // 新增
            menuMapper.insertReturnMenuId(menu);
            map.put("status", "1");
            return map;
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            return map;
        }

    }

    // 根据用户id获取所有对应权限的菜单
    @Override
    public Map getMenuByUserId(String userId) {
        // 查询用户所有有查询权限的菜单
        XUser user = userMapper.selectByPrimaryKey(userId);
        String[] groups = groupService.checkSelectGroup(user);


        // 循环权限列表,获取所有菜单
        List<XMenu> parentList = new ArrayList<>(); // 父菜单
        List<XMenu> childList = new ArrayList<>();  // 子菜单
        Map map = new HashMap();
        // 查询所有菜单
        List<XMenu> xMenuList = menuMapper.selectByExample(null);
        // 封装
        for (XMenu pm : xMenuList) {
            // 封装父菜单集合
            if (pm.getIsParent() == true) {
                for (String pg : groups) {
                    if (pg.equalsIgnoreCase(pm.getMenuId().toString())) {
                        parentList.add(pm);
                    }
                }
            } else {
                // 封装子菜单
                for (String pg : groups) {
                    if (pg.equalsIgnoreCase(pm.getMenuId().toString())) {
                        childList.add(pm);
                    }
                }
            }
        }

        // 放入map集合中
        map.put("parentList", parentList);
        map.put("childList", childList);

        return map;
    }

    // 删除菜单
    @Override
    public Map deleteMenuByMenuId(Integer menuId) {
        Map map = new HashMap();
        try {
            // 检查是否有权限
            String userId = CookieUtil.getCookie("userId");
            boolean ret = groupService.checkUserRights(userId, menuId, "delete");
            if(ret == true){
                // 检查是否含有子菜单
                XMenuExample example = new XMenuExample();
                XMenuExample.Criteria criteria = example.createCriteria();
                criteria.andParentIdEqualTo(menuId);
                List<XMenu> menus = menuMapper.selectByExample(example);
                if (menus.size() >= 1) {
                    map.put("msg", "有子菜单不能删除，请先删除子菜单");
                    return map;
                } else {
                    // 删除当前菜单
                    menuMapper.deleteByPrimaryKey(menuId);
                    // 删除所有组中的该菜单数据
                    String retGroup = groupService.deleteGroupMenu(menuId);
                    if(!"1".equalsIgnoreCase(retGroup)){
                        map.put("msg","删除失败"+retGroup);
                        return map;
                    }
                    map.put("status", "1");
                    return map;
                }
            }else{
                map.put("msg","您没有权限删除菜单");
                return map;
            }

        } catch (Exception e) {
            map.put("msg", e.getMessage());
            return map;
        }


    }

}
