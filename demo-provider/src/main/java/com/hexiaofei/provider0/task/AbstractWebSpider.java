package com.hexiaofei.provider0.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.SpiderListener;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWebSpider {

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractWebSpider.class);

    protected Spider initSpider(){
        Spider spider = Spider.create(new SjzPageProcessor(System.currentTimeMillis()));
        LOGGER.info("Loading  Spider……   ");
        // 加载 ERROR错误监听
        List<SpiderListener> listenerList = new ArrayList();
        listenerList.add(new SjzHttpSpiderListener());
        spider.setSpiderListeners(listenerList).setDownloader(new SjzHttpClientDownloader());
        return spider;
    }


}
