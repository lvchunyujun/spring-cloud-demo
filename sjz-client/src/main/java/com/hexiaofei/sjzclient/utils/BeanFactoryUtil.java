package com.hexiaofei.sjzclient.utils;

import com.hexiaofei.sjzclient.common.CommonDef;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanFactoryUtil {
	private static ApplicationContext ctx_producer = null;
	
	public static void init() {
		// 初始化
		if(ctx_producer == null) {
			ctx_producer = new ClassPathXmlApplicationContext(new String[]{CommonDef.ApplicationContextPath,CommonDef.ApplicationContext_ThirdParty_Path,CommonDef.ApplicationContext_Quzrtz_Path});
		}
	}
	
	public static ApplicationContext getContext() {
		if(ctx_producer == null) {
			init();
		}
		return ctx_producer;
	}
}
