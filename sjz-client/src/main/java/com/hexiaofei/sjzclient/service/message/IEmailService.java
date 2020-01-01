package com.hexiaofei.sjzclient.service.message;

import com.hexiaofei.sjzclient.common.EmailSendType;

public interface IEmailService {
	/**
	 * 增加一个新邮件到发送队列中，等待被别的线程发送。
	 * 
	 * @param type
	 *            邮件类型（注册激活，放标_流标_满标，成功还款等）
	 * @param toAddress
	 *            收件人地址
	 * @param subject
	 *            邮件标题
	 * @param content
	 *            邮件正文
	 */
	public void sendMail(EmailSendType type, String toAddress, String subject,
						 String content);
}
