package com.hexiaofei.sjzclient.service.message;

public interface ISmsService {
    /**
     * 增加一个短信到发送队列中，等待被发送
     * 
     * @param mobileNumber
     *            接收人手机号
     * @param smsContent
     *            短信内容
     */
    public void sendSMS(String mobileNumber, String smsContent);
    
    /**
     * 获得序列号的剩余金额
     *
     * @return
     * @return double
     * 
     */
    public double getBalance();
}

