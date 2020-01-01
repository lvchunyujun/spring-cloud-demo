package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.common.CommonDef;
import com.hexiaofei.sjzclient.dao.mapper.MailAuthenMapper;
import com.hexiaofei.sjzclient.dao.mapper.MobileAuthenMapper;
import com.hexiaofei.sjzclient.domain.message.MailAuthen;
import com.hexiaofei.sjzclient.domain.message.MobileAuthen;
import com.hexiaofei.sjzclient.service.IAuthenRecordService;
import com.hexiaofei.sjzclient.service.base.BaseService;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service(value = "authenRecordService")
public class AuthenRecordServiceImpl extends BaseService implements IAuthenRecordService
{
	private static Logger logger = Logger.getLogger(AuthenRecordServiceImpl.class);
    private MailAuthenMapper mailAuthenMapper;
    private MobileAuthenMapper mobileAuthenMapper;
	@Override
	public int addMailAuthen(MailAuthen mailAuthen)
	{
		 logger.debug("增加一条邮件验证的记录,mail：" + mailAuthen.getMail() + " userid:" + mailAuthen.getUserId());
		 mailAuthenMapper = writableSQLSession.getMapper(MailAuthenMapper.class);
		 //logSqlSession(writableSQLSession);
		 logger.info("(1)当前MySQL用户: "+mailAuthenMapper.getCurrentUser());
		 try{
			 //如果该用户已经发送过一次激活验证，则此时应该删除以前存在的验证记录，使其失效
			 int userId = mailAuthen.getUserId();
			 mailAuthenMapper.delOldMailAuthenByUserId(userId);
			 mailAuthenMapper.addMailAuthen(mailAuthen);
			 int mailauthenid = mailAuthen.getMailAuthenId();
			 //logSqlSession(writableSQLSession);
			return mailauthenid;
		 }catch(Exception e){
		     logger.error("增加邮件验证记录时异常",e);
			 return -1;
		 }
		
	}

	@Override
	public MailAuthen getMailAuthenById(int mailauthenid)
	{
		logger.debug("根据mailauthenid取得此MailAuthen对象,mailauthenid：" +mailauthenid);
		mailAuthenMapper = readonlySQLSession.getMapper(MailAuthenMapper.class);
		MailAuthen mailAuthen = mailAuthenMapper.getMailAuthenByEmail(mailauthenid);
		return mailAuthen;
	}

	@Override
	public int delMailAuthenById(int mailauthenid)
	{
		logger.debug("删除MailAuthen记录,mailauthenid：" + mailauthenid);
		mailAuthenMapper = writableSQLSession.getMapper(MailAuthenMapper.class);
		mailAuthenMapper.delMailAuthenById(mailauthenid);
		return CommonDef.DELETE_SUCCESS;
	}

	@Override
	public int addMobileAuthen(MobileAuthen mobileAuthen)
	{
		 logger.debug("mobileAuthen,mobile：" + mobileAuthen.getMobile()+ " userid:" + mobileAuthen.getUserId());
		 mobileAuthenMapper = writableSQLSession.getMapper(MobileAuthenMapper.class);
		 try{
			 mobileAuthenMapper.addMobileAuthen(mobileAuthen);
			 int mobileauthenid = mobileAuthen.getMobileAuthenId();
			return mobileauthenid;
		 }catch(Exception e){
			 return -1;
		 }
	}

	@Override
	public MobileAuthen getMobileAuthenById(int mobileauthenid)
	{
		logger.debug("根据mobileauthenid取MobileAuthen对象,mobileauthenid：" +mobileauthenid);
		mobileAuthenMapper = readonlySQLSession.getMapper(MobileAuthenMapper.class);
		MobileAuthen mobileAuthen = mobileAuthenMapper.getMobileAuthenByMobile(mobileauthenid);
		return mobileAuthen;
	}

	@Override
	public int delMobileAuthenById(int mobileauthenid)
	{
		logger.debug("删除MobileAuthen对象,mailauthenid：" + mobileauthenid);
		mobileAuthenMapper = writableSQLSession.getMapper(MobileAuthenMapper.class);
		mobileAuthenMapper.delMobileAuthenById(mobileauthenid);
		return CommonDef.DELETE_SUCCESS;
	}
	
	private void logSqlSession(SqlSession toBeLoggedSqlSession)
	{
	    try
	    {
	    logger.info("--开始log SqlSession--");
	    //logger.info("(1)"+toBeLoggedSqlSession.getConfiguration().getDatabaseId());
	    //logger.info("(2)"+toBeLoggedSqlSession.getConfiguration().getMappedStatements());
	    logger.info("(3)"+toBeLoggedSqlSession.getConfiguration().getEnvironment().getDataSource());
	    logger.info("(4)"+toBeLoggedSqlSession.getConfiguration().getParameterMaps());
	    logger.info("(5)"+toBeLoggedSqlSession.getConfiguration().getVariables());
	    //logger.info("(6)"+toBeLoggedSqlSession.getConnection().getClientInfo().elements());
	    logger.info("(7)"+toBeLoggedSqlSession.getConnection().getTypeMap());
	    }
	    catch(Exception e)
	    {
	        logger.error(e);
	    }
	}
}
