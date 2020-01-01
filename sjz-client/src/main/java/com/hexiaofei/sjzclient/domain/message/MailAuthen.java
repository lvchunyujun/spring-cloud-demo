package com.hexiaofei.sjzclient.domain.message;

import java.io.Serializable;
import java.util.Date;

public class MailAuthen implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -767827916621170813L;

	/**
     *
     */
    private Integer mailAuthenId;

    /**
     *邮件地址
     */
    private String mail;

    /**
     *验证发送时间
     */
    private Date sendTime;

    /**
     *验证码
     */
    private String validCode;

    /**
     *用户id
     */
    private Integer userId;

    /**
     *
     */
    public Integer getMailAuthenId() {
        return mailAuthenId;
    }

    /**
     *
     */
    public void setMailAuthenId(Integer mailAuthenId) {
        this.mailAuthenId = mailAuthenId;
    }

    /**
     *邮件地址
     */
    public String getMail() {
        return mail;
    }

    /**
     *邮件地址
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     *验证发送时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     *验证发送时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     *验证码
     */
    public String getValidCode() {
        return validCode;
    }

    /**
     *验证码
     */
    public void setValidCode(String validCode) {
        this.validCode = validCode == null ? null : validCode.trim();
    }

    /**
     *用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
