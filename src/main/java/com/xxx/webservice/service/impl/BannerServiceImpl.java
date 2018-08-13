package com.xxx.webservice.service.impl;

import java.util.List;
import com.xxx.webservice.dao.XBannerMapper;
import com.xxx.webservice.pojo.XBanner;
import com.xxx.webservice.pojo.XBannerExample;
import com.xxx.webservice.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	private XBannerMapper bannerMapper;
	
	// 获取所有banner图地址
	@Override
	public List<XBanner> getBannerList() {
		XBannerExample example = new XBannerExample();
		example.setOrderByClause("sort asc");
		List<XBanner> list = bannerMapper.selectByExample(example);
		return list;
	}
	
}
