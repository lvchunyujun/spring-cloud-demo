package com.hexiaofei.sjzclient.service.message;

import com.hexiaofei.sjzclient.domain.message.UserNotice;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.vo.PageVo;

import java.util.List;

/**
 * @since v1.1
 * @history
 * @see
 */
public interface IUserNoticeService
{
	/**
	 * @param userNotice
	 * @return
	 * 
	 */
	public int addNotice(UserNotice userNotice);
	
	/**
	 * 更新公告的标题和内容
	 * @param userNotice
	 * 
	 */
	public void updateNotice(UserNotice userNotice) throws PlatformException;

	/**
	 * 取公告列表
	 * 
	 * @param pageVo
	 *            当前显示的页数
	 * @return
	 */
	public PageVo<UserNotice> getUserNoticeListByPage(PageVo<UserNotice> pageVo) throws PlatformException;

	/**
	 * 标记一条不显示一条公告
	 * 
	 * @param userNoticeId
	 * @return
	 */
	public boolean markUserNoticeDisplay(int userNoticeId);

	/**
	 * 删除一个公告
	 * 
	 * @param userNoticeId
	 * @return
	 * @throws PlatformException
	 */
	public int delUserNoticebyId(int userNoticeId) throws PlatformException;
    
	public UserNotice getNoticeDetailById(int id) throws PlatformException;
	/**
	 * 获取指定条数的公告
	 * @param limit
	 * @return
	 */
	public List<UserNotice> getUserNoticeByLimit(int limit);
}
