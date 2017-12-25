package com.hexiaofei.springeurekaclient.domain;

/**
 * Created by Administrator on 2017/12/25.
 */
public class Order {

    private Integer orderId;
    private Integer userId;
    private String orderName;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
