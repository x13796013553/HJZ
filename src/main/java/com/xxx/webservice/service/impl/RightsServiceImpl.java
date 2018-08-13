package com.xxx.webservice.service.impl;


import com.xxx.webservice.dao.XMenuMapper;
import com.xxx.webservice.dao.XRightsMapper;
import com.xxx.webservice.pojo.XMenu;
import com.xxx.webservice.pojo.XMenuExample;
import com.xxx.webservice.pojo.XRights;
import com.xxx.webservice.pojo.XRightsExample;
import com.xxx.webservice.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 权限Service
 *
 * @author Administrator
 */
@Service
public class RightsServiceImpl implements RightsService {

    @Autowired
    private XRightsMapper rightMapper;

    @Autowired
    private XMenuMapper menuMapper;

    // 根据用户id获取所有该用户的权限
    @Override
    public List<XRights> getRightsByUserId(String userId) {
        XRightsExample example = new XRightsExample();
        XRightsExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<XRights> list = rightMapper.selectByExample(example);
        return list;
    }

    // 修改当前用户的增删改查条件
    @Override
    public String updateRightsDetail(String rightsKind, String userId, Integer menuId, Integer status,
                                     Integer rightsId) {
        try {
            XRights record = new XRights();
            record.setRightsId(rightsId);
            record.setUserId(userId);
            record.setMenuId(menuId);
            if ("insertRights".equalsIgnoreCase(rightsKind)) {
                record.setInsertRights(status);
            } else if ("deleteRights".equalsIgnoreCase(rightsKind)) {
                record.setDeleteRights(status);
            } else if ("updateRights".equalsIgnoreCase(rightsKind)) {
                record.setUpdateRights(status);
            } else if ("selectRights".equalsIgnoreCase(rightsKind)) {
                record.setSelectRights(status);
            }
            rightMapper.updateByPrimaryKeySelective(record);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }

    }

    // 根据父菜单修改所有权限
    @Override
    public String updateRightsByParent(String userId, Integer parentId, Integer status) {
        XMenuExample example = new XMenuExample();
        XRightsExample parentExample = new XRightsExample(); // 父exam
        XRights right = new XRights();
        XRightsExample rightExample = new XRightsExample();
        XRightsExample.Criteria rightCriteria = rightExample.createCriteria(); // 权限rightCriteria
        XMenuExample.Criteria criteria = example.createCriteria(); // 菜单criteria

        try {
            criteria.andParentIdEqualTo(parentId);
            // 1.根据父id获取所有菜单的信息集合
            List<XMenu> menuList = menuMapper.selectByExample(example);
            // 2.循环menuList集合，根据menuid和userId更新所有权限表状态
            for (XMenu xMenu : menuList) {
                right = new XRights();
                right.setDeleteRights(status);
                right.setInsertRights(status);
                right.setUpdateRights(status);
                right.setSelectRights(status);
                rightCriteria.andMenuIdEqualTo(xMenu.getMenuId());

                rightMapper.updateByExampleSelective(right, rightExample);
            }
            // 3.补漏，更新所有parentid的权限
            right = new XRights();
            right.setInsertRights(status);
            right.setDeleteRights(status);
            right.setUpdateRights(status);
            right.setSelectRights(status);
            XRightsExample.Criteria parCriteria = parentExample.createCriteria();
            parCriteria.andMenuIdEqualTo(parentId);
            rightMapper.updateByExampleSelective(right, parentExample);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }

    }

    // 根据用户id，菜单id，修改一个菜单的增删改查状态
    @Override
    public String updateRightsOne(String userId, Integer menuId, Integer status) {
        try {
            XRightsExample example = new XRightsExample();
            XRights right = new XRights();
            XRightsExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            criteria.andMenuIdEqualTo(menuId);
            right.setInsertRights(status);
            right.setDeleteRights(status);
            right.setUpdateRights(status);
            right.setSelectRights(status);
            rightMapper.updateByExampleSelective(right, example);

            // 处理父id：
            // 根据菜单id查询所有父id
            XMenuExample menuExample = new XMenuExample();
            XMenuExample.Criteria menuCriteria = menuExample.createCriteria();
            menuCriteria.andMenuIdEqualTo(menuId);
            List<XMenu> menuList = menuMapper.selectByExample(menuExample);
            // 父id
            Integer parentId = menuList.get(0).getParentId();
            // 父example
            XMenuExample menuExample2 = new XMenuExample();
            XMenuExample.Criteria parentCriteria = menuExample2.createCriteria();
            parentCriteria.andParentIdEqualTo(parentId);
            // 根据parentId查询数据库，看是否只有一条记录
            List<XMenu> parentList = menuMapper.selectByExample(menuExample2);
            // 判断：如果父菜单下只有一个
            if (parentList.size() <= 1) {
                XRightsExample pRightExample = new XRightsExample();
                XRightsExample.Criteria pRightCriteria = pRightExample.createCriteria();
                pRightCriteria.andMenuIdEqualTo(parentId);
                pRightCriteria.andUserIdEqualTo(userId);
                XRights pRight = new XRights();
                pRight.setInsertRights(status);
                pRight.setDeleteRights(status);
                pRight.setUpdateRights(status);
                pRight.setSelectRights(status);

                // 只有一条记录，则把父权限也都改成可用或不可用
                rightMapper.updateByExampleSelective(pRight, pRightExample);
            }
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }

    }

    // 根据userId，菜单id，权限名，返回是否有这个菜单的权限
    @Override
    public boolean checkRights(String userId, Integer menuId, String action) {
        XRightsExample example = new XRightsExample();
        XRightsExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andMenuIdEqualTo(menuId);

        List<XRights> list = rightMapper.selectByExample(example);
        Integer ret;
        action = action.toLowerCase();
        if ("insert".equalsIgnoreCase(action)) {
            ret = list.get(0).getInsertRights();
        } else if ("delete".equalsIgnoreCase(action)) {
            ret = list.get(0).getDeleteRights();
        } else if ("update".equalsIgnoreCase(action)) {
            ret = list.get(0).getUpdateRights();
        } else {
            ret = list.get(0).getSelectRights();
        }

        if (ret == 1) {
            return true;
        } else {
            return false;
        }

    }

    // 根据权限id获取权限
    @Override
    public XRights getRightsByRightsId(Integer rightsId) {
        XRights xRights = rightMapper.selectByPrimaryKey(rightsId);
        return xRights;
    }

    // 权限id更新数据
    @Override
    public String updateRightsByRightsId(String insertRights, String deleteRights, String updateRights, String selectRights, String rightsId) {
        try {
            XRights rights = new XRights();
            rights.setInsertRights(Integer.parseInt(insertRights));
            rights.setDeleteRights(Integer.parseInt(deleteRights));
            rights.setUpdateRights(Integer.parseInt(updateRights));
            rights.setSelectRights(Integer.parseInt(selectRights));
            rights.setRightsId(Integer.parseInt(rightsId));

            rightMapper.updateByPrimaryKeySelective(rights);
            return "1";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
