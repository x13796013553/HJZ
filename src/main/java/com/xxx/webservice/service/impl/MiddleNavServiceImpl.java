package com.xxx.webservice.service.impl;

import java.util.List;

import com.xxx.webservice.dao.XMiddleNavMapper;
import com.xxx.webservice.pojo.XMiddleNav;
import com.xxx.webservice.pojo.XMiddleNavExample;
import com.xxx.webservice.service.MiddleNavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiddleNavServiceImpl implements MiddleNavService {

	@Autowired
	private XMiddleNavMapper middleNavMapper;
	
	@Override
	public List<XMiddleNav> getMiddleNavList() {
		XMiddleNavExample example = new XMiddleNavExample();
		example.setOrderByClause("sort asc");
		return middleNavMapper.selectByExample(example);
	}

}
