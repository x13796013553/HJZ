package com.xxx.webservice.pojo;

public class XSingleUrl {
    private String urlId;

    private String urlAddress;

    private String localUrl;

    private String illustrate;

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId == null ? null : urlId.trim();
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress == null ? null : urlAddress.trim();
    }

    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl == null ? null : localUrl.trim();
    }

    public String getIllustrate() {
        return illustrate;
    }

    public void setIllustrate(String illustrate) {
        this.illustrate = illustrate == null ? null : illustrate.trim();
    }
}