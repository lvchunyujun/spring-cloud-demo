package com.hexiaofei.sjzclient.common;

public class EmailTemplate {

    /**
     * 注册成功提醒邮件
     */
    public static final String REG_CHECK_CODE = "<div style='color:#333333;'>"
            + "<p>亲爱的"+PlatformConstant.PLATFORM_NAME+"用户：您好！</p>"
            + "<p>感谢您注册"+PlatformConstant.SERVER_WEBSITE+"，这是您的注册验证码【%s】。</p>"
            + "<br />"
            + "<p style='color:#333333;'>感谢您对历史轴网站的支持！</p>"
            + "<br />"
            + "<p>---------------------------------- </p>"
            + "<p style='color:#333333;'>注：此邮件由"+PlatformConstant.SERVER_NAME+"系统自动发送，请勿回复 </p>"
            + "<p style='color:#333333;'>&nbsp;</p>"
            + "<p style='color:#333333;'>&nbsp;</p>"
            + "<p style='color:#333333;'>&copy;2020 "+PlatformConstant.SERVER_WEBSITE+" | 历史轴 </p>"
            + "</div>";

}
