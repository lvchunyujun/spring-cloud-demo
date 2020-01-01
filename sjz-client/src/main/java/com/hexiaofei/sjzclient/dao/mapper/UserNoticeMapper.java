package com.hexiaofei.sjzclient.dao.mapper;

import com.hexiaofei.sjzclient.domain.message.UserNotice;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserNoticeMapper {
	/**
	 * 增加一條通告
	 * @param userNotice
	 */
	@Insert("insert into user_notice" + "(title, content, isDisplay, createTime) " + "values "
			+ "(#{title},#{content},#{isDisplay},#{createTime})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void addUserNotice(UserNotice userNotice);
	
	@Update("UPDATE user_notice SET content=#{content}, title=#{title} WHERE id=#{id}")
	public void updateUserNotice(UserNotice userNotice);
	
	/**
	 * 取得所有通告总数，以方便分页
	 * 
	 * @return
	 */
	@Select("Select count(*) from user_notice where isDisplay=#{isDisplay}")
	public int getUserNoticeCount(@Param("isDisplay") boolean isDisplay);

	/**
	 * 标记不显示一条通告
	 * @param isDisplay
	 * @param userNoticeId
	 * @return
	 */
	@Update("update user_notice set isDisplay=#{isDisplay} where id=#{userNoticeId}")
	public int markUserNoticeReaded(@Param("isDisplay") boolean isDisplay, @Param("userNoticeId") int userNoticeId);
	
	   /**
     * 根据当前页码获取通告分页信息
     * @param offset
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM user_notice where isDisplay=#{isDisplay} ORDER BY createTime DESC LIMIT #{offset}, #{pagesize} ")
	List<UserNotice> getUserNoticeListByPage(@Param("isDisplay") boolean isDisplay, @Param("offset") int offset, @Param("pagesize") int pageSize);
    
	/**
	 *根据公告id删除一条公告
	 * @param userNoticeId
	 */
	@Delete("delete from user_notice where id=#{userNoticeId}")
	public void delUserNoticeById(int userNoticeId);
	/**
	 * 根据公告id获取一条公告
	 * @param id
	 */
    @Select("SELECT * FROM user_notice WHERE  id = #{id}")
    UserNotice getNoticeDetailById(@Param("id") int id);
}
