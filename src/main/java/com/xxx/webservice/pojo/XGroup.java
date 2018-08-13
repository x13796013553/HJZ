package com.xxx.webservice.pojo;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-07
 */
public class XGroup {
    /**
     * 组id
     */
    private String groupId;

    /**
     * 组名称
     */
    private String groupName;

    /**
     * 查询权限菜单集合
     */
    private String selectMenu;

    /**
     * 新增权限菜单集合
     */
    private String addMenu;

    /**
     * 删除权限菜单集合
     */
    private String deleteMenu;

    /**
     * 更新权限菜单集合
     */
    private String updateMenu;

    /**
     * 能查询的文章集合
     */
    private String selectArticle;

    /**
     * 新增文章集合
     */
    private String addArticle;

    /**
     * 能删除文章集合
     */
    private String deleteArticle;

    /**
     * 修改文章集合
     */
    private Date updateArticle;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getSelectMenu() {
        return selectMenu;
    }

    public void setSelectMenu(String selectMenu) {
        this.selectMenu = selectMenu == null ? null : selectMenu.trim();
    }

    public String getAddMenu() {
        return addMenu;
    }

    public void setAddMenu(String addMenu) {
        this.addMenu = addMenu == null ? null : addMenu.trim();
    }

    public String getDeleteMenu() {
        return deleteMenu;
    }

    public void setDeleteMenu(String deleteMenu) {
        this.deleteMenu = deleteMenu == null ? null : deleteMenu.trim();
    }

    public String getUpdateMenu() {
        return updateMenu;
    }

    public void setUpdateMenu(String updateMenu) {
        this.updateMenu = updateMenu == null ? null : updateMenu.trim();
    }

    public String getSelectArticle() {
        return selectArticle;
    }

    public void setSelectArticle(String selectArticle) {
        this.selectArticle = selectArticle == null ? null : selectArticle.trim();
    }

    public String getAddArticle() {
        return addArticle;
    }

    public void setAddArticle(String addArticle) {
        this.addArticle = addArticle == null ? null : addArticle.trim();
    }

    public String getDeleteArticle() {
        return deleteArticle;
    }

    public void setDeleteArticle(String deleteArticle) {
        this.deleteArticle = deleteArticle == null ? null : deleteArticle.trim();
    }

    public Date getUpdateArticle() {
        return updateArticle;
    }

    public void setUpdateArticle(Date updateArticle) {
        this.updateArticle = updateArticle;
    }
}