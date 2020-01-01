package com.hexiaofei.sjzclient.utils.messages;

import com.hexiaofei.sjzclient.service.UserInfoService;
import com.hexiaofei.sjzclient.service.message.IEmailService;
import com.hexiaofei.sjzclient.service.message.IInnerMailService;
import com.hexiaofei.sjzclient.service.message.INotificationConfigService;
import com.hexiaofei.sjzclient.service.message.ISmsService;
import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * Core项目中发送各种消息的帮助类
 * 
 * @since v1.0
 * @history
 * @see
 */
public class MessageHelper
{

    private static Logger logger = Logger.getLogger(MessageHelper.class);

    private static IEmailService emailService;
    
    private static ISmsService smsService;

    private static IInnerMailService innerMailService;

    private static INotificationConfigService notificationConfigService;

    private static UserInfoService userService;

    private static Properties prop;

    private static final String CORE_MESSAGE_TEMPLATE = "coreMessageTemplate.properties";




}
