package com.hexiaofei.provider0.service;


import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.IBaseService;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface UserInfoService  extends IBaseService<UserInfo> {

    UserInfo getUserInfoForLogin(String userName,String password) throws PlatformException;
}
