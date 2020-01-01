package com.hexiaofei.sjzclient.web;

import com.hexiaofei.sjzclient.common.CommonDef;
import com.hexiaofei.sjzclient.common.EmailSendType;
import com.hexiaofei.sjzclient.common.IMailTpl;
import com.hexiaofei.sjzclient.domain.message.MailAuthen;
import com.hexiaofei.sjzclient.entity.User;
import com.hexiaofei.sjzclient.service.IAuthenRecordService;
import com.hexiaofei.sjzclient.service.UserInfoService;
import com.hexiaofei.sjzclient.service.message.IEmailService;
import com.hexiaofei.sjzclient.service.message.ISmsService;
import com.hexiaofei.sjzclient.utils.messages.MobileVerifyCode;
import com.hexiaofei.sjzclient.web.my.UserInfoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/20.
 */
@RestController
@RequestMapping(value = "/user")
public class UserInfoRegisterController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ISmsService smsService;

    @Autowired
    private IEmailService emailService;

    @Autowired
    public IAuthenRecordService authenRecordService;

    @Autowired
    protected BeanFactory factory;
    private String userRole = "1"; //ROLE_INVESTOR=1 为投资人;ROLE_BORROWER = 2 为借款人
    private String message;
    private String nickname;
    private String email;
    private String password;
    private Short roles;
    private String rand;
    private String isresub;
    private String verifycode;
    private String mailId;
    private String question;
    private String answer;
    private String inviterId;
    private String mobile;
    private MobileVerifyCode phoneVCode;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable(value = "id") Integer id){
        LOGGER.info("【查询客户信息】   id="+id);
        return null;
    }

    @RequestMapping("/sendEmail")
    private void sendEmail(HttpServletRequest request, int newlyAddeduserRegisterTempId) {
        int mailId;
        String registerRand = MobileVerifyCode.MobileVfCode(); // 注册后生成六位数验证码
        // 把发出的邮件验证码存入数据库
        MailAuthen mailAuthen = new MailAuthen();
        mailAuthen.setUserId(newlyAddeduserRegisterTempId);
        mailAuthen.setMail(email);
        mailAuthen.setSendTime(new Date());
        mailAuthen.setValidCode(registerRand);

        mailId = authenRecordService.addMailAuthen(mailAuthen); // 将邮件相关存入数据库调用AddMailAuthen方法

        // 注册成功后向用户发送一封邮件
        if (newlyAddeduserRegisterTempId > 0 && mailId > 0) {
            emailService = (IEmailService) factory
                    .getBean("emailService");
            String host_port_path;
            if("80".equals(request.getServerPort())){
                host_port_path = request.getServerName() + "" + request.getContextPath();
            }else{
                host_port_path = request.getServerName() + ":" + request.getServerPort() +""
                        + request.getContextPath();
            }
            String url = "<a href=http://" + host_port_path
                    + "/registerActive?mailAuthenid="
                    + mailId + "&tempUserId="
                    + newlyAddeduserRegisterTempId + "&validteCde="
                    + registerRand
                    + "><font color='#DA722B'>立即激活账户</front></a>";
            String copyLink = "http://" + host_port_path
                    + "/registerActive?mailAuthenid="
                    + mailId + "&tempUserId="
                    + newlyAddeduserRegisterTempId + "&validteCde="
                    + registerRand;
            String mailMsg = IMailTpl.MAIL_REG_SUCCESS_TPL;
            mailMsg = mailMsg.replaceAll("#copyLink#", copyLink);
            mailMsg = mailMsg.replaceAll("#username#", nickname);
            mailMsg = mailMsg.replaceAll("#url#", url);
            emailService.sendMail(EmailSendType.REG_PASSWD, email, "【"
                    + CommonDef.WEBSITE_NAME_CN + "】注册用户“" + nickname
                    + "”账户激活邮件", mailMsg);
            request.setAttribute("mailId", mailId);
            request.setAttribute("email", email);
            request.setAttribute("nickname", nickname);
            request.setAttribute("password", password);
            request.setAttribute("personrole", roles);
            request.setAttribute("verifycode", verifycode);
            request.setAttribute("isresub", isresub);
        	/*try {
        		response.getWriter().write("" + mailAuthenid);
        		response.getWriter().flush();
        	} catch (IOException e) {
        		logger.info("注册提交失败" + e);
        	}*/
        }
    }


}
