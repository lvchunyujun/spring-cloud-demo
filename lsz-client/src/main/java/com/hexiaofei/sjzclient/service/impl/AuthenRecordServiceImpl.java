package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.dao.mapper.MailAuthenMapper;
import com.hexiaofei.sjzclient.dao.mapper.MobileAuthenMapper;
import com.hexiaofei.sjzclient.domain.MailAuthen;
import com.hexiaofei.sjzclient.domain.MobileAuthen;
import com.hexiaofei.sjzclient.service.IAuthenRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("authenRecordService")
public class AuthenRecordServiceImpl implements IAuthenRecordService {
    private final static Logger LOGGER = LoggerFactory.getLogger(AuthenRecordServiceImpl.class);
    @Autowired
    private MailAuthenMapper mailAuthenMapper;
    @Autowired
    private MobileAuthenMapper mobileAuthenMapper;

    @Override
    public int addMailAuthen(MailAuthen mailAuthen)
    {
        LOGGER.debug("增加一条邮件验证的记录,mail：" + mailAuthen.getMail() + " userid:" + mailAuthen.getUserId());
        int mailauthenid = -1;
        try{
            //如果该用户已经发送过一次激活验证，则此时应该删除以前存在的验证记录，使其失效
            int userId = mailAuthen.getUserId();
            mailAuthenMapper.delOldMailAuthenByUserId(userId);
            mailAuthenMapper.insert(mailAuthen);
            mailauthenid = mailAuthen.getMailAuthenId();
            return mailauthenid;
        }catch(Exception e){
            LOGGER.error("增加邮件验证记录时异常",e);

        }
        return mailauthenid;
    }

    @Override
    public MailAuthen getMailAuthenById(int mailauthenid)
    {
        LOGGER.debug("根据mailauthenid取得此MailAuthen对象,mailauthenid：" +mailauthenid);
        MailAuthen mailAuthen = mailAuthenMapper.getMailAuthenByEmail(mailauthenid);
        return mailAuthen;
    }

    @Override
    public int delMailAuthenById(int mailauthenid)
    {
        LOGGER.debug("删除MailAuthen记录,mailauthenid：" + mailauthenid);
        return mailAuthenMapper.deleteByPrimaryKey(mailauthenid);
    }

    @Override
    public int addMobileAuthen(MobileAuthen mobileAuthen)
    {
        LOGGER.debug("mobileAuthen,mobile：" + mobileAuthen.getMobile()+ " userid:" + mobileAuthen.getUserId());
        try{
            mobileAuthenMapper.insert(mobileAuthen);
            int mobileauthenid = mobileAuthen.getMobileAuthenId();
            return mobileauthenid;
        }catch(Exception e){
            return -1;
        }
    }

    @Override
    public MobileAuthen getMobileAuthenById(int mobileauthenid)
    {
        return null;
    }

    @Override
    public int delMobileAuthenById(int mobileauthenid)
    {
        return -1;
    }

    @Override
    public int delOldMailAuthenByMail(String email){
        return mailAuthenMapper.delOldMailAuthenByMail(email);
    }

}
