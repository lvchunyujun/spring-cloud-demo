package com.hexiaofei.sjzclient.service.message.impl.producer;

import com.hexiaofei.sjzclient.service.message.impl.consumer.impl.MailConsumer;
import com.hexiaofei.sjzclient.service.message.impl.consumer.impl.SMSConsumer;
import com.hexiaofei.sjzclient.service.message.impl.model.mail.Mail;
import com.hexiaofei.sjzclient.service.message.impl.model.sms.SMS;
import com.hexiaofei.sjzclient.service.message.impl.queue.MailQueue;
import com.hexiaofei.sjzclient.service.message.impl.queue.SMSQueue;
import com.hexiaofei.sjzclient.utils.BeanFactoryUtil;
import org.apache.log4j.Logger;

public class TaskProducer
{
    private static Logger logger = Logger.getLogger(TaskProducer.class);
    private static Logger loggerMailBefore = Logger.getLogger("mail_before");
    private static Logger loggerSMSBefore = Logger.getLogger("sms_before");

    private static MailQueue normalPriorMailQueue;
    private static MailQueue highPriorMailQueue;

    static
    {
        logger.info("开始初始化存储第三方消息的Queue");
        normalPriorMailQueue = (MailQueue)BeanFactoryUtil.getContext().getBean("normalPriorMailQueue");
        highPriorMailQueue = (MailQueue)BeanFactoryUtil.getContext().getBean("highPriorMailQueue");
        logger.info("初始化存储第三方消息的Queue成功");
        // 检查是否需要启动恢复线程，如果是，那么开始恢复
        
        logger.info("开始启动不包含验证码的线程池");
        RecoverOutHourExecutor.getInstance().startRecover();
        
        logger.info("开始启动Consumer线程池");
        startConsumer();
    }

    /**
     * 启动所有的Consumer线程池
     */
    private static void startConsumer()
    {
        
        logger.info("开始启动普通优先级邮件Consumer线程池");
        // 普通优先级邮件处理线程池
        ((MailConsumer)BeanFactoryUtil.getContext().getBean("normalPriorMailConsumer")).startConsume();
        
        logger.info("开始启动高优先级邮件Consumer线程池");
        ((MailConsumer)BeanFactoryUtil.getContext().getBean("highPriorMailConsumer")).startConsume();

        // 短信处理线程池
        logger.info("开始启动短信Consumer线程池");
        SMSConsumer.getInstance().startConsume();

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ie)
        {
            logger.error("等待线程池启动时发生错误", ie);
        }

    }

    /**
     * 把普通优先级Mail放入待发送的队列中
     * 
     * @param mailToBeSend
     * @param doLog
     *            true表示需要打log。有这个标志位的原因是，正常发送是需要log，但Recover线程调用此方法时，就不能再打log了，否则会造成log中的重复记录
     */
    public static void addNormalPriorMail(Mail mailToBeSend, boolean doLog)
    {
        logger.debug("开始加入普通优先级邮件到队列:"+mailToBeSend);
        normalPriorMailQueue.put(mailToBeSend);
        if (doLog){
            loggerMailBefore.info(mailToBeSend.toJSONString());
        }
    }

    /**
     * 把高优先级Mail放入待发送的队列中
     * 
     * @param mailToBeSend
     * @param doLog
     *            true表示需要打log。
     */
    public static void addHighPriorMail(Mail mailToBeSend, boolean doLog)
    {
        logger.info("开始加入高优先级邮件到队列:"+mailToBeSend);
        highPriorMailQueue.put(mailToBeSend);
        if (doLog)
        {
            loggerMailBefore.info(mailToBeSend.toJSONString());
        }
    }

    /**
     * 把SMS放入待发送队列中
     * 
     * @param smsToBeSend
     * @param doLog
     */
    public static void addSMS(SMS smsToBeSend, boolean doLog)
    {
        logger.debug("开始加入短信到队列:"+smsToBeSend);
        SMSQueue.getInstance().put(smsToBeSend);
        if (doLog)
        {
            loggerSMSBefore.info(smsToBeSend.toJSONString());
        }
    }

}
