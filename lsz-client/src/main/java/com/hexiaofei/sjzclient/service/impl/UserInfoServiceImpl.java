package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.common.EmailSendType;
import com.hexiaofei.sjzclient.common.EmailTemplate;
import com.hexiaofei.sjzclient.common.PlatformConstant;
import com.hexiaofei.sjzclient.common.WebSystemConsts;
import com.hexiaofei.sjzclient.dao.mapper.UserInfoMapper;
import com.hexiaofei.sjzclient.domain.MailAuthen;
import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.IAuthenRecordService;
import com.hexiaofei.sjzclient.service.IUserInfoService;
import com.hexiaofei.sjzclient.service.base.AbstractService;
import com.hexiaofei.sjzclient.service.sms.SmsEmailService;
import com.hexiaofei.sjzclient.service.sms.SmsUserinfoService;
import com.hexiaofei.sjzclient.vo.PageVo;
import com.lcyj.common.bo.sms.SmsEmail;
import com.lcyj.common.utils.DateUtils;
import com.lcyj.common.utils.security.HmacSHA1Utils;
import com.lcyj.common.utils.security.MD5;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Administrator on 2017/12/1.
 */

/**
 * 用户服务接口
 */
@Transactional
@Service("userInfoService")
public class UserInfoServiceImpl extends AbstractService implements IUserInfoService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SmsUserinfoService smsUserinfoService;

    @Autowired
    private SmsEmailService smsEmailService;

    @Autowired
    private IAuthenRecordService authenRecordService;

    private final static String OK = "OK";

    @Override
    public UserInfo getUserInfoForLogin(String userName, String password) throws PlatformException {
        password = MD5.encodeByMd5AndSalt(password);
        return userInfoMapper.selectUserInfoForLogin(userName,password);
    }

    /**
     * 用户注册
     * @param email
     * @param password
     * @return
     * @throws PlatformException
     */
    @Override
    public int register(String email, String password) throws PlatformException {

        UserInfo userInfo = null;

        if(StringUtils.isBlank(email)||StringUtils.isBlank(password)){
            return -1;
        }

        if(getUserInfoByEmail(email)!=null){
            return -1;
        }
        userInfo = new UserInfo();
        userInfo.setUserName(email);
        userInfo.setEmail(email);
        userInfo.setPassword(MD5.encodeByMd5AndSalt(password));
        userInfo.setRegisterDate(new Date());
        userInfo.setStatus((short)0);
        userInfo.setRole((short)20);
        return addObject(userInfo);
    }

    @Override
    public UserInfo getUserInfoByEmail(String email) {
        return userInfoMapper.selectUserInfoForEmail(email);
    }

    /**
     * 找回密码- 1.发送验证邮件
     * @param email
     * @return 0:发送成功，-1：email未注册，-2：发送失败
     */
    @Transactional
    @Override
    public int sendFindPasswdVerifyEmail(String email) {

        // step1.  email是否存在
        UserInfo userInfo = this.getUserInfoByEmail(email);
        if(userInfo!=null){
            // step2. 保存email验证信息
            MailAuthen mailAuthen =  setMailAuthen(userInfo);
            authenRecordService.addMailAuthen(mailAuthen);

            // step3. 设置email信息
            SmsEmail smsEmail = setEmailInfo(userInfo,mailAuthen);
            String result = smsEmailService.send(smsEmail);

            if(OK.equals(result)){
                return 0;
            }else{
                return -2;
            }
        }else{
            return -1;
        }
    }

    /**
     * 找回密码- 2. 校验请求参数
     *      * http://www.lishizhou.com/findPasswd/verify?mailAuthenId=23&email=lvchunyujun@163.com&newValidCode=A96DAA60AE957B63A51A6F7212602507&sign=b78d2586e0f6737a0571aca377c6cc79a7a3debe
     *      *      * @param email
     * @param email
     * @param mailAuthenId
     * @param requestNewValidCode
     * @param requestSignText
     * @return 0:通过；-100: email不能为空；
     * -110：email不存在！；
     * -200：认证信息不存在；
     * -210：认证信息不一致；
     * -300：验证签名失败；
     * -400：链接失效；
     */
    @Transactional
    @Override
    public int verifyFindPasswdEmail(String email,int mailAuthenId,String requestNewValidCode,String requestSignText) {
        LOGGER.info("【找回密码-校验连接】-->  [email=" + email+ ",mailAuthenID=" + mailAuthenId +
                ",newValidCode=" + requestNewValidCode + ",sign="+requestSignText+"]");

        int resultCode = verifyFindPassword( email, mailAuthenId, requestNewValidCode, requestSignText);
        LOGGER.info("【找回密码-校验连接】<--  ");
        return resultCode;
    }

    private int verifyFindPassword(String email,int mailAuthenId,String requestNewValidCode,String requestSignText){
        UserInfo userInfo = null;
        MailAuthen mailAuthen = null;
        //step1:  检查email是否存在
        if(StringUtils.isBlank(email)){
            LOGGER.error("【找回密码-校验连接】 email不存在！  email="+email);
            return -100;
        }
        userInfo =  getUserInfoByEmail(email);
        if(userInfo == null){
            LOGGER.error("【找回密码-校验连接】 email不存在！  email="+email);
            return -110;
        }
        //step2:  mailAuthenId与userID按位异或，得到原来的mailauthenid，获取数据库中的记录,进行比较，如有不符，则返回失败
        mailAuthenId = mailAuthenId^userInfo.getId().intValue();

        //step3: 先从请求中获取到四个要素，email,处理之后的mailauthenid,newValidCode和签名
        String computeSignText = getSignTxt( mailAuthenId, email, requestNewValidCode);
        LOGGER.info(mailAuthenId+"");
        LOGGER.info(requestSignText);
        LOGGER.info(computeSignText);
        if(!requestSignText.equals(computeSignText)) {
            LOGGER.error("用户重置密码时，检查Signature失败，请求sign=" + requestSignText + "计算出sign" + computeSignText);
            return -300;
        }

        mailAuthen = authenRecordService.getMailAuthenById(mailAuthenId);
        if (mailAuthen == null) {
            LOGGER.error("【找回密码-校验连接】 mailAuthen不存在！  mailAuthenid="+mailAuthenId);
            return -200;
        }
        if (!email.equals(mailAuthen.getMail())
                || !requestNewValidCode.equals(mailAuthen.getValidCode())) {
            LOGGER.error("用户重置密码时，请求中的Email与validcode与数据库中记录不一致，email=" + email
                    + "，newValidCode" + requestNewValidCode + "数据库中记录email="
                    + mailAuthen.getMail() + "ValidCode"
                    + mailAuthen.getValidCode());
            return -210;
        }

        //step4:  检查邮件有效期30分钟有效，若超时则返回失败信息
        Date sendTime = mailAuthen.getSendTime();
        Calendar ca = Calendar.getInstance();
        long nowtime = ca.getTimeInMillis();
        ca.setTime(sendTime);
        long startime = ca.getTimeInMillis();
        long lasttime = nowtime - startime;
        if (lasttime <= 0 || lasttime >= (30 * 60 * 1000)) {
            LOGGER.error("【找回密码-校验连接】连接失效！");
            return -400;
        }
        return 0;
    }

    /**
     * 找回密码- 3. 修改密码
     * @return
     */
    @Transactional
    @Override
    public int updatePasswdForFindPasswd(String email,String newPasswd,String validCode,Integer mailAuthenId,String requestSignText) {
        LOGGER.info("【找回密码-重置密码】-->  ");
        int resultCode = -1;
        try {
            resultCode = verifyFindPassword(email,mailAuthenId, validCode, requestSignText);
            if(resultCode == 0){
                if((resultCode = checkPasswd(newPasswd))==0){
                    this.resetUserPassword(email, newPasswd);
                    LOGGER.info("【找回密码-重置密码】 用户提交表单检查完毕，开始重置密码，email="+ email);
                }
            }
        } catch (Exception e) {
            LOGGER.error("【找回密码-重置密码】 重置密码错误");
            return -1;
        }
        LOGGER.info("【找回密码-重置密码】<--  ");
        return resultCode;
    }

    private int checkPasswd(String newPasswd){
        if(StringUtils.isBlank(newPasswd)){
            return -500;
        }
        if( newPasswd.equals("")){
            return -510;
        }
        return 0;
    }

    private String getSignTxt(Integer mailAuthenId,String email,String validCode){
        //step1: 检查签名，计算出的签名是否与从请求中获取的签名一致，如果不一致，返回失拜
        String plainText = "mailAuthenID=[" + mailAuthenId.intValue() + "]email=[" + email +"]newValidCode=[" + validCode + "]";
        String signText = HmacSHA1Utils.createSignature(plainText, HmacSHA1Utils.MAIL_AUTH_CONSUMER_KEY);
        return signText;
    }

    private int resetUserPassword(String email, String newPassword) throws PlatformException
    {
        LOGGER.debug("密码重置，用户邮箱：" + email);
        userInfoMapper.resetUserPassword(email, MD5.encodeByMd5AndSalt(newPassword));
        authenRecordService.delOldMailAuthenByMail(email);
        return 0;
    }


    private MailAuthen setMailAuthen(UserInfo userInfo){
        // 验证码
        String validcode = MD5.encodeByMd5AndSalt(userInfo.getEmail()+""+userInfo.getPassword());

        MailAuthen mailAuthen = new MailAuthen();
        mailAuthen.setUserId(userInfo.getId());
        mailAuthen.setMail(userInfo.getEmail());
        mailAuthen.setSendTime(new Date());
        mailAuthen.setValidCode(validcode);

        return mailAuthen;
    }

    /**
     *
     * @param userInfo
     * @param mailAuthenId
     * @param email
     * @param tagFlag url=生成url,a=生成a标签
     * @return
     */
    private String generateLink(UserInfo userInfo,Integer mailAuthenId, String email,String tagFlag)   {
        String validCode = MD5.encodeByMd5AndSalt(userInfo.getEmail()+""+userInfo.getPassword());

        String signText = getSignTxt( mailAuthenId, email, validCode);

        mailAuthenId = mailAuthenId^userInfo.getId().intValue();
        if("a".equals(tagFlag)){
            String url = "点击该链接<a href=\"http://" + PlatformConstant.SERVER_WEBSITE
                    + "/findPasswd/verify?mailAuthenId=" + mailAuthenId
                    + "&email=" + email + "&newValidCode=" + validCode
                    + "&sign=" + signText + "\"><font color=\"red\">重置密码</font></a>";
            return url;
        }else if("url".equals(tagFlag)){
            String a = "http://" + PlatformConstant.SERVER_WEBSITE
                    + "/findPasswd/verify?mailAuthenId=" + mailAuthenId
                    + "&email=" + email + "&newValidCode=" + validCode + "&sign=" + signText;

            return a;
        }else{
            return "";
        }
    }

    /**
     * 发送邮件
     * @param userInfo
     * @param mailAuthen
     * @return
     */
    private SmsEmail setEmailInfo(UserInfo userInfo,MailAuthen mailAuthen){

        SmsEmail smsEmail = new SmsEmail();
        smsEmail.setPlatformId(PlatformConstant.PLATFORM_ID);
        smsEmail.setServerId(PlatformConstant.SERVER_ID);
        smsEmail.setToEmail(userInfo.getEmail());
        smsEmail.setEmailType(EmailSendType.FIND_PASSWORD_CODE.getType());
        smsEmail.setSubject(EmailSendType.FIND_PASSWORD_CODE.getDescri());
        smsEmail.setLastUpdateTime(new Date());
        smsEmail.setCreateTime(mailAuthen.getSendTime());

        Map parameterMap = new HashMap();
        parameterMap.put("username",userInfo.getEmail());
        // 生成超链接<a/>标签
        String a = generateLink(userInfo,mailAuthen.getMailAuthenId(),userInfo.getEmail(),"a");
        parameterMap.put("<a/>",a);
        // 提交申请日期
        parameterMap.put("time",DateUtils.dateToStr(mailAuthen.getSendTime(),"yyyy-MM-dd HH:mm:ss"));
        // 生成复制URL
        String copyLink = generateLink(userInfo,mailAuthen.getMailAuthenId(),userInfo.getEmail(),"url");
        parameterMap.put("copyLink",copyLink);

        smsEmail.setContent(paraseParameterMap(EmailTemplate.FIND_PASSWORD_CODE,parameterMap));
        return smsEmail;
    }

    /**
     * 待优化：抽离到 EmailTemplate.class
     * @param template
     * @param parasMap
     * @return
     */
    private static String paraseParameterMap(String template,Map<String,String> parasMap){

        template = template.replaceAll("#username#", parasMap.get("username"));
        template = template.replaceAll("#<a/>#",  parasMap.get("<a/>"));
        template = template.replaceAll("#url#",  parasMap.get("url"));
        template = template.replaceAll("#time#", parasMap.get("time"));
        template = template.replaceAll("#copyLink#", parasMap.get("copyLink") );


        return template;
    }


    @Override
    public int addObject(UserInfo userInfo) throws PlatformException {
        if(userInfo.getPassword() == null){
            userInfo.setPassword(MD5.encodeByMd5AndSalt(WebSystemConsts.DFAULT_PASSWORD));
        }
        userInfo.setLoginCount(0);
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(UserInfo userInfo) throws PlatformException {
        int resultId = -1;
        UserInfo targetObj = getObjectById(userInfo.getId());
        targetObj = refreshObjectForNotNullVal(targetObj,userInfo);
        resultId = userInfoMapper.updateByPrimaryKey(targetObj);
        return resultId;
    }

    @Override
    public UserInfo getObjectById(int id) throws PlatformException {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVo<UserInfo> getPageVoObject(PageVo<UserInfo> pageVo) throws PlatformException {
        List<UserInfo> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = userInfoMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = userInfoMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<UserInfo> getAllObject() throws PlatformException {
        return null;
    }
}
