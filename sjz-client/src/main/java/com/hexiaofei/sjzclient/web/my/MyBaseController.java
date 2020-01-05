package com.hexiaofei.sjzclient.web.my;

import com.hexiaofei.sjzclient.common.WebSystemConsts;
import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.web.AbstractBaseController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@RequestMapping(value = "my")
public abstract class MyBaseController extends AbstractBaseController {

    protected static final String ADD_SUCCESS_URL = "common/addSuccess";
    protected static final String ADD_FAIL_URL = "common/addFail";

    protected UserInfo getLoginUserInfo(HttpServletRequest request){

        UserInfo userInfo = null;

        Object obj =   request.getSession().getAttribute(WebSystemConsts.COOKIE_USER);

        if(obj != null){
            userInfo = (UserInfo) obj;
        }

        return userInfo;
    }

}
