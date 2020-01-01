package com.hexiaofei.sjzclient.common;

import java.math.BigDecimal;

/**
 * 信用等级
 * 
 * @since v1.0
 * @history
 * @see
 */
public class CreditLevel
{
    /**
     * 信用等级名称
     */
    private String name;

    /**
     * 信用等级排序，此值越小说明排序越靠前
     */
    private int order;

    /**
     * 得分下限
     */
    private int minValue;

    /**
     * 得分上限
     */
    private int maxValue;
    
    /**
     * 风险金费率，注意此费率是乘以100后的值。
     * <br>例如：4.50表示4.5%
     */
    BigDecimal riskFeeRate;

    /**
     * 此等级对应的图片路径
     */
    private String picPath;
    
    /**
     * 信用等级的构造函数
     * @param name
     * @param order
     * @param minValue
     * @param maxValue
     * @param riskFeeRate
     */
    public CreditLevel(String name, int order, int minValue, int maxValue, BigDecimal riskFeeRate)
    {
        super();
        this.name = name;
        this.order = order;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.riskFeeRate = riskFeeRate;
    }

    
    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }


    /**
     * @return the order
     */
    public int getOrder()
    {
        return order;
    }


    /**
     * @return the minValue
     */
    public int getMinValue()
    {
        return minValue;
    }


    /**
     * @return the maxValue
     */
    public int getMaxValue()
    {
        return maxValue;
    }


    /**
     * @return the riskFeeRate 风险金费率，注意此费率是乘以100后的值。
     * <br>例如：4.50表示4.5%
     */
    public BigDecimal getRiskFeeRate()
    {
        return riskFeeRate;
    }


    /**
     * @return the picPath
     */
    public String getPicPath()
    {
        return picPath;
    }


    /**
     * @param 此等级对应的图片路径
     */
    public void setPicPath(String picPath)
    {
        this.picPath = picPath;
    }
    
    
    
}
