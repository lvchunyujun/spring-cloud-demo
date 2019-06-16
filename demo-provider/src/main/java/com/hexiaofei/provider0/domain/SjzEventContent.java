package com.hexiaofei.provider0.domain;

import java.util.Date;

public class SjzEventContent {
    /**
     *
     */
    private Integer id;

    /**
     *事件标题
     */
    private String eventTitle;

    /**
     *创建事件
     */
    private Date recordTime;

    /**
     *关联事件上下文ID
     */
    private Integer eventContextId;

    /**
     *事件内容
     */
    private String eventContent;

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
     *事件标题
     */
    public String getEventTitle() {
        return eventTitle;
    }

    /**
     *事件标题
     */
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle == null ? null : eventTitle.trim();
    }

    /**
     *创建事件
     */
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     *创建事件
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    /**
     *关联事件上下文ID
     */
    public Integer getEventContextId() {
        return eventContextId;
    }

    /**
     *关联事件上下文ID
     */
    public void setEventContextId(Integer eventContextId) {
        this.eventContextId = eventContextId;
    }

    /**
     *事件内容
     */
    public String getEventContent() {
        return eventContent;
    }

    /**
     *事件内容
     */
    public void setEventContent(String eventContent) {
        this.eventContent = eventContent == null ? null : eventContent.trim();
    }
}