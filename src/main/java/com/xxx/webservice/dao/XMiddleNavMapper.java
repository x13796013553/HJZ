package com.xxx.webservice.dao;


import java.util.List;

import com.xxx.webservice.pojo.XMiddleNav;
import com.xxx.webservice.pojo.XMiddleNavExample;
import org.apache.ibatis.annotations.Param;

public interface XMiddleNavMapper {
    int countByExample(XMiddleNavExample example);

    int deleteByExample(XMiddleNavExample example);

    int deleteByPrimaryKey(Integer navId);

    int insert(XMiddleNav record);

    int insertSelective(XMiddleNav record);

    List<XMiddleNav> selectByExample(XMiddleNavExample example);

    XMiddleNav selectByPrimaryKey(Integer navId);

    int updateByExampleSelective(@Param("record") XMiddleNav record, @Param("example") XMiddleNavExample example);

    int updateByExample(@Param("record") XMiddleNav record, @Param("example") XMiddleNavExample example);

    int updateByPrimaryKeySelective(XMiddleNav record);

    int updateByPrimaryKey(XMiddleNav record);
}