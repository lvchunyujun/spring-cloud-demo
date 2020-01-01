package com.hexiaofei.sjzclient.service.message.impl;

import com.hexiaofei.sjzclient.common.CommonDef;
import com.hexiaofei.sjzclient.dao.mapper.NotificationConfigMapper;
import com.hexiaofei.sjzclient.domain.NotificationConfig;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.base.BaseService;
import com.hexiaofei.sjzclient.service.message.INotificationConfigService;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import java.util.List;
public class NotificationConfigServiceImpl extends BaseService implements INotificationConfigService
{
	private static Logger logger = Logger.getLogger(NotificationConfigServiceImpl.class);
	private NotificationConfigMapper notificationConfigMapper;
	@Override
	public int addNotificationConfig(NotificationConfig notificationConfig)
	{
		Assert.notNull(notificationConfig, "notificationConfig must not be null");
		logger.debug("添加一条提醒配置，UserId:" + notificationConfig.getUserId());
		notificationConfigMapper = writableSQLSession.getMapper(NotificationConfigMapper.class);
		notificationConfigMapper.updateByUserId(notificationConfig);
		return notificationConfig.getUserId();
	}

	@Override
	public int delNotificationConfigByUserId(int userId) throws PlatformException
	{
		Assert.notNull(userId, "userId must not be null");
		logger.debug("删除一条提醒配置，notificationConfigId:" + userId);
		NotificationConfig notificationConfig = new NotificationConfig();
		notificationConfig.setUserId(userId);
		notificationConfigMapper = writableSQLSession.getMapper(NotificationConfigMapper.class);
		notificationConfigMapper.updateByUserId(notificationConfig);
		return CommonDef.DELETE_SUCCESS ;
	}

	@Override
	public NotificationConfig getNotificationConfigByUserId(int userId) throws PlatformException
	{
		Assert.notNull(userId, "userId must not be null");
		logger.debug("获取一条提醒配置，userId:" + userId);
		notificationConfigMapper = readonlySQLSession.getMapper(NotificationConfigMapper.class);
		NotificationConfig notificationConfig = notificationConfigMapper.selectByUserId(userId);
		return notificationConfig;
	}

	@Override
	public int updateNotificationConfig(NotificationConfig notificationConfig)
	{
		Assert.notNull(notificationConfig, "notificationConfig must not be null");
		logger.debug("更新一条提醒配置，UserId:" + notificationConfig.getUserId());
		notificationConfigMapper = writableSQLSession.getMapper(NotificationConfigMapper.class);
		notificationConfigMapper.updateByUserId(notificationConfig);
		
		return CommonDef.UPDATE_SUCCESS;
	}

	@Override
	public List<NotificationConfig> getInvestorNotificationConfigByLoanId(int loanId)
	{
		Assert.notNull(loanId, "loanId must not be null");
		logger.debug("根据loanId获取所有投资人的提醒配置，loanId:" + loanId);
		notificationConfigMapper = readonlySQLSession.getMapper(NotificationConfigMapper.class);
		List<NotificationConfig> notificationConfigList = notificationConfigMapper.getInvestorNotificationConfigByLoanId(loanId);
		return notificationConfigList;
	}

	@Override
	public NotificationConfig getNoticeDetailById(int id)
	{
		Assert.notNull(id, "id must not be null");
		notificationConfigMapper = readonlySQLSession.getMapper(NotificationConfigMapper.class);
		NotificationConfig notificationConfig = notificationConfigMapper.getNoticeDetailById(id);
		return notificationConfig;
	}

	@Override
	public String getMessageSetup(Integer userId) {
		Assert.notNull(userId, "id must not be null");
		notificationConfigMapper = readonlySQLSession.getMapper(NotificationConfigMapper.class);
		return notificationConfigMapper.getMessageSetup(userId);
	}

	@Override
	public int saveMessageSetup(String messageSetup, Integer userId) {
		Assert.notNull(userId, "userId must not be null");
		Assert.notNull(messageSetup, "messageSetup must not be null");
		notificationConfigMapper = writableSQLSession.getMapper(NotificationConfigMapper.class);
		return notificationConfigMapper.updateMessageSetup(messageSetup,userId);
	}

}
