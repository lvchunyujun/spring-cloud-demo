package com.hexiaofei.sjzclient.common;
/**
 * Email 发送类型
 */
public enum EmailSendType {

    /**
     * 注册激活_密码找回
     */
    REG_CODE("REG_PASSWD","注册验证码"),
    /**
     * 其他
     */
    OTHER("OTHER","其他");

    private String type;
    private String descri;


    EmailSendType(String type, String descri) {
        this.type = type;
        this.descri = descri;
    }

    public String getType() {
        return type;
    }

    public String getDescri() {
        return descri;
    }
}
