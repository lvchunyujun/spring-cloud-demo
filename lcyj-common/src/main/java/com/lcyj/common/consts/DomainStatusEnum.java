package com.lcyj.common.consts;

/**
 * 访问域名状态
 */
public enum DomainStatusEnum {

    NEW_INIT((short)-200,"新增状态"),
    NO_EXIST((short)-100,"网站不存在"),
    VISIT_OUTTIME((short)-99,"访问超时"),
    NORMAL((short)200,"正常"),
    STATUS_430((short)430,"状态430");
    private Short code;
    private String status;

    DomainStatusEnum(Short code, String status) {
        this.code = code;
        this.status = status;
    }

    public Short getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
