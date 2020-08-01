package com.hexiaofei.provider0.service.impl.spider;

import com.hexiaofei.provider0.task.SjzHttpClientDownloader;
import com.hexiaofei.provider0.task.SjzHttpSpiderListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.SpiderListener;

import java.util.ArrayList;
import java.util.List;

/**
 * spider抽象类 <br/>
 *
 * @author lcyj
 * @date 2020-07-19 18:20
 * @since
 */
public class AbstractSpiderService {

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractSpiderService.class);
    /**
     * 初始化爬虫
     * @return
     */
    public Spider initSpider(){
        Spider spider = Spider.create(new ArtificialPageProcessor());
        LOGGER.info("Loading  Spider……   ");
        // 加载 ERROR错误监听
        List<SpiderListener> listenerList = new ArrayList();
        listenerList.add(new SjzHttpSpiderListener());
        spider.setSpiderListeners(listenerList).setDownloader(new SjzHttpClientDownloader());
        return spider;
    }

    /**
     *
     * @param recursionFlag 递归标识：true-抓取页面中的连接，false-不抓取页面链接
     * @return
     */
    public Spider initSpider(boolean recursionFlag){
        Spider spider = Spider.create(new ArtificialPageProcessor(System.currentTimeMillis(),recursionFlag));
        LOGGER.info("Loading  Spider……   ");
        // 加载 ERROR错误监听
        List<SpiderListener> listenerList = new ArrayList();
        listenerList.add(new SjzHttpSpiderListener());
        spider.setSpiderListeners(listenerList).setDownloader(new SjzHttpClientDownloader());
        return spider;
    }

}
