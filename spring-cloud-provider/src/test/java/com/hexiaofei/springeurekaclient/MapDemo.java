package com.hexiaofei.springeurekaclient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hexiaofei on 2018/3/29.
 */
public class MapDemo {

    static class OOMObject{}

    public static void main(String[] args){
        List list = new ArrayList<OOMObject>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
