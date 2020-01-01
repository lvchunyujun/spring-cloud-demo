package com.hexiaofei.sjzclient.common;
/**
 * Email 发送类型
 */
public enum EmailSendType {

    /**
     * 注册
     */
    RERGISTER(){
        @Override
        public String toString() {
            return "注册";
        }
    },
    /**
     * 密码找回
     */
    REG_PASSWD() {

        @Override
        public String toString() {
            return "注册激活_密码找回";
        }
    },
    /**
     * 其他
     */
    OTHER() {

        @Override
        public String toString() {
            return "其他";
        }
    };

    @Override
    public abstract String toString();
}
