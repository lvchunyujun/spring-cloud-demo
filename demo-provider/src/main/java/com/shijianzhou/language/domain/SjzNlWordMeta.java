package com.shijianzhou.language.domain;

import java.util.Date;

public class SjzNlWordMeta {
    /**
     *ID
     */
    private Integer id;

    /**
     *词类编码
     */
    private Integer wordMetaCode;

    /**
     *词类英文名称
     */
    private String wordMetaEn;

    /**
     *词类名称中文
     */
    private String wordMetaZh;

    /**
     *英文名称缩写
     */
    private String simpleWordMetaEn;

    /**
     *中文名称缩写
     */
    private String simpleWordMetaZh;

    /**
     *所属语言ID
     */
    private Integer languageId;

    /**
     *所属语言类型编码
     */
    private String languageTypeCode;

    /**
     *所属父类词类编码
     */
    private Integer parentWordMetaCode;

    /**
     *第几级词类
     */
    private Short level;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *描述
     */
    private String description;

    /**
     *ID
     */
    public Integer getId() {
        return id;
    }

    /**
     *ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *词类编码
     */
    public Integer getWordMetaCode() {
        return wordMetaCode;
    }

    /**
     *词类编码
     */
    public void setWordMetaCode(Integer wordMetaCode) {
        this.wordMetaCode = wordMetaCode;
    }

    /**
     *词类英文名称
     */
    public String getWordMetaEn() {
        return wordMetaEn;
    }

    /**
     *词类英文名称
     */
    public void setWordMetaEn(String wordMetaEn) {
        this.wordMetaEn = wordMetaEn == null ? null : wordMetaEn.trim();
    }

    /**
     *词类名称中文
     */
    public String getWordMetaZh() {
        return wordMetaZh;
    }

    /**
     *词类名称中文
     */
    public void setWordMetaZh(String wordMetaZh) {
        this.wordMetaZh = wordMetaZh == null ? null : wordMetaZh.trim();
    }

    /**
     *英文名称缩写
     */
    public String getSimpleWordMetaEn() {
        return simpleWordMetaEn;
    }

    /**
     *英文名称缩写
     */
    public void setSimpleWordMetaEn(String simpleWordMetaEn) {
        this.simpleWordMetaEn = simpleWordMetaEn == null ? null : simpleWordMetaEn.trim();
    }

    /**
     *中文名称缩写
     */
    public String getSimpleWordMetaZh() {
        return simpleWordMetaZh;
    }

    /**
     *中文名称缩写
     */
    public void setSimpleWordMetaZh(String simpleWordMetaZh) {
        this.simpleWordMetaZh = simpleWordMetaZh == null ? null : simpleWordMetaZh.trim();
    }

    /**
     *所属语言ID
     */
    public Integer getLanguageId() {
        return languageId;
    }

    /**
     *所属语言ID
     */
    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    /**
     *所属语言类型编码
     */
    public String getLanguageTypeCode() {
        return languageTypeCode;
    }

    /**
     *所属语言类型编码
     */
    public void setLanguageTypeCode(String languageTypeCode) {
        this.languageTypeCode = languageTypeCode == null ? null : languageTypeCode.trim();
    }

    /**
     *所属父类词类编码
     */
    public Integer getParentWordMetaCode() {
        return parentWordMetaCode;
    }

    /**
     *所属父类词类编码
     */
    public void setParentWordMetaCode(Integer parentWordMetaCode) {
        this.parentWordMetaCode = parentWordMetaCode;
    }

    /**
     *第几级词类
     */
    public Short getLevel() {
        return level;
    }

    /**
     *第几级词类
     */
    public void setLevel(Short level) {
        this.level = level;
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