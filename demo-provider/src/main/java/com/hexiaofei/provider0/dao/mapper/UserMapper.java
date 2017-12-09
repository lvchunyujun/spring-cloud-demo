package com.hexiaofei.provider0.dao.mapper;

import com.hexiaofei.provider0.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface UserMapper {

    User selectUserById(@Param("id") int id);
}
