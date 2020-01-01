package com.hexiaofei.sjzclient.dao.mapper;

import com.hexiaofei.sjzclient.domain.message.MobileAuthen;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface MobileAuthenMapper {
	
	@Insert("insert into mobile_authen(mobile,validCode,userId,sendTime) values (#{mobile},#{validCode},#{userId},#{sendTime})")
	@Options(useGeneratedKeys = true, keyProperty = "mobileAuthenId")
	public int addMobileAuthen(MobileAuthen mobileAuthen);

	@Select("Select * from mobile_authen where  mobileAuthenId=(select max(mobileAuthenId) from mobile_authen where  mobileAuthenId =#{mobileAuthenId})")
	public MobileAuthen getMobileAuthenByMobile(int mobileAuthenId);

	@Delete("delete from mobile_authen where mobileAuthenId =#{mobileAuthenId}")
	public void delMobileAuthenById(int mobileauthenid);
	
}
