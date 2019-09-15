package com.hexiaofei.provider0.common.consts;

/**
 * 访问域名状态
 */
public enum DomainManageStatusEnum {

    NORMAL((short)0,"正常"),
    TEST((short)10,"测试"),
    BAN((short)20,"禁用");
    private Short code;
    private String status;

    DomainManageStatusEnum(Short code, String status) {
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
