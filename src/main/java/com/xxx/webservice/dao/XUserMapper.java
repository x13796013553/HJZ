package com.xxx.webservice.dao;

import com.xxx.webservice.pojo.XUser;

import java.util.List;
import java.util.Map;

public interface XUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(XUser record);

    int insertSelective(XUser record);

    XUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(XUser record);

    int updateByPrimaryKey(XUser record);

    // 分页查询
    List<XUser> selectUserByQueryString(Map map);

    // 查询所有用户(有分页)
    List<XUser> selectAllUser(Map map);

    // 查询所有用户
    List<XUser> selectAllOfUser();

    // 根据用户名密码查询当前用户是否存在
    List<XUser> selectUserByUsernameAndPassWord(XUser user);

}