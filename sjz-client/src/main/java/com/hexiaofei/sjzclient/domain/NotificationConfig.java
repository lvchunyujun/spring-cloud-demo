package com.hexiaofei.sjzclient.domain;

import java.io.Serializable;
/**
 * 发送消息配置，三位比特数：
 *      [_][_][_]： 第1位，短信；
 *       		       第2位，邮件；
 *       		       第3位，站内信；
 * @author hexiaofei
 *
 */
public class NotificationConfig implements Serializable {
	public NotificationConfig() {
		this.borrowerLoanDead = 0;
		this.borrowerLoanRejected = 0;
		this.borrowerLoanReleased = 0;
		this.borrowerOverDueNotice = 0;
		this.borrowerPlatformNotice = 0;
		this.borrowerRepayReminder = 0;
		
		this.investorCommentReplied = 0;
		this.investorInvest = 0;
		this.investorLoanDead = 0;
		this.investorLoanReleased = 0;
		this.investorNewProduct = 0;
		this.investorRepay = 0;
	}
    /**
	 * 
	 */
	private static final long serialVersionUID = 610750700918835228L;

	/**
     *
     */
    private Integer id;

    /**
     *用户ID
     */
    private Integer userId;

    /**
     *投资者-已投标
     */
    private Short investorInvest;

    /**
     *投资者-已投的标回款
     */
    private Short investorRepay;

    /**
     *投资者-已投的标流标
     */
    private Short investorLoanDead;

    /**
     *投资者-已投的标放款
     */
    private Short investorLoanReleased;

    /**
     *投资者-平台的新产品
     */
    private Short investorNewProduct;

    /**
     *投资者-留言被回复
     */
    private Short investorCommentReplied;

    /**
     *借款者-满标放款
     */
    private Short borrowerLoanReleased;

    /**
     *借款者-审核未通过
     */
    private Short borrowerLoanRejected;

    /**
     *借款者-流标
     */
    private Short borrowerLoanDead;

    /**
     *借款者-平台通知
     */
    private Short borrowerPlatformNotice;

    /**
     *借款者-提前3天还款提醒
     */
    private Short borrowerRepayReminder;

    /**
     *借款者-逾期通知
     */
    private Short borrowerOverDueNotice;
    
    /**
     * 消息设置
     */
//    private String messageSetup;
    
    /**
     * 提现申请
     */
    private Short withdrawApply;
    
    /**
     * 提现成功
     */
    private Short withdrawSuccess;
    
    /**
     * 提现失败
     */
    private Short withdrawFailed;
    
    /**
     * 充值成功
     */
    private Short rechargeSuccess;
    
    /**
     * 登录失败
     */
    private Short loginFailed;
    
    /**
     * 修改登录密码
     */
    private Short modifyLoginPassword;
    
    /**
     * 修改支付密码
     */
    private Short modifyPayPassword;
    
    private Short borrowerLoanAgree;
    
    public Short getBorrowerLoanAgree() {
        return borrowerLoanAgree;
    }

    public void setBorrowerLoanAgree(Short borrowerLoanAgree) {
        this.borrowerLoanAgree = borrowerLoanAgree;
    }

    public Short getWithdrawApply() {
        return withdrawApply;
    }

    public void setWithdrawApply(Short withdrawApply) {
        this.withdrawApply = withdrawApply;
    }

    public Short getWithdrawSuccess() {
        return withdrawSuccess;
    }

    public void setWithdrawSuccess(Short withdrawSuccess) {
        this.withdrawSuccess = withdrawSuccess;
    }

    public Short getWithdrawFailed() {
        return withdrawFailed;
    }

    public void setWithdrawFailed(Short withdrawFailed) {
        this.withdrawFailed = withdrawFailed;
    }

    public Short getRechargeSuccess() {
        return rechargeSuccess;
    }

    public void setRechargeSuccess(Short rechargeSuccess) {
        this.rechargeSuccess = rechargeSuccess;
    }

    public Short getLoginFailed() {
        return loginFailed;
    }

    public void setLoginFailed(Short loginFailed) {
        this.loginFailed = loginFailed;
    }

    public Short getModifyLoginPassword() {
        return modifyLoginPassword;
    }

    public void setModifyLoginPassword(Short modifyLoginPassword) {
        this.modifyLoginPassword = modifyLoginPassword;
    }

    public Short getModifyPayPassword() {
        return modifyPayPassword;
    }

    public void setModifyPayPassword(Short modifyPayPassword) {
        this.modifyPayPassword = modifyPayPassword;
    }

//    public String getMessageSetup() {
//		return messageSetup;
//	}
//
//	public void setMessageSetup(String messageSetup) {
//		this.messageSetup = messageSetup;
//	}

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
     *用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *投资者-已投标
     */
    public Short getInvestorInvest() {
        return investorInvest;
    }

    /**
     *投资者-已投标
     */
    public void setInvestorInvest(Short investorInvest) {
        this.investorInvest = investorInvest;
    }

    /**
     *投资者-已投的标回款
     */
    public Short getInvestorRepay() {
        return investorRepay;
    }

    /**
     *投资者-已投的标回款
     */
    public void setInvestorRepay(Short investorRepay) {
        this.investorRepay = investorRepay;
    }

    /**
     *投资者-已投的标流标
     */
    public Short getInvestorLoanDead() {
        return investorLoanDead;
    }

    /**
     *投资者-已投的标流标
     */
    public void setInvestorLoanDead(Short investorLoanDead) {
        this.investorLoanDead = investorLoanDead;
    }

    /**
     *投资者-已投的标放款
     */
    public Short getInvestorLoanReleased() {
        return investorLoanReleased;
    }

    /**
     *投资者-已投的标放款
     */
    public void setInvestorLoanReleased(Short investorLoanReleased) {
        this.investorLoanReleased = investorLoanReleased;
    }

    /**
     *投资者-平台的新产品
     */
    public Short getInvestorNewProduct() {
        return investorNewProduct;
    }

    /**
     *投资者-平台的新产品
     */
    public void setInvestorNewProduct(Short investorNewProduct) {
        this.investorNewProduct = investorNewProduct;
    }

    /**
     *投资者-留言被回复
     */
    public Short getInvestorCommentReplied() {
        return investorCommentReplied;
    }

    /**
     *投资者-留言被回复
     */
    public void setInvestorCommentReplied(Short investorCommentReplied) {
        this.investorCommentReplied = investorCommentReplied;
    }

    /**
     *借款者-满标放款
     */
    public Short getBorrowerLoanReleased() {
        return borrowerLoanReleased;
    }

    /**
     *借款者-满标放款
     */
    public void setBorrowerLoanReleased(Short borrowerLoanReleased) {
        this.borrowerLoanReleased = borrowerLoanReleased;
    }

    /**
     *借款者-审核未通过
     */
    public Short getBorrowerLoanRejected() {
        return borrowerLoanRejected;
    }

    /**
     *借款者-审核未通过
     */
    public void setBorrowerLoanRejected(Short borrowerLoanRejected) {
        this.borrowerLoanRejected = borrowerLoanRejected;
    }

    /**
     *借款者-流标
     */
    public Short getBorrowerLoanDead() {
        return borrowerLoanDead;
    }

    /**
     *借款者-流标
     */
    public void setBorrowerLoanDead(Short borrowerLoanDead) {
        this.borrowerLoanDead = borrowerLoanDead;
    }

    /**
     *借款者-平台通知
     */
    public Short getBorrowerPlatformNotice() {
        return borrowerPlatformNotice;
    }

    /**
     *借款者-平台通知
     */
    public void setBorrowerPlatformNotice(Short borrowerPlatformNotice) {
        this.borrowerPlatformNotice = borrowerPlatformNotice;
    }

    /**
     *借款者-提前3天还款提醒
     */
    public Short getBorrowerRepayReminder() {
        return borrowerRepayReminder;
    }

    /**
     *借款者-提前3天还款提醒
     */
    public void setBorrowerRepayReminder(Short borrowerRepayReminder) {
        this.borrowerRepayReminder = borrowerRepayReminder;
    }

    /**
     *借款者-逾期通知
     */
    public Short getBorrowerOverDueNotice() {
        return borrowerOverDueNotice;
    }

    /**
     *借款者-逾期通知
     */
    public void setBorrowerOverDueNotice(Short borrowerOverDueNotice) {
        this.borrowerOverDueNotice = borrowerOverDueNotice;
    }
    
    /**
     * 设置是否允许发送邮件
     * @param in
     * @param isEmail
     * @return
     * 
     */
    public static Short setIsEmail(Short in, boolean isEmail){
    	Short out = 0;
    	if(isEmail) {
    		out = (short) (in | 2); //010
    	}else {
    		out = (short) (in & 5); //101
    	}
    	return out;
    };
    
    /**
     * 获取是否允许发送邮件
     * @param in
     * @return
     * 
     */
    public static boolean getIsEmail(Short in) {
    	boolean isEmail = false;
    	if((in & 2) > 0) { //010
    		isEmail = true;
    	}
    	return isEmail;
    };
    
    /**
     * 设置是否允许发送短信
     * @param in
     * @param isSMS
     * @return
     * 
     */
    public static Short setIsSMS(Short in, boolean isSMS){
    	Short out = 0;
    	if(isSMS) {
    		out = (short) (in | 4); //100
    	}else {
    		out = (short) (in & 3); //011
    	}
    	return out;
    };
    
    /**
     * 获取是否允许发送短信
     * @param in
     * @return
     * 
     */
    public static boolean getIsSMS(Short in) {
    	boolean isSMS = false;
    	if((in & 4) > 0) { //100
    		isSMS = true;
    	}
    	return isSMS;
    };
    
    /**
     * 设置是否允许发送站内信
     * @param in
     * @param isInnerMail
     * @return
     * 
     */
    public static Short setIsInnerMail(Short in, boolean isInnerMail){
    	Short out = 0;
    	if(isInnerMail) {
    		out = (short) (in | 1); //001
    	}else {
    		out = (short) (in & 6); //110
    	}
    	return out;
    };
    
    /**
     * 获取是否允许发送站内信
     * @param in
     * @return
     * 
     */
    public static boolean getIsInnerMail(Short in) {
    	boolean isInnerMail = false;
    	if((in & 1) > 0) { //001
    		isInnerMail = true;
    	}
    	return isInnerMail;
    };
}
