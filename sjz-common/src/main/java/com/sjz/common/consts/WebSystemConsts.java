package com.sjz.common.consts;

public interface WebSystemConsts {

    // cookie 超时时间
    int COOKIEAGE = 1800;

    String COOKIE_USER = "USERINFO";
    int COOKIE_OUTTIME = 600;

    String DFAULT_PASSWORD = "000000";

    String ADMIN_TOLOGIN_URL = "/toLogin";
    String ADMIN_LOGIN_URL   = "/login";
    String ADMIN_LOGOUT_URL  = "/logout";
    String ADMIN_INDEX_URL   = "/admin/index";
    String ADMIN_ERROR_URL   = "/error";
    String ADMIN_STATIC_URL  = "/static/**";


}
