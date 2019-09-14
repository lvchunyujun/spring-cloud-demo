package com.shijianzhou.language.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtils {

    /**
     * 正则表达式匹配字符串
     * @param resource 目标字符串
     * @param ptn 匹配模板
     * @return
     */
    public static boolean stringMarchStrCheck(String resource,String ptn){
        Pattern p = Pattern.compile(ptn);
        Matcher m=p.matcher(resource);
        return m.matches();//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
    }
}
