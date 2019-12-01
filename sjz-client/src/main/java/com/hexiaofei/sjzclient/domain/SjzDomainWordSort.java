package com.hexiaofei.sjzclient.domain;

import java.util.Date;

public class SjzDomainWordSort {
    /**
     *
     */
    private Integer id;

    /**
     *域名
     */
    private String domainName;

    /**
     *域名URL
     */
    private String domainUrl;

    /**
     *单词代码
     */
    private Integer wordMetaCode;

    /**
     *单词英文
     */
    private String wordMetaEn;

    /**
     *单词中文
     */
    private String wordMetaZh;

    /**
     *单词英文缩写
     */
    private String simpleWordMetaEn;

    /**
     *单词中文缩写
     */
    private String simpleWordMetaZh;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *描述
     */
    private String description;

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
     *域名
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     *域名
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName == null ? null : domainName.trim();
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
     *单词代码
     */
    public Integer getWordMetaCode() {
        return wordMetaCode;
    }

    /**
     *单词代码
     */
    public void setWordMetaCode(Integer wordMetaCode) {
        this.wordMetaCode = wordMetaCode;
    }

    /**
     *单词英文
     */
    public String getWordMetaEn() {
        return wordMetaEn;
    }

    /**
     *单词英文
     */
    public void setWordMetaEn(String wordMetaEn) {
        this.wordMetaEn = wordMetaEn == null ? null : wordMetaEn.trim();
    }

    /**
     *单词中文
     */
    public String getWordMetaZh() {
        return wordMetaZh;
    }

    /**
     *单词中文
     */
    public void setWordMetaZh(String wordMetaZh) {
        this.wordMetaZh = wordMetaZh == null ? null : wordMetaZh.trim();
    }

    /**
     *单词英文缩写
     */
    public String getSimpleWordMetaEn() {
        return simpleWordMetaEn;
    }

    /**
     *单词英文缩写
     */
    public void setSimpleWordMetaEn(String simpleWordMetaEn) {
        this.simpleWordMetaEn = simpleWordMetaEn == null ? null : simpleWordMetaEn.trim();
    }

    /**
     *单词中文缩写
     */
    public String getSimpleWordMetaZh() {
        return simpleWordMetaZh;
    }

    /**
     *单词中文缩写
     */
    public void setSimpleWordMetaZh(String simpleWordMetaZh) {
        this.simpleWordMetaZh = simpleWordMetaZh == null ? null : simpleWordMetaZh.trim();
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
}