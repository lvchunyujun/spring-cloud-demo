/**
 * 
 */
package com.hexiaofei.sjzclient.service.message.impl.producer;

import com.hexiaofei.sjzclient.utils.BeanFactoryUtil;
import org.apache.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @since v1.1
 * @history 恢复不包含验证码并且当时发送时间在晚9点到早上9点间的短信
 */
public class RecoverOutHourExecutor {

	private static ScheduledExecutorService executorService;

	private static final int NTHREADS = 1;

	// 每次Recover的时间间隔，单位秒
	private int interval;

	// 第一次启动Recover的延迟时间，单位秒
	private int initialDelay;

	private static Logger logger = Logger.getLogger(RecoverOutHourExecutor.class);

	/**
	 * 开始恢复线程
	 */
	public void startRecover() {
		logger.info("startRecover()  开始启动Recover线程池");
		if (executorService == null || executorService.isShutdown()
				|| executorService.isTerminated()) {
			executorService = Executors.newScheduledThreadPool(NTHREADS);
		}
		executorService.scheduleWithFixedDelay(new RecoverOutHourThread(),
				initialDelay, interval, TimeUnit.SECONDS);
		logger.info("Recover线程池初始化成功, 将在" + initialDelay + "秒后启动线程，每"
				+ interval + "秒运行一次");
	}

	/**
	 * 取得Recover线程的线程池
	 * 
	 * @return
	 */
	public static RecoverOutHourExecutor getInstance() {
		return (RecoverOutHourExecutor) BeanFactoryUtil.getContext()
				.getBean("recoverOutHourExecutor");
	}

	/**
	 * Spring注入每次Recover的时间间隔
	 * 
	 * @param interval
	 *            the interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

	/**
	 * Spring注入第一次启动Recover的延迟时间，单位分钟
	 * 
	 * @param initialDelay
	 *            the initialDelay to set
	 */
	public void setInitialDelay(int initialDelay) {
		this.initialDelay = initialDelay;
	}

}
