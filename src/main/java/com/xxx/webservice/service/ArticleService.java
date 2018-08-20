package com.xxx.webservice.service;

import java.util.List;
import java.util.Map;

import com.xxx.webservice.pojo.XArticle;

import javax.servlet.http.HttpServletRequest;

public interface ArticleService {


    // 根据classId获取所有文章列表
    public List<XArticle> getArticleByClassId(Integer before, Integer after, Integer classId);

    // 根据classId分页获取所有文章列表
    public List<XArticle> getPageArticleByClassId(String classId, Integer page, Integer pageSize);


    // 根据articleId获取整篇文章
    public XArticle getArticle(Integer articleId);

    // 根据articleId增加文章的点击量
    public String addArticleHits(String articleId);

    // classId获取所有对应的数据条目数
    public Integer getArticleCountByClassId(Integer classId);

    // 新增文章
    public Map addArticle(XArticle article);

    // 删除文章
    public Map deleteArticleByArticleId(Integer articleId, HttpServletRequest request);

    // 获取编辑页面数据
    public Map getEditArticleData(Integer articleId);

    // 更新文章
    public Map updateArticleById(XArticle article, HttpServletRequest request);

    // 获取所有文章
    public List<XArticle> getAllArticle();

    // 根据classId获取所有文章
    public List<XArticle> getAllArticleByClassId(Integer classId);


}
