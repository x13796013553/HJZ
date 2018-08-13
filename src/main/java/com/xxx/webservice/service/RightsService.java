package com.xxx.webservice.service;
/**
 * 权限接口
 *
 * @author Administrator
 */

import java.util.List;

import com.xxx.webservice.pojo.XRights;

public interface RightsService {

    // 根据用户id获取当前用户的权限
    public List<XRights> getRightsByUserId(String userId);

    // 修改当前用户的增删改查条件
    public String updateRightsDetail(String rightsKind, String userId, Integer menuId, Integer status, Integer rightsId);

    // 根据父菜单修改所有权限
    public String updateRightsByParent(String userId, Integer parentId, Integer status);

    // 根据用户id，菜单id，修改一个菜单的增删改查状态
    public String updateRightsOne(String userId, Integer menuId, Integer status);

    // 根据userId，菜单id，权限名，返回是否有这个菜单的权限
    public boolean checkRights(String userId, Integer menuId, String action);

    // 根据权限id获取权限
    public XRights getRightsByRightsId(Integer rightsId);

    // 权限id更新数据
    public String updateRightsByRightsId(String insertRights, String deleteRights, String updateRights, String selectRights, String rightsId);
}
