package com.xxx.webservice.service.impl;

import com.xxx.webservice.dao.XArticleClassMapper;
import com.xxx.webservice.dao.XArticleMapper;
import com.xxx.webservice.pojo.*;
import com.xxx.webservice.service.ArticleClassService;
import com.xxx.webservice.service.GroupService;
import com.xxx.webservice.service.UserService;
import com.xxx.webservice.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ArticleClassServiceImpl implements ArticleClassService {

    @Autowired
    private XArticleClassMapper articleClassMapper;

    @Autowired
    private XArticleMapper articleMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    // 根据classId获取类别
    @Override
    public XArticleClass getArticleClass(Integer classId) {
        return articleClassMapper.selectByPrimaryKey(classId);
    }


    // 获取所有class
    @Override
    public List<XArticleClass> getAllArticleClass() {
        return articleClassMapper.selectByExample(null);
    }

    // 新增class
    @Override
    public Map addArticleClass(XArticleClass articleClass) {
        Map map = new HashMap();
        try {
            articleClassMapper.insertSelective(articleClass);
            map.put("status", "1");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
            return map;
        }

    }

    // 根据classId删除分类
    @Override
    public Map deleteArticleClassById(Integer classId, HttpServletRequest request) {
        Map map = new HashMap();
        try {
            // 检查此分类下是否含有子分类
            XArticleClass articleClass = articleClassMapper.selectByPrimaryKey(classId);
            List<XArticleClass> classList = articleClassMapper.selectByExample(null);

            for (XArticleClass ac : classList) {
                if (ac.getParentId() == articleClass.getClassId()) {
                    map.put("msg", "下面还有子分类或文章，请先删除子分类或文章！！！");
                    return map;
                }
            }

            // 先删除文章，再删除分类
            // 根据classId删除文章
            // 删除文章前先删除文章的图片
            List<XArticle> articleList = articleMapper.selectAllArticleByClassId(classId);
            for (XArticle article : articleList) {
                if(article.getLocalUrl() != null && !"".equalsIgnoreCase(article.getLocalUrl())){
                    // 有图片删除图片
                    Integer ret = FileUtil.deleteFile(article.getLocalUrl(), request);
                    if(ret == 2){
                        map.put("msg","此文章中有图片，但是图片没有删除成功");
                    }
                }
                // 删除文章
                articleMapper.deleteByPrimaryKey(article.getArticleId());

            }
            // 删除分类
            articleClassMapper.deleteByPrimaryKey(classId);

            map.put("status","1");
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg",e.getMessage());
            return map;
        }


    }

    // 根据classId获取所有父类
    @Override
    public List<XArticleClass> getAllParentClassByClassId(Integer classId) {
        XArticleClassExample example = new XArticleClassExample();
        XArticleClassExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(classId);
        List<XArticleClass> list = articleClassMapper.selectByExample(example);
        return list;
    }

    // 根据classId获取所有子分类
    @Override
    public List<XArticleClass> getAllChildClass(Integer classId) {
        XArticleClassExample example = new XArticleClassExample();
        XArticleClassExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(classId);
        List<XArticleClass> classList = articleClassMapper.selectByExample(example);
        return classList;
    }

    // 根据用户所拥有的权限获取能看到的文章
    @Override
    public List<XArticleClass> getArticleClassByUserId(String userId) {
        List<XArticleClass> list = new ArrayList<>();
        // 获取当前用户拥有的文章操作权限
        XUser user = userService.getUserByUserId(userId);
        XGroup group = groupService.getGroupByGroupId(user.getGroupId());
        String selectArticle = group.getSelectArticle();
        if(selectArticle != null && !"".equalsIgnoreCase(selectArticle)){
            String[] sas = selectArticle.split(",");
            for (String classId:sas) {
                list.add(articleClassMapper.selectByPrimaryKey(Integer.parseInt(classId)));
            }
            return list;
        }else{
            return null;
        }
    }


}
