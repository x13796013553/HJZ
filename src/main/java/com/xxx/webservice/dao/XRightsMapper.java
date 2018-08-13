package com.xxx.webservice.dao;

import java.util.List;

import com.xxx.webservice.pojo.XRights;
import com.xxx.webservice.pojo.XRightsExample;
import org.apache.ibatis.annotations.Param;

public interface XRightsMapper {
    int countByExample(XRightsExample example);

    int deleteByExample(XRightsExample example);

    int deleteByPrimaryKey(Integer rightsId);

    int insert(XRights record);

    int insertSelective(XRights record);

    List<XRights> selectByExample(XRightsExample example);

    XRights selectByPrimaryKey(Integer rightsId);

    int updateByExampleSelective(@Param("record") XRights record, @Param("example") XRightsExample example);

    int updateByExample(@Param("record") XRights record, @Param("example") XRightsExample example);

    int updateByPrimaryKeySelective(XRights record);

    int updateByPrimaryKey(XRights record);
}