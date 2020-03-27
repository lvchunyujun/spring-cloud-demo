package com.hexiaofei.sjzclient.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SjzEventIndexTemp {
    /**
     *
     */
    private Integer id;

    /**
     *事件发生时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventTime;

    /**
     *主页显示文章索引内容
     */
    private String eventContent;

    /**
     *类型：0:文本 默认，20: 超链接
     */
    private Byte eventType;

    /**
     *状态：-10-排除 10-(同步到事件表待审核状态)
     */
    private Byte eventState;

    /**
     *创建记录事件
     */
    private Date createTime;

    /**
     *模板名称：外键
     */
    private String patternName;

    /**
     *模板单元顺序号：外键
     */
    private Integer unitSerialNo;

    /**
     *内容来源域名地址
     */
    private String domainName;

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
     *事件发生事件
     */
    public Date getEventTime() {
        return eventTime;
    }

    /**
     *事件发生事件
     */
    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    /**
     *主页显示文章索引内容
     */
    public String getEventContent() {
        return eventContent;
    }

    /**
     *主页显示文章索引内容
     */
    public void setEventContent(String eventContent) {
        this.eventContent = eventContent == null ? null : eventContent.trim();
    }

    /**
     *类型：0:文本 默认，20: 超链接
     */
    public Byte getEventType() {
        return eventType;
    }

    /**
     *类型：0:文本 默认，20: 超链接
     */
    public void setEventType(Byte eventType) {
        this.eventType = eventType;
    }

    /**
     *状态：-10-排除 10-(同步到事件表待审核状态)
     */
    public Byte getEventState() {
        return eventState;
    }

    /**
     *状态：-10-排除 10-(同步到事件表待审核状态)
     */
    public void setEventState(Byte eventState) {
        this.eventState = eventState;
    }

    /**
     *创建记录事件
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *创建记录事件
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *模板名称：外键
     */
    public String getPatternName() {
        return patternName;
    }

    /**
     *模板名称：外键
     */
    public void setPatternName(String patternName) {
        this.patternName = patternName == null ? null : patternName.trim();
    }

    /**
     *模板单元顺序号：外键
     */
    public Integer getUnitSerialNo() {
        return unitSerialNo;
    }

    /**
     *模板单元顺序号：外键
     */
    public void setUnitSerialNo(Integer unitSerialNo) {
        this.unitSerialNo = unitSerialNo;
    }

    /**
     *内容来源域名地址
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     *内容来源域名地址
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName == null ? null : domainName.trim();
    }
}