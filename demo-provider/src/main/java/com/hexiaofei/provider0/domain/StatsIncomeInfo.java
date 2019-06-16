package com.hexiaofei.provider0.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by Administrator on 2017/7/10.
 * 平台网站收益统计
 */
public class StatsIncomeInfo implements Serializable{

    private Integer id;
    private Integer period;
    private Integer periodType;
    private Double annualIncome;
    private Integer loanCount;
    private Double businessAmount;
    private Date statsTime;
    private Date createTime;
    private Double expand1;
    private String expand2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getPeriodType() {
        return periodType;
    }

    public void setPeriodType(Integer periodType) {
        this.periodType = periodType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getExpand1() {
        return expand1;
    }

    public void setExpand1(Double expand1) {
        this.expand1 = expand1;
    }

    public String getExpand2() {
        return expand2;
    }

    public void setExpand2(String expand2) {
        this.expand2 = expand2;
    }

    public Integer getLoanCount() {
        return loanCount;
    }

    public void setLoanCount(Integer loanCount) {
        this.loanCount = loanCount;
    }

    public Double getBusinessAmount() {
        return businessAmount;
    }

    public void setBusinessAmount(Double businessAmount) {
        this.businessAmount = businessAmount;
    }

    public Date getStatsTime() {
        return statsTime;
    }

    public void setStatsTime(Date statsTime) {
        this.statsTime = statsTime;
    }
}
