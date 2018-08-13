package com.xxx.webservice.service;

import java.util.List;
import java.util.Map;

import com.xxx.webservice.pojo.XMenu;
import com.xxx.webservice.pojo.XUser;

/**
 * 用户管理接口
 *
 * @author Administrator
 */
public interface UserService {

    // 获取所有用户信息
    public List<XUser> getAllUser();

    // 查询当前数据库中是否有该用户
    public String checkUserLogin(String username, String password);

    // 根据id查询用户信息
    public XUser getUserByUserId(String userId);

    // 根据userId，更新数据库最后登录时间，登录次数等信息
    public void updateUserForLogin(XUser user);


    // 获取一共有多少条用户数据
    public Integer getUserCount();

    // 根据当前页数，模糊查询字符串进行查询用户信息，显示在前台
    public List<XUser> getPageUserList(Integer before, Integer after);

    // 新增用户
    public Map addUser(XUser user);

    // 根据id删除用户信息
    public Map deleteUser(String userId);

    // 根据id更改用户数据
    public String changeUserByUserId(String userId, String password);

    // 更新用户信息
    public Map updateUser(XUser user);
}
