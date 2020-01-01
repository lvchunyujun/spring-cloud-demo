package com.hexiaofei.sjzclient.service.message.impl;

import cn.b2m.eucp.client.Client;
import cn.b2m.eucp.client.SingletonClient;
import com.hexiaofei.sjzclient.service.base.BaseService;
import com.hexiaofei.sjzclient.service.message.ISmsService;
import com.hexiaofei.sjzclient.service.message.impl.consumer.impl.SMSConsumer;
import com.hexiaofei.sjzclient.service.message.impl.model.sms.SMS;
import com.hexiaofei.sjzclient.service.message.impl.producer.TaskProducer;
import com.hexiaofei.sjzclient.utils.BeanFactoryUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 向第三方发送消息的接口，短信，请求等
 * 
 * @version 1.0
 */
@Service("smsService")
public class SmsServiceImpl extends BaseService implements ISmsService
{
    private static Logger logger = Logger.getLogger(SmsServiceImpl.class);
    
    /**
     * 增加一个短信到发送队列中，等待被发送
     * 
     * @param mobileNumber
     *            接收人手机号
     * @param smsContent
     *            短信内容
     */
    public void sendSMS(String mobileNumber, String smsContent)
    {
    	if(mobileNumber==null||"".equals(mobileNumber.trim())){
        	return ;
        }
        SMS smsToBeSend = new SMS( mobileNumber, smsContent);
        TaskProducer.addSMS(smsToBeSend, true);
    }

	@Override
	public double getBalance() {
		
		double balance = 0;
		
		SMSConsumer smsConsumer = (SMSConsumer) BeanFactoryUtil.getContext().getBean("smsConsumer");
		try {
//			Client sdkclient = new Client(smsConsumer.getSerialNumber(),smsConsumer.getKey());
			Client sdkclient = SingletonClient.getClient(smsConsumer.getSerialNumber(),smsConsumer.getKey());
			balance = sdkclient.getBalance();
		} catch (Exception e) {
			 logger.error("获取序列号的剩余金额失败");
		}
			
		return balance;
	}
}
