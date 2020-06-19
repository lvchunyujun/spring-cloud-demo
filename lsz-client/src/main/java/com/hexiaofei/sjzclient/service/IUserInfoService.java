package com.hexiaofei.sjzclient.service;

import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.base.IBaseService;
import com.hexiaofei.sjzclient.vo.PageVo;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface IUserInfoService extends IBaseService<UserInfo> {

    @Override
    default PageVo<UserInfo> getPageVoObject(PageVo<UserInfo> pageVo) throws PlatformException {
        return null;
    }

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

    /**
     * 找回密码- 1.发送email验证链接
     * @return
     */
    int sendFindPasswdVerifyEmail(String email);


    /**
     * 找回密码- 2.校验email链接
     * @param email
     * @param mailauthenid
     * @param requestNewValidCode
     * @param requestSignText
     * @return
     */
    int verifyFindPasswdEmail(String email,int mailauthenid,String requestNewValidCode,String requestSignText);


    /**
     * 找回密码- 3.重置密码
     * @param email
     * @param newPasswd
     * @param validCode
     * @param mailAuthenId
     * @param requestSignText
     * @return
     */
    int updatePasswdForFindPasswd(String email,String newPasswd,String validCode,Integer mailAuthenId,String requestSignText);
}
