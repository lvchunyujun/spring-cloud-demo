package com.hexiaofei.sjzclient.service.message.impl.adapter.sms;


import cn.b2m.eucp.client.Client;
import cn.b2m.eucp.client.SingletonClient;
import com.hexiaofei.sjzclient.exception.thirdparty.ThirdPartyException;
import com.hexiaofei.sjzclient.service.message.impl.adapter.ITaskAdapter;
import com.hexiaofei.sjzclient.service.message.impl.model.sms.SMS;
import com.hexiaofei.sjzclient.utils.RegExpValidator;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * 短信发送的适配器
 * 
 * @version 1.0
 */
public class SMSAdapterImpl implements ITaskAdapter
{

    private static Logger logger = Logger.getLogger(SMSAdapterImpl.class);

    private Client smsClient;

    private SMS smsToBeSend;

    /**
     * 短信适配器的构造函数
     * 
     * @param serialNumber
     * @param key
     */
    public SMSAdapterImpl(String serialNumber, String key) throws Exception
    {
        super();
        if (smsClient == null)
        {
            this.initClient(serialNumber, key);
        }
    }

    /**
     * 发送短信
     * @return
     */
    public int send()
    {
    	String to = smsToBeSend.getTo();
    	if (RegExpValidator.IsHandset(to) == false) {
    		logger.info("非法手机号码:" + to );
    		return 1;
    	}
    	int resultId = -1;
		try {
			// 延迟10毫秒发送
			TimeUnit.MILLISECONDS.sleep(10);
			resultId = smsClient.sendSMS(new String[] { to }, smsToBeSend.getContent(),"", 5);
		} catch (Exception e) {
			logger.error("", e);
		}
        return resultId;
    }

    /**
     * 初始化短信客户端
     * 
     * @param serialNumber
     * @param key
     */
    private void initClient(String serialNumber, String key) throws Exception
    {
        logger.info("开始初始化短信Adapter");
        try {
        	/**
        	 *  2013-06-17 短信客户端不用每次都注册，key和password也不是一个东西，在这里不能设置相同
        	 *  2015-6-16 使用单例模式获取客户端对象
        	 */
//        	smsClient = new Client(serialNumber, key);
        	smsClient = SingletonClient.getClient(serialNumber, key);
//        	logger.info("serialNumber:"+serialNumber);
//        	logger.info("key:"+key);
//        	int result = smsClient.registEx("362224");
        } catch (Exception e)
        	//if (result != 0)
        {
           logger.info("短信Adapter初始化失败");
           throw new ThirdPartyException("短信适配器初始化失败, error code <" + e + ">");
        }
        logger.info("短信适配器初始化成功");
    }

    /**
     * @param smsToBeSend
     *            the smsToBeSend to set
     */
    public void setSMS(SMS smsToBeSend)
    {
        this.smsToBeSend = smsToBeSend;
    }
}
