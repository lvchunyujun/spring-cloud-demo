package com.hexiaofei.sjzclient.service.message.impl.producer;

import com.hexiaofei.sjzclient.service.message.impl.consumer.impl.SMSConsumer;
import com.hexiaofei.sjzclient.service.message.impl.model.sms.SMS;
import com.hexiaofei.sjzclient.service.message.impl.queue.SMSQueue;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 对比log进行恢复的线程
 * 
 * 
 */
public class RecoverOutHourThread implements Runnable {

	private static Logger logger = Logger.getLogger(RecoverOutHourThread.class);

	// 短信发送成功邮件的日志
	private static final String SMS_AFTER_SUCC_LOG_PATH = ((FileAppender) Logger.getLogger("sms_after_succ").getAppender("sms_after_succ")).getFile();

	// 短信发送失败邮件的日志
	private static final String SMS_OUT_HOUR_LOG_PATH = ((FileAppender) Logger.getLogger("sms_out_hour").getAppender("sms_out_hour")).getFile();

	@Override
	public void run() {
		recoverSMS();
	}

	/**
	 * 构造函数
	 */
	public RecoverOutHourThread() {
		logger.info("Recover线程启动");
	}

	/**
	 * 恢复不包含验证码并且时间是在晚上9点到早上9间发的短信
	 */
	private void recoverSMS() {
		// 如果不在发送时间内，那么退出短信的recover
		if (!canSendSMS()) {
			logger.debug("当前不在允许发送短信的时间范围内，不进行短信recover动作");
			return;
		}

		SMSQueue smsQueue = SMSQueue.getInstance();

		if (smsQueue.size() > 0) {
			logger.info("短信队列正忙，恢复动作取消");
			return;
		} else {
			logger.info("短信队列空闲，开始恢复发送失败的短信");
			Map<UUID, SMS> smsAfterSucc = readSMSFromLog(SMS_AFTER_SUCC_LOG_PATH);
			Map<UUID, SMS> smsOutHour = readSMSFromLog(SMS_OUT_HOUR_LOG_PATH);

			Iterator<UUID> i_SMSAfterSucc = smsAfterSucc.keySet().iterator();

			// 从这个map中去掉所有发送成功的短信
			while (i_SMSAfterSucc.hasNext()) {
				smsOutHour.remove(i_SMSAfterSucc.next());
			}

			// map中剩下的就是需要重新发送的短信了
			List<SMS> smsToBeRecover = new ArrayList<SMS>(smsOutHour.values());
			int i;
			for (i = 0; i < smsToBeRecover.size(); i++) {
				TaskProducer.addSMS(smsToBeRecover.get(i), false);
				logger.info("恢复短信" + smsToBeRecover.get(i).toJSONString());
			}
			logger.info("短信恢复完毕，共恢复了 " + i + " 条短信");

		}
	}

	/**
	 * 读取短信log，并转换成SMS对象
	 */
	private Map<UUID, SMS> readSMSFromLog(String logFile) {
		Map<UUID, SMS> sms_before = new HashMap<UUID, SMS>();
		FileReader fr_before = null;
		BufferedReader br_before = null;
		try {
			fr_before = new FileReader(logFile);
			br_before = new BufferedReader(fr_before);
			String eachline;
			while (br_before.ready()) {
				eachline = br_before.readLine();// 读取一行
				SMS smsInLog = convertLogToSMS(eachline);
				sms_before.put(smsInLog.getTaskID(), smsInLog);
			}
		} catch (FileNotFoundException fnfe) {
			logger.error("短信log文件未找到", fnfe);
		} catch (IOException ioe) {
			logger.error("io error.", ioe);
		} catch (JSONException jsone) {
			logger.error("转换JSON格式时发生错误", jsone);
		} finally {
			if (br_before != null) {
				try {
					br_before.close();
					logger.info("读取短信log " + logFile + " 的BufferReader关闭");
				} catch (IOException ioe) {
					logger.error("短信恢复的BufferReader关闭时发生异常", ioe);
				}
			}
			if (fr_before != null) {
				try {
					fr_before.close();
					logger.info("读取短信log " + logFile + " 的FileReader关闭");
				} catch (IOException ioe) {
					logger.error("短信恢复的FileReader关闭时发生异常.", ioe);
				}
			}
		}
		return sms_before;
	}

	/**
	 * 把一行log转换成一个SMS对象
	 * 
	 * @param logLine
	 * @return
	 */
	private static SMS convertLogToSMS(String logLine) throws JSONException {
		String jsonLog = logLine.substring(logLine.indexOf("{"));
		return SMS.fromJSONString(jsonLog);
	}

	/**
	 * 检查是否在发送短信的时间范围之内
	 * 
	 * @return true 在上午9点到晚上21点之间
	 */
	private static boolean canSendSMS() {
		Calendar time = Calendar.getInstance();
		int currentHour = time.get(Calendar.HOUR_OF_DAY);
		if (currentHour < SMSConsumer.START_SEND_HOUR
				|| currentHour >= SMSConsumer.END_SEND_HOUR) {
			return false;
		} else {
			return true;
		}
	}
}
