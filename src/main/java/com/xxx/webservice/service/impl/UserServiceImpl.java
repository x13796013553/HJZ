package com.xxx.webservice.service.impl;

import java.net.InetAddress;
import java.util.*;

import com.xxx.webservice.dao.XGroupMapper;
import com.xxx.webservice.dao.XMenuMapper;
import com.xxx.webservice.dao.XRightsMapper;
import com.xxx.webservice.dao.XUserMapper;
import com.xxx.webservice.pojo.*;
import com.xxx.webservice.service.UserService;
import com.xxx.webservice.utils.AddressUtils;
import com.xxx.webservice.utils.IDUtils;
import com.xxx.webservice.utils.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private XUserMapper userMapper;

    @Autowired
    private XGroupMapper groupMapper;

    @Autowired
    private XMenuMapper menuMapper;


    // 查询当前数据库是否有该用户
    @Override
    public String checkUserLogin(String username, String password) {
        try {
            // 加密password，和比较数据库中比较是否一样
            if ("".equalsIgnoreCase(password) || password == null) {
                return "-1";
            }
            String shaPass = SHA256.getSHA256StrJava(password);
            XUser user = new XUser();
            user.setUsername(username);
            user.setPassword(shaPass);
            List<XUser> list = userMapper.selectUserByUsernameAndPassWord(user);

            if (list.isEmpty()) {
                return "-1";
            } else {
                // 返回id,为了把userId存到Cookie中
                return list.get(0).getUserId();
            }
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    // 根据id获取当前用户信息
    @Override
    public XUser getUserByUserId(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    // 根据userId，更新数据库最后登录时间，登录次数等信息
    @Override
    public void updateUserForLogin(XUser user) {
        try {
            userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    // 得到用户一共条数
    @Override
    public Integer getUserCount() {
        XUserExample example = new XUserExample();
        return userMapper.selectAllOfUser().size();
    }

    // 根据当前页数，模糊查询字符串进行查询用户信息，显示在前台
    @Override
    public List<XUser> getPageUserList(Integer before, Integer after) {
        Map map = new HashMap();
        map.put("before", before);
        map.put("after", after);
        List<XUser> userList = userMapper.selectAllUser(map);

        return userList;
    }


    // 新增用户
    @Override
    public Map addUser(XUser user) {
        Map map = new HashMap();
        try{
            user.setUserId(IDUtils.uuid());
            String SHAPass = SHA256.getSHA256StrJava(user.getPassword());
            user.setPassword(SHAPass);
            // 复制权限名称
            XGroup xGroup = groupMapper.selectByPrimaryKey(user.getGroupId());
            user.setGroupName(xGroup.getGroupName());


            userMapper.insert(user);
            map.put("status","1");
            return map;
        }catch (Exception e){
            System.out.println(e.getMessage());
            map.put("msg",e.getMessage());
            return map;
        }


    }

    // 删除用户
    @Override
    public Map deleteUser(String userId) {
        Map map = new HashMap();
        try {
            userMapper.deleteByPrimaryKey(userId);
            map.put("status","1");
            return map;
        } catch (Exception e) {
            map.put("msg",e.getMessage());
            return map;
        }
    }

    // 根据id更改用户数据
    @Override
    public String changeUserByUserId(String userId, String password) {
        try {
            // 选择example，查询当前数据库中是否存在相同用户名
            XUserExample selExample = new XUserExample();
            XUserExample.Criteria selCriteria = selExample.createCriteria();
            selCriteria.andUserIdEqualTo(userId);
            XUser user = new XUser();
            user.setUserId(userId);
            user.setPassword(SHA256.getSHA256StrJava(password));
            // 更新到数据库中
            userMapper.updateByPrimaryKeySelective(user);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }

    }


    // 获取所有用户
    @Override
    public List<XUser> getAllUser() {
        return userMapper.selectAllOfUser();
    }

    // 更新用户信息
    @Override
    public Map updateUser(XUser user) {
        Map map = new HashMap();
        try {
            // 获取原始user数据
            XUser xUser = userMapper.selectByPrimaryKey(user.getUserId());
            // 判断密码是否为空
            if(user.getPassword() != null && !"".equalsIgnoreCase(user.getPassword()) && user.getPassword().length() > 16){
                // 加密新密码
                String shaPass = SHA256.getSHA256StrJava(user.getPassword());
                user.setPassword(shaPass);
            }else{
                // 密码保持不变
                user.setPassword(xUser.getPassword());
            }

            // 权限组赋值
            // 获取权限数据
            XGroup xGroup = groupMapper.selectByPrimaryKey(user.getGroupId());
            user.setGroupId(xGroup.getGroupId());
            user.setGroupName(xGroup.getGroupName());

            userMapper.updateByPrimaryKeySelective(user);
            map.put("status","1");
            return map;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            map.put("msg",e.getMessage());
            return map;
        }
    }
}
