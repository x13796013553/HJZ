package com.xxx.webservice.service.impl;

import com.xxx.webservice.dao.XMessageMapper;
import com.xxx.webservice.pojo.XMessage;
import com.xxx.webservice.pojo.XMessageExample;
import com.xxx.webservice.service.MessageService;
import com.xxx.webservice.utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private XMessageMapper messageMapper;

    @Override
    public Map addMessage(String message) {
        Map map = new HashMap();
        try {
            XMessage msg =  new XMessage();
            msg.setMsgContent(message);
            msg.setIsRead(0);
            msg.setMsgDatetime(ConvertUtil.getNowDate("yyyy-MM-dd HH:mm:ss"));
            messageMapper.insertSelective(msg);
            map.put("status","1");
            return map;
        }catch (Exception e){
            map.put("msg",e.getMessage());
            return map;
        }

    }

    // 获取所有未读信息
    @Override
    public List<XMessage> getUnreadMessage() {
        XMessageExample example = new XMessageExample();
        XMessageExample.Criteria criteria = example.createCriteria();
        criteria.andIsReadEqualTo(0);
        return messageMapper.selectByExample(example);
    }

    // 分页获取所有消息
    @Override
    public List<XMessage> getMsgPageList(Integer before, Integer after) {
        Map map = new HashMap();
        map.put("before",before);
        map.put("after",after);
        return messageMapper.selectMsgPageList(map);
    }

    // 获取所有消息count
    @Override
    public Integer getMsgCount() {
        return messageMapper.countByExample(null);
    }

    // 回复更新留言
    @Override
    public Map updateMessage(XMessage message) {
        Map map = new HashMap();
        try{
            messageMapper.updateByPrimaryKeySelective(message);
            map.put("status","1");
            return map;
        }catch (Exception e){
            map.put("msg",e.getMessage());
            return map;
        }

    }

    // 删除消息
    @Override
    public Map deleteMessage(Integer msgId) {
        Map map  = new HashMap();
        try{
            messageMapper.deleteByPrimaryKey(msgId);
            map.put("status","1");
            return map;
        }catch (Exception e){
            map.put("msg",e.getMessage());
            return map;
        }

    }
}
