package com.xxx.webservice.dao;


import java.util.List;
import java.util.Map;
import com.xxx.webservice.pojo.XMenu;
import com.xxx.webservice.pojo.XMenuExample;
import org.apache.ibatis.annotations.Param;

public interface XMenuMapper {
    int countByExample(XMenuExample example);

    int deleteByExample(XMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(XMenu record);

    int insertSelective(XMenu record);

    List<XMenu> selectByExample(XMenuExample example);

    XMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") XMenu record, @Param("example") XMenuExample example);

    int updateByExample(@Param("record") XMenu record, @Param("example") XMenuExample example);

    int updateByPrimaryKeySelective(XMenu record);

    int updateByPrimaryKey(XMenu record);

    List<XMenu> selectMenusByQueryString(Map map);

    // 查询所有用户
    List<XMenu> selectAllMenu(Map map);

    // 新增菜单，返回menuId
    int insertReturnMenuId(XMenu menu);
}