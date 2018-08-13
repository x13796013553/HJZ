package com.xxx.webservice.dao;

import java.util.List;
import com.xxx.webservice.pojo.XSingleUrl;
import com.xxx.webservice.pojo.XSingleUrlExample;
import org.apache.ibatis.annotations.Param;

public interface XSingleUrlMapper {
    int countByExample(XSingleUrlExample example);

    int deleteByExample(XSingleUrlExample example);

    int deleteByPrimaryKey(String urlId);

    int insert(XSingleUrl record);

    int insertSelective(XSingleUrl record);

    List<XSingleUrl> selectByExample(XSingleUrlExample example);

    XSingleUrl selectByPrimaryKey(String urlId);

    int updateByExampleSelective(@Param("record") XSingleUrl record, @Param("example") XSingleUrlExample example);

    int updateByExample(@Param("record") XSingleUrl record, @Param("example") XSingleUrlExample example);

    int updateByPrimaryKeySelective(XSingleUrl record);

    int updateByPrimaryKey(XSingleUrl record);
}