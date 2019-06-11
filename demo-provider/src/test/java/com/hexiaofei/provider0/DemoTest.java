package com.hexiaofei.provider0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by hexiaofei on 2018/4/22.
 */
public class DemoTest extends B{
//    static String name = "DemoTst_Name";
//    static{
//        System.out.println("DemoTst.static{}");
//    }

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Integer ff = 100;
        Integer fff = 221;
        Long g = 3l;
        System.out.println(a == b);
        System.out.println(e == f);
        System.out.println(f == (ff+fff));
        System.out.println(c == (a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g == (a+b));
        System.out.println(g.equals(a+b));

        String[] s = {"",""};
        ClassPathResource resource = new ClassPathResource("");
        ApplicationContext context = new FileSystemXmlApplicationContext(s);
        context.getBean("");
        context.containsBean("");
    }
}
//class A{
//
////    static String name = "A_Name";
////    static{
////        System.out.println("A.static{}");
////    }
//
//}
