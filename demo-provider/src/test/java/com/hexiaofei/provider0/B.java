package com.hexiaofei.provider0;

import com.hexiaofei.provider1.A;

/**
 * Created by hexiaofei on 2018/4/22.
 */
public class B extends A {



    public static void main(String[] args){
        B a = new B();
        Byte b = null;
        Integer s2 = 111111;
        Integer s1 = 111111;

        Short s = null;
        Long l = null;

        System.out.println(s1.intValue()==s2.intValue());

        Float f = 0.1f;
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(f+=0.1f);
        }
    }
}
