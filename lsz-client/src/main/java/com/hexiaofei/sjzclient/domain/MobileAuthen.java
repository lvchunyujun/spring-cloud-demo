package com.hexiaofei.sjzclient.domain;

import java.util.Date;

public class MobileAuthen {
    /**
     *移动认证ID
     */
    private Integer mobileAuthenId;

    /**
     *手机号
     */
    private String mobile;

    /**
     *发送日期
     */
    private Date sendTime;

    /**
     *认证码
     */
    private String validCode;

    /**
     *用户ID
     */
    private Integer userId;

    /**
     *移动认证ID
     */
    public Integer getMobileAuthenId() {
        return mobileAuthenId;
    }

    /**
     *移动认证ID
     */
    public void setMobileAuthenId(Integer mobileAuthenId) {
        this.mobileAuthenId = mobileAuthenId;
    }

    /**
     *手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     *发送日期
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     *发送日期
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     *认证码
     */
    public String getValidCode() {
        return validCode;
    }

    /**
     *认证码
     */
    public void setValidCode(String validCode) {
        this.validCode = validCode == null ? null : validCode.trim();
    }

    /**
     *用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}