package com.hexiaofei.sjzclient.domain;

import java.util.Date;

public class SjzDomainSpiderTask {
    /**
     *
     */
    private Integer id;

    /**
     *任务名称
     */
    private String spiderTaskName;

    /**
     *单词编码
     */
    private Integer wordCode;

    /**
     *外键关联=关联的模板单元表
     */
    private String patternName;

    /**
     *单词英文名称
     */
    private String wordMetaEn;

    /**
     *单词中文名称
     */
    private String wordMetaZh;

    /**
     *任务类型
     */
    private Short spiderTaskType;

    /**
     *任务状态
     */
    private Short spiderTaskStatus;

    /**
     *创建时间
     */
    private Date spiderTaskCreateTime;

    /**
     *任务描述
     */
    private String spiderTaskDescription;

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
     *任务名称
     */
    public String getSpiderTaskName() {
        return spiderTaskName;
    }

    /**
     *任务名称
     */
    public void setSpiderTaskName(String spiderTaskName) {
        this.spiderTaskName = spiderTaskName == null ? null : spiderTaskName.trim();
    }

    /**
     *单词编码
     */
    public Integer getWordCode() {
        return wordCode;
    }

    /**
     *单词编码
     */
    public void setWordCode(Integer wordCode) {
        this.wordCode = wordCode;
    }

    /**
     *外键关联=关联的模板单元表
     */
    public String getPatternName() {
        return patternName;
    }

    /**
     *外键关联=关联的模板单元表
     */
    public void setPatternName(String patternName) {
        this.patternName = patternName == null ? null : patternName.trim();
    }

    /**
     *单词英文名称
     */
    public String getWordMetaEn() {
        return wordMetaEn;
    }

    /**
     *单词英文名称
     */
    public void setWordMetaEn(String wordMetaEn) {
        this.wordMetaEn = wordMetaEn == null ? null : wordMetaEn.trim();
    }

    /**
     *单词中文名称
     */
    public String getWordMetaZh() {
        return wordMetaZh;
    }

    /**
     *单词中文名称
     */
    public void setWordMetaZh(String wordMetaZh) {
        this.wordMetaZh = wordMetaZh == null ? null : wordMetaZh.trim();
    }

    /**
     *任务类型
     */
    public Short getSpiderTaskType() {
        return spiderTaskType;
    }

    /**
     *任务类型
     */
    public void setSpiderTaskType(Short spiderTaskType) {
        this.spiderTaskType = spiderTaskType;
    }

    /**
     *任务状态
     */
    public Short getSpiderTaskStatus() {
        return spiderTaskStatus;
    }

    /**
     *任务状态
     */
    public void setSpiderTaskStatus(Short spiderTaskStatus) {
        this.spiderTaskStatus = spiderTaskStatus;
    }

    /**
     *创建时间
     */
    public Date getSpiderTaskCreateTime() {
        return spiderTaskCreateTime;
    }

    /**
     *创建时间
     */
    public void setSpiderTaskCreateTime(Date spiderTaskCreateTime) {
        this.spiderTaskCreateTime = spiderTaskCreateTime;
    }

    /**
     *任务描述
     */
    public String getSpiderTaskDescription() {
        return spiderTaskDescription;
    }

    /**
     *任务描述
     */
    public void setSpiderTaskDescription(String spiderTaskDescription) {
        this.spiderTaskDescription = spiderTaskDescription == null ? null : spiderTaskDescription.trim();
    }
}