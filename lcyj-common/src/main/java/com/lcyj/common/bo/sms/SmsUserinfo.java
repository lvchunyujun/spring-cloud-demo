package com.lcyj.common.bo.sms;

import java.util.Date;

public class SmsUserinfo {
    /**
     *ID
     */
    private Integer id;

    /**
     *
     */
    private String smsUserId;

    /**
     *用户ID
     */
    private String userId;

    /**
     *用户名称
     */
    private String userName;

    /**
     *用户身份证号
     */
    private String idCard;

    /**
     *用户级别
     */
    private Short userLevel;

    /**
     *email地址
     */
    private String email;

    /**
     *手机号
     */
    private String mobileNo;

    /**
     *email状态：0-正常，10-禁止发送
     */
    private Short emailStatus;

    /**
     *手机号码状态：0-正常，10-禁止发送
     */
    private Short mobileNoStatus;

    /**
     *记录创建日期
     */
    private Date createTime;

    /**
     *平台ID
     */
    private String platformId;

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
     *
     */
    public String getSmsUserId() {
        return smsUserId;
    }

    /**
     *
     */
    public void setSmsUserId(String smsUserId) {
        this.smsUserId = smsUserId == null ? null : smsUserId.trim();
    }

    /**
     *用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     *用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     *用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     *用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     *用户身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     *用户身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     *用户级别
     */
    public Short getUserLevel() {
        return userLevel;
    }

    /**
     *用户级别
     */
    public void setUserLevel(Short userLevel) {
        this.userLevel = userLevel;
    }

    /**
     *email地址
     */
    public String getEmail() {
        return email;
    }

    /**
     *email地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     *手机号
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     *手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    /**
     *email状态：0-正常，10-禁止发送
     */
    public Short getEmailStatus() {
        return emailStatus;
    }

    /**
     *email状态：0-正常，10-禁止发送
     */
    public void setEmailStatus(Short emailStatus) {
        this.emailStatus = emailStatus;
    }

    /**
     *手机号码状态：0-正常，10-禁止发送
     */
    public Short getMobileNoStatus() {
        return mobileNoStatus;
    }

    /**
     *手机号码状态：0-正常，10-禁止发送
     */
    public void setMobileNoStatus(Short mobileNoStatus) {
        this.mobileNoStatus = mobileNoStatus;
    }

    /**
     *记录创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *记录创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *平台ID
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     *平台ID
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId == null ? null : platformId.trim();
    }
}