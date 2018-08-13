package com.xxx.webservice.controller.web;

import com.xxx.webservice.pojo.XArticle;
import com.xxx.webservice.pojo.XArticleClass;
import com.xxx.webservice.redis.RedisUtils;
import com.xxx.webservice.service.ArticleClassService;
import com.xxx.webservice.service.ArticleService;
import com.xxx.webservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class WebIndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleClassService articleClassService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private RedisUtils redisUtils;

    // 首页
    @RequestMapping("/")
    public String showWebDefaultPage(Model model) {

        // 根据classId获取所有父类是这个分类集合
        List<XArticleClass> articleClassList = new ArrayList<>();
        List<XArticle> articleList = new ArrayList<>();
        List<XArticleClass> cyzy = new ArrayList<>(); // 常用资源
        List<XArticleClass> zrtsg = new ArrayList<>(); // 真人图书馆
        List<XArticle> xnjg = new ArrayList<>();
        List<XArticle> xwjg = new ArrayList<>();
        List<XArticle> yxlj = new ArrayList<>();
        List<XArticle> yqlj = new ArrayList<>();
        List<XArticle> tzgg = new ArrayList<>();
        List<XArticle> zydt = new ArrayList<>();

        try {
            boolean exists = redisUtils.exists("articleClassList");
            if (exists == true) {
                // 存在
                articleClassList = (List<XArticleClass>) redisUtils.get("articleClassList");
                articleList = (List<XArticle>) redisUtils.get("articleList");
                System.out.println("已经从缓存中取出数据");
            } else {
                // 不存在
                articleClassList = articleClassService.getAllArticleClass();
                articleList = articleService.getAllArticle();
                redisUtils.set("articleClassList", articleClassList, 5l, TimeUnit.MINUTES);
                redisUtils.set("articleList", articleList, 5l, TimeUnit.MINUTES);
                System.out.println("正在存储数据到缓存中。。。。。。,保存时间为5分钟");
            }

            // 常用资源
            for (int i = 0; i < articleClassList.size(); i++) {
                if (articleClassList.get(i).getParentId() == 14) {
                    cyzy.add(articleClassList.get(i));
                } else if (articleClassList.get(i).getParentId() == 20) {
                    zrtsg.add(articleClassList.get(i));
                }
            }

            for (XArticle article : articleList) {
                if (article.getClassId() == 26) {
                    xnjg.add(article);
                } else if (article.getClassId() == 27) {
                    xwjg.add(article);
                } else if (article.getClassId() == 28) {
                    yxlj.add(article);
                } else if (article.getClassId() == 29) {
                    yqlj.add(article);
                } else if (article.getClassId() == 30) {
                    tzgg.add(article);
                } else if (article.getClassId() == 31) {
                    zydt.add(article);
                }
            }

            model.addAttribute("cyzy", cyzy);
            model.addAttribute("zrtsg", zrtsg);

            // 获取所有文章
            model.addAttribute("xnjg", xnjg);
            model.addAttribute("xwjg", xwjg);
            model.addAttribute("yxlj", yxlj);
            model.addAttribute("yqlj", yqlj);
            model.addAttribute("tzgg", tzgg);
            model.addAttribute("zydt", zydt);

            return "web/index";
        } catch (Exception e) {
            System.out.println("首页TMD出问题了！！！" + e.getMessage());
            return "web/index";
        }

    }

    // 三级页面
    @RequestMapping("web/detail")
    public String showCenterPage(Model model, Integer articleId) {
        XArticle article = articleService.getArticle(articleId);
        model.addAttribute("content", article);
        model.addAttribute("title", articleClassService.getArticleClass(article.getClassId()).getClassName());
        return "web/detail";
    }

    // 二级分类页面
    @RequestMapping("web/class")
    public String showClassPage(Model model, Integer classId) {
        model.addAttribute("classId", classId);
        model.addAttribute("title", articleClassService.getArticleClass(classId).getClassName());
        return "web/class";
    }

    // 分页获取二级数据
    @RequestMapping("web/getClassPage")
    @ResponseBody
    public Map getClassPage(Integer pageNow, Integer pageSize, Integer classId) {
        Integer before = (pageNow - 1) * pageSize;

        List<XArticle> articleList = articleService.getArticleByClassId(before, pageSize, classId);
        Map map = new HashMap();
        map.put("articleList", articleList);
        // 计算一共页数
        // 获取次分类下一共多少数据
        List<XArticle> list = articleService.getAllArticleByClassId(classId);
        Integer pageCount = 1;
        if (list.size() % pageSize == 0) {
            pageCount = list.size() / pageSize;
        } else {
            pageCount = (list.size() / pageSize) + 1;
        }
        map.put("pageCount", pageCount);

        return map;
    }

    // 获取所有分页信息
    @RequestMapping("web/getArticleAllCount")
    @ResponseBody
    public Map getArticleAll(Integer classId) {
        Map map = new HashMap();
        map.put("Count", articleService.getArticleCountByClassId(classId));
        return map;
    }

    // 二级分类页面
    @RequestMapping("web/class-2")
    public String showClassOrDetailPage(Model model, Integer parentId, Integer classId) {


        List<XArticleClass> classList = articleClassService.getAllChildClass(parentId);
        if (classId == null || classId == 0) {
            classId = classList.get(0).getClassId();
        }

        // 获取此分类文章数据
        List<XArticle> xArticleList = articleService.getAllArticleByClassId(classId);

        model.addAttribute("title", articleClassService.getArticleClass(parentId).getClassName());
        model.addAttribute("classId", classId);
        model.addAttribute("classList", classList);
        if (!xArticleList.isEmpty()) {
            model.addAttribute("content", xArticleList.get(0));
        }

        model.addAttribute("articleCount", xArticleList.size());
        model.addAttribute("parentId", parentId);

        return "web/class-2";
    }

    // 三级页面-2
    @RequestMapping("web/detail2")
    public String showDetail2Page(Model model, Integer parentId, Integer classId, Integer articleId) {

        List<XArticleClass> classList = articleClassService.getAllChildClass(parentId);
        if (classId == null || classId == 0) {
            classId = classList.get(0).getClassId();
        }

        // 获取此分类文章数据
        XArticle article = articleService.getArticle(articleId);

        model.addAttribute("content", article);
        model.addAttribute("title", articleClassService.getArticleClass(parentId).getClassName());
        model.addAttribute("classId", classId);
        model.addAttribute("classList", classList);
        model.addAttribute("parentId", parentId);

        return "web/detail-2";
    }

    // 留言
    @RequestMapping("web/message")
    public String showMessagePage(Model model) {
        model.addAttribute("title", "在线沟通");
        return "web/message";
    }

    // 提交留言
    @RequestMapping("web/addMessage")
    @ResponseBody
    public Map addMessage(String message) {
        return messageService.addMessage(message);
    }
}
