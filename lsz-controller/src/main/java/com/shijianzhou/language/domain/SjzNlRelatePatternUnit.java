package com.shijianzhou.language.domain;

import java.util.Date;

public class SjzNlRelatePatternUnit {
    /**
     *
     */
    private Integer id;

    /**
     *匹配模板名称(联合主键)
     */
    private String patternName;

    /**
     *顺序号（联合主键）
     */
    private Integer unitSerialNo;

    /**
     *正则表达式代码
     */
    private String regExpCode;

    /**
     *正则表达式
     */
    private String regExpPattern;

    /**
     *关联类型：0:包含（符合需求的内容） 10:排除（不符合条件的内容
     */
    private Short relateType;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *最后修改时间
     */
    private Date lastUpdateTime;

    /**
     *描述
     */
    private String descript;

    /**
     *使用状态： 0-开启   10-关闭
     */
    private Short useStatus;

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
     *匹配模板名称(联合主键)
     */
    public String getPatternName() {
        return patternName;
    }

    /**
     *匹配模板名称(联合主键)
     */
    public void setPatternName(String patternName) {
        this.patternName = patternName == null ? null : patternName.trim();
    }

    /**
     *顺序号（联合主键）
     */
    public Integer getUnitSerialNo() {
        return unitSerialNo;
    }

    /**
     *顺序号（联合主键）
     */
    public void setUnitSerialNo(Integer unitSerialNo) {
        this.unitSerialNo = unitSerialNo;
    }

    /**
     *正则表达式代码
     */
    public String getRegExpCode() {
        return regExpCode;
    }

    /**
     *正则表达式代码
     */
    public void setRegExpCode(String regExpCode) {
        this.regExpCode = regExpCode == null ? null : regExpCode.trim();
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

    /**
     *关联类型：-10:排除、10:包含
     */
    public Short getRelateType() {
        return relateType;
    }

    /**
     *关联类型：-10:排除、10:包含
     */
    public void setRelateType(Short relateType) {
        this.relateType = relateType;
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
     *最后修改时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     *最后修改时间
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     *描述
     */
    public String getDescript() {
        return descript;
    }

    /**
     *描述
     */
    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }

    /**
     *使用状态
     */
    public Short getUseStatus() {
        return useStatus;
    }

    /**
     *使用状态
     */
    public void setUseStatus(Short useStatus) {
        this.useStatus = useStatus;
    }
}