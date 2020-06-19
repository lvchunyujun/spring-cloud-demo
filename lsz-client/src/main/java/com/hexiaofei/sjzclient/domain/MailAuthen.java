package com.hexiaofei.sjzclient.domain;

import java.util.Date;

public class MailAuthen {
    /**
     *mail认证ID
     */
    private Integer mailAuthenId;

    /**
     *mail
     */
    private String mail;

    /**
     *发送时间
     */
    private Date sendTime;

    /**
     *检验码
     */
    private String validCode;

    /**
     *用户ID
     */
    private Integer userId;

    /**
     *mail认证ID
     */
    public Integer getMailAuthenId() {
        return mailAuthenId;
    }

    /**
     *mail认证ID
     */
    public void setMailAuthenId(Integer mailAuthenId) {
        this.mailAuthenId = mailAuthenId;
    }

    /**
     *mail
     */
    public String getMail() {
        return mail;
    }

    /**
     *mail
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     *发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     *发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     *检验码
     */
    public String getValidCode() {
        return validCode;
    }

    /**
     *检验码
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