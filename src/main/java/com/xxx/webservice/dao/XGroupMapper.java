package com.xxx.webservice.dao;

import com.xxx.webservice.pojo.XGroup;
import com.xxx.webservice.pojo.XGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XGroupMapper {
    int countByExample(XGroupExample example);

    int deleteByExample(XGroupExample example);

    int deleteByPrimaryKey(String groupId);

    int insert(XGroup record);

    int insertSelective(XGroup record);

    List<XGroup> selectByExample(XGroupExample example);

    XGroup selectByPrimaryKey(String groupId);

    int updateByExampleSelective(@Param("record") XGroup record, @Param("example") XGroupExample example);

    int updateByExample(@Param("record") XGroup record, @Param("example") XGroupExample example);

    int updateByPrimaryKeySelective(XGroup record);

    int updateByPrimaryKey(XGroup record);
}