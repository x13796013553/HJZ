package com.xxx.webservice.service;
/**
 * 菜单接口
 *
 * @author Administrator
 */

import java.util.List;
import java.util.Map;

import com.xxx.webservice.pojo.XMenu;

public interface MenuService {

    // 获取所有菜单
    public List<XMenu> getAllMenu();


    // 获取所有父菜单
    public List<XMenu> getAllParentMenu();

    // 获取所有zi子菜单
    public List<XMenu> getAllChildMenu();

  // 获取一共有多少条菜单
    public Integer getMenuCount();

    // 分页获取菜单列表
    public List<XMenu> getPageMenuList(Integer before, Integer after,Integer parentId);

    // 编辑页面
    public XMenu getMenuById(Integer id);

    // 更新数据库icoUrl
    public String updateIcoUrl(Integer id, String url);

    // 更新菜单
    public Map updateMenu(XMenu menu);


    // 根据父菜单id获取所有子菜单
    public Integer getChildrenMenus(Integer parentId);

    // 执行新增菜单
    public Map addMenu(XMenu menu);

    // 根据用户id获取所有对应权限的菜单
    public Map getMenuByUserId(String userId);

    // 删除菜单
    public Map deleteMenuByMenuId(Integer menuId);

}
