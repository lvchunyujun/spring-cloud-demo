package com.hexiaofei.sjzclient.domain;

import java.util.Date;

public class UserInfo {
    /**
     *
     */
    private Integer id;

    /**
     *用户昵称
     */
    private String nickName;

    /**
     *用户名
     */
    private String userName;

    /**
     *密码
     */
    private String password;

    /**
     *真实姓名
     */
    private String realName;

    /**
     *角色
     */
    private Short role;

    /**
     *身份证号码
     */
    private String idCard;

    /**
     *手机号码
     */
    private String phone;

    /**
     *email地址
     */
    private String email;

    /**
     *注册日期
     */
    private Date registerDate;

    /**
     *状态
     */
    private Short status;

    /**
     *登录次数
     */
    private Integer loginCount;

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
     *用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     *用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     *用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     *用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     *密码
     */
    public String getPassword() {
        return password;
    }

    /**
     *密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     *真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     *真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     *角色
     */
    public Short getRole() {
        return role;
    }

    /**
     *角色
     */
    public void setRole(Short role) {
        this.role = role;
    }

    /**
     *身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     *身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     *手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     *手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *注册日期
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     *注册日期
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     *状态
     */
    public Short getStatus() {
        return status;
    }

    /**
     *状态
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     *登录次数
     */
    public Integer getLoginCount() {
        return loginCount;
    }

    /**
     *登录次数
     */
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }
}