package com.lcyj.common.utils.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * HmacSHA1签名实用类（供Cookie SSO使用）
 * 
 *
 */
public class HmacSHA1Utils {
	
	private static final Logger logger = LoggerFactory.getLogger(HmacSHA1Utils.class);

	private final static String FORUM_COOKIE_SSO_MASTER_KEY = "SE$VNAXdg.+[TgaUxE9L";
	private final static String FORUM_COOKIE_SSO_CONSUMER_KEY = "!q9yObu+g!+7mFdOlup7";
	private final static String FORUM_COOKIE_SSO_SALT = "RoF[8N4-29ultGSfKvT=li1uIyEG^6^i";
	/** email认证Key */
	public final static String MAIL_AUTH_CONSUMER_KEY = "kZbM#0<xF*^rb6(e";
	
	/**
	 * 生成HmacSHA1签名
	 * 
	 * @param baseString
	 * @param consumerkey
	 * @return signature
	 * @author yuxuan.zhai
	 */
	public static String createSignature(String baseString, String consumerkey) {
		String algorithm = "HmacSHA1";
		Mac mac = null;
		try {
			mac = Mac.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		byte[] key = consumerkey.getBytes();
		
		SecretKeySpec spec = new SecretKeySpec(key, algorithm);
		
		try {
			mac.init(spec);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		}
		
		byte[] data;
		try {
			data = baseString.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		
		mac.update(data);
		StringBuilder sb = new StringBuilder();
		byte[] result = mac.doFinal();
		for (int i = 0; i < result.length; i++) {
			String str = Integer.toHexString(result[i] & 0xFF);
			if (str.length() == 1) {
				str = "0" + str;
			}
			sb.append(str.toLowerCase());
		}
		
		String signature = sb.toString();
		
		return signature;
	}
	
	/**
	 * 生成加盐的双重HmacSHA1签名，供Cookie SSO使用
	 * 
	 * @param cookieUserInfo
	 * @return signature
	 * @author yuxuan.zhai
	 */
	public static String createCookieSSOHash(String cookieUserInfo) {
		return createSignature(
				createSignature(cookieUserInfo, FORUM_COOKIE_SSO_CONSUMER_KEY)
						+ FORUM_COOKIE_SSO_SALT, FORUM_COOKIE_SSO_MASTER_KEY);
	}
	
	public static String createCookieSSOUserInfo(String nickName, Integer userId) {
		String userInfo = nickName;
		try {
			userInfo = URLEncoder.encode(nickName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("",e);
		}
		userInfo += "&" + userId.toString();
		userInfo += "&" + createCookieSSOHash(userInfo);
		userInfo = Base64Coder.encodeString(userInfo);
		try {
			userInfo = URLEncoder.encode(userInfo, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("",e);
		}
		return userInfo;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(createCookieSSOHash("salburg&10001"));
		System.out.println(createCookieSSOUserInfo("salburg", Integer.valueOf(10001)));
	}

}
