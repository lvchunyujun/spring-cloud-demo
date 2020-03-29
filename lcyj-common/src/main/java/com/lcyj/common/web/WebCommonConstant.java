package com.lcyj.common.web;

/**
 * web常量
 */
public class WebCommonConstant {

     public final static String URL_INDEX = "index";
     public final static String URL_TO_ADD = "toAdd";
     public final static String URL_ADD = "add";
     public final static String URL_GET = "get";
     public final static String URL_TO_UPDATE = "toUpadte";
     public final static String URL_UPDATE = "upadte";
     public final static String URL_DELETE = "delete";
     public final static String URL_LIST = "list";


     /** 注册校验码超时时间 */
     public final static int COOKIE_CHECK_CODE_OUTTIME = 1*2;
     /** 登录超时时间*/
     public final static int COOKIE_LOGIN_IN_OUTTIME = 1000*60*10;

     public final static String OK = "OK";
     public final static String FAIL = "FAIL";
     /**
      * 注册验证码:SESSION-KEY
      */
     public final static String REGISTER_CHECK_CODE = "REGISTER_CHECK_CODE";
     public final static String REGISTER_CHECK_EMAIL = "REGISTER_CHECK_EMAIL";
}
