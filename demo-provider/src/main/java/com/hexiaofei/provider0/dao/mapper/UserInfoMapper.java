package com.hexiaofei.provider0.dao.mapper;

import com.hexiaofei.provider0.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface UserInfoMapper {

    @Select("select * from user_info where id = #{id}")
    UserInfo selectUserInfoById(@Param("id") int id);
}
