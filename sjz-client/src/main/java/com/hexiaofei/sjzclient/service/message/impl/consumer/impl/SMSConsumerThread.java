package com.hexiaofei.sjzclient.service.message.impl.consumer.impl;

import com.hexiaofei.sjzclient.common.CommonDef;
import com.hexiaofei.sjzclient.service.message.impl.adapter.sms.SMSAdapterImpl;
import com.hexiaofei.sjzclient.service.message.impl.model.sms.SMS;
import com.hexiaofei.sjzclient.service.message.impl.queue.SMSQueue;
import org.apache.log4j.Logger;

import java.util.Calendar;

/**
 * 短信的consumer线程，从队列中取待发短信，然后调用adapter发送
 * 
 * 
 */
public class SMSConsumerThread extends Thread
{
    private static Logger logger = Logger.getLogger(SMSConsumerThread.class);
    private static Logger loggerSMSAfterSucc = Logger.getLogger("sms_after_succ");
    private static Logger loggerSMSAfterFail = Logger.getLogger("sms_after_fail");
    private static Logger loggerSMSOutHour = Logger.getLogger("sms_out_hour");

    private int thread_id;
    private SMSAdapterImpl smsAdapter;
    private final static String  VALID_CODE_CONSTANT = "验证码";

    /**
     * 构造函数
     * 
     * @param thread_id
     */
    public SMSConsumerThread(int thread_id, String serialNumber, String key)
    {
        this.thread_id = thread_id;
        if (smsAdapter == null){
            try{
                smsAdapter = new SMSAdapterImpl(serialNumber, key);
                logger.info("短信处理线程 " + thread_id + " 创建成功");
            }catch (Exception e){
                logger.error("创建短信Consumer线程时出错", e);
                this.interrupt();
                return;
            }
        }

    }

    @Override
    public void run()
    {
    	SMS smsFromQueue = (SMS) SMSQueue.getInstance().take();
    	
    	if(smsFromQueue==null){
    		return ;
    	}
        if (canSendSMS(smsFromQueue)){
            
            logger.debug("短信线程" + thread_id + "  从队列取出短信" + smsFromQueue);

            smsAdapter.setSMS(smsFromQueue);

            int result = smsAdapter.send();
            if (result == 0){
                loggerSMSAfterSucc.info(smsFromQueue.toJSONString());
            }else{
                logger.error("发送短信时发生异常,信息码:"+result+"。异常短信id=" + smsFromQueue.getTaskID());
                loggerSMSAfterFail.info(smsFromQueue.toJSONString());
            }
        }else{
            try{
                Thread.sleep(CommonDef.ONE_SECOND * 5);
            }catch (InterruptedException ie){
                logger.error("短信线程暂停时发生异常", ie);
            }
        }
    }

    /**
     * 检查包含验证码的短信是否在发送短信的时间范围之内
     * 
     * @return true 在上午9点到晚上21点之间
     */
    private static boolean canSendSMS(SMS smsFromQueue)
    {
    	if(smsFromQueue.getContent().indexOf(VALID_CODE_CONSTANT)<0){
	        Calendar time = Calendar.getInstance();
	        int currentHour = time.get(Calendar.HOUR_OF_DAY);
	        if (currentHour < SMSConsumer.START_SEND_HOUR || currentHour >= SMSConsumer.END_SEND_HOUR)
	        {
	        	//不包含验证码并且时间不在上午9点到晚上21点之间的短信
	        	logger.info("开始记录时间以外的日志") ;
	        	logger.info("【smsFromQueue.toJSONString()】"+smsFromQueue.toJSONString()) ;
	        	loggerSMSOutHour.info(smsFromQueue.toJSONString());
	        	
	            return false;
	        }else{
	            return true;
	        }
    	
        }else{
		 return true ;
	 }
   }
}
