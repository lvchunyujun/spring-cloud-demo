package com.hexiaofei.sjzclient.service;

import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.base.IBaseService;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface UserInfoService  extends IBaseService<UserInfo> {

    UserInfo getUserInfoForLogin(String userName, String password) throws PlatformException;

    /**
     * 邮箱注册
     * @param email
     * @param password
     * @return
     * @throws PlatformException
     */
    int register(String email,String password)throws PlatformException;

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    UserInfo getUserInfoByEmail(String email);
}
