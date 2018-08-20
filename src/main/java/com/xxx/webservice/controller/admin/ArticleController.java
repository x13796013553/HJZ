package com.xxx.webservice.controller.admin;

import com.xxx.webservice.pojo.XArticle;
import com.xxx.webservice.pojo.XArticleClass;
import com.xxx.webservice.redis.RedisUtils;
import com.xxx.webservice.service.ArticleClassService;
import com.xxx.webservice.service.ArticleService;
import com.xxx.webservice.utils.ConvertUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 文章管理Controller
@Controller
public class ArticleController {

    @Autowired
    private ArticleClassService articleClassService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private RedisUtils redisUtils;

    // 文章页面
    @RequestMapping("/admin/article")
    public String showArticlePage(Model model, @RequestParam(defaultValue = "1") Integer classId) {
        model.addAttribute("classId", classId);
        return "admin/article";
    }

    // 新增文章列表页面
    @RequestMapping("/article/addArticleClass")
    public String showAddArticleClassPage() {
        return "admin/addArticleClass";
    }

    // 获取所有分类
    @RequestMapping("/article/getAllArticleClass")
    @ResponseBody
    public List<XArticleClass> getAllArticleClass() {
        List<XArticleClass> allArticleClass = articleClassService.getAllArticleClass();
        return allArticleClass;
    }

    // 新增分类
    @RequestMapping("/article/exeAddArticleClass")
    @ResponseBody
    public Map exeAddArticle(XArticleClass articleClass) {
        return articleClassService.addArticleClass(articleClass);
    }

    // 删除分类
    @RequestMapping("/article/deleteArticleClassById")
    @ResponseBody
    public Map deleteArticleClassById(Integer classId, HttpServletRequest request) {
        return articleClassService.deleteArticleClassById(classId, request);
    }

    //获取树的信息
    @RequestMapping("/article/getTree")
    @ResponseBody
    public Map getTreeList() {
        // 获取所有文章类别
        String userId = (String) redisUtils.get("userId");
        List<XArticleClass> allArticleClass = articleClassService.getArticleClassByUserId(userId);
        Map map = new HashMap();
        map.put("list", allArticleClass);
        return map;
    }

    // 获取文章列表
    @RequestMapping(value = "/article/getArticleList", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getArticleList(int page, int limit, Integer classId) {
        int before = limit * (page - 1);
        int after = limit;
        //带参数从数据库里查询出来放到eilist的集合里
        List<XArticle> articleList = articleService.getArticleByClassId(before, after, classId);

        int count = articleService.getArticleCountByClassId(classId);
        //用json来传值
        JSONArray json = JSONArray.fromObject(articleList);
        String js = json.toString();
        //*****转为layui需要的json格式，必须要这一步，博主也是没写这一步，在页面上数据就是数据接口异常
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":" + count + ",\"data\":" + js + "}";
        return jso;
    }

    // 新增文章页面
    @RequestMapping("/article/addArticle")
    public String showAddArticlePage(Integer classId, Model model) {
        model.addAttribute("classId", classId);
        return "admin/addArticle";
    }

    // 执行新增文章
    @RequestMapping("/article/exeAddArticle")
    @ResponseBody
    public Map exeAddArticle(String title, String author, String createDatetime, String articleContent, String ifHref, Integer classId, String titleImage) {
        XArticle article = new XArticle();
        article.setTitle(title);
        article.setAuthor(author);
        article.setCreateDatetime(ConvertUtil.stringConvertToDate(createDatetime, "yyyy-MM-dd"));
        article.setArticleContent(articleContent);
        article.setIfHref(ifHref);
        article.setClassId(classId);
        article.setTitleImage(titleImage);

        return articleService.addArticle(article);
    }

    // 删除文章
    @RequestMapping("/article/deleteArticleById")
    @ResponseBody
    public Map deleteArticleById(Integer articleId, HttpServletRequest request) {
        return articleService.deleteArticleByArticleId(articleId, request);
    }

    // 编辑页面
    @RequestMapping("/article/editArticle")
    public String showEditArticlePage(Integer articleId, Model model) {
        model.addAttribute("articleId", articleId);
        return "admin/editArticle";
    }

    // 获取编辑文章页面 基本信息
    @RequestMapping("/article/getEditArticleData")
    @ResponseBody
    public Map getEditArticleData(Integer articleId) {
        return articleService.getEditArticleData(articleId);
    }

    // 执行编辑
    @RequestMapping("/article/exeEditArticle")
    @ResponseBody
    public Map exeEditArticle(HttpServletRequest request, Integer articleId, String title, String author, String createDatetime, String articleContent, String ifHref, Integer classId, String titleImage) {
        XArticle article = new XArticle();
        article.setArticleId(articleId);
        article.setTitle(title);
        article.setAuthor(author);
        article.setCreateDatetime(ConvertUtil.stringConvertToDate(createDatetime, "yyyy-MM-dd"));
        article.setArticleContent(articleContent);
        article.setIfHref(ifHref);
        article.setClassId(classId);
        article.setTitleImage(titleImage);

        return articleService.updateArticleById(article, request);
    }


}
