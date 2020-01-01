package com.hexiaofei.provider0.task.website;

import com.hexiaofei.provider0.common.consts.SpiderTaskStatusEnum;
import com.hexiaofei.provider0.domain.SjzDomainWordSort;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzDomainSpiderTaskService;
import com.hexiaofei.provider0.task.AbstractWebSpider;
import com.hexiaofei.provider0.task.WebSpiderTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.Iterator;
import java.util.List;

@Component
@EnableAsync
public class SjzEventSpiderTask extends AbstractWebSpider {

    private static Logger LOGGER = LoggerFactory.getLogger(WebSpiderTask.class);

    private static final int thread_c = 1;

    @Autowired
    private SjzDomainSpiderTaskService sjzDomainSpiderTaskService;
    /**
     * 抓取页面
     */

    @Scheduled(cron="00 36 21 * * ?")
    public void crawlWebPage(){
        Spider spider = initSpider();

        List<SjzDomainWordSort> list = null;

        try {
            list = sjzDomainSpiderTaskService.getWordSordDomainListByTaskStatus(SpiderTaskStatusEnum.ON.getCode());

            Iterator<SjzDomainWordSort> iterable = list.iterator();

            while(iterable.hasNext()){
                SjzDomainWordSort sjzDomainWordSort = iterable.next();
                String url = sjzDomainWordSort.getDomainUrl();
                spider.addUrl(url).thread(thread_c).run();
            }
        } catch (PlatformException e) {
            e.printStackTrace();
        }


    }


}
