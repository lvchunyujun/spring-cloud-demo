package com.hexiaofei.springcloudconsumer.web;

import com.hexiaofei.springcloudconsumer.domain.User;
import com.hexiaofei.springcloudconsumer.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/29.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    private final static Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/{id}")
    @ResponseBody
    public ResultVo findUserByID(@PathVariable Integer id){
        ResultVo resultVo = new  ResultVo();
        User user = userService.getUserById(id);
        resultVo.setResultCode("0000");
        resultVo.setResultMsg("success");
        resultVo.setData(user);
        return resultVo;
    }

    @ResponseBody
    @RequestMapping("/modify/{id}")
    public ResultVo updateUserById(@PathVariable() int id,int credit){
        ResultVo resultVo = new ResultVo();

        User user = new User();
        user.setId(id);
        user.setCredit(credit);
        try{
            userService.updateUserById(user);
        }catch(Exception e){
            LOGGER.error("【更新用户信用积分异常】",e);
        }
        user = userService.getUserById(id);
        resultVo.setResultCode("0000");
        resultVo.setResultMsg("success");
        resultVo.setData(user);
        return resultVo;
    }
}
