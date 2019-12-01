package com.hexiaofei.sjzclient.domain;


/**
 * Created by Administrator on 2017/7/7.
 */
public class P2PIncomeInfo implements java.io.Serializable{

    private int id;
    private String domainName;
    private String title;
    private String product;
    private String productNo;
    private String productUrl;
    private Integer loanPeriod;
    private Integer periodType;
    private Double annualIncome;
    private String repaymentType;
    private Double startAmount;
    private String source;
    private String statsTime;
    private String createTime;
    private String loanRelaseTime;
    private Double loanAmount;
    private String expand1;
    private String expand2;
    private String expand3;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    public Integer getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(Integer loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType;
    }

    public Double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(Double startAmount) {
        this.startAmount = startAmount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLoanRelaseTime() {
        return loanRelaseTime;
    }

    public void setLoanRelaseTime(String loanRelaseTime) {
        this.loanRelaseTime = loanRelaseTime;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getPeriodType() {
        return periodType;
    }

    public void setPeriodType(Integer periodType) {
        this.periodType = periodType;
    }

    public String getExpand1() {
        return expand1;
    }

    public void setExpand1(String expand1) {
        this.expand1 = expand1;
    }

    public String getExpand2() {
        return expand2;
    }

    public void setExpand2(String expand2) {
        this.expand2 = expand2;
    }

    public String getExpand3() {
        return expand3;
    }

    public void setExpand3(String expand3) {
        this.expand3 = expand3;
    }
    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getStatsTime() {
        return statsTime;
    }

    public void setStatsTime(String statsTime) {
        this.statsTime = statsTime;
    }

    @Override
    public String toString() {
        return "P2PIncomeInfo{" +
                "id=" + id +
                ", domainName='" + domainName + '\'' +
                ", title='" + title + '\'' +
                ", product='" + product + '\'' +
                ", loanPeriod=" + loanPeriod +
                ", annualIncome=" + annualIncome +
                ", repaymentType='" + repaymentType + '\'' +
                ", startAmount=" + startAmount +
                ", source='" + source + '\'' +
                ", createTime='" + createTime + '\'' +
                ", loanRelaseTime='" + loanRelaseTime + '\'' +
                ", loanAmount=" + loanAmount +
                ", expand1='" + expand1 + '\'' +
                ", expand2='" + expand2 + '\'' +
                ", expand3='" + expand3 + '\'' +
                '}';
    }
}
