package com.hexiaofei.provider0.common.consts;

/**
 * 访问域名状态
 */
public enum DomainStatusEnum {

    NORMAL((short)200,"正常"),
    NO_EXIST((short)-100,"网站不存在"),
    VISIT_OUTTIME((short)-99,"访问超时"),
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
