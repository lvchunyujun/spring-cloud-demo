package com.lcyj.common.utils;

import java.util.Random;

/**
 *
 */
public class NumberUtils {

    /**
     * 随机生成一个数字字符串
     * @param length 字符串长度
     * @return
     */
    public static String genRandomNumberStr(int length){
        char[] c = {'0','1','2','3','4','5','6','7','8','9'};

        char[] num = new char[length];

        for(int i = 0 ; i < length ; i++){
            int n = new Random().nextInt(10);
            num[i] = c[n];
        }
        return new String(num);
    }
}
