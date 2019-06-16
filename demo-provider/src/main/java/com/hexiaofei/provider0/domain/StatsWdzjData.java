package com.hexiaofei.provider0.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/10.
 *  统计网贷之家数据
 */
public class StatsWdzjData implements Serializable{

    private Integer id ;
    private String platform ;
    private Double businessAmount ;
    private Double avgIncome ;
    private Double avgPeriod  ;
    private Integer periodType ;
    private Double shouldAmount  ;
    private Date statsTime;
    private Date createTime ;
    private String expand1  ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Double getBusinessAmount() {
        return businessAmount;
    }

    public void setBusinessAmount(Double businessAmount) {
        this.businessAmount = businessAmount;
    }
    public Double getAvgIncome() {
        return avgIncome;
    }

    public void setAvgIncome(Double avg_income) {
        this.avgIncome = avg_income;
    }

    public Double getAvgPeriod() {
        return avgPeriod;
    }

    public void setAvgPeriod(Double avgPeriod) {
        this.avgPeriod = avgPeriod;
    }

    public Integer getPeriodType() {
        return periodType;
    }

    public void setPeriodType(Integer periodType) {
        this.periodType = periodType;
    }

    public Double getShouldAmount() {
        return shouldAmount;
    }

    public void setShouldAmount(Double shouldAmount) {
        this.shouldAmount = shouldAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExpand1() {
        return expand1;
    }

    public void setExpand1(String expand1) {
        this.expand1 = expand1;
    }

    public Date getStatsTime() {
        return statsTime;
    }

    public void setStatsTime(Date statsTime) {
        this.statsTime = statsTime;
    }
}
