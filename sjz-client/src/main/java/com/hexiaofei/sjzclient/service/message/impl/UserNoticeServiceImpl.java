package com.hexiaofei.sjzclient.service.message.impl;

import com.hexiaofei.sjzclient.common.CommonDef;
import com.hexiaofei.sjzclient.dao.mapper.UserNoticeMapper;
import com.hexiaofei.sjzclient.domain.message.UserNotice;
import com.hexiaofei.sjzclient.exception.IllegalPlatformAugumentException;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.base.BaseService;
import com.hexiaofei.sjzclient.service.message.IUserNoticeService;
import com.hexiaofei.sjzclient.vo.PageVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @since v1.1
 * @history
 * @see
 */
@Service("userNoticeService")
public class UserNoticeServiceImpl extends BaseService implements IUserNoticeService
{
	private static Logger logger = Logger.getLogger(UserNoticeServiceImpl.class);
	private UserNoticeMapper userNoticeMapper;

	@Override
	public int addNotice(UserNotice userNotice)
	{
		Assert.notNull(userNotice, "userNoticeId must not be null");
		logger.debug("增加一条公告，title:" + userNotice.getTitle());
		userNoticeMapper = writableSQLSession.getMapper(UserNoticeMapper.class);
		userNotice.setIsDisplay(true) ;
		userNoticeMapper.addUserNotice(userNotice) ;
		
		int userNoticeId = userNotice.getId() ;
		
		return userNoticeId;
	}
	
	
    @Override
    public void updateNotice(UserNotice userNotice)  throws PlatformException
    {
        if(userNotice==null || userNotice.getId()==null || userNotice.getId().intValue()<1)
        {
            throw new IllegalPlatformAugumentException("传入的公告对象UserNotice格式为空或不合法");
        }
        userNoticeMapper = writableSQLSession.getMapper(UserNoticeMapper.class);
        userNoticeMapper.updateUserNotice(userNotice);
    }



    @Override
	public int delUserNoticebyId(int userNoticeId) throws PlatformException
	{
		Assert.notNull(userNoticeId, "userNoticeId must not be null") ;
		logger.debug("删除一条公告,公告id："+userNoticeId);
		userNoticeMapper = writableSQLSession.getMapper(UserNoticeMapper.class);
		userNoticeMapper.delUserNoticeById(userNoticeId) ;
		return CommonDef.DELETE_SUCCESS ;
	}

	@Override
	public PageVo<UserNotice> getUserNoticeListByPage(PageVo<UserNotice> pageVo) throws PlatformException
	{
		logger.debug("开始按页取通告列表，页码=" + pageVo.getCurrentPage() );
		// 放入当前页的数据list
		int offset = pageVo.getCurrentPage() - 1;
		userNoticeMapper = readonlySQLSession.getMapper(UserNoticeMapper.class);
		List<UserNotice> userNoticeLists = userNoticeMapper.getUserNoticeListByPage(true,offset * pageVo.getPageSize(),
				pageVo.getPageSize());
		pageVo.setVoList(userNoticeLists);
		int recordCount = userNoticeMapper.getUserNoticeCount(true);
		pageVo.setRecordCount(recordCount);
		return pageVo;
	}

	@Override
	public boolean markUserNoticeDisplay(int userNoticeId)
	{
		boolean isdisplay = false;
		userNoticeMapper = writableSQLSession.getMapper(UserNoticeMapper.class);
		int i = userNoticeMapper.markUserNoticeReaded(isdisplay, userNoticeId);
		if (i == 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public UserNotice getNoticeDetailById(int id) throws PlatformException
	{
		Assert.notNull(id, "id must not be null");
		userNoticeMapper = readonlySQLSession.getMapper(UserNoticeMapper.class);
		UserNotice userNotice = userNoticeMapper.getNoticeDetailById(id);
		return userNotice;
	}


	@Override
	public List<UserNotice> getUserNoticeByLimit(int limit) {
		userNoticeMapper = readonlySQLSession.getMapper(UserNoticeMapper.class);
		List<UserNotice> userNoticeLists = userNoticeMapper.getUserNoticeListByPage(true,0,limit);
		return userNoticeLists;
	}

}
