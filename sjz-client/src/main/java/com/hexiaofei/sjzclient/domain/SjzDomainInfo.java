package com.hexiaofei.sjzclient.domain;

import java.util.Date;

public class SjzDomainInfo {
    /**
     *
     */
    private Integer id;

    /**
     *域名名称
     */
    private String domainName;

    /**
     *域名URL
     */
    private String domainUrl;

    /**
     *域名IP
     */
    private String domainIp;

    /**
     *来源:0000
     */
    private String source;
    /**
     * 所属语言：ZH,EN
     */
    private String language;

    /**
     *域名所属类型:0-其他
     */
    private Short type;

    /**
     *当前抓取状态:200-正常，-99：异常
     */
    private Short crawlStatus;

    /**
     *最后抓取时间
     */
    private Date lastCrawlTime;

    /**
     *抓取用时
     */
    private Integer crawlUseTime;

    /**
     *描述
     */
    private String description;

    /**
     *管理状态：0-正常
     */
    private Short manageStatus;

    /**
     *内容评级：0-999999
     */
    private Integer contentLevel;

    /**
     *创建时间
     */
    private Date createTime;

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
     *域名名称
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     *域名名称
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     *域名URL
     */
    public String getDomainUrl() {
        return domainUrl;
    }

    /**
     *域名URL
     */
    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl == null ? null : domainUrl.trim();
    }

    /**
     *域名IP
     */
    public String getDomainIp() {
        return domainIp;
    }

    /**
     *域名IP
     */
    public void setDomainIp(String domainIp) {
        this.domainIp = domainIp == null ? null : domainIp.trim();
    }

    /**
     *来源:0000
     */
    public String getSource() {
        return source;
    }

    /**
     *来源:0000
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     *域名所属类型:0-其他
     */
    public Short getType() {
        return type;
    }

    /**
     *域名所属类型:0-其他
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     *当前抓取状态:0-正常，10：异常
     */
    public Short getCrawlStatus() {
        return crawlStatus;
    }

    /**
     *当前抓取状态:200-正常，-99：异常
     */
    public void setCrawlStatus(Short crawlStatus) {
        this.crawlStatus = crawlStatus;
    }

    /**
     *最后抓取时间
     */
    public Date getLastCrawlTime() {
        return lastCrawlTime;
    }

    /**
     *最后抓取时间
     */
    public void setLastCrawlTime(Date lastCrawlTime) {
        this.lastCrawlTime = lastCrawlTime;
    }

    /**
     *抓取用时
     */
    public Integer getCrawlUseTime() {
        return crawlUseTime;
    }

    /**
     *抓取用时
     */
    public void setCrawlUseTime(Integer crawlUseTime) {
        this.crawlUseTime = crawlUseTime;
    }

    /**
     *描述
     */
    public String getDescription() {
        return description;
    }

    /**
     *描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     *管理状态：0-正常
     */
    public Short getManageStatus() {
        return manageStatus;
    }

    /**
     *管理状态：0-正常
     */
    public void setManageStatus(Short manageStatus) {
        this.manageStatus = manageStatus;
    }

    /**
     *内容评级：0-999999
     */
    public Integer getContentLevel() {
        return contentLevel;
    }

    /**
     *内容评级：0-999999
     */
    public void setContentLevel(Integer contentLevel) {
        this.contentLevel = contentLevel;
    }

    /**
     *创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}