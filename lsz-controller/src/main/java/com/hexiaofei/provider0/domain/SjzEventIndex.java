package com.hexiaofei.provider0.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SjzEventIndex {
    /**
     *
     */
    private Integer id;

    /**
     *事件发生事件
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
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
     *状态：0:发布，10:待审核(默认)，20:审核通过 30:审核禁止
     */
    private Byte eventState;

    /**
     *创建记录事件
     */
    private Date recordCreateTime;

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
     *状态：0:正常 默认，10:不显示
     */
    public Byte getEventState() {
        return eventState;
    }

    /**
     *状态：0:正常 默认，10:不显示
     */
    public void setEventState(Byte eventState) {
        this.eventState = eventState;
    }

    /**
     *创建记录事件
     */
    public Date getRecordCreateTime() {
        return recordCreateTime;
    }

    /**
     *创建记录事件
     */
    public void setRecordCreateTime(Date recordCreateTime) {
        this.recordCreateTime = recordCreateTime;
    }
}