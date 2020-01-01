package com.hexiaofei.sjzclient.common;

public class IMailTpl
{
	/**
	 * 注册成功提醒邮件
	 */
	public static final String MAIL_REG_SUCCESS_TPL = "<div style='color:#333333;'>"
			+ "<p>亲爱的"+CommonDef.WEBSITE_NAME_CN+"用户： #username# ，您好！</p>"
			+ "<p>感谢您注册"+CommonDef.WEBSITE_NAME_CN+"，您现在只需点击以下链接，即可完成注册。</p>"
			+ "<br />"
			+ "<p>请#url#!</p>"
			+ "<br />"
			+ "<p style='color:#333333;'>若您无法直接点击链接，也可复制以下地址到浏览器地址栏中：</p>"
			+ "<p style='color:#333333;'>#copyLink#</p>"
			+ "<br />"
			/*+ "<p style='color:#333333;'>您在"+CommonDef.WEBSITE_NAME_CN+"可以享受到以下服务： </p>"
			+ "<p style='color:#333333;'>1.	通过简单、便捷的网络操作出借富余资金，享受<b><u>远高于银行存款利息</u><b>的优质理财项目</p>"
			+ "<p style='color:#333333;'>2.	所有理财项目的本息均由大型合作机构<b><u>100%免费担保</u><b></p>"
			+ "<p style='color:#333333;'>3.	<b><u>投资门槛低</u><b>，<b><u>灵活性高</u><b>，可随时赎回投资</p>"
			+ "<p style='color:#333333;'>4.	充值、投资、提现，<b><u>各种服务全免费</u><b></p>"
			+ "<br /><p style='color:#333333;'>"+CommonDef.WEBSITE_NAME_CN+"，您的互联网理财新渠道！</p><br />"*/
			+ "<p style='color:#333333;'>感谢您的支持！</p>"
			+ "<p style='color:#333333;'>"+CommonDef.WEBSITE_NAME_CN+"团队</p>"
			+ "<br />"
			+ "<p>---------------------------------- </p>"
			+ "<p style='color:#333333;'>注：此邮件由"+CommonDef.WEBSITE_NAME_CN+"系统自动发送，请勿回复 </p>"
			/*+ "<p style='color:#333333;'>如果您有任何疑问，可以点击 <a target=_blank href='http://www."+CommonDef.WEBSITE_DOMAIN_NAME+"/toAboutPage.action?aboutType=5'>这里</a> 与我们的客服进行沟通，或者发送邮件至：<a href='mailto:kefu@"+CommonDef.WEBSITE_DOMAIN_NAME+"'>kefu@"+CommonDef.WEBSITE_DOMAIN_NAME+"</a></p>"*/
			+ "<p style='color:#333333;'>如果您有任何疑问，可以电话与我们的客服进行沟通（400-013-1876），或者发送邮件至：<a href='mailto:kefu@"+CommonDef.WEBSITE_DOMAIN_NAME+"'>kefu@"+CommonDef.WEBSITE_DOMAIN_NAME+"</a></p>"
			+ "<p style='color:#333333;'>&nbsp;</p>"
			+ "<p style='color:#333333;'>&nbsp;</p>"
			+ "<p style='color:#333333;'>&copy;2015 "+CommonDef.WEBSITE_DOMAIN_NAME+" | 北京金水玉桥信息科技有限公司  版权所有</p>"
			+ "</div>";
	/**
	 * 忘记密码邮件模版
	 */
	public static final String MAIL_FORGET_PWD = "<div style='color:#333333;'>"
			+ "<p>亲爱的"+CommonDef.WEBSITE_NAME_CN+"用户： **#username# ，您好！</p>"
			+ "<p>您在#time#提交了密码重置的请求。</p>"
			+ "<p>请您在24小时内点击下面的链接重设您的密码：</p>"
			+ "<br />"
			+ "<p>请#url#!(该链接在24小时内有效)</p>"
			+ "<br />"
			+ "<p style='color:#333333;'>若您无法直接点击链接，也可复制以下地址到浏览器地址栏中：</p>"
			+ "<p style='color:#333333;'>#copyLink#</p>"
			+ "<br />"
			+ "<p>---------------------------------- </p>"
			+ "<p style='color:#333333;'>注：此邮件由"+CommonDef.WEBSITE_NAME_CN+"系统自动发送，请勿回复 </p>"
			+ "<p style='color:#333333;'>如果您有任何疑问，可以电话与我们的客服进行沟通（400-013-1876），或者发送邮件至：<a href='mailto:kefu@"+CommonDef.WEBSITE_DOMAIN_NAME+"'>kefu@"+CommonDef.WEBSITE_DOMAIN_NAME+"</a></p>"
			+ "<p style='color:#333333;'>&nbsp;</p>"
			+ "<p style='color:#333333;'>&nbsp;</p>"
			+ "<p style='color:#333333;'>&copy;2015 "+CommonDef.WEBSITE_DOMAIN_NAME+" | 北京金水玉桥信息科技有限公司  版权所有</p>"
			+ "</div>";

}
