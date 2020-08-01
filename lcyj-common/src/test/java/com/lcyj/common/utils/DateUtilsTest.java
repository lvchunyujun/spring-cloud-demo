package com.lcyj.common.utils;


import org.junit.Test;

import java.util.Date;
import java.util.List;

public class DateUtilsTest {

    @Test
    public void strToDate() {
    }

    @Test
    public void strToDate1() {
    }

    @Test
    public void dateToStr() {
    }

    @Test
    public void resolveStrToDate() {
    }

    @Test
    public void resolveDateOfStr() {

        String dateStr = "张三0020-2-29李1023-12-12四";
        String pat = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))";
        String pat1 = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})年(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))";
        List<String> list = DateUtils.resolveDateOfStr(dateStr,pat);
        list.forEach(str ->{
            System.out.println(str);
        });

    }

    @Test
    public void parseStrToDate(){
        String[] ss = {"","2020","10-12","2020-10-12","2020-2-12","2020/3/12","2020年3月12日","2020年3月12"};
        for(String s : ss){
            Date date = DateUtils.parseStrToDate(s);
            System.out.println(s+"转换后：" + (date != null ? DateUtils.dateToStr(date) : ""));
        }

    }
}