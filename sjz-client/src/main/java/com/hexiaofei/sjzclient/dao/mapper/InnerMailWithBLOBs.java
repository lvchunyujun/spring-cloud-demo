package com.hexiaofei.sjzclient.dao.mapper;


import java.io.Serializable;

public class InnerMailWithBLOBs extends InnerMail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2922610173892577485L;

	/**
     *内容
     */
    private String content;

    /**
     *引用的内容
     */
    private String context;
    
    /**
     * 发件人姓名
     */
    private String sendName;
   
	/**
     * 发送日期(yyyy-mm-dd)
     */
    private String sendDate;
    /**
     *内容
     */
    public String getContent() {
        return content;
    }

    /**
     *内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     *引用的内容
     */
    public String getContext() {
        return context;
    }

    /**
     *引用的内容
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
    /**
     * 发件人姓名
     */
	public String getSendName() {
		return sendName;
	}
	/**
     * 发件人姓名
     */
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	 /**
     * 发送日期(yyyy-mm-dd)
     */
    public String getSendDate() {
		return sendDate;
	}
    /**
     * 发送日期(yyyy-mm-dd)
     */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
}
