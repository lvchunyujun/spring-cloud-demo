package com.hexiaofei.sjzclient.service;

import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.base.IBaseService;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface UserInfoService  extends IBaseService<UserInfo> {

    UserInfo getUserInfoForLogin(String userName, String password) throws PlatformException;


}
