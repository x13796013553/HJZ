package com.xxx.webservice.dao;


import java.util.List;

import com.xxx.webservice.pojo.XBanner;
import com.xxx.webservice.pojo.XBannerExample;
import org.apache.ibatis.annotations.Param;

public interface XBannerMapper {
    int countByExample(XBannerExample example);

    int deleteByExample(XBannerExample example);

    int deleteByPrimaryKey(Integer bannerId);

    int insert(XBanner record);

    int insertSelective(XBanner record);

    List<XBanner> selectByExample(XBannerExample example);

    XBanner selectByPrimaryKey(Integer bannerId);

    int updateByExampleSelective(@Param("record") XBanner record, @Param("example") XBannerExample example);

    int updateByExample(@Param("record") XBanner record, @Param("example") XBannerExample example);

    int updateByPrimaryKeySelective(XBanner record);

    int updateByPrimaryKey(XBanner record);
}