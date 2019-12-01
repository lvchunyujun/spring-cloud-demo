package com.hexiaofei.sjzclient.domain;

public class SjzBasePinyin {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String pinYin;

    /**
     *
     */
    private Integer pyCode;

    /**
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     */
    public String getPinYin() {
        return pinYin;
    }

    /**
     *
     */
    public void setPinYin(String pinYin) {
        this.pinYin = pinYin == null ? null : pinYin.trim();
    }

    /**
     *
     */
    public Integer getPyCode() {
        return pyCode;
    }

    /**
     *
     */
    public void setPyCode(Integer pyCode) {
        this.pyCode = pyCode;
    }
}