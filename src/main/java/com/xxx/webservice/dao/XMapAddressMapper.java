package com.xxx.webservice.dao;

import com.xxx.webservice.pojo.XMapAddress;
import com.xxx.webservice.pojo.XMapAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XMapAddressMapper {
    int countByExample(XMapAddressExample example);

    int deleteByExample(XMapAddressExample example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(XMapAddress record);

    int insertSelective(XMapAddress record);

    List<XMapAddress> selectByExample(XMapAddressExample example);

    XMapAddress selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") XMapAddress record, @Param("example") XMapAddressExample example);

    int updateByExample(@Param("record") XMapAddress record, @Param("example") XMapAddressExample example);

    int updateByPrimaryKeySelective(XMapAddress record);

    int updateByPrimaryKey(XMapAddress record);
}