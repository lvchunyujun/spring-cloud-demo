package com.hexiaofei.sjzclient.dao.mapper;

import java.io.Serializable;
import java.util.Date;

/**
 * 站内信
 * @author hexiaofei
 *
 */
public class InnerMail implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8404341899794828139L;

	/**
     *
     */
    private Integer id;

    /**
     *内容
     */
    private String content;

    /**
     *引用的内容
     */
    private String context;

    /**
     *收件人
     */
    private Integer receiver;

    /**
     *发件人
     */
    private Integer sender;

    /**
     *是否已读，默认否
     */
    private Boolean isread;

    /**
     *是否红旗，默认否
     */
    private Boolean isOutstanding;

    /**
     *站内信类型
     */
    private Short messageType;

    /**
     *
     */
    private Date sendtime;

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
     *收件人
     */
    public Integer getReceiver() {
        return receiver;
    }

    /**
     *收件人
     */
    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    /**
     *发件人
     */
    public Integer getSender() {
        return sender;
    }

    /**
     *发件人
     */
    public void setSender(Integer sender) {
        this.sender = sender;
    }

    /**
     *是否已读，默认否
     */
    public Boolean getIsread() {
        return isread;
    }

    /**
     *是否已读，默认否
     */
    public void setIsread(Boolean isread) {
        this.isread = isread;
    }

    /**
     *是否红旗，默认否
     */
    public Boolean getIsOutstanding() {
        return isOutstanding;
    }

    /**
     *是否红旗，默认否
     */
    public void setIsOutstanding(Boolean isOutstanding) {
        this.isOutstanding = isOutstanding;
    }

    /**
     *站内信类型
     */
    public Short getMessageType() {
        return messageType;
    }

    /**
     *站内信类型
     */
    public void setMessageType(Short messageType) {
        this.messageType = messageType;
    }

    /**
     *
     */
    public Date getSendtime() {
        return sendtime;
    }

    /**
     *
     */
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
}
