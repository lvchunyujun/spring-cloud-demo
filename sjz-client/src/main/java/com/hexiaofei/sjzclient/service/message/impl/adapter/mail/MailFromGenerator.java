package com.hexiaofei.sjzclient.service.message.impl.adapter.mail;


import com.hexiaofei.sjzclient.common.CommonDef;
import com.hexiaofei.sjzclient.service.message.impl.model.mail.FromAddress;

/**
 * 发件人的生成器，根据从配置文件读到的发件人列表，随机返回一个发件人信息，避免一个帐号发的邮件过多
 * 
 */
public class MailFromGenerator
{
    // 发件人池子列表
    // private static List<FromAddress> fromAddressList;

    // smtp服务器列表
    // private static List<SmtpServer> smtpList;

    // 初始化发件人池子的定时器
    // private static final Timer initFromAddressListimer = new Timer();

    // private static Random random;

    /**
     * 初始化
     */
    static
    {
        // if (fromAddressList == null)
        // {
        // fromAddressList = MailFromXMLParser.getFromAddressList();
        // }
        //
        // if (smtpList == null)
        // {
        // smtpList = MailFromXMLParser.getSmtpList();
        // }
        //
        // if (random == null)
        // {
        // random = new Random();
        // }
        //
        // // 初始化邮件列表,每10分钟初始化一次
        // initFromAddressListimer.schedule(new FromAddressListInitTask(),
        // TimeDef.ONE_MINUTE * 10, TimeDef.ONE_HOUR *
        // 12);
    }

    /**
     * 随机从缓存的fromAddressList中取一个发件人信息
     * 
     * @return
     */
    public static FromAddress getRandomFromAddress()
    {
        // FromAddress fromAddress =
        // fromAddressList.get(random.nextInt(fromAddressList.size()));
        FromAddress fromAddress = new FromAddress(CommonDef.WEBSITE_NAME_CN, CommonDef.EMAIL_SERVICE, CommonDef.SMTP_PASSWORD);
        return fromAddress;

    }

    /**
     * 取smtp地址
     * 
     * @return
     */
    public static String getSmtpAddress()
    {
        return CommonDef.SMTP_SERVER;
        // return smtpList.get(0).getAddress();
    }

    /**
     * 初始化发件人列表的任务，从EMAIL_FILE中读取所有记录，放入fromAddressList中
     * 
     * Bai Song
     * 
     * @version 1.0
     */
    // static class FromAddressListInitTask extends TimerTask
    // {
    // @Override
    // public void run()
    // {
    // if (fromAddressList == null || fromAddressList.isEmpty())
    // {
    // fromAddressList = new ArrayList<FromAddress>();
    // }
    // fromAddressList.clear();
    // fromAddressList = MailFromXMLParser.getFromAddressList();
    //
    // if (smtpList == null || smtpList.isEmpty())
    // {
    // smtpList = new ArrayList<SmtpServer>();
    // }
    // smtpList.clear();
    // smtpList = MailFromXMLParser.getSmtpList();
    // }
    // }
}
