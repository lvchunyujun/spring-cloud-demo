package com.hexiaofei.provider0.service.impl.spider;

import com.hexiaofei.provider0.common.consts.spider.SpiderConfig;
import com.hexiaofei.provider0.service.SjzDomainSpiderTaskService;
import com.hexiaofei.provider0.service.spider.ISpiderService;
import com.hexiaofei.provider0.task.WebSpiderTask;
import com.lcyj.common.bo.spider.UriBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

/**
 * <br/>
 *
 * @author lcyj
 * @date 2020-07-19 18:21
 * @since
 */
@Service("spiderService")
public class SpiderServiceImpl extends AbstractSpiderService implements ISpiderService {

    private static Logger LOGGER = LoggerFactory.getLogger(WebSpiderTask.class);

    @Autowired
    private SjzDomainSpiderTaskService sjzDomainSpiderTaskService;

    @Override
    public void downloadUrl(UriBO lszUriBO) {
        downloadUrl(lszUriBO, true);
    }

    @Override
    public void downloadUrl(UriBO uriBO, boolean recursionFlag) {
        // step1: 初始化Spider实例
        Spider spider = initSpider(recursionFlag);
        String uri = uriBO.getUri();
        spider.addUrl(uri).thread(SpiderConfig.SPIDER_THREAD_COUNT).run();
    }

}
