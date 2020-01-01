package com.hexiaofei.sjzclient.service;

import com.hexiaofei.sjzclient.domain.message.MailAuthen;
import com.hexiaofei.sjzclient.domain.message.MobileAuthen;

/**
 * 提供邮件，手机等验证记录的服务
 */
public interface IAuthenRecordService
{
    /**
     * 增加一条邮件验证的记录。此方法在用户注册，发出验证邮件后被调用。
     * 作用是把发出的邮件验证码存入数据库。
     * @param mailAuthen
     * @return 增加成功：mailAuthenId，增加失败：-1
     */
    int addMailAuthen(MailAuthen mailAuthen);
    
    /**
     * 根据Email取得此MailAuthen对象。
     * 此方法在用户点击注册确认邮件后调用
     * @return
     */
    MailAuthen getMailAuthenById(int mailauthenid);
    
    /**
     * 删除MailAuthen记录。若匹配则执行此方法
     * @param mailauthenid
     * @return
     */
    int delMailAuthenById(int mailauthenid);
    
    /**
     * 增加一条手机验证的记录。此方法在用户绑定手机时执行。
     * 作用是把发出的短信验证码存入数据库。
     * @param mobileAuthen
     * @return 增加成功：mobileAuthenId，增加失败：-1 
     */
    int addMobileAuthen(MobileAuthen mobileAuthen);
    
    /**
     * 取MobileAuthen对象
     * @param mobileauthenid
     * @return
     */
    MobileAuthen getMobileAuthenById(int mobileauthenid);
    
    /**
     * 删除MobileAuthen对象，若匹配则执行
     * @param mobileauthenid
     * @return
     */
    int delMobileAuthenById(int mobileauthenid);
}
