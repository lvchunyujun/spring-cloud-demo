package com.hexiaofei.sjzclient.common;

import java.math.BigDecimal;

/**
 * 各种常量定义
 * 
 * 
 */
public interface CommonDef
{

    /** 系统版本号 */
	final public static String PLATFORM_VERSION = "v2.1.1";
	
    final public static String WEBSITE_NAME_CN = "乐金网";
    
    final public static String WEBSITE_SMSNAME_CN = "【乐金网】";

    final public static String WEBSITE_NAME_EN = "lejinwang.com";
    
    final public static String EMAIL_SERVICE = "service@lejinwang.com";

    final public static String SMTP_SERVER = "smtp.exmail.qq.com";
    
    final public static String SMTP_PASSWORD = "ljw_20150501";
    
    final public static String SERVICE_PHONE = "400-013-1876";
    /**
     * 后台地址
     */
    final public static String BACKSTAGE_ADDRESS="http://lejinwang.com/mgmt";
    
    /**
     * 财务人员邮件
     */
    final public static String FINANCIAL_EMAIL = "caiwu@lejinwang.com";
    
    /**
     * 管理人员邮件
     *   定时发送平台运行情况邮件
     */
    final public static String ADMIN_EMAIL = "hexf@lejinwang.com";

    /**
     * web服务器ip
     */
    final public static String WEBSITE_IP = "127.0.0.2";
    
    /**
     * 域名
     */
    final public static String WEBSITE_DOMAIN_NAME = "lejinwang.com";

    /**
     * 测试服务器IP
     */
    final public static String TEST_SERVER_IP = "127.0.0.2";
    
    /**
     * web服务器端口
     */
    final public static String WEBSITE_PORT = "80";

    final static String ApplicationContextRoot = "applicationContext/";

    /**
     * 本地applicationContext.xml的相对位置
     */
    final static String ApplicationContextPath = ApplicationContextRoot + "applicationContext.xml";

    /**
     * 远程applicationContext.xml的相对位置
     */
    final static String ApplicationContext_Spring_RMI_Client_Path = ApplicationContextRoot
            + "applicationContext-spring-rmi-client.xml";

    /**
     * Thirdparty applicationContext.xml的相对位置
     */
    final static String ApplicationContext_ThirdParty_Path = ApplicationContextRoot
            + "applicationContext-thirdparty.xml";
    
    final static String ApplicationContext_Quzrtz_Path = ApplicationContextRoot + "applicationContext-quartz.xml";

    final static String PIC_ROOT = "/usr/lejinwang/pic";

    /**
     * 用户自有图片存储路径
     */
    final static String USER_PIC_FOLDER = PIC_ROOT + "/user/";

    /**
     * 标自有图片存储路径
     */
    final static String LOAN_PIC_FOLDER = PIC_ROOT + "/loan/";
    
    /**
     * 借款人企业信息图片
     */
    final static String COMPANY_PIC_FOLDER = PIC_ROOT+"/company_credent/";
    /**
     * 认证材料存储路径
     */
    final static String CREDIT_PIC_FOLDER = PIC_ROOT + "/credit/";
    /**
     * 用户上传头像临时存放路径
     */
    final static String USER_HEAR_FOLDER = PIC_ROOT + "/userhead/";
    /**
     * 身份证图片的保存路径
     */
    final static String USER_IDCARD_FOLDER = PIC_ROOT + "/idcard/";
    /**
     * 上传图片的小图相对存放路径
     */
    final static String PIC_MIN = "/140px/";
    /**
     * 上传图片的原图相对存放路径
     */
    final static String PIC_PROTOTYPE = "/prototype/";

    /**
     * 生成FICO三向图临时目录
     */

    final static String PIC_FICO_TMP = PIC_ROOT + "/fico_tmp/";

    /**
     * FICO三向图存放路径
     */

    final static String PIC_FICO = PIC_ROOT + "/fico/";

    /**
     * 马赛克图存放路径
     */

    final static String PIC_MOSAIC = PIC_ROOT + "/mosaic/";
    /**
     * 小贷公司上传文件路径
     */
    final static String PIC_COMPANY = PIC_ROOT + "/company/";

    /**
     * 原密码错误
     */
    public static final int WRONG_OLD_PASSWORD = -1;

    /**
     * 密码更新成功
     */
    public static final int PASSWORD_UPDATE_SUCCESS = 1;

    /**
     * 密码更新失败
     */
    public static final int PASSWORD_UPDATE_FAIL = 0;

    /**
     * 用户名不存在
     */
    public static final int USERNAME_NOT_EXIST = -1;

    /**
     * 密码错误
     */
    public static final int WRONG_PASSWORD = -2;

    /**
     * 刪除失敗
     */
    public static final int DELETE_FAIL = -1;

    /**
     * 刪除成功
     */
    public static final int DELETE_SUCCESS = 1;

    /**
     * 更新失敗
     */
    public static final int UPDATE_FAIL = -1;

    /**
     * 更新成功
     */
    public static final int UPDATE_SUCCESS = 1;

    /**
     * 一秒钟长度
     */
    long ONE_SECOND = 1000;
    /**
     * 一分钟的长度
     */
    long ONE_MINUTE = 60L * 1000;
    /**
     * 一个小时的长度，修改此值将影响邮件验证过期的判断
     */
    long ONE_HOUR = ONE_MINUTE * 60;
    /**
     * 一天的长度，修改此值将影响逾期天数的计算
     */
    long ONE_DAY = ONE_HOUR * 24;
    /**
     * 一个月的长度，修改此值将影响信用认证的过期时间
     */
    long ONE_MONTH = 30 * ONE_DAY;
    /**
     * 一年的长度
     */
    long ONE_YEAR = ONE_DAY * 365;

    /**
     * 资金来往类型，小于1000的都是汇入，即资金增加；大于1000的都是汇出，即资金减少
     */


    /**
     * 资金来往类型，小于1000的都是汇入，即资金增加；大于1000的都是汇出，即资金减少
     */

    // -------------------------------------------------------------------
    // 资金记录类型定义 开始
    // 所有奇数代表汇出，偶数代表汇入
    // -------------------------------------------------------------------

//----------2014-11-8  柏松注释  开始-------
    
//资金记录类型今后请用com.lejinwang.core.consts.money.TradeType
    
//    // ------------- 0-299 的号段分配给系统中转账户
//    /**
//     * 系统中转账户 - 放标时，付款给借款人
//     */
//    public static final short MONEYRECORD_SYSTEM_TRANSIT_RELEASE_LOAN = 101;
//
//    // ------------- 300-599 的号段分配给系统风险保证金账户
//    /**
//     * 系统风险保证金账户 - 放标时，借款人支付风险保证金给风险保证金账户
//     */
//    public static final short MONEYRECORD_SYSTEM_RISK_FEE_ADD = 300;
//
//    // ------------- 600-899 的号段分配给系统收入账户
//    /**
//     * 系统收入账户 - 放标时，借款人支付手续费给收入账户
//     */
//    public static final short MONEYRECORD_SYSTEM_INCOME_ADD = 600;

    // ------------------资金记录类型定义 结束------------------
//
//    /**
//     * 汇入-充值（国付宝）
//     */
//    public static final short TRADE_TYPE_IN_RECHARGE = 100;
//    
//    /**
//     * 汇入-充值（财付通）
//     */
//    public static final short TRADE_TYPE_IN_RECHARGE_TENPAY = 101;
//    
//    /**
//     * 汇入-充值（华利金控）
//     */
//    public static final short TRADE_TYPE_IN_RECHARGE_WALLY = 102;
//    
//    /**
//     * 汇入-后台充值
//     */
//    public static final short TRADE_TYPE_IN_RECHARGE_MGMT = 110;
//    
//    /**
//     * 汇入-邀请好友返利
//     */
//    public static final short TRADE_TYPE_IN_INVITATION_PROFIT = 120;
//    
//    /**
//     * 汇入-推广活动返利
//     */
//    public static final short TRADE_TYPE_IN_PROMOTION_PROFIT = 125;
//
//    /**
//     * 汇入-提现（拒绝）
//     */
//    public static final short TRADE_TYPE_IN_WITHDRAW = 150;
//    
//    /**
//     * 汇入-提现（银行退回）
//     */
//    public static final short TRADE_TYPE_IN_WITHDRAW_REFUNDED = 160;
//
//    /**
//     * 汇入-回收本息
//     */
//    public static final short TRADE_TYPE_IN_REPAYED = 200;
//
//    /**
//     * 汇入-提前收到回收的本息
//     */
//    public static final short TRADE_TYPE_IN_REPAYED_IN_ADVANCE = 210;
//    
//    /**
//     * 汇入-回收本金
//     */
//    public static final short TRADE_TYPE_IN_REPAYED_PRINCIPAL = 220;
//    
//    /**
//     * 汇入-回收正常利息
//     */
//    public static final short TRADE_TYPE_IN_REPAYED_INTEREST = 230;
//    
//    /**
//     * 汇入-提前收到回收的本金
//     */
//    public static final short TRADE_TYPE_IN_REPAYED_IN_ADVANCE_PRINCIPAL = 240;
//    
//    /**
//     * 汇入-提前还款利息（精确到天）
//     */
//    public static final short TRADE_TYPE_IN_REPAYED_IN_ADVANCE_INTEREST = 250;
//    
//    /**
//     * 汇入-提前还款20%罚息
//     */
//    public static final short TRADE_TYPE_IN_REPAYED_IN_ADVANCE_PUNITIVE_INTEREST = 255;
//    
//    /**
//     * 汇入-逾期罚息
//     */
//    public static final short TRADE_TYPE_IN_REPAYED_OVERDUE_INTEREST = 260;
//
//    /**
//     * 汇入-招标成功（针对借款人）
//     */
//    public static final short TRADE_TYPE_IN_BORROW_SUCCESS = 300;
//
//    /**
//     * 汇入-平台账户得到手续费收入（只限于平台收入账户）
//     */
//    public static final short TRADE_TYPE_IN_TRANSACTION_FEE = 500;
//    
//    /**
//     * 汇入-平台账户得到滞纳金收入（只限于平台收入账户）
//     */
//    public static final short TRADE_TYPE_IN_OVERDUE_FEE = 510;
//
//    /**
//     * 汇入-风险保证金（只限于平台风险保证金账户）
//     */
//    public static final short TRADE_TYPE_IN_RISK_FEE = 550;
//
//    /**
//     * 汇入-卖出债权
//     */
//    public static final short TRADE_TYPE_IN_SELL_CREDIT_RIGHTS = 600;
//    
//    /**
//     * 汇入-流标
//     */
//    public static final short TRADE_TYPE_IN_KILL_LOAN = 650;
//
//    /**
//     * 汇出-提现
//     */
//    public static final short TRADE_TYPE_OUT_WITHDRAW = 1100;
//    /**
//     * 汇出-提现手续费
//     */
//    public static final short TRADE_TYPE_OUT_WITHDRAW_FEE = 1110;
//
//    /**
//     * 汇出-提现冻结
//     */
//    public static final short TRADE_TYPE_OUT_CASH_WITHDRAW_FROZEN = 1150;
//    
//    /**
//     * 汇出-充值退回（第三方充值平台原卡退回）
//     */
//    public static final short TRADE_TYPE_OUT_CASH_WITHDRAW_THIRDPARTY = 1151;
//
//    /**
//     * 汇出-偿还本息（针对借款人）
//     */
//    public static final short TRADE_TYPE_OUT_REPAYING = 1200;
//
//    /**
//     * 汇出-提前偿还本息（针对借款人）
//     */
//    public static final short TRADE_TYPE_OUT_REPAYING_IN_ADVANCE = 1210;
//    
//    /**
//     * 汇出-偿还本金（针对借款人）
//     */
//    public static final short TRADE_TYPE_OUT_REPAYING_PRINCIPAL = 1220;
//    
//    /**
//     * 汇出-偿还正常利息（针对借款人）
//     */
//    public static final short TRADE_TYPE_OUT_REPAYING_INTEREST = 1230;
//    
//    /**
//     * 汇出-提前偿还本金（针对借款人）
//     */
//    public static final short TRADE_TYPE_OUT_REPAYING_IN_ADVANCE_PRINCIPAL = 1240;
//    
//    /**
//     * 汇出-提前还款利息（精确到天）（针对借款人）
//     */
//    public static final short TRADE_TYPE_OUT_REPAYING_IN_ADVANCE_INTEREST = 1250;
//    
//    /**
//     * 汇出-提前还款20%罚息（针对借款人）
//     */
//    public static final short TRADE_TYPE_OUT_REPAYING_IN_ADVANCE_PUNITIVE_INTEREST = 1255;
//    
//    /**
//     * 汇出-支付逾期罚息（针对借款人）
//     */
//    public static final short TRADE_TYPE_OUT_REPAYING_OVERDUE_INTEREST = 1260;
//
//    /**
//     * 汇出-投标成功
//     */
//    public static final short TRADE_TYPE_OUT_LEND_SUCCESS = 1300;
//
//    /**
//     * 汇出-投标冻结
//     */
//    public static final short TRADE_TYPE_OUT_BIDDING_FROZEN = 1350;
//
//    /**
//     * 汇出-债权交易手续费（针对投资人-债权出让方）
//     */
//    public static final short TRADE_TYPE_OUT_TRADE_COMMISSION_FEE = 1400;
//    
//    /**
//     * 汇出-借款人支付借款手续费
//     */
//    public static final short TRADE_TYPE_OUT_TRANSACTION_FEE = 1500;
//    
//    /**
//     * 汇出-借款人支付逾期滞纳金
//     */
//    public static final short TRADE_TYPE_OUT_OVERDUE_FEE = 1510;
//
//    /**
//     * 汇出-借款人支付风险保证金
//     */
//    public static final short TRADE_TYPE_OUT_RISK_FEE = 1550;
//
//    /**
//     * 汇出-买入债权
//     */
//    public static final short TRADE_TYPE_OUT_BUY_CREDIT_RIGHTS = 1600;

    public final static String[][] CONSTANT_PROVIENCE = { { "11", "北京" }, { "12", "天津" }, { "13", "河北" },
            { "14", "山西" }, { "15", "内蒙古" }, { "21", "辽宁" }, { "22", "吉林" }, { "23", "黑龙江" }, { "31", "上海" },
            { "32", "江苏" }, { "33", "浙江" }, { "34", "安徽" }, { "35", "福建" }, { "36", "江西" }, { "37", "山东" },
            { "41", "河南" }, { "42", "湖北" }, { "43", "湖南" }, { "44", "广东" }, { "45", "广西" }, { "46", "海南" },
            { "50", "重庆" }, { "51", "四川" }, { "52", "贵州" }, { "53", "云南" }, { "54", "西藏" }, { "61", "陕西" },
            { "62", "甘肃" }, { "63", "青海" }, { "64", "宁夏" }, { "65", "新疆" }, { "71", "台湾" }, { "81", "香港" },
            { "82", "澳门" }, { "91", "国外" } };

    /**
     * 浏览器类型
     */
    public enum BROWSER_TYPE {
    	IE6((short)100),IE7((short)110),IE8((short)120),IE9((short)130),IE10((short)140),IE11((short)150),IE12((short)160),FIREFOX((short)200),CHROME((short)300),OPERA((short)400),B360((short)500),MAXTHON((short)600),QQ((short)610),GREEN((short)620),SAFARI((short)630),SOGOU((short)640),OTHER((short)999);
    	private short value;
    	BROWSER_TYPE(short value) {
    		this.value = value;
    	}
    	public short getValue() {
    		return this.value;
    	}
    }

    /**
     * 操作系统类型
     */
    public enum OS_TYPE {
    	WIN95((short)100),WIN98((short)110),WINME((short)120),WINNT4((short)130),WIN2K((short)140),WINXP((short)150),WIN7((short)160),WIN8((short)170),WIN9((short)180),WIN2003((short)200),WIN2008((short)210),LINUX((short)300),MAC((short)400),UNIX((short)500),IOS((short)600),ANDROID((short)700),SUNOS((short)800),OTHER((short)900);
    	private short value;
    	OS_TYPE(short value) {
    		this.value = value;
    	}
    	public short getValue() {
    		return this.value;
    	}
    }

    /**
     * 检查数据库中已有的实名信息
     */
    // 数据库中不存在该身份证号。流程继续，前往国政通。
    public static final short CHECK_IDCARDNO_NOT_EXIST = 0;

    // 数据库中存在该身份证号，且通过实名认证。流程跳过国政通验证。
    public static final short CHECK_IDCARDNO_EXIST_AND_VERIFIED = 1;

    // 数据库中存在该身份证号，但是与实名不匹配。流程停止，提示身份证与真实姓名不匹配。
    public static final short CHECK_IDCARDNO_EXIST_BUT_NOT_MATCHED = 2;

    // 数据库中存在该身份证号，但是该角色已注册。流程停止，提示角色重复注册。
    public static final short CHECK_IDCARDNO_EXIST_BUT_REGISTERED = 3;

    // 数据库中存在该身份证号，但是因为还有欠款被禁止投资。流程停止，提示以前注册有借款人角色且有欠款，被禁止投资。
    public static final short CHECK_IDCARDNO_EXIST_BUT_FORBIDDEN = 4;

    /**
     * 消息类型定义开始
     */
    /**
     * 投资人投资成功
     */
    public static final short INNER_MAIL_TYPE_INVESTOR_SUCCESS = 101; 
    
    /**
     * 站内信类别-投资人-新回款
     */
    public static final short INNER_MAIL_TYPE_INVESTOR_MONEYREPAY = 102; 
    
    /**
     * 站内信类别-投资人-资金解冻
     */
    public static final short INNER_MAIL_TYPE_INVESTOR_MONEYBACK = 103; 
    
    /**
     * 站内信类别-投资人-出借成功
     */
    public static final short INNER_MAIL_TYPE_INVESTOR_INVESTSUCCESS = 104; 
    
    /**
     * 站内信类别-投资人-留言被回复
     */
    public static final short INNER_MAIL_TYPE_INVESTOR_GETMESSAGE = 105; 
    
    /**
     * 站内信类别-投资人-其他
     */
    public static final short INNER_MAIL_TYPE_INVESTOR_OTHER = 199; 
    
    /**
     * 站内信类别-借款人-成功满额
     */
    public static final short INNER_MAIL_TYPE_BORROWER_SUCCESS = 201; 
    
    /**
     * 站内信类别-借款人-审核未通过
     */
    public static final short INNER_MAIL_TYPE_BORROWER_NOPASS = 202; 
    
    /**
     * 站内信类别-借款人-借款项目未满额
     */
    public static final short INNER_MAIL_TYPE_BORROWER_NOFULL = 203; 
    
    /**
     * 站内信类别-借款人-还款提醒
     */
    public static final short INNER_MAIL_TYPE_BORROWER_PAY = 204; 
    
    /**
     * 站内信类别-借款人-逾期通知
     */
    public static final short INNER_MAIL_TYPE_BORROWER_LATEPAY = 205; 
    /**
     * 站内信类别-借款人-审核通过
     */
    public static final short INNER_MAIL_TYPE_BORROWER_PASS = 206; 
    
    /**
     * 站内信类别-借款人-其他
     */
    public static final short INNER_MAIL_TYPE_BORROWER_OTHER = 299; 
    
    /**
     * 邀请功能常量定义开始
     */
    
    /**
     * 每一档返现金额，单用户有效投资总额达到2000的时候，返现30块
     */
    final public static BigDecimal CASH_BACK_LEVEL1 = new BigDecimal("30.00");
    
    final public static BigDecimal CASH_BACK_LEVEL1_THRESHOLD = new BigDecimal("2000.00");
    
    /**
     * 第二档返现金额，单用户有效投资金额达到12000的时候，返现200块
     */
    final public static BigDecimal CASH_BACK_LEVEL2 = new BigDecimal("200.00");
    
    final public static BigDecimal CASH_BACK_LEVEL2_THRESHOLD = new BigDecimal("12000.00");
    
    /**
     * 返现标志位，
     * 700为未进行返现，
     * 701为已返现第一档，未进行第二档返现
     * 702为已返现第二档
     * 710为已失效
     */
    final public static int CASH_BACK_STATUS_NO_700 = 700;
    
    final public static int CASH_BACK_STATUS_ONE_701 = 701;
    
    final public static int CASH_BACK_STATUS_TWO_702 = 702;
    
    final public static int CASH_BACK_STATUS_TEN_710 = 710;
    
    // 定时器每天的执行时间,暂时是每天晚上12:10分执行
    final public static String QUZRTZ_RUNTIME="00:10";
    
    //--------------充值操作相关配置-----------------------------
    /* 易宝支付充值费用百分比 */
    final public static BigDecimal RECHARGE_RATE=new BigDecimal(0.002);
    
    /*预留充值费用余额初始值*/
    final public static BigDecimal RESERVE_FEE_BALANCE = new BigDecimal(1000);
    /**
     * 单笔最小充值额度
     */
    final public static BigDecimal RECHARGE_AMOUNT_MIN = new BigDecimal(10);
    /**
     * 单笔最大充值额度
     */
    final public static BigDecimal RECHARGE_AMOUNT_MAX = new BigDecimal(1000000);
    //--------------充值操作相关配置--------------------------------
    final public static BigDecimal OVERDUE_FEE = new BigDecimal(0.1);
}
