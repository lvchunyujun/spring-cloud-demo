package com.hexiaofei.provider0.common;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author zhuliyu
 */
public class StringUtils {

    /**
     * @param src 参数
     * @return 结果
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * @param hexString 参数
     * @return 结果
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * @param c 参数
     * @return 结果
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * @param string 参数
     * @return 结果
     */
    public static byte[] stringToBytes(String string) {
        byte[] b = null;
        try {
            b = string.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return b;
    }

    /**
     * @param b 参数
     * @return 结果
     */
    public static String bytesToString(byte[] b) {
        String s = null;
        try {
            s = new String(b, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * @param b 参数
     * @return 结果
     */
    public static String encryptBASE64(byte[] b) {
        String ret = "";
        try {
            ret = new String(Base64.encodeBase64(b), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * @param s 参数
     * @return 结果
     */
    public static byte[] decryptBASE64(String s) {
        byte[] ret = {};
        try {
            ret = Base64.decodeBase64(s.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 字符串转换，如果为null则返回空，不为null则返回原值
     *
     * @param str 代转换字符串
     * @return 结果
     */
    public static String transStrNullToBlank(String str) {
        String result = "";
        if (str != null) {
            result = str;
        }
        return result;
    }

    /**
     * 随机生成返回业务系统的绑卡id（2+22位）
     *
     * @return 结果
     */
    public static String getBindId() {

        String before = "MXDBK";
        String result = before + getFlowNum();

        return result;
    }

    /**
     * 随机生成批次号（2+22位）
     *
     * @return 结果
     */
    public static String getBatchNo() {

        String before = "MXDBN";
        String result = before + getFlowNum();

        return result;
    }

    /**
     * 随机生成鉴权订单编号（2+22位）
     *
     * @return 结果
     */
    public static String getIdentityOrderNo() {

        String before = "MXDJQ";
        String result = before + getFlowNum();

        return result;
    }

    /**
     * 随机生成提现订单编号（2+22位）
     *
     * @return 结果
     */
    public static String getWithdrawPayOrderNo() {

        String before = "MXDTX";
        String result = before + getFlowNum();

        return result;
    }

    /**
     * 生成流水号（22位）
     *
     * @return 结果
     */
    public static String getFlowNum() {

        //获取时间戳，精确到毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
        Date currentTime = new Date();
        String currentTimeStr = sdf.format(currentTime);

        //获取6位随机数
        Random random = new Random();
        String randomStr = String.valueOf(random.nextInt(100000));

        //随机数不足6位，前面补0
        int randomLength = 6;
        String zero = "";
        if (randomStr.length() < randomLength) {
            for (int i = randomStr.length(); i < randomLength; i++) {
                zero = zero + "0";
            }
            randomStr = zero + randomStr;
        }

        String result = currentTimeStr + randomStr;

        return result;
    }

    /**
     * 生成充值订单编号-发送支付公司的
     *
     * @return 结果
     */
    public static String getRechargeOrderNo() {
        String before = "MXDCZ";
        String result = before + getFlowNum();

        return result;
    }
}
