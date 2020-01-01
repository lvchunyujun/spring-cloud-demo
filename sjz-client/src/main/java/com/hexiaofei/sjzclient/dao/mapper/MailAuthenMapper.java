package com.hexiaofei.sjzclient.dao.mapper;

import com.hexiaofei.sjzclient.domain.message.MailAuthen;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface MailAuthenMapper {

	@Insert("insert into mail_authen(mail,sendTime,validCode,userId) values (#{mail},#{sendTime},#{validCode},#{userId})")
	@Options(useGeneratedKeys = true, keyProperty = "mailAuthenId")
	public int addMailAuthen(MailAuthen mailAuthen);

	@Select("Select * from mail_authen where mailAuthenId=(select max(mailAuthenId) from mail_authen where  mailauthenId =#{mailAuthenId})")
	public MailAuthen getMailAuthenByEmail(int mailAuthenId);

	@Delete("delete from mail_authen where mailAuthenId =#{mailAuthenId}")
	public void delMailAuthenById(int mailAuthenId);

	@Delete("delete from mail_authen where userId =#{userId}")
	public void delOldMailAuthenByUserId(int userId);
	
	@Delete("delete from mail_authen where mail =#{email}")
	public void delOldMailAuthenByMail(String email);
	
	@Select("SELECT CURRENT_USER()")
	public String getCurrentUser();
}
