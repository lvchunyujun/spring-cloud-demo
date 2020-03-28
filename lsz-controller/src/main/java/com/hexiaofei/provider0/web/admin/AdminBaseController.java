package com.hexiaofei.provider0.web.admin;

import com.hexiaofei.provider0.web.AbstractBaseController;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "admin")
public abstract class AdminBaseController extends AbstractBaseController {

    protected static final String ADD_SUCCESS_URL = "/common/addSuccess";
    protected static final String ADD_FAIL_URL = "/common/addFail";

}
