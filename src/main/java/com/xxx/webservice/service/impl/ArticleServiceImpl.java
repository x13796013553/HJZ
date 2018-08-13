package com.xxx.webservice.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xxx.webservice.dao.XArticleClassMapper;
import com.xxx.webservice.dao.XArticleMapper;
import com.xxx.webservice.pojo.XArticle;
import com.xxx.webservice.pojo.XArticleClass;
import com.xxx.webservice.pojo.XArticleExample;
import com.xxx.webservice.service.ArticleService;
import com.xxx.webservice.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private XArticleMapper articleMapper;

	@Autowired
	private XArticleClassMapper articleClassMapper;

	// 根据articleId获取整篇文章
	@Override
	public XArticle getArticle(Integer articleId) {
		return articleMapper.selectByPrimaryKey(articleId);
	}

	// 根据articleId增加文章的点击量
	@Override
	public String addArticleHits(String articleId) {
		try {
			// 1.从数据库中取出该条记录
			XArticle article = articleMapper.selectByPrimaryKey(Integer.parseInt(articleId));

			// 2.放置新的点击次数
			article.setHits(article.getHits() + 1);

			// 3.更新数据
			articleMapper.updateByPrimaryKeySelective(article);

			return "1";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	// classId获取所有对应的数据条目数
	@Override
	public Integer getArticleCountByClassId(Integer classId) {
		List<XArticle> xArticles = articleMapper.selectAllArticleByClassId(classId);
		return xArticles.size();
	}

	// 新增文章
	@Override
	public Map addArticle(XArticle article) {
		Map map = new HashMap();
		try{
			if ("".equalsIgnoreCase(article.getCreateDatetime().toString())  || article.getCreateDatetime() == null){
				article.setCreateDatetime(ConvertUtil.getNowDate("yyyy-MM-dd"));
			}
			articleMapper.insertSelective(article);
			map.put("status","1");
			return map;
		}catch (Exception e){
			map.put("msg",e.getMessage());
			return map;
		}
	}

	// 删除文章
	@Override
	public Map deleteArticleByArticleId(Integer articleId) {
		System.out.println(articleId);
		Map map = new HashMap();
		try{
			articleMapper.deleteByPrimaryKey(articleId);
			map.put("status","1");
			return map;
		}catch (Exception e){
			map.put("msg",e.getMessage());
			return map;
		}

	}

	// 获取编辑页面数据
	@Override
	public Map getEditArticleData(Integer articleId) {
		XArticle article = articleMapper.selectByPrimaryKey(articleId);
		// 将类中时间戳转换成时间
		String createDatetime = ConvertUtil.getJavaDateOfString(article.getCreateDatetime(), "yyyy-MM-dd");

		// 获取所有类菜单
		List<XArticleClass> classList = articleClassMapper.selectByExample(null);
		Map map = new HashMap();
		map.put("article",article);
		map.put("classList",classList);
		map.put("createDatetime",createDatetime);
		return map;
	}

	// 更新文章
	@Override
	public Map updateArticleById(XArticle article) {
		Map map = new HashMap();
		try{
			articleMapper.updateByPrimaryKeySelective(article);
			map.put("status","1");
			return map;
		}catch (Exception e){
			map.put("msg",e.getMessage());
			return map;
		}
	}

	// 获取所有文章
	@Override
	public List<XArticle> getAllArticle() {
		List<XArticle> articleList = articleMapper.selectByExample(null);
		return articleList;
	}

	// 根据classId获取所有文章
	@Override
	public List<XArticle> getAllArticleByClassId(Integer classId) {
		List<XArticle> xArticles = articleMapper.selectAllArticleByClassId(classId);
		return xArticles;
	}

	// 根据classId获取所有文章列表
	@Override
	public List<XArticle> getArticleByClassId(Integer before, Integer after, Integer classId) {
		Map map = new HashMap();
		map.put("before",before);
		map.put("after",after);
		map.put("classId",classId);

		List<XArticle> xArticles = articleMapper.selectArticleByPageAndClassId(map);

		return xArticles;
	}

	// 根据classId分页获取所有文章列表
	@Override
	public List<XArticle> getPageArticleByClassId(String classId, Integer page, Integer pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("classId", classId);
		map.put("pageNow", page);
		map.put("pageSize", pageSize);
		map.put("start", (page - 1) * pageSize);

		return articleMapper.selectByPageArticle(map);
	}

}
