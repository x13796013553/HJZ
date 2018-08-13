package com.xxx.webservice.service;

import com.xxx.webservice.pojo.XMessage;

import java.util.List;
import java.util.Map;

public interface MessageService {

    // 新增留言
    public Map addMessage(String message);

    // 获取所有未读信息
    public List<XMessage> getUnreadMessage();

    // 分页获取所有消息
    public List<XMessage> getMsgPageList(Integer before,Integer after);

    // 获取所有消息count
    public Integer getMsgCount();

    // 回复更新留言
    public Map updateMessage(XMessage message);

    // 删除留言
    public Map deleteMessage(Integer msgId);
}
