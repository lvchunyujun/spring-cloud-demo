package com.hexiaofei.sjzclient.domain.message;

import java.io.Serializable;
import java.util.Date;

public class MobileAuthen implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8057883119695785980L;

	/**
     *
     */
    private Integer mobileAuthenId;

    /**
     *手机号
     */
    private String mobile;

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
    public Integer getMobileAuthenId() {
        return mobileAuthenId;
    }

    /**
     *
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
