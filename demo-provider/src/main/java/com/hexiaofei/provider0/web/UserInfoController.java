package com.hexiaofei.provider0.web;

import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.service.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/17.
 */
//@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends AbstractBaseController implements BaseController<UserInfo>{

    private final static Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);


    @Autowired
    private IUserInfoService userInfoService;

    @RequestMapping("/{id}")
    @ResponseBody
    public String findUserInfoById(@PathVariable Integer id){
        ResultEntity re = new ResultEntity();


        try {
            UserInfo user = userInfoService.getUserInfoById(id);
            TimeUnit.MILLISECONDS.sleep(100);
            re.setResultCode("000000");
            re.setResultMsg("success");
            re.setData(user);
        } catch (InterruptedException e) {
            re.setResultCode("999999");
            re.setResultMsg("系统异常！");
            e.printStackTrace();
        }
        LOGGER.info("【{}】查询客户id={},详情{}",id,re.toString());
        return re.toString();
    }

    @Override
    public String index() {
        return null;
    }

    @Override
    public String toAdd() {
        return null;
    }

    @Override
    public String add(UserInfo o) {
        return null;
    }

    @Override
    public ModelAndView toUpadte(Integer id) {
        return null;
    }

    @Override
    public String listEventIndex(UserInfo o, int currentPage, int pageSize) {
        return null;
    }

    @Override
    public ModelAndView update(UserInfo userInfo) {
        return null;
    }
}
