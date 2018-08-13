package com.xxx.webservice.pojo;

public class XMiddleNav {
    private Integer navId;

    private String navName;

    private String imgUrl;

    private String navUrl;

    private Integer sort;

    private String imgLocalUrl;

    public Integer getNavId() {
        return navId;
    }

    public void setNavId(Integer navId) {
        this.navId = navId;
    }

    public String getNavName() {
        return navName;
    }

    public void setNavName(String navName) {
        this.navName = navName == null ? null : navName.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getNavUrl() {
        return navUrl;
    }

    public void setNavUrl(String navUrl) {
        this.navUrl = navUrl == null ? null : navUrl.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getImgLocalUrl() {
        return imgLocalUrl;
    }

    public void setImgLocalUrl(String imgLocalUrl) {
        this.imgLocalUrl = imgLocalUrl == null ? null : imgLocalUrl.trim();
    }
}