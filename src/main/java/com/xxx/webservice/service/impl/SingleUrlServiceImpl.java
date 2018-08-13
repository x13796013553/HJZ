package com.xxx.webservice.service.impl;

import java.util.List;

import com.xxx.webservice.dao.XSingleUrlMapper;
import com.xxx.webservice.pojo.XSingleUrl;
import com.xxx.webservice.pojo.XSingleUrlExample;
import com.xxx.webservice.service.SingleUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SingleUrlServiceImpl implements SingleUrlService {

	@Autowired
	private XSingleUrlMapper singleUrlMapper;
	
	
	// 根据说明获取文件
	@Override
	public XSingleUrl getSingleUrlByillustrate(String illustrate) {
		XSingleUrlExample example = new XSingleUrlExample();
		XSingleUrlExample.Criteria criteria = example.createCriteria();
		criteria.andIllustrateEqualTo(illustrate);
		List<XSingleUrl> list = singleUrlMapper.selectByExample(example );
		return list.get(0);
	}

}
