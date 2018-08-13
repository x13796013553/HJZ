package com.xxx.webservice.dao;

import java.util.List;
import java.util.Map;

import com.xxx.webservice.pojo.XArticle;
import com.xxx.webservice.pojo.XArticleExample;
import org.apache.ibatis.annotations.Param;

public interface XArticleMapper {
    int countByExample(XArticleExample example);

    int deleteByExample(XArticleExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(XArticle record);

    int insertSelective(XArticle record);

    List<XArticle> selectByExample(XArticleExample example);

    XArticle selectByPrimaryKey(Integer articleId);

    int updateByExampleSelective(@Param("record") XArticle record, @Param("example") XArticleExample example);

    int updateByExample(@Param("record") XArticle record, @Param("example") XArticleExample example);

    int updateByPrimaryKeySelective(XArticle record);

    int updateByPrimaryKey(XArticle record);
    
    List<XArticle> selectByQueryString(Map map);
    
    List<XArticle> selectByPageArticle(Map map);

    List<XArticle> selectArticleByPageAndClassId(Map map);

    List<XArticle> selectAllArticleByClassId(Integer classId);
}