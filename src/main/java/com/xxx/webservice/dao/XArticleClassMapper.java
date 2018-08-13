package com.xxx.webservice.dao;


import com.xxx.webservice.pojo.XArticleClass;
import com.xxx.webservice.pojo.XArticleClassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface XArticleClassMapper {
    int countByExample(XArticleClassExample example);

    int deleteByExample(XArticleClassExample example);

    int deleteByPrimaryKey(Integer classId);

    int insert(XArticleClass record);

    int insertSelective(XArticleClass record);

    List<XArticleClass> selectByExample(XArticleClassExample example);

    XArticleClass selectByPrimaryKey(Integer classId);

    int updateByExampleSelective(@Param("record") XArticleClass record, @Param("example") XArticleClassExample example);

    int updateByExample(@Param("record") XArticleClass record, @Param("example") XArticleClassExample example);

    int updateByPrimaryKeySelective(XArticleClass record);

    int updateByPrimaryKey(XArticleClass record);

}