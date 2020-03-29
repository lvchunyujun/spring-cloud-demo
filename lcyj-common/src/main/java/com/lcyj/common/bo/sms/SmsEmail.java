package com.lcyj.common.bo.sms;

import java.util.Date;

/**
 * Email信息：暂不支持模板发送
 */
public class SmsEmail {
    /**
     *
     */
    private Integer id;

    /**
     *用户ID
     */
    private String smsUserId;

    /**
     *toEmail
     */
    private String toEmail;

    /**
     *平台ID
     */
    private String platformId;

    /**
     *平台服务ID
     */
    private String serverId;

    /**
     *fromEmail
     */
    private String fromEmail;

    /**
     *业务类型
     */
    private String emailType;

    /**
     *邮件标题
     */
    private String subject;

    /**
     *邮件内容
     */
    private String content;

    /**
     *附件
     */
    private String enclosure;

    /**
     *发送状态
     */
    private Short sendStatus;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *发送成功时间
     */
    private Date sendTime;

    /**
     *发送次数
     */
    private Integer sendCount;

    /**
     *最后更新时间
     */
    private Date lastUpdateTime;

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
     *用户ID
     */
    public String getSmsUserId() {
        return smsUserId;
    }

    /**
     *用户ID
     */
    public void setSmsUserId(String smsUserId) {
        this.smsUserId = smsUserId == null ? null : smsUserId.trim();
    }

    /**
     *toEmail
     */
    public String getToEmail() {
        return toEmail;
    }

    /**
     *toEmail
     */
    public void setToEmail(String toEmail) {
        this.toEmail = toEmail == null ? null : toEmail.trim();
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

    /**
     *平台服务ID
     */
    public String getServerId() {
        return serverId;
    }

    /**
     *平台服务ID
     */
    public void setServerId(String serverId) {
        this.serverId = serverId == null ? null : serverId.trim();
    }

    /**
     *fromEmail
     */
    public String getFromEmail() {
        return fromEmail;
    }

    /**
     *fromEmail
     */
    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail == null ? null : fromEmail.trim();
    }

    /**
     *业务类型
     */
    public String getEmailType() {
        return emailType;
    }

    /**
     *业务类型
     */
    public void setEmailType(String emailType) {
        this.emailType = emailType == null ? null : emailType.trim();
    }

    /**
     *邮件标题
     */
    public String getSubject() {
        return subject;
    }

    /**
     *邮件标题
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     *邮件内容
     */
    public String getContent() {
        return content;
    }

    /**
     *邮件内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     *附件
     */
    public String getEnclosure() {
        return enclosure;
    }

    /**
     *附件
     */
    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure == null ? null : enclosure.trim();
    }

    /**
     *发送状态
     */
    public Short getSendStatus() {
        return sendStatus;
    }

    /**
     *发送状态
     */
    public void setSendStatus(Short sendStatus) {
        this.sendStatus = sendStatus;
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

    /**
     *发送成功时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     *发送成功时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     *发送次数
     */
    public Integer getSendCount() {
        return sendCount;
    }

    /**
     *发送次数
     */
    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    /**
     *最后更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     *最后更新时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}