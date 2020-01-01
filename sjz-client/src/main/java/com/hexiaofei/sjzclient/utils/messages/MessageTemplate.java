package com.hexiaofei.sjzclient.utils.messages;


import com.hexiaofei.sjzclient.common.CommonDef;
import com.hexiaofei.sjzclient.common.EmailSendType;
import com.hexiaofei.sjzclient.domain.NotificationConfig;
import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.message.IEmailService;
import com.hexiaofei.sjzclient.service.message.IInnerMailService;
import com.hexiaofei.sjzclient.service.message.INotificationConfigService;
import com.hexiaofei.sjzclient.service.message.ISmsService;
import com.hexiaofei.sjzclient.utils.DateUtil;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Properties;

public class MessageTemplate {
    private static Logger logger = Logger.getLogger(MessageHelper.class);

    private static IEmailService emailService;
    
    private static ISmsService smsService;

    private static IInnerMailService innerMailService;

    private static INotificationConfigService notificationConfigService;

    private static Properties prop;

    private static final String CORE_MESSAGE_TEMPLATE = "coreMessageTemplate.properties";
    //初始化
    static
    {
        try
        {
            //String path=MessageTemplate.class.getResource("/").getPath();
            //path=path.substring(0, path.indexOf("core")+5);
            //path=path+"src"+File.separator+"main"+File.separator+"config"+File.separator+CORE_MESSAGE_TEMPLATE;
            InputStream is = MessageTemplate.class.getResourceAsStream("/coreMessageTemplate.properties");
            
            //FileInputStream is=new FileInputStream(path);
            prop = new Properties();
            prop.load(new InputStreamReader(is, "UTF-8"));
            //prop.list(System.out);
        }
        catch (FileNotFoundException ffe)
        {
            logger.error("没找到消息模板配置文件coreMessageTemplate.properties", ffe);
        }
        catch (IOException ioe)
        {
            logger.error("读取消息模板配置文件coreMessageTemplate.properties异常", ioe);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("报错了");
        }

    }

    /**
     * 返回模板信息
     * @param mail
     * @param objs
     * @return
     */
    private static String returnMessage(String mail, Object[] objs) {
        mail = MessageFormat.format(prop.getProperty(mail), objs);
        return mail;
    }
    

    /**
     * 登录失败消息
     * @param user
     * @param ip
     * @throws PlatformException
     */
    public static void sendLoginFailedMessage(UserInfo user, String ip) throws PlatformException {
        NotificationConfig notificationConfig = notificationConfigService.getNotificationConfigByUserId(user.getId());
        Short in = notificationConfig.getLoginFailed();
        String mail_title = prop.getProperty("login.failed.title");
        Object[] objs = {user.getNickName(), DateUtil.formatToYMZSlash(new Date()), ip};
        String mail = returnMessage("login.failed.mail", objs);
        if (NotificationConfig.getIsEmail(in)) {
            emailService.sendMail(EmailSendType.OTHER, user.getEmail(), mail_title, mail);
        }
        if (NotificationConfig.getIsInnerMail(in)) {
            innerMailService.sendInnerMail(user.getId(), mail, CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
        }
    }
    
    /**
     * 修改登录密码消息
     * @param user
     */
    public static void sendModifyLoginPasswordMessage(UserInfo user) {
        String mail_title = prop.getProperty("modify.login.password.title");
        Object[] objs = {user.getNickName(), DateUtil.formatToYMZSlash(new Date()), CommonDef.WEBSITE_NAME_CN};
        String mail = returnMessage("modify.login.password.mail", objs);
        String sms = returnMessage("modify.login.password.sms", objs);
        emailService.sendMail(EmailSendType.OTHER, user.getEmail(), mail_title, mail);
        smsService.sendSMS(user.getPhone(), sms);
        innerMailService.sendInnerMail(user.getId(), mail, CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
    }
    
    /**
     * 修改支付密码消息
     * @param user
     */
    public static void sendModifyPayPasswordMessage(UserInfo user) {
        String mail_title = prop.getProperty("modify.pay.password.title");
        Object[] objs = {user.getNickName(), DateUtil.formatToYMZSlash(new Date()), CommonDef.WEBSITE_NAME_CN};
        String mail = returnMessage("modify.pay.password.mail", objs);
        String sms = returnMessage("modify.pay.password.sms", objs);
        emailService.sendMail(EmailSendType.OTHER, user.getEmail(), mail_title, mail);
        smsService.sendSMS(user.getPhone(), sms);
        innerMailService.sendInnerMail(user.getId(), mail, CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
    }
    

    
    
    /**
     * 发送充值成功消息
     * @param innerMailService
     * @param thirdPartyService
     * @param notificationConfigService
     * @param user
     * @param tranAmt
     * @throws Exception
     */
//    @Deprecated
//    public  static void sendTopupMessage(User user,String tranAmt)throws Exception{
//        String setup=notificationConfigService.getMessageSetup(user.getUserId());
//        if(setup.contains("me1")){
//            MessageTemplate.topupMesg(innerMailService, user.getUserId(), tranAmt);
//        }
//        if(setup.contains("me2")){
//            MessageTemplate.topupEmail(emailService, user.getEmail(), tranAmt);
//        }
//        if(setup.contains("me3")){
//            MessageTemplate.topupSMS(smsService, user.getMobile(), tranAmt);
//        }
//    }
    /**
     * 发送登录错误消息
     */
//  public static void sendLoginFailedMessage(User user,String ip) throws Exception{
//      String setup=notificationConfigService.getMessageSetup(user.getPortrait());
//      if(setup.contains("wa1")){
//          loginFailedMesg(innerMailService, user, ip);
//      }
//      if(setup.contains("wa2")){
//          loginFailedEmail(emailService, user, ip);
//      }
//  }
    /**
     * 发送修改登录密码
     * @param user
     * @param mes 支付密码/登录密码 发送对应消息
     */
//    @Deprecated
//    public static void sendUpdatePasswordMessage(User user,String mes){
//        updatePasswordMsg(innerMailService, user,mes);
//        updatePasswordEmail(emailService, user,mes);
//        updatePasswordSMS(smsService, user,mes);
//    }
    /**
     * 发送投标成功消息
     * @throws PlatformException 
     */
//    @Deprecated
//    public static void sendInvestMesg(User user,Loan loan,Integer investAmount,String path) throws PlatformException{
//        NotificationConfig config  = notificationConfigService.getNotificationConfigByUserId(user.getUserId());
//        if(config!=null) {
//            // 站内信
//            if(config.getMessageSetup().contains("pa1")) {
//                investMesg(user, loan, path, investAmount);
//            }
//            
//            if(config.getMessageSetup().contains("pa2")&& user.getEmail()!=null) {
//                investEmail(user, loan, path, investAmount);
//            }
//        }
//    }
    
    /**
     * 流标发送消息
     * @throws PlatformException 
     */
//    @Deprecated
//    public static void sendflowLoanMesg(User user,String setUp,String title) throws PlatformException{
//        if(setUp.contains("pc1")||setUp.contains("pf1")){
//            flowLoanMesg(user, title);
//        }
//        if(setUp.contains("pc2")||setUp.contains("pf2")){
//            flowLoanEmail(user, title);
//        }
//        if(setUp.contains("pc3")||setUp.contains("pf3")){
//            flowLoanSMS(user, title);
//        }
//    }
    /**
     * 发送回款消息
     */
//    @Deprecated
//    public static void sendRepayMessageToInvestor(LoanInvestor loanInvestor, Loan loan) throws PlatformException
//    {
//
//        NotificationConfig notificationConfig = notificationConfigService.getNotificationConfigByUserId(loanInvestor.getInvestorUserId());
//
//        // 准备参数开始
//        int currentTerm = loan.getTermCount().intValue() - loanInvestor.getLeftTermCount().intValue();
//        if(loan.getRepayType().shortValue() == RepayType.Yh100OneTimeInterestLoan.getValue()) {
//            currentTerm = 1;
//        }
//        BigDecimal totalRepaidAmount;
//        if (loanInvestor.getLeftTermCount().intValue() > 0)
//        {
//            if (loanInvestor.getOverDueInterest() != null)
//            {
//                totalRepaidAmount = loanInvestor.getTermReturnAmount().add(loanInvestor.getOverDueInterest());
//            }
//            else
//            {
//                totalRepaidAmount = loanInvestor.getTermReturnAmount();
//            }
//        }
//        else
//        {
//            // 最后一期
//            if (loanInvestor.getOverDueInterest() != null)
//            {
//                totalRepaidAmount = loanInvestor.getTermReturnAmount().add(loanInvestor.getOverDueInterest())
//                        .add(loanInvestor.getLastTermPrincipalCompensation());
//            }
//            else
//            {
//                totalRepaidAmount = loanInvestor.getTermReturnAmount().add(
//                        loanInvestor.getLastTermPrincipalCompensation());
//            }
//        }
//        if(loan.getRepayType().shortValue() == RepayType.Yh100OneTimeInterestLoan.getValue()) {
//            totalRepaidAmount = loanInvestor.getOverDueInterest()==null?loanInvestor.getTermReturnAmount():loanInvestor.getOverDueInterest().add(loanInvestor.getTermReturnAmount());
//        }
        // 准备参数结束

//        if (notificationConfig.getMessageSetup().contains("pb1"))
//        {
//            logger.info("开始向标(" + loan.getLoanId() + ")的投资者(" + loanInvestor.getInvestorUserId() + ", " + loanInvestor.getInvestorNickname() + ")发送回款通知站内信");
//            String innermail = prop.getProperty("repay.investor.innermail");
//
//            // 生成站内信
//            innermail = MessageFormat.format(innermail, loan.getTitle(), currentTerm, totalRepaidAmount,
//                    CommonDef.WEBSITE_NAME_CN, CommonDef.WEBSITE_DOMAIN_NAME, CommonDef.SERVICE_PHONE,
//                    DateUtil.formatToYYYYMMDD(new Date()), loan.getLoanId().toString(), loan.getBorrowerId().toString(), loan.getBorrowerNickname());
//
//            logger.info("站内信：" + innermail);
//            innerMailService.sendInnerMail(loanInvestor.getInvestorUserId(), innermail,
//                    CommonDef.INNER_MAIL_TYPE_INVESTOR_MONEYREPAY);
//        }
//
//        User investor = userService.getUserByID(loanInvestor.getInvestorUserId());
//
//        if (notificationConfig.getMessageSetup().contains("pb2"))
//        {
//            logger.info("开始向标(" + loan.getLoanId() + "(的投资者(" + loanInvestor.getInvestorUserId() + ", "
//                    + loanInvestor.getInvestorNickname() + ")发送回款通知邮件");
//            String email = prop.getProperty("repay.investor.email");
//            String subject = "您向“" + loan.getTitle() + "”项目出借的第" + currentTerm + "期回款￥"
//                    + totalRepaidAmount + "元已转入您的" + CommonDef.WEBSITE_NAME_CN + "账户";
//            email = MessageFormat.format(email, investor.getNickName(), loan.getTitle(), currentTerm,
//                    totalRepaidAmount, CommonDef.WEBSITE_NAME_CN, CommonDef.SERVICE_PHONE,
//                    CommonDef.WEBSITE_DOMAIN_NAME, DateUtil.formatToYYYYMMDD(new Date()),
//                    loan.getLoanId().toString(), loan.getBorrowerId().toString(), loan.getBorrowerNickname());
//            emailService.sendMail(EmailSendType.IN_REPAY_RECEIVED_REPAY, investor.getEmail(), subject, email);
//        }

//        if (NotificationConfig.getIsSMS(notificationConfig.getInvestorRepay()) && investor.getMobile() != null
//                && investor.getMobile().length() > 6)
//        {
//            logger.info("开始向标(" + loan.getLoanId() + ")的投资者(" + loanInvestor.getInvestorUserId() + ", "
//                    + loanInvestor.getInvestorNickname() + ")发送回款通知短信");
//            String sms = prop.getProperty("repay.investor.sms");
//            sms = MessageFormat.format(sms, CommonDef.WEBSITE_NAME_CN, loan.getTitle(), currentTerm, totalRepaidAmount,
//                    CommonDef.SERVICE_PHONE, CommonDef.WEBSITE_DOMAIN_NAME, investor.getNickName());
//            thirdPartyService.sendSMS(investor.getMobile(), sms);
//        }
//    }
    /**
     *投资人满标发送消息
     */
//    public static void sendFullLoanMesg(User user,Loan loan,String setUp){
//      if(setUp.contains("pe1")){
//          fullLoanMesg(innerMailService, user, loan);
//      }
//      if(setUp.contains("pe2")){
//          fullLoanEmail(thirdPartyService, user, loan);
//      }
//      if(setUp.contains("pe3")){
//          fullLoanSMS(thirdPartyService, user, loan);
//      }
//    }
    
    /**
     * 给借款人发送满标到账消息
     * @throws PlatformException 
     */
//    @Deprecated
//    public static void sendBorrMoToAccMesg(Loan loan) throws PlatformException{
//        User user = userService.getUserByID(loan.getBorrowerId());
//        NotificationConfig config = notificationConfigService.getNotificationConfigByUserId(loan.getBorrowerId());
//        String setUp=config.getMessageSetup();
//        if(setUp.contains("pd1")){
//            borrowMoneyToAccountMesg(innerMailService, user, loan.getTitle(),loan.getAmount());
//        }
//        if(setUp.contains("pd2")){
//            borrowMoneyToAccountEmail(emailService, user, loan.getTitle(),loan.getAmount());
//        }
//        if(setUp.contains("pd3")){
//            borrowMoneyToAccountSMS(smsService, user, loan.getTitle(),loan.getAmount());
//        }
//    }
    /**
     *  发送站审核未通过消息
     * @param thirdPartyService
     * @param innerMailService
     * @param user
     * @param loan
     * @param reason 未通过理由
     * @param suggest 建议
     */
//    @Deprecated
//    public static void sendRejectMesg(User user,Loan loan,String reason,String suggest){
//        String setUp=notificationConfigService.getMessageSetup(user.getUserId());
//        if(setUp.contains("pe1")){
//            rejectInnerMail(innerMailService, user, loan, reason, suggest);
//        }
//        if(setUp.contains("pe2")){
//            rejectEmail(emailService, user, loan, reason, suggest);
//        }
//        if(setUp.contains("pe3")){
//            rejectSMS(smsService, user, loan, reason, suggest);
//        }
//    }
    /**
     * 发送提前三天还款提示信息
     * @throws PlatformException 
     */
//    @Deprecated
//    public static void sendBorrowerReimbursementPrompt(LoanPhase loanPhase) throws PlatformException{
//        NotificationConfig notificationConfig = notificationConfigService.getNotificationConfigByUserId(loanPhase.getBorrowerId());
//        User user = userService.getUserByID(loanPhase.getBorrowerId());
//        if (notificationConfig.getMessageSetup().contains("pj1")){
//            borrowerReimbursementPrompt(loanPhase, user);
//        }
//        if (notificationConfig.getMessageSetup().contains("pj2")){
//            borrowerReimbursementPromptEmail(loanPhase, user);
//        }
//        if (notificationConfig.getMessageSetup().contains("pj3")){
//            borrowerReimbursementPromptSMS(loanPhase, user);
//        }
//    }
    /**
     * 发送逾期还款提示
     * @param loanPhase
     * @param user
     */
//    @Deprecated
//    public static void sendNotLimitReimbursement(LoanPhase loanPhase) throws PlatformException{
//        NotificationConfig notificationConfig = notificationConfigService.getNotificationConfigByUserId(loanPhase.getBorrowerId());
//        User user = userService.getUserByID(loanPhase.getBorrowerId());
//        if (notificationConfig.getMessageSetup().contains("ph1")){
//            notLimitReimbursementMsg(loanPhase, user);
//        }
//        if (notificationConfig.getMessageSetup().contains("ph2")){
//            notLimitReimbursementEmail(loanPhase, user);
//        }
//        if (notificationConfig.getMessageSetup().contains("ph3")){
//            notLimitReimbursementSMS(loanPhase, user);
//        }
//    }
    /**
     * 发送借人审核通过消息
     */
//    @Deprecated
//    public static void sendBorrowingAuditThroughMsg(Integer  loanId)throws PlatformException{
//        Loan loan = loanService.getLoanByID(loanId);
//        NotificationConfig notificationConfig = notificationConfigService.getNotificationConfigByUserId(loan.getBorrowerId());
//        User user = userService.getUserByID(loan.getBorrowerId());
//        if (notificationConfig.getMessageSetup().contains("pi1")){
//            borrowingAuditThroughMsg(user,loan);
//        }
//        if (notificationConfig.getMessageSetup().contains("pi2")){
//            borrowingAuditThroughEmail(user,loan);
//        }
//        if (notificationConfig.getMessageSetup().contains("pi3")){
//            borrowingAuditThroughSMS(user,loan);
//        }
//    }
    
    
    
    
    
    
    
    
//    /**
//     * 借人审核通过站内信
//     */
//    public static void borrowingAuditThroughMsg(User user,Loan loan)throws PlatformException{
//        StringBuffer innerMailsb = new StringBuffer("");
//        innerMailsb.append("您的“"+loan.getTitle()+"”借款申请在");
//        innerMailsb.append(DateUtil.formatToYMZSlash(new Date()));
//        innerMailsb.append("审核通过。");
//        innerMailsb.append(teamSignature());
//        innerMailService.sendInnerMail(user.getUserId(), innerMailsb.toString(), CommonDef.INNER_MAIL_TYPE_BORROWER_PASS);
//    }
//    /**
//     * 借人审核通过邮件
//     */
//    public static void borrowingAuditThroughEmail(User user,Loan loan)throws PlatformException{
//        StringBuffer innerMailsb = new StringBuffer("");
//        innerMailsb.append("您的“"+loan.getTitle()+"”借款申请在");
//        innerMailsb.append(DateUtil.formatToYMZSlash(new Date()));
//        innerMailsb.append("审核通过。");
//        innerMailsb.append(teamSignature());
//        emailService.sendMail(EmailSendType.OTHER, user.getEmail(), "借款申请审核通过", innerMailsb.toString());
//    }
//    /**
//     * 借人审核通过短信
//     */
//    public static void borrowingAuditThroughSMS(User user,Loan loan)throws PlatformException{
//        StringBuffer innerMailsb = new StringBuffer("");
//        innerMailsb.append("您的“"+loan.getTitle()+"”借款申请在");
//        innerMailsb.append(DateUtil.formatToYMZSlash(new Date()));
//        innerMailsb.append("审核通过。");
//        innerMailsb.append("，退订回复TD");
//        smsService.sendSMS(user.getMobile(), innerMailsb.toString());
//    }
//
//    /**
//     * 逾期还款发送站内信
//     * @param loanPhase
//     * @param user
//     */
//    public static void  notLimitReimbursementMsg(LoanPhase loanPhase,User user){
//        StringBuffer innerMailsb = new StringBuffer("");
//        innerMailsb.append("您的借款需在");
//        innerMailsb.append(DateUtil.formatToYMZSlash(loanPhase.getDueDate()));
//        innerMailsb.append("进行第");
//        innerMailsb.append(loanPhase.getPhaseNumber());
//        innerMailsb.append("期还款");
//        innerMailsb.append(loanPhase.getPlannedTermAmount());
//        innerMailsb.append("元，您目前账户的余额是");
//        innerMailsb.append(user.getCash());
//        innerMailsb.append("元，");
//        innerMailsb.append("余额不足,请您及时充值。");
//        innerMailsb.append(teamSignature());
//        innerMailService.sendInnerMail(user.getUserId(), innerMailsb.toString(), CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
//    }
//    /**
//     * 逾期还款发送邮件
//     * @param loanPhase
//     * @param user
//     */
//    public static void  notLimitReimbursementEmail(LoanPhase loanPhase,User user){
//        StringBuffer mailSb = new StringBuffer("你好，" + user.getNickName() + "<br><br>");
//        mailSb.append("您的借款需在" + DateUtil.daysBetween(loanPhase.getDueDate(), new Date()) + ",进行第"
//                + loanPhase.getPhaseNumber() + "期还款" + loanPhase.getPlannedTermAmount() + "元，" + "您目前账户的余额是"
//                + user.getCash() + "元，");
//        mailSb.append("余额不足,请您及时充值。<br><br>");
//        mailSb.append(teamSignature());
//        emailService.sendMail(EmailSendType.OTHER, user.getEmail(),"账户余额不足,请及时充值!", mailSb.toString());
//    }
//    /**
//     * 逾期还款发送短信
//     * @param loanPhase
//     * @param user
//     */
//    public static void  notLimitReimbursementSMS(LoanPhase loanPhase,User user){
//         StringBuffer smssb = new StringBuffer();
//         smssb.append("您的借款需在" + DateUtil.daysBetween(loanPhase.getDueDate(), new Date()) + "进行第"
//                 + loanPhase.getPhaseNumber() + "期还款" + loanPhase.getPlannedTermAmount() + "元，" + "您目前账户的余额是"
//                 + user.getCash() + "元，");
//         smssb.append("余额不足,请您及时充值，退订回复TD");
//         smsService.sendSMS(user.getMobile(), smssb.toString());
//    }
//    
//    /**
//     * 提前三天还款提示
//     */
//    public static String borrowerReimbursementPrompt(LoanPhase loanPhase,User user){
//        StringBuffer innerMailsb = new StringBuffer("");
//        innerMailsb.append("您的借款需在");
//        innerMailsb.append(DateUtil.daysBetween(loanPhase.getDueDate(), new Date()));
//        innerMailsb.append("天后进行第");
//        innerMailsb.append(loanPhase.getPhaseNumber());
//        innerMailsb.append("期还款");
//        innerMailsb.append(loanPhase.getPlannedTermAmount());
//        innerMailsb.append("元，您目前账户的余额是");
//        innerMailsb.append(user.getCash());
//        innerMailsb.append("元，");
//        if (user.getCash().compareTo(loanPhase.getPlannedTermAmount()) > 0)
//        {
//            innerMailsb.append("系统将自动代扣该笔还款。");
//        }
//        else
//        {
//            innerMailsb.append("请您及时充值。");
//        }
//        innerMailsb.append(teamSignature());
//        innerMailService.sendInnerMail(user.getUserId(), innerMailsb.toString(), CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
//        return "success";
//    }
//    /**
//     * 到期还款邮件
//     */
//    public static String borrowerReimbursementPromptEmail(LoanPhase loanPhase,User user){
//          StringBuffer mailSb = new StringBuffer("你好，" + user.getNickName() + "<br><br>");
//          mailSb.append("您的借款需在" + DateUtil.daysBetween(loanPhase.getDueDate(), new Date()) + "天后进行第"
//                  + loanPhase.getPhaseNumber() + "期还款" + loanPhase.getPlannedTermAmount() + "元，" + "您目前账户的余额是"
//                  + user.getCash() + "元，");
//          if (user.getCash().compareTo(loanPhase.getPlannedTermAmount()) > 0)
//          {
//              mailSb.append("系统将自动代扣该笔还款。");
//          }
//          else
//          {
//              mailSb.append("请您及时充值。");
//          }
//          mailSb.append(teamSignature());
//          
//          emailService.sendMail(EmailSendType.OTHER, user.getEmail(),"到期还款提醒", mailSb.toString());
//          return "success";
//    }
//    /**
//     * 到期还款短信
//     */
//    public static String borrowerReimbursementPromptSMS(LoanPhase loanPhase,User user){
//           StringBuffer smssb = new StringBuffer();
//           smssb.append("您的借款需在" + DateUtil.daysBetween(loanPhase.getDueDate(), new Date()) + "天后进行第"
//                   + loanPhase.getPhaseNumber() + "期还款" + loanPhase.getPlannedTermAmount() + "元，" + "您目前账户的余额是"
//                   + user.getCash() + "元，");
//           if (user.getCash().compareTo(loanPhase.getPlannedTermAmount()) > 0)
//           {
//               smssb.append("系统将自动代扣该笔还款。");
//           }
//           else
//           {
//               smssb.append("请您及时充值。");
//           }
//           smssb.append("退订回复TD");
//           smsService.sendSMS(user.getMobile(), smssb.toString());
//           return "success";
//    }
//    
//    /**
//     * 流标发送站内信
//     * @param title
//     * @return
//     */
//    public static String flowLoanMesg(User user,String title){
//        StringBuffer mesgStr = new StringBuffer("");
//        mesgStr.append("<span>您的");
//        mesgStr.append(title);
//        mesgStr.append("项目已流标，投标资金已返回您的账户余额中。</span>");
//        mesgStr.append(teamSignature());
//        innerMailService.sendInnerMail(user.getUserId(), mesgStr.toString(),  CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
//        return mesgStr.toString();
//    }
//    /**
//     * 流标发送email
//     */
//    
//    public static String flowLoanEmail(User user,String title){
//        StringBuffer mesgStr = new StringBuffer("");
//        mesgStr.append("<p>您好：");
//        mesgStr.append(user.getNickName());
//        mesgStr.append("，</p></br><p>您的");
//        mesgStr.append(title);
//        mesgStr.append("项目已流标。</p>");
//        mesgStr.append(teamSignature());
//        emailService.sendMail(EmailSendType.START_FAIL_FULL_LOAN, user.getEmail(), "项目流标", mesgStr.toString());
//        return mesgStr.toString();
//    }
//    
//    /**
//     * 流标发送短信
//     */
//    public static String flowLoanSMS(User user,String title){
//        StringBuffer mesgStr = new StringBuffer();
//        mesgStr.append("尊敬的" + CommonDef.WEBSITE_NAME_CN + "用户"+user.getNickName() + "，您好！我们抱歉的通知您，");
//        mesgStr.append("您的“" + title + "”项目由于未能在规定时间内筹款成功而流标，");
//        mesgStr.append("我们对由此造成的不便深表歉意。如果您有任何疑问，请随时致电客服电话"+ CommonDef.SERVICE_PHONE +"。");
//        //mesgStr.append("上" + CommonDef.WEBSITE_NAME_CN + "，财富每天多一点！");
//        mesgStr.append("退订回复TD");
//        smsService.sendSMS(user.getMobile(), mesgStr.toString());
//        return mesgStr.toString();
//    }
//    /**
//     * 满标发送站内信
//     */
//    public static String fullLoanMesg(IInnerMailService innerMailService,User user,Loan loan){
//        StringBuffer mesgStr = new StringBuffer();
//        mesgStr.append("<span>您投资的“"+loanDetails(loan)+"”项目已成功满额，您的投资已成功从您的账户转出。</span>");
//        mesgStr.append(teamSignature());
//        innerMailService.sendInnerMail(user.getUserId(), mesgStr.toString(),  CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
//        return mesgStr.toString();
//    }
//    /**
//     * 满标发送邮件
//     */
//    public static String fullLoanEmail(IEmailService emailService,User user,Loan loan){
//        String str ="<p>您好："+user.getNickName()+"，</p>" +
//                "</br>" +
//                "<p>您投资的“"+loanDetails(loan)+"”项目已成功满额，您的投资已成功从您的账户转出。</p>" +
//                teamSignature() ;
//        emailService.sendMail(EmailSendType.OTHER, user.getEmail(), "项目满标", str);
//        return str;
//    }
//    /**
//     * 满标发送短信
//     */
//    public static String fullLoanSMS(ISmsService smsService,User user,Loan loan){
//        StringBuffer sb = new StringBuffer();
//        sb.append("尊敬的" + CommonDef.WEBSITE_NAME_CN + "用户" + user.getNickName() + "，您好！");
//        sb.append("您投资的“" + loan.getTitle()+ "”项目已成功放款，开始计息。");
//        sb.append("如果您有任何疑问，请随时致电客服电话"+ CommonDef.SERVICE_PHONE +"。");
//        //sb.append("上" + CommonDef.WEBSITE_NAME_CN + "，财富每天多一点！");
//        sb.append("退订回复TD");
//        smsService.sendSMS(user.getMobile(), sb.toString());
//        return sb.toString();
//    }
//
//    /**
//     * 给借款到账站内信
//     */
//    public static String borrowMoneyToAccountMesg(IInnerMailService innerMailService,User user,String title,BigDecimal amount){
//        String str ="<span>您的“"+title+"”借款请求已成功募集资金"+amount+"元，这笔资金将于一个工作日内转账至您绑定的银行卡账户，请注意查收。</span>" +teamSignature();
//        innerMailService.sendInnerMail(user.getUserId(), str,  CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
//        return str;
//    }
//    /**
//     * 给借款到账邮件
//     */
//    public static String borrowMoneyToAccountEmail(IEmailService emailService,User user,String title,BigDecimal amount){
//        String str ="<p>您好："+user.getNickName()+"，</p></br>" +
//                "<p>您的“"+title+"”借款请求已成功募集资金"+amount+"元，这笔资金将于一个工作日内转账至您绑定的银行卡账户，请注意查收。</p>"+teamSignature();
//        emailService.sendMail(EmailSendType.OTHER, user.getEmail(), "满标放款", str);
//        return str;
//    }
//    /**
//     * 给借款到账短信
//     */
//    public static String borrowMoneyToAccountSMS(ISmsService smsService,User user,String title,BigDecimal amount){
//        String str = "您的“"+title+"”借款请求已成功募集资金"+amount+"元，这笔资金将于一个工作日内转账至您绑定的银行卡账户，请注意查收。如果您有任何疑问，请随时致电"+CommonDef.SERVICE_PHONE+"退订回复TD";
//        smsService.sendSMS(user.getMobile(), str);
//        return str;
//    }
//    
//    /**
//     * 审核未通过邮件内容
//     * @param reason
//     * @param suggest
//     * @return
//     */
//    public static String rejectInnerMail(IInnerMailService innerMailService,User user,Loan loan,String reason, String suggest) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("<p>您的“");
//        builder.append(loan.getTitle());
//        builder.append("”借款请求未通过审核，理由为：");
//        builder.append(reason);
//        builder.append("。建议您");
//        builder.append(suggest);
//        builder.append("。</p>");
//        builder.append(teamSignature());
//        innerMailService.sendInnerMail(user.getUserId(), builder.toString(), CommonDef.INNER_MAIL_TYPE_BORROWER_NOPASS);
//        return "success";
//    }
//    
//    /**
//     * 审核未通过短信内容
//     * @return
//     */
//    public static String rejectSMS(ISmsService smsService,User user,Loan loan,String reason, String suggest){
//        StringBuilder builder = new StringBuilder();
//        builder.append("[元融元通知]:您的");
//        builder.append(loan.getTitle());
//        builder.append("借款请求未通过审核，理由为：");
//        builder.append(reason);
//        builder.append("。建议您");
//        builder.append(suggest);
//        builder.append("。退订回复TD");
//        smsService.sendSMS(user.getMobile(),  builder.toString());
//        return "success";
//    }
//
//    /**
//     * 审核未通过发送email内容
//     * @param borrowerName
//     * @param loanName
//     * @param reason
//     * @param suggest
//     * @return
//     */
//    public static String rejectEmail(IEmailService emailService,User user,Loan loan,String reason,String suggest) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("<p>您好");
//        builder.append(loan.getBorrowerNickname());
//        builder.append("</p>");
//        builder.append("您的");
//        builder.append(loan.getTitle());
//        builder.append("借款请求未通过审核，理由为：");
//        builder.append(reason);
//        builder.append("。建议您");
//        builder.append(suggest);
//        builder.append(teamSignature());
//        emailService.sendMail(EmailSendType.OTHER, user.getEmail(), reason, builder.toString());
//        return "success";
//    }
//    /**
//     * 投标成功站内信
//     * @return
//     */
//    public static String investMesg(User user,Loan loan,String path, Integer investAmount){
//        String str ="<span>您已成功向“"+loanDetails(loan)+"”项目投资" + 
//                investAmount+"元，直到招标结束您账户内的这部分资金将被冻结。</br>"+teamSignature();
//        innerMailService.sendInnerMail(user.getUserId(), str,CommonDef.INNER_MAIL_TYPE_INVESTOR_SUCCESS );
//        return str;
//    }
//    /**
//     * 投标成功站邮件
//     * @return
//     */
//    public static String investEmail(User user,Loan loan,String path,Integer investAmount){
//        String str ="你好"+user.getNickName()+"，<br/>您已成功向“"+loanDetails(loan)+"”项目投资"+
//                    investAmount+"元，直到招标结束您账户内的这部分资金将被冻结。<br/>"+teamSignature();
//        emailService.sendMail(EmailSendType.OTHER, user.getEmail(),"您已成功向“"+loan.getTitle()+"”项目投资"+investAmount+"元", str);
//        return str;
//    }
//    /**
//     * 投标成功站短信
//     * @return
//     */
//    public static String investSMS(String userName,String loanTitle,Integer investAmount){
//        StringBuffer sb = new StringBuffer();
//        sb.append("尊敬的" + CommonDef.WEBSITE_NAME_CN + "用户"
//                + userName);
//        sb.append("，您好！您已成功向“"+ loanTitle + "”项目投资"+ investAmount +"元人民币，");
//        sb.append("在该项目资金需求筹满前您账户内的这部分资金将被冻结。");
//        sb.append("如果您有任何疑问，请随时致电客服电话" + CommonDef.SERVICE_PHONE + "。");
//        sb.append("上" + CommonDef.WEBSITE_NAME_CN +"，财富每天多一点！");
//        return sb.toString();
//    }
//    
//    

//    /**
//     * 申请提现发送站内信
//     */
//    public static String applyForWithdrawalMesg(Integer userId,BigDecimal  amount) throws PlatformException{
//        StringBuffer sb =  new StringBuffer();
//        sb.append("您已经于");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("通过");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("发起提现申请,提现金额:");
//        sb.append(amount);
//        sb.append("元,");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("会在");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("前完成审核并打款。");
//        innerMailService.sendInnerMail(userId, sb.toString(), CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
//        return "success";
//    }
//    /**
//     * 申请提现发送邮件
//     */
//    public static String applyForWithdrawalEmail(String userEmail,BigDecimal  amount) throws PlatformException{
//        StringBuffer sb =  new StringBuffer();
//        sb.append("您已经于");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("通过");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("发起提现申请,提现金额:");
//        sb.append(amount);
//        sb.append("元,");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("会在");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("前完成审核并打款。");
//        emailService.sendMail(EmailSendType.OTHER,userEmail,"您已申请提现", sb.toString());
//        return "success";
//    }
//    /**
//     * 申请提现发送短信
//     */
//    public static String applyForWithdrawalSMS(String mobileNumber,BigDecimal  amount) throws PlatformException{
//        StringBuffer sb =  new StringBuffer();
//        sb.append("您已经于");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("通过");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("发起提现申请,提现金额:");
//        sb.append(amount);
//        sb.append("元,");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("会在");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("前完成审核并打款。请注意查收，退订回复TD");
//        smsService.sendSMS(mobileNumber, sb.toString());
//        return "success";
//    }
//    
//    /**
//     * 充值
//     */
//    public static void topupMesg(IInnerMailService innerMailService,Integer userId,String amount) throws Exception{
//        StringBuffer sb =  new StringBuffer();
//        sb.append("您已经于");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("通过");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("进行充值,充值金额:");
//        sb.append(amount);
//        sb.append("元,请注意查收!");
//        sb.append(teamSignature());
//        innerMailService.sendInnerMail(userId, sb.toString(), CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
//    }
//    public static void topupEmail(IEmailService emailService,String userEmail,String amount) throws Exception{
//        StringBuffer sb =  new StringBuffer();
//        sb.append("您已经于");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("通过");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("进行充值,充值金额:");
//        sb.append(amount);
//        sb.append("元,请注意查收!");
//        sb.append(teamSignature());
//        emailService.sendMail(EmailSendType.OTHER,userEmail,"充值成功", sb.toString());
//    }
//    
//    public static void topupSMS(ISmsService smsService,String mobileNumber,String amount) throws Exception{
//        StringBuffer sb =  new StringBuffer();
//        sb.append("您已经于");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("通过");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("进行充值,充值金额:");
//        sb.append(amount);
//        sb.append("元,请注意查收，退订回复TD");
//        smsService.sendSMS(mobileNumber, sb.toString());
//    }
//
//    
//    /**
//     *  登录失败站内信
//     */
//    public  static void loginFailedMesg(IInnerMailService innerMailService,User user,String ip)throws Exception{
//        StringBuffer sb =  new StringBuffer();
//        sb.append("用户:");
//        sb.append(user.getNickName());
//        sb.append("您的账号在");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("在");
//        sb.append(ip);
//        sb.append("处登录密码错误!");
//        innerMailService.sendInnerMail(user.getPortrait(), sb.toString(), CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
//    }
//    /**
//     *  登录失败email
//     */
//    public  static void loginFailedEmail(IEmailService emailService,User user,String ip)throws Exception{
//        StringBuffer sb =  new StringBuffer();
//        sb.append("用户:");
//        sb.append(user.getNickName());
//        sb.append("您的账号在");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("在");
//        sb.append(ip);
//        sb.append("处登录密码错误!");
//        emailService.sendMail(EmailSendType.OTHER, user.getEmail(), "登录密码错误", sb.toString());
//    }
//    
//    /**
//     * 修改登录密码站内信
//     */
//    public static void updatePasswordMsg(IInnerMailService innerMailService,User user,String mes){
//        StringBuffer sb =  new StringBuffer();
//        sb.append("用户:");
//        sb.append(user.getNickName());
//        sb.append("您在");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("对您的账号进行了"+mes+",如有问题请联系");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("客服进行帮助!");
//        innerMailService.sendInnerMail(user.getUserId(), sb.toString(), CommonDef.INNER_MAIL_TYPE_INVESTOR_OTHER);
//    }
//    /**
//     * 修改登录密码邮件
//     */
//    public static void updatePasswordEmail(IEmailService emailService,User user,String mes){
//        StringBuffer sb =  new StringBuffer();
//        sb.append("用户:");
//        sb.append(user.getNickName());
//        sb.append("您在");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("对您的账号进行了"+mes+",如有问题请联系");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("客服进行帮助!");
//        emailService.sendMail(EmailSendType.OTHER, user.getEmail(), mes+"修改", sb.toString());
//    }
//    /**
//     * 修改登录密码短信
//     */
//    public static void updatePasswordSMS(ISmsService smsService,User user,String mes){
//        StringBuffer sb =  new StringBuffer();
//        sb.append("用户:");
//        sb.append(user.getNickName());
//        sb.append("您在");
//        sb.append(DateUtil.formatToYMZSlash(new Date()));
//        sb.append("对您的账号进行了"+mes+",如有问题请联系");
//        sb.append(CommonDef.WEBSITE_NAME_CN);
//        sb.append("客服进行帮助，退订回复TD");
//        smsService.sendSMS(user.getMobile(), sb.toString());
//    }
//
    /**
     * 团队签名
     * @return
     */
    public static String teamSignature(){
        String str="<div style='margin-left:650px;padding-top:100px'>"+CommonDef.WEBSITE_NAME_CN+"团队</div><br/>"+
                    "<div style='margin-left:650px;margin-top:-10px'>"+DateUtil.formatToYMZSlash(new Date())+"</div>";
        return str;
    }


    /**
     * 回复留言站内信
     */
    public static String leaveWordMesg(String loanName,String url,String url1){
        String str="您在“"+loanName+"”发布的留言有一条新回复，请<a href=\""+url+"\">点击</a>查看详情。"+teamSignature();
        return str;
    }
    /**
     * 回复留言邮件
     */
    public static String leaveWordEmail(String replyToUserName,String loanName,String url,String url1,String url2,String url3){
        String str="你好"+replyToUserName+"，<br/>您在“"+loanName+"”发布的留言有一条新回复，请<a href=\""+url+"\">点击</a>查看详情。"+teamSignature();
        return str;
    }
    
    /**
     * 回复留言短信
     */
    public static String leaveWordSMS(String name,String loanName){
        StringBuffer sb = new StringBuffer();
        sb.append("尊敬的" + CommonDef.WEBSITE_NAME_CN + "用户" + name + "，您好！");
        sb.append("您在“" + loanName + "”项目下发布的留言有一条新回复，请登录"+ CommonDef.WEBSITE_NAME_CN +"查看详情。");
        sb.append("如果您有任何疑问，请随时致电客服电话"+ CommonDef.SERVICE_PHONE +"。");
        sb.append(  CommonDef.WEBSITE_NAME_CN + "为您提供安全、便捷、高回报的理财项目。");
        sb.append("上" + CommonDef.WEBSITE_NAME_CN + "，财富每天多一点！");
        return sb.toString();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static IInnerMailService getInnerMailService() {
        return innerMailService;
    }

    public static IEmailService getEmailService() {
        return emailService;
    }

    public static void setEmailService(IEmailService emailService) {
        MessageTemplate.emailService = emailService;
    }

    public static ISmsService getSmsService() {
        return smsService;
    }

    public static void setSmsService(ISmsService smsService) {
        MessageTemplate.smsService = smsService;
    }

    public static void setInnerMailService(IInnerMailService innerMailService) {
        MessageTemplate.innerMailService = innerMailService;
    }

    public static INotificationConfigService getNotificationConfigService() {
        return notificationConfigService;
    }

    public static void setNotificationConfigService(
            INotificationConfigService notificationConfigService) {
        MessageTemplate.notificationConfigService = notificationConfigService;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        MessageTemplate.logger = logger;
    }

    public static Properties getProp() {
        return prop;
    }

    public static void setProp(Properties prop) {
        MessageTemplate.prop = prop;
    }


}
