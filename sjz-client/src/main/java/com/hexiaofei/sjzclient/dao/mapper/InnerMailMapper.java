package com.hexiaofei.sjzclient.dao.mapper;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


public interface InnerMailMapper
{

	/**
	 * 增加一条站内信
	 * 
	 * @param innerMail
	 * @return
	 */
	@Insert("insert into inner_mail" + "(content, context, receiver, sender, isread,isOutstanding,messageType,sendtime) " + "values "
			+ "(#{content},#{context},#{receiver},#{sender},#{isread},#{isOutstanding},#{messageType},#{sendtime})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void addInnerMail(InnerMailWithBLOBs innerMail);

	/**
	 * 取某用户的站内信总数，以方便分页
	 * 
	 * @param userId
	 * @return
	 */
	@Select("Select count(*) from inner_mail where receiver =#{userId} ")
	public int getInnerMailCountByUserid(int userId);

	/**
	 * 标记一条站内信为已读
	 * 
	 * @param innerMailId
	 * @return
	 */
	
	@Update("update inner_mail set isread=#{isread} where id=#{innerMailId}")
	public int markInnerMailReaded(@Param("isread") boolean isread, @Param("innerMailId") int innerMailId);
	
    /**
     * 根据当前页码获取站内信分页信息
     * @param offset
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM inner_mail WHERE receiver = #{userId} ORDER BY id DESC LIMIT #{offset}, #{pagesize} ")
	List<InnerMailWithBLOBs> getInnerMailListByPage(@Param("offset") int offset, @Param("pagesize") int pageSize, @Param("userId") int userId);
    
	/**
	 * 取站内信总数，以方便分页
	 * 
	 * @return
	 */
	@Select("Select count(*) from inner_mail ")
	public int getInnerMailCount();
	
	/**
	 * 获取未读站内信数量
	 *@param userId
	 *@return 
	 *@comment
	 */
	@Select("Select count(*) from inner_mail where receiver =#{userId} and isread=0")
	public int getUnreadInnerMailCountByUserid(@Param("userId") int userId);

	@Insert("insert into inner_mail"
			+ "(content, receiver, isread, sendtime, sender, messageType) "
			+ "values "
			+ "(#{content},#{receiver},#{isread},#{sendtime},#{sender},#{messageType})")
	public void sendInnerMail(@Param("sender") int sender,
                              @Param("receiver") int receiver, @Param("content") String content,
                              @Param("isread") boolean isread, @Param("sendtime") Date sendTime,
                              @Param("messageType") int messageType);
	
	/**
	 * 根据id获取站内信
	 * @param id
	 * @return
	 */
	//@Select("SELECT * FROM inner_mail WHERE id = #{id}")
	@Select("SELECT im.id,receiver,content,context,DATE_FORMAT(sendtime,'%Y-%m-%d') sendDate,nickName AS sendName,isread,messageType,sender,sendtime FROM inner_mail im INNER JOIN user_main um ON im.sender = um.userid WHERE im.id =#{id}")
	public InnerMailWithBLOBs getInnerMailById(@Param("id") int id);
	
	/**
	 * 获取一条站内信详情：根据userId
	 * @param userId
	 * @param id
	 * @return
	 */
	@Select({" SELECT im.id,receiver,content,context,DATE_FORMAT(sendtime,'%Y-%m-%d') sendDate,nickName AS sendName,isread,messageType,sender,sendtime ",
			 " FROM inner_mail im INNER JOIN user_main um ON im.sender = um.userid ",
			 " WHERE im.receiver = #{userId} AND im.id = #{id} "})
	public InnerMailWithBLOBs getInnerMailByUserId(@Param("userId") int userId, @Param("id") int id);
	
	/**
	 * 根据id删除一条站内信
	 * @param id
	 */
	@Delete("DELETE FROM inner_mail WHERE id = #{id}")
	public void delInnerMailById(@Param("id") int id);

	/**
	 * 标记一个站内信是否是小红旗状态
	 *
	 * @param innerMailId
	 * @param isFlagged
	 * @return void
	 */
	@Update("update inner_mail set isOutstanding=#{isFlagged} where id = #{innerMailId}")
	public void markInnerMailFlag(@Param("innerMailId") int innerMailId, @Param("isFlagged") boolean isFlagged);

	/**
	 *
	 * @param offset
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	 @Select("SELECT id,DATE_FORMAT(sendtime,'%Y-%m-%d %T') sendtime,sender,um.nickName senderName,messageType,isread,content title,(CASE TO_DAYS(now()) - TO_DAYS(sendtime) WHEN 0 THEN 0 WHEN 1 THEN 1 ELSE - 1 END) timeOrder"+
	" FROM inner_mail im inner join user_main um on im.sender=um.userid WHERE receiver = #{userId} ORDER BY im.sendtime DESC LIMIT #{offset}, #{pagesize}" )
    public List<HashMap<String, Object>> queryInnerMailList(@Param("offset") int offset, @Param("pagesize") int pageSize, @Param("userId") int userId);
}
