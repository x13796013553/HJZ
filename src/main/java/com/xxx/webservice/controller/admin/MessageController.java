package com.xxx.webservice.controller.admin;

import com.xxx.webservice.pojo.XMessage;
import com.xxx.webservice.service.MessageService;
import com.xxx.webservice.utils.ConvertUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/msg")
    public String showMessagePage() {
        return "admin/message";
    }

    @RequestMapping(value = "/msg/getMsgList", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getMsgList(int page, int limit) {
        if (page == 0) {
            page = 1;
        }
        int before = limit * (page - 1);
        int after = limit;
        //带参数从数据库里查询出来放到eilist的集合里
        List<XMessage> msgList = messageService.getMsgPageList(before, after);
        int count = messageService.getMsgCount();
        //用json来传值
        JSONArray json = JSONArray.fromObject(msgList);
        String js = json.toString();
        //*****转为layui需要的json格式，必须要这一步，博主也是没写这一步，在页面上数据就是数据接口异常
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":" + count + ",\"data\":" + js + "}";
        return jso;
    }

    @RequestMapping("/msg/addReply")
    @ResponseBody
    public Map addReply(Integer msgId, String replyContent) {
        XMessage message = new XMessage();
        message.setMsgId(msgId);
        message.setReplyContent(replyContent);
        message.setReplyDatetime(ConvertUtil.getNowDate("yyyy-MM-dd HH:mm:ss"));
        message.setIsRead(1);
        return messageService.updateMessage(message);
    }

    @RequestMapping("/msg/deleteMsg")
    @ResponseBody
    public Map deleteMsg(Integer msgId) {
        // 删除消息
        return messageService.deleteMessage(msgId);
    }

}
