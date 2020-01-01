package com.hexiaofei.sjzclient.utils.messages;

import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 生成一个六位数随机验证码
 */
public class MobileVerifyCode
{
	private static Logger logger = Logger.getLogger(MobileVerifyCode.class);
	private final static int OFFSET = 538309;
	/** 失效时间（30分钟） */
	private final static long EXPIRED = 30 * 60 * 3000;
	/** 同一用途重复发送频率（1分钟） */
	private final static long FREQ = 1 * 60 * 1000;
	/** 安全性增强：最大尝试次数 */
	public final static int MAX_ATTEMPTS = 10;
	/** 有效期 */
	private long validThru;
	/** 短信验证码 */
	private String phoneVCode;
	/** 引用页面 */
	private String referrer;
	/** 目标接收手机号 */
	private String destMobileNum;
	/** 已尝试验证次数 */
	private int hasAttempt;
	/** 最近发送时间 */
	private long lastSent;
	/**
	 * 随机生成六位数验证码
	 * 
	 * @return 返回一个六位随机数验证码
	 */
	public static String MobileVfCode()
	{
		long seed = System.currentTimeMillis() + OFFSET;
		SecureRandom secureRandom = null; // 安全随机类
		try {
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
		}
		
		String codeList = "1234567890"; // 验证码数字取值范围
		String sRand = ""; // 定义一个验证码字符串变量

		for (int i = 0; i < 6; i++) {
			int code = secureRandom.nextInt(codeList.length() - 1);   // 随即生成一个0-9之间的整数
			String rand = codeList.substring(code, code + 1);
			sRand += rand;		 											// 将生成的随机数拼成一个六位数验证码
		}
		return sRand; 			 										    // 返回一个六位随机数验证码

	}
	
	/**
	 * 随机生成十位数ValidCode码，用于邮件验证
	 * @param 
	 * @param 
	 */
	public static String generateMailValidCode()
	{
		long seed = System.currentTimeMillis() + OFFSET;
		SecureRandom secureRandom = null; 						// 安全随机类
		try {
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
		}
		
		String codeList = "ABCDEFGHIJKLMNOPQRSTUVWXYZabckefghijklmnopqrstuvwxyz1234567890"; // 验证码数字取值范围
		String sRand = new String(""); 					// 定义一个验证码字符串变量

		for (int i = 0; i < 10; i++) {
			int code = secureRandom.nextInt(codeList.length() - 1); // 随即生成一个整数
			String rand = codeList.substring(code, code + 1);
			sRand += rand; 									// 将生成的随机数拼成一个十位数验证码
		}
		return sRand; 										// 返回一个六位随机数验证码
	}
	
	/**
	 * 构造函数
	 * @param referrer
	 * @param destMobileNum
	 */
	public MobileVerifyCode(String referrer, String destMobileNum) {
		this.setPhoneVCode(MobileVfCode());
		this.setReferrer(referrer);
		this.setDestMobileNum(destMobileNum);
		this.setValidThru(new Date().getTime() + EXPIRED);
		this.setLastSent(new Date().getTime());
	}
	
	/**
	 * 验证短信验证码是否有效
	 * @param referrer
	 * @return
	 */
	public boolean validate(String referrer, String phoneVCode, String destMobileNum) {
		boolean result = false;
		/*
		logger.info(this.getPhoneVCode() + " vs. " + phoneVCode);
		logger.info(this.getReferrer() + " vs. " + referrer);
		logger.info(this.getDestMobileNum() + " vs. " + destMobileNum);
		logger.info(this.getValidThru() + " vs. " + new Date().getTime());
		*/
		this.setHasAttempt(this.getHasAttempt() + 1);
		if (this.referrer != null && referrer != null) {
			if (this.referrer.equals(referrer) && this.phoneVCode.equals(phoneVCode) 
					&& this.destMobileNum.equals(destMobileNum) 
					&& this.getHasAttempt() <= MAX_ATTEMPTS
					&& new Date().getTime() < this.validThru) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * 是否可以发送短信
	 * @return
	 */
	public boolean checkShouldSendSMS(String referrer, String destMobileNum) {
		boolean result = true;
		/*
		logger.info(this.getReferrer() + " vs. " + referrer);
		logger.info(this.getDestMobileNum() + " vs. " + destMobileNum);
		logger.info(this.getLastSent() + " vs. " + new Date().getTime());
		*/
		if (this.getDestMobileNum() != null && this.getReferrer() != null
				&& this.getDestMobileNum().equals(destMobileNum)
				&& this.getReferrer().equals(referrer) 
				&& ((this.getLastSent() + FREQ) > new Date().getTime())) {
			result = false;
		}
		return result;
	}
	
	/**
	 * 检测是否为合法中国手机号码
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		if (mobiles == null) {
			return false;
		}
		//Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		Pattern p = Pattern.compile("^(1[3|4|5|7|8][0-9]\\d{4,8})$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	public String getPhoneVCode() {
		return phoneVCode;
	}

	public void setPhoneVCode(String phoneVCode) {
		this.phoneVCode = phoneVCode;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getDestMobileNum() {
		return destMobileNum;
	}

	public void setDestMobileNum(String destMobileNum) {
		this.destMobileNum = destMobileNum;
	}

	public long getValidThru() {
		return validThru;
	}

	public void setValidThru(long validThru) {
		this.validThru = validThru;
	}

	public long getLastSent() {
		return lastSent;
	}

	public void setLastSent(long lastSent) {
		this.lastSent = lastSent;
	}

	public int getHasAttempt() {
		return hasAttempt;
	}

	public void setHasAttempt(int hasAttempt) {
		this.hasAttempt = hasAttempt;
	}
	
}
