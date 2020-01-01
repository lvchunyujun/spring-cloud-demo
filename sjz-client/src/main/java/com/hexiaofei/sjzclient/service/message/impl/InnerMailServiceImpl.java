package com.hexiaofei.sjzclient.service.message.impl;

import com.hexiaofei.sjzclient.common.CommonDef;
import com.hexiaofei.sjzclient.common.UserDef;
import com.hexiaofei.sjzclient.dao.mapper.InnerMailMapper;
import com.hexiaofei.sjzclient.dao.mapper.InnerMailWithBLOBs;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.base.BaseService;
import com.hexiaofei.sjzclient.service.message.IInnerMailService;
import com.hexiaofei.sjzclient.vo.PageVo;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class InnerMailServiceImpl extends BaseService implements IInnerMailService
{
	private static Logger logger = Logger.getLogger(InnerMailServiceImpl.class);
	private InnerMailMapper innerMailMapper;

	@Override
	public int addInnerMail(InnerMailWithBLOBs innerMail)
	{
		logger.debug("增加一条站内信，sender:" + innerMail.getSender() + " receiver:" + innerMail.getReceiver());
		innerMailMapper = writableSQLSession.getMapper(InnerMailMapper.class);
		innerMail.setIsread(false) ;
		innerMailMapper.addInnerMail(innerMail);

		int innerMailId = innerMail.getId();

		return innerMailId;
	}

	@Override
	public PageVo<InnerMailWithBLOBs> getInnerMailListByPage(PageVo<InnerMailWithBLOBs> pageVo, int userId) throws PlatformException
	{
		logger.debug("用户（"+userId+"）取站内信列表，页码=" + pageVo.getCurrentPage());
		// 放入当前页的数据list
		int offset = pageVo.getCurrentPage() - 1;
		innerMailMapper = readonlySQLSession.getMapper(InnerMailMapper.class);
		List<InnerMailWithBLOBs> innerMailLists = innerMailMapper.getInnerMailListByPage(offset * pageVo.getPageSize(),
				pageVo.getPageSize(), userId);
		pageVo.setVoList(innerMailLists);
		int recordCount = innerMailMapper.getInnerMailCountByUserid(userId);
		pageVo.setRecordCount(recordCount);
		return pageVo;
	}

	@Override
	public boolean markInnerMailReaded(int innerMailId)
	{
		innerMailMapper = writableSQLSession.getMapper(InnerMailMapper.class);
		boolean isread = true;
		int isSuccess = innerMailMapper.markInnerMailReaded(isread, innerMailId);
		if (isSuccess == 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public int getUnreadInnerMailCount(int userId)
	{
		logger.debug("获取用户未读站内信数量， userId:" + userId);
		innerMailMapper = readonlySQLSession.getMapper(InnerMailMapper.class);
		int unreadInnerMailCount = innerMailMapper.getUnreadInnerMailCountByUserid(userId);
		return unreadInnerMailCount;
	}

	@Override
	public void sendInnerMail(int userId, String content, int messageType) {
		logger.info("发送一条站内信， userId:" + userId);
		innerMailMapper = writableSQLSession.getMapper(InnerMailMapper.class);	
		boolean isread = false;
		Date sendTime = new Date();
		innerMailMapper.sendInnerMail(UserDef.COMPANY_TRANSIT_USER_ID, userId,content,isread,sendTime, messageType);
	}

    @Override
    public InnerMailWithBLOBs getInnerMailById(int innerMailId)
    {
    	logger.info("根据id获取一条站内信， innerMailId:" + innerMailId);
    	innerMailMapper = readonlySQLSession.getMapper(InnerMailMapper.class);
    	InnerMailWithBLOBs innerMailWithBLOBs =innerMailMapper.getInnerMailById(innerMailId);
        return innerMailWithBLOBs;
    }

	@Override
	public InnerMailWithBLOBs getInnerMailByUserId(int userId, int innerMailId) {
		logger.info("根据userId获取一条站内信， innerMailId:" + innerMailId);
    	innerMailMapper = readonlySQLSession.getMapper(InnerMailMapper.class);
    	InnerMailWithBLOBs innerMailWithBLOBs =innerMailMapper.getInnerMailByUserId(userId,innerMailId);
        return innerMailWithBLOBs;
	}
    
	@Override
	public int delInnerMailById(int innerMailId)
	{
		logger.info("根据id删除一条站内信， innerMailId:" + innerMailId);
		innerMailMapper = writableSQLSession.getMapper(InnerMailMapper.class);
		innerMailMapper.delInnerMailById(innerMailId);
		return CommonDef.DELETE_SUCCESS;
	}

    @Override
    public void markInnerMailFlag(int innerMailId, boolean isFlagged)
    {
    	innerMailMapper = writableSQLSession.getMapper(InnerMailMapper.class);
    	innerMailMapper.markInnerMailFlag(innerMailId,isFlagged);
    }
    /**
     * 查询站内消息按时间排序
     * @param pageVo
     * @param userId
     */
    @Override
    public PageVo<HashMap<String, Object>>  queryInnerMailList(PageVo<HashMap<String, Object>> pageVo, int userId) throws Exception
    {
        logger.info("用户（"+userId+"）取站内信列表，页码=" + pageVo.getCurrentPage());
        // 放入当前页的数据list
        int offset = pageVo.getCurrentPage() - 1;
        innerMailMapper = readonlySQLSession.getMapper(InnerMailMapper.class);
        List<HashMap<String, Object>> innerMailLists = innerMailMapper.queryInnerMailList(offset * pageVo.getPageSize(), pageVo.getPageSize(), userId);
        pageVo.setVoList(innerMailLists);
        int recordCount = innerMailMapper.getInnerMailCountByUserid(userId);
        pageVo.setRecordCount(recordCount);
        return pageVo;
    }
    /**
     * 标记一条数据为未读
     * @param innerMailId
     * @return
     * @throws Exception
     */
	@Override
	public boolean markInnerMailNoReaded(int innerMailId) throws Exception {
		innerMailMapper = writableSQLSession.getMapper(InnerMailMapper.class);
		boolean isread = false;
		int isSuccess = innerMailMapper.markInnerMailReaded(isread, innerMailId);
		if (isSuccess == 1)
		{
			return true;
		}
		return false;
	}
    
}
