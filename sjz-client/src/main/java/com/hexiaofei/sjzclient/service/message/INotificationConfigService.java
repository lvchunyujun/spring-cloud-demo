/**
 * 
 */
package com.hexiaofei.sjzclient.service.message;

import com.hexiaofei.sjzclient.domain.NotificationConfig;
import com.hexiaofei.sjzclient.exception.PlatformException;

import java.util.List;

/**
 *
 */
public interface INotificationConfigService
{
	/**
	 * 添加一个提醒配置
	 *@param notificationConfig
	 *@return 
	 *
	 *@comment
	 */
	public int addNotificationConfig(NotificationConfig notificationConfig);
	
	/**
	 * 根据userId删除一个提醒配置，其实只是清空这个用户的配置
	 *@param userId
	 *@return
	 *@throws PlatformException 
	 *
	 *@comment
	 */
	public int delNotificationConfigByUserId(int userId) throws PlatformException;
	
	/**
	 * 通过userId获取提醒配置
	 *@param userId
	 *@return
	 *@throws PlatformException 
	 *
	 *@comment
	 */
	public NotificationConfig getNotificationConfigByUserId(int userId) throws PlatformException;
	
	
	/**
	 * 更新提醒配置
	 *@param notificationConfig
	 *@return
	 *
	 *@comment
	 */
	public int updateNotificationConfig(NotificationConfig notificationConfig);
	
	/**
	 * 根据loanId获取投资人的提醒配置
	 * @param loanId
	 * @return
	 * 
	 */
	public List<NotificationConfig> getInvestorNotificationConfigByLoanId(int loanId);
	
	/**
	 * 根据Id获取提醒配置的详情
	 * @param id
	 * @return
	 * 
	 */
	public NotificationConfig getNoticeDetailById(int id);
	/**
	 * 根据用户id获得消息设置
	 * @param userId
	 * @return
	 */
	public String getMessageSetup(Integer userId);
	/**
	 * 根据用户id修改消息设置
	 * @param messageSetup 
	 * @param userId
	 * @return
	 */
	public int saveMessageSetup(String messageSetup, Integer userId);
	
}
