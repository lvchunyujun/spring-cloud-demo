package com.hexiaofei.provider0.web;

import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.service.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/17.
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends BaseController{

    private final static Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);


    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping("/{id}")
    @ResponseBody
    public String findUserInfoById(@PathVariable Integer id){

        try {
            UserInfo user = userInfoService.getUserInfoById(id);
            TimeUnit.MILLISECONDS.sleep(100);
            getResultEntity().setResultCode("000000");
            getResultEntity().setResultMsg("success");
            getResultEntity().setData(user);
        } catch (InterruptedException e) {
            getResultEntity().setResultCode("999999");
            getResultEntity().setResultMsg("系统异常！");
            e.printStackTrace();
        }
        LOGGER.info("【{}】查询客户id={},详情{}",id,getResultEntity().toString());
        return getResultEntity().toString();
    }

}
