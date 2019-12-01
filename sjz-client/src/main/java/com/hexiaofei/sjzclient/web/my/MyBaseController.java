package com.hexiaofei.sjzclient.web.my;

import com.hexiaofei.sjzclient.web.AbstractBaseController;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "my")
public abstract class MyBaseController extends AbstractBaseController {

    protected static final String ADD_SUCCESS_URL = "common/addSuccess";
    protected static final String ADD_FAIL_URL = "common/addFail";

}
