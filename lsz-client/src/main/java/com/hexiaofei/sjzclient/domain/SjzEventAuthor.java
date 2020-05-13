package com.hexiaofei.sjzclient.domain;

import java.util.Date;

public class SjzEventAuthor {
    /**
     *
     */
    private Integer id;

    /**
     *事件索引ID
     */
    private Integer eventIndexId;

    /**
     *用户ID（作者）
     */
    private Integer userId;

    /**
     *用户昵称
     */
    private String nickName;

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
     *事件索引ID
     */
    public Integer getEventIndexId() {
        return eventIndexId;
    }

    /**
     *事件索引ID
     */
    public void setEventIndexId(Integer eventIndexId) {
        this.eventIndexId = eventIndexId;
    }

    /**
     *用户ID（作者）
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *用户ID（作者）
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     *用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
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