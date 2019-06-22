package com.hexiaofei.provider0.task;

import com.hexiaofei.provider0.common.consts.DomainStatusEnum;
import com.hexiaofei.provider0.common.consts.DomainTypeEnum;
import com.hexiaofei.provider0.domain.SjzBasePinyin;
import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzBasePinyinService;
import com.hexiaofei.provider0.service.SjzDomainInfoService;
import com.hexiaofei.provider0.service.SjzSpiderWebsiteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@EnableAsync     // 多线程异步执行
public class WebSpiderTask {

    private static Logger LOGGER = Logger.getLogger(WebSpiderTask.class);
    private static final int thread_c = 1;

    private static String[] domainSuf = {"com","org","xyz","net","top",
                                         "tech","gov","edu","ink","red",
                                         "int","mil","pub","cn","com.cn",
                                         "net.cn","gov.cn","org.cn","biz","CC",
                                         "TV","info","name","mobi","travel",
                                         "pro","museum","coop","aero","xin",
                                         "wiki","club","wang","win","vip"};

    @Autowired
    private SjzBasePinyinService sjzBasePinyinService;
    @Autowired
    private SjzDomainInfoService sjzDomainInfoService;

    public void fetchWebPage(String url){
        Spider spider = Spider.create(new HttpSpider());
        spider.addUrl(url).thread(thread_c).run();

    }

    @Async
    @Scheduled(cron="10 1 23 * * ?")
    public void parseUrl() throws PlatformException {
        int count = sjzBasePinyinService.getCountByAll();

        for(int i = 1 ; i <= count ; i++){

            String[] urls = getUrl(i);
            if(urls==null){
                continue;
            }
            for(int j = 0 ; j < urls.length ; j++){
                try {
//                    fetchWebPage(urls[j]);

                    SjzDomainInfo sjzDomainInfo = new SjzDomainInfo();
                    sjzDomainInfo.setType(DomainTypeEnum.OTHER.getType());
                    sjzDomainInfo.setCrawlStatus(DomainStatusEnum.NORMAL.getCode());
                    sjzDomainInfo.setDomainUrl(urls[j]);
                    sjzDomainInfo.setCreateTime(new Date());
                    sjzDomainInfo.setSource("0000");

                    int resultId = sjzDomainInfoService.addObject(sjzDomainInfo);

                    LOGGER.info("add domain_info-->id:"+resultId);
                    TimeUnit.MILLISECONDS.sleep(40);
                }catch (Exception e){
                    LOGGER.error("抓取网站异常！",e);
                }
            }
        }
    }

    /**
     * 获取 URL
     * @param domainPinyinId
     * @return
     * @throws PlatformException
     */
    public String[]  getUrl(int domainPinyinId) throws PlatformException {

        List<String> urls = new ArrayList<String>();

        StringBuffer http = new StringBuffer("http");
        urls = concatDomain(http,domainPinyinId);
        StringBuffer https = new StringBuffer("https");
        urls.addAll(concatDomain(https,domainPinyinId));

        return urls.toArray(new String[0]);
    }

    /**
     * 组合域名
     * @param url
     * @param domainPinyinId
     * @return
     * @throws PlatformException
     */
    public List<String> concatDomain(StringBuffer url,int domainPinyinId) throws PlatformException {
        List<String> urls = new ArrayList();

        url.append("://");
        url.append("www");
        url.append(".");

        SjzBasePinyin sjzBasePinyin = sjzBasePinyinService.getObjectById(domainPinyinId);


        url.append(sjzBasePinyin.getPinYin());
        url.append(".");

        // 遍历拼接domainSuffix
        for(int i = 0 ; i <  domainSuf.length; i++){
            urls.add(url.append(domainSuf[i]).toString());
            url.delete(url.length()-domainSuf[i].length(),url.length()) ;
        }
        return urls;
    }

}
