package com.lcyj.common.utils.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义缓存 <br/>
 *
 * @author lcyj
 * @date 2020-08-01 15:45
 * @since
 */
public class LcyjCache {

    private static LcyjCache lcyjCache;
    private static Map<String,String> cacheMap ;

    private LcyjCache(){}

    static{
        init();
    }

    private static void init(){
        if(cacheMap == null){
            cacheMap = new HashMap<String,String>();
        }
    }

    public static  LcyjCache getInstance(){
        if(lcyjCache == null){
            lcyjCache = new LcyjCache();
        }
        return lcyjCache;
    }

    public void set(String key,String value){
        cacheMap.put(key,value);
    }

    public String get(String key){
        return cacheMap.get(key);
    }

}
