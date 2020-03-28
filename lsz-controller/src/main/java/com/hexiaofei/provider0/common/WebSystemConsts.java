package com.hexiaofei.provider0.common;

public interface WebSystemConsts {

    /** cookie 超时时间 */
    int COOKIEAGE = 1800;
    /** */
    String COOKIE_USER = "USERINFO";
    int COOKIE_OUTTIME = 600;

    String DFAULT_PASSWORD = "000000";

    /** URL: 跳转登录页面 */
    String ADMIN_TOLOGIN_URL = "/toLogin";
    /** URL: 登录 */
    String ADMIN_LOGIN_URL   = "/login";
    /** URL: 注销登录 */
    String ADMIN_LOGOUT_URL  = "/logout";
    /** URL: 异常跳转 */
    String ADMIN_ERROR_URL   = "/error";
    /** URL: 静态资源*/
    String ADMIN_STATIC_URL  = "/static/**";


}
