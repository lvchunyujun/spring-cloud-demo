package com.hexiaofei.sjzclient.common;

public interface WebSystemConsts {

    // cookie 超时时间
    int COOKIEAGE = 1800;

    String COOKIE_USER = "USERINFO";
    int COOKIE_OUTTIME = 600;

    String DFAULT_PASSWORD = "000000";

    /** 登录成功欢迎页 */
    String WELCOME_INDEX_URL   = "/my/index";

    String INDEX_URL = "/index";

    String TO_LOGIN_URL = "/toLogin";
    String LOGIN_URL   = "/login";
    String LOGOUT_URL  = "/logout";
    String ERROR_URL   = "/error";
    String STATIC_URL  = "/static/**";



}
