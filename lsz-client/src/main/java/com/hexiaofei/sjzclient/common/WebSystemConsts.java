package com.hexiaofei.sjzclient.common;

public interface WebSystemConsts {

    // cookie 超时时间
    int COOKIEAGE = 1800;

    String COOKIE_USER = "USERINFO";


    String DFAULT_PASSWORD = "000000";

    /** 登录成功欢迎页 */
    String WELCOME_INDEX_URL = "/my/index";

    /** 首页索引 */
    String INDEX_URL = "/index";

    /** URL: 跳转登录页面 */
    String TO_LOGIN_URL = "/toLogin";
    /** URL: 跳转注册*/
    String TO_SIGN_IN = "/toRegistor";
    /** URL: 注册*/
    String SIGN_IN = "/registor";
    /** URL: 登录 */
    String LOGIN_URL   = "/login";
    /** URL: 注销登录 */
    String LOGOUT_URL  = "/logout";
    /** URL: 异常跳转 */
    String ERROR_URL   = "/error";
    /** URL: 静态资源*/
    String STATIC_URL  = "/static/**";
    /** URL: 发送注册码 */
    String SEND_CHECK_CODE = "/sendCheckCode";
    /** URL: 图片验证码 */
    String IMG_VERIFY_CODE = "/verifyImg";

}
