package com.hexiaofei.sjzclient.service.message.impl.model.mail;

import com.hexiaofei.sjzclient.common.EmailSendType;
import com.hexiaofei.sjzclient.service.message.impl.model.ThirdPartyTask;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * 待发送的邮件对象
 * 
 * @version 1.0
 */
public class Mail extends ThirdPartyTask
{
    private static Logger logger = Logger.getLogger(Mail.class);

    private String to;
    private String content;
    private FromAddress from;
    private String subject;
    private EmailSendType type;

    public static final String TO = "To";
    public static final String CONTENT = "Content";
    public static final String SUBJECT = "Subject";
    public static final String TYPE = "Type";

    /**
     * 构造函数
     * 
     * @param to
     *            收件人邮箱
     * @param content
     *            邮件内容
     * @param from
     *            发件人对象
     * @param subject
     *            标题
     * @param type
     *            邮件类型
     */
    public Mail(String to, String content, FromAddress from, String subject, EmailSendType type)
    {
        super();
        this.to = to;
        this.content = content;
        this.from = from;
        this.subject = subject;
        this.type = type;
    }

    /**
     * 构造函数
     * 
     * @param to
     *            收件人邮箱
     * @param content
     *            邮件内容
     * @param from
     *            发件人对象
     * @param subject
     *            标题
     * @param type
     *            邮件类型
     * @param mailID
     *            邮件id
     */
    public Mail(UUID mailID, String to, String content, FromAddress from, String subject, EmailSendType type)
    {
        super(mailID);
        this.to = to;
        this.content = content;
        this.from = from;
        this.subject = subject;
        this.type = type;
    }

    /**
     * @return 收件人邮箱
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return 邮件内容
     */
    public String getContent()
    {
        return content;
    }

    /**
     * @return 发件人对象
     */
    public FromAddress getFrom()
    {
        return from;
    }

    /**
     * @return the subject
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * @return the type
     */
    public EmailSendType getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return "Mail [mailID=" + this.getTaskID() + ", to=" + to + ", subject=" + subject + ", type=" + type + "]";
    }

    /**
     * 把本类中的所有字段生成JSON格式的字符串，作为在Producer中记入log的格式
     * 
     * @return
     */
    public String toJSONString()
    {
        JSONObject jsonObject = new JSONObject();
        try
        {
            jsonObject.put(Mail.TASK_ID, this.getTaskID());
            jsonObject.put(Mail.TYPE, this.getType().name());
            jsonObject.put(Mail.TO, this.getTo());
            jsonObject.put(Mail.SUBJECT, this.getSubject());
            jsonObject.put(Mail.CONTENT, this.getContent());
        }
        catch (JSONException jsone)
        {
            logger.error("把Mail转换成JSON对象时发生错误", jsone);
        }
        return jsonObject.toString();
    }
    
    /**
     * 生成一个不包含邮件内容的JSON字符串
     * @return
     */
    public String toBriefJSONString()
    {
        JSONObject jsonObject = new JSONObject();
        try
        {
            jsonObject.put(Mail.TASK_ID, this.getTaskID());
            jsonObject.put(Mail.TYPE, this.getType().name());
            jsonObject.put(Mail.TO, this.getTo());
            jsonObject.put(Mail.SUBJECT, this.getSubject());
        }
        catch (JSONException jsone)
        {
            logger.error("把Mail转换成JSON对象时发生错误", jsone);
        }
        return jsonObject.toString();
    }
    
    /**
     * 根据一个json格式的字符串，转换成一个Mail对象
     * @param jsonString
     * @return
     * @throws JSONException
     */
    public static Mail fromJSONString(String jsonString) throws JSONException
    {
        JSONObject jsonLine = new JSONObject(jsonString);
        UUID mailID = UUID.fromString(jsonLine.getString(Mail.TASK_ID));
        String to = jsonLine.getString(Mail.TO);

        String content = null;

        if (jsonLine.has(Mail.CONTENT))
        {
            content = jsonLine.getString(Mail.CONTENT);
        }

        String subject = jsonLine.getString(Mail.SUBJECT);
        EmailSendType type = EmailSendType.valueOf(jsonLine.getString(Mail.TYPE));
        return new Mail(mailID, to, content, null, subject, type);
    }
}
