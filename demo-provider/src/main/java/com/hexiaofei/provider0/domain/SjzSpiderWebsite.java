package com.hexiaofei.provider0.domain;

import java.util.Date;

public class SjzSpiderWebsite {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String websiteUrl;

    /**
     *
     */
    private String websiteTitle;

    /**
     *
     */
    private String websiteDescri;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private String websiteContent;

    /**
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     */
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    /**
     *
     */
    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl == null ? null : websiteUrl.trim();
    }

    /**
     *
     */
    public String getWebsiteTitle() {
        return websiteTitle;
    }

    /**
     *
     */
    public void setWebsiteTitle(String websiteTitle) {
        this.websiteTitle = websiteTitle == null ? null : websiteTitle.trim();
    }

    /**
     *
     */
    public String getWebsiteDescri() {
        return websiteDescri;
    }

    /**
     *
     */
    public void setWebsiteDescri(String websiteDescri) {
        this.websiteDescri = websiteDescri == null ? null : websiteDescri.trim();
    }

    /**
     *
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     */
    public String getWebsiteContent() {
        return websiteContent;
    }

    /**
     *
     */
    public void setWebsiteContent(String websiteContent) {
        this.websiteContent = websiteContent == null ? null : websiteContent.trim();
    }
}