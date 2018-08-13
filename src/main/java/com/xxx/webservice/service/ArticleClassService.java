package com.xxx.webservice.service;

import com.xxx.webservice.pojo.XArticleClass;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ArticleClassService {
	
	
	// 根据classId获取类别
	public XArticleClass getArticleClass(Integer classId);

	// 获取所有class
	public List<XArticleClass> getAllArticleClass();

	// 新增class
	public Map addArticleClass(XArticleClass articleClass);

	// 根据classId删除分类
	public Map deleteArticleClassById(Integer classId, HttpServletRequest request);

	// 根据classId获取所有父类
	public List<XArticleClass> getAllParentClassByClassId(Integer classId);

	// 根据classId获取所有子分类
	public List<XArticleClass> getAllChildClass(Integer classId);

	// 根据用户所拥有的权限获取能看到的文章
	public List<XArticleClass> getArticleClassByUserId(String userId);

}
