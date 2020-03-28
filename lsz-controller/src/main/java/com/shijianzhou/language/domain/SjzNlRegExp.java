package com.shijianzhou.language.domain;

import java.util.Date;

public class SjzNlRegExp {
    /**
     *
     */
    private Integer id;

    /**
     *正则表达式
     */
    private String regExpPattern;

    /**
     *正则表达式编码
     */
    private String regExpCode;

    /**
     *匹配实例
     */
    private String regExpDemo;

    /**
     *模板类型，组合正则表达式
     */
    private Short patternType;

    /**
     *匹配类型
     */
    private Short matchType;

    /**
     *是否检查
     */
    private Short checkStatus;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *正则表达式描述
     */
    private String descr;

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
     *正则表达式
     */
    public String getRegExpPattern() {
        return regExpPattern;
    }

    /**
     *正则表达式
     */
    public void setRegExpPattern(String regExpPattern) {
        this.regExpPattern = regExpPattern == null ? null : regExpPattern.trim();
    }

    public String getRegExpCode() {
        return regExpCode;
    }

    public void setRegExpCode(String regExpCode) {
        this.regExpCode = regExpCode;
    }

    /**
     *匹配实例
     */
    public String getRegExpDemo() {
        return regExpDemo;
    }

    /**
     *匹配实例
     */
    public void setRegExpDemo(String regExpDemo) {
        this.regExpDemo = regExpDemo == null ? null : regExpDemo.trim();
    }

    /**
     *模板类型，组合正则表达式
     */
    public Short getPatternType() {
        return patternType;
    }

    /**
     *模板类型，组合正则表达式
     */
    public void setPatternType(Short patternType) {
        this.patternType = patternType;
    }

    /**
     *匹配类型
     */
    public Short getMatchType() {
        return matchType;
    }

    /**
     *匹配类型
     */
    public void setMatchType(Short matchType) {
        this.matchType = matchType;
    }

    /**
     *是否检查
     */
    public Short getCheckStatus() {
        return checkStatus;
    }

    /**
     *是否检查
     */
    public void setCheckStatus(Short checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     *创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *正则表达式描述
     */
    public String getDescr() {
        return descr;
    }

    /**
     *正则表达式描述
     */
    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }
}