package com.lcyj.servicedemo.model;

import java.util.Date;

public class UserRegisterTemp {
    /**
     *
     */
    private Integer id;

    /**
     *邮件
     */
    private String email;

    /**
     *用户昵称
     */
    private String nickName;

    /**
     *密码
     */
    private String passwd;

    /**
     *注册时间
     */
    private Date registerTime;

    /**
     *角色，参见com.lejinwang.core.consts.user.UserRolesType
     */
    private Short roles;

    /**
     *安全问题
     */
    private String question;

    /**
     *安全问题答案
     */
    private String answer;

    /**
     *新浪微博uid
     */
    private String weiboUId;

    /**
     *新浪微博AccessToken
     */
    private String weiboAccessToken;

    /**
     *腾讯uid
     */
    private String qqUId;

    /**
     *腾讯AccessToken
     */
    private String qqAccessToken;

    /**
     *借款用户的渠道
     */
    private Short origin;

    /**
     *所属客户经理
     */
    private Integer staffId;

    /**
     *推荐人id
     */
    private Integer inviterId;

    /**
     *注册的手机号码
     */
    private String mobile;

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
     *邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     *邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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
     *密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     *密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     *注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     *注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     *角色，参见com.lejinwang.core.consts.user.UserRolesType
     */
    public Short getRoles() {
        return roles;
    }

    /**
     *角色，参见com.lejinwang.core.consts.user.UserRolesType
     */
    public void setRoles(Short roles) {
        this.roles = roles;
    }

    /**
     *安全问题
     */
    public String getQuestion() {
        return question;
    }

    /**
     *安全问题
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     *安全问题答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     *安全问题答案
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     *新浪微博uid
     */
    public String getWeiboUId() {
        return weiboUId;
    }

    /**
     *新浪微博uid
     */
    public void setWeiboUId(String weiboUId) {
        this.weiboUId = weiboUId == null ? null : weiboUId.trim();
    }

    /**
     *新浪微博AccessToken
     */
    public String getWeiboAccessToken() {
        return weiboAccessToken;
    }

    /**
     *新浪微博AccessToken
     */
    public void setWeiboAccessToken(String weiboAccessToken) {
        this.weiboAccessToken = weiboAccessToken == null ? null : weiboAccessToken.trim();
    }

    /**
     *腾讯uid
     */
    public String getQqUId() {
        return qqUId;
    }

    /**
     *腾讯uid
     */
    public void setQqUId(String qqUId) {
        this.qqUId = qqUId == null ? null : qqUId.trim();
    }

    /**
     *腾讯AccessToken
     */
    public String getQqAccessToken() {
        return qqAccessToken;
    }

    /**
     *腾讯AccessToken
     */
    public void setQqAccessToken(String qqAccessToken) {
        this.qqAccessToken = qqAccessToken == null ? null : qqAccessToken.trim();
    }

    /**
     *借款用户的渠道
     */
    public Short getOrigin() {
        return origin;
    }

    /**
     *借款用户的渠道
     */
    public void setOrigin(Short origin) {
        this.origin = origin;
    }

    /**
     *所属客户经理
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     *所属客户经理
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     *推荐人id
     */
    public Integer getInviterId() {
        return inviterId;
    }

    /**
     *推荐人id
     */
    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
    }

    /**
     *注册的手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *注册的手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
}