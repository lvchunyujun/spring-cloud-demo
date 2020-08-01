package com.lcyj.common.consts;

public enum DomainTypeEnum {

    /**
     * 其他类型
     */
    OTHER((short)0,"OTHER");

    private final Short type;
    private final String descri;

    DomainTypeEnum(Short type, String descri) {
        this.type = type;
        this.descri = descri;
    }

    public Short getType() {
        return type;
    }

    public String getDescri() {
        return descri;
    }
}
