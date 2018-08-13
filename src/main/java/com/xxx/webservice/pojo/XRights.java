package com.xxx.webservice.pojo;

import java.util.Date;

public class XRights {
    private Integer rightsId;

    private String userId;

    private Integer menuId;

    private Integer insertRights;

    private Integer deleteRights;

    private Integer updateRights;

    private Integer selectRights;

    private Date lastChangeDatetime;

    private String lastOperateUserid;

    public Integer getRightsId() {
        return rightsId;
    }

    public void setRightsId(Integer rightsId) {
        this.rightsId = rightsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getInsertRights() {
        return insertRights;
    }

    public void setInsertRights(Integer insertRights) {
        this.insertRights = insertRights;
    }

    public Integer getDeleteRights() {
        return deleteRights;
    }

    public void setDeleteRights(Integer deleteRights) {
        this.deleteRights = deleteRights;
    }

    public Integer getUpdateRights() {
        return updateRights;
    }

    public void setUpdateRights(Integer updateRights) {
        this.updateRights = updateRights;
    }

    public Integer getSelectRights() {
        return selectRights;
    }

    public void setSelectRights(Integer selectRights) {
        this.selectRights = selectRights;
    }

    public Date getLastChangeDatetime() {
        return lastChangeDatetime;
    }

    public void setLastChangeDatetime(Date lastChangeDatetime) {
        this.lastChangeDatetime = lastChangeDatetime;
    }

    public String getLastOperateUserid() {
        return lastOperateUserid;
    }

    public void setLastOperateUserid(String lastOperateUserid) {
        this.lastOperateUserid = lastOperateUserid == null ? null : lastOperateUserid.trim();
    }
}