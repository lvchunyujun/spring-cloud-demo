package com.hexiaofei.sjzclient.service.message.impl.model.sms;

import com.hexiaofei.sjzclient.service.message.impl.model.ThirdPartyTask;
import com.hexiaofei.sjzclient.service.message.impl.model.mail.Mail;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * 短信实体类
 * @version 1.0
 */
public class SMS extends ThirdPartyTask {
    
    private static Logger logger = Logger.getLogger(SMS.class);
    
    public static final String TO="To";
    public static final String CONTENT="Content";

    //接收人手机号
    private String to;
    
    //短信内容
    private String content;

    /**
     * 构造函数
     * @param to
     * @param content
     */
    public SMS(String to, String content)
    {
        this.to = to;
        this.content = content;
    }
    

    /**
     * 私有构造函数
     * @param taskID
     * @param to
     * @param content
     */
    private SMS(UUID taskID, String to, String content)
    {
        super(taskID);
        this.to = to;
        this.content = content;
    }



    /**
     * @return 接收人的手机号
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return the content
     */
    public String getContent()
    {
        return content;
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
            jsonObject.put(Mail.TO, this.getTo());
            jsonObject.put(Mail.CONTENT, this.getContent());
        }
        catch (JSONException jsone)
        {
            logger.error("把SMS转换成JSON对象时发生错误", jsone);
        }
        return jsonObject.toString();
    }
    
    /**
     * 根据一个json格式的字符串，转换成一个SMS对象
     * @param jsonString
     * @return
     * @throws JSONException
     */
    public static SMS fromJSONString(String jsonString) throws JSONException
    {
        JSONObject jsonLine = new JSONObject(jsonString);
        UUID mailID = UUID.fromString(jsonLine.getString(SMS.TASK_ID));
        String to = jsonLine.getString(SMS.TO);

        String content = null;
        if (jsonLine.has(SMS.CONTENT))
        {
            content = jsonLine.getString(SMS.CONTENT);
        }
        return new SMS(mailID, to, content);
    }
}
