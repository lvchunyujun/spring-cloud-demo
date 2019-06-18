package com.hexiaofei.provider0.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

@Component
@EnableAsync     // 多线程异步执行
public class WebSpiderTask {

    private static final int thread_c = 1;


    @Async
    @Scheduled(cron="0/5 * * * * ?")
    public void fetchWebPage(){

        String url = "https://www.so.com";
        url = "http://news.baidu.com/";
        String website = "news.baidu";

        Spider spider = Spider.create(new HttpSpider());
        spider.addUrl(url).thread(thread_c).run();

    }


    public String parseUrl(){

        return null;
    }


}
