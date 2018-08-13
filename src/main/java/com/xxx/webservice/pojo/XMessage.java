package com.xxx.webservice.pojo;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-01
 */
public class XMessage {
    /**
     * 消息id
     */
    private Integer msgId;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 附件1
     */
    private String fileUrl1;

    /**
     * 附件2
     */
    private String fileUrl2;

    /**
     * 消息时间
     */
    private Date msgDatetime;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 发送人
     */
    private String sendUser;

    /**
     * 是否已读1：已读，0：未读
     */
    private Integer isRead;

    /**
     * 是否已审核：1-审核通过，0-审核未通过
     */
    private Integer isPass;

    /**
     * 信息状态：0-草稿箱  1-正式
     */
    private String status;

    /**
     * 发送人头像
     */
    private String sendUserHeadurl;

    /**
     * 发送人昵称
     */
    private String sendUserPicname;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复时间
     */
    private Date replyDatetime;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public String getFileUrl1() {
        return fileUrl1;
    }

    public void setFileUrl1(String fileUrl1) {
        this.fileUrl1 = fileUrl1 == null ? null : fileUrl1.trim();
    }

    public String getFileUrl2() {
        return fileUrl2;
    }

    public void setFileUrl2(String fileUrl2) {
        this.fileUrl2 = fileUrl2 == null ? null : fileUrl2.trim();
    }

    public Date getMsgDatetime() {
        return msgDatetime;
    }

    public void setMsgDatetime(Date msgDatetime) {
        this.msgDatetime = msgDatetime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser == null ? null : sendUser.trim();
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSendUserHeadurl() {
        return sendUserHeadurl;
    }

    public void setSendUserHeadurl(String sendUserHeadurl) {
        this.sendUserHeadurl = sendUserHeadurl == null ? null : sendUserHeadurl.trim();
    }

    public String getSendUserPicname() {
        return sendUserPicname;
    }

    public void setSendUserPicname(String sendUserPicname) {
        this.sendUserPicname = sendUserPicname == null ? null : sendUserPicname.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Date getReplyDatetime() {
        return replyDatetime;
    }

    public void setReplyDatetime(Date replyDatetime) {
        this.replyDatetime = replyDatetime;
    }
}