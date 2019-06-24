package com.hexiaofei.provider0.task;

import com.hexiaofei.provider0.common.consts.DomainStatusEnum;
import com.hexiaofei.provider0.common.consts.DomainTypeEnum;
import com.hexiaofei.provider0.domain.SjzBasePinyin;
import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzBasePinyinService;
import com.hexiaofei.provider0.service.SjzDomainInfoService;
import com.hexiaofei.provider0.vo.PageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.SpiderListener;
import us.codecraft.webmagic.model.OOSpider;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
@EnableAsync     // 多线程异步执行
public class WebSpiderTask {

    private static Logger LOGGER = LoggerFactory.getLogger(WebSpiderTask.class);
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

    /**
     * 抓取页面
     * @param url
     */
    public void crawlWebPage(String url){
        Spider spider = Spider.create(new SjzPageProcessor(System.currentTimeMillis()));
        LOGGER.info("Loading……   url:{}",url);
        // 加载 ERROR错误监听
        List<SpiderListener> listenerList = new ArrayList();
        listenerList.add(new SjzHttpSpiderListener());
        spider.setSpiderListeners(listenerList).setDownloader(new SjzHttpClientDownloader()).addUrl(url).thread(thread_c).run();
        OOSpider OO;
    }

    /**
     *
     */
    @Async
    @Scheduled(cron="20 32 23 * * ?")
    public void loadingUrl2(){
        try {
            int currentPage = 1;
            int pageSize = 500;
            while(checkOfWaitCrawlUrl()){
                LOGGER.info("开始加载第[{}]页数据……",currentPage);
                 // 因每次循环都初始化查询 ，所以当前页=1；currentPage只用作计数
                List<SjzDomainInfo> list = getListUrlByWaitCrwal(1,pageSize);

                for(int i = 0 ; i < list.size() ; i++ ){
                    SjzDomainInfo sjzDomainInfo = list.get(i);
                    crawlWebPage(sjzDomainInfo.getDomainUrl());
                }
                currentPage++;
            }
        } catch (PlatformException e) {
            LOGGER.error("加载页面异常！",e);
        } catch (Exception e){
            LOGGER.error("加载页面异常！",e);
        }
    }

//    @Async
//    @Scheduled(cron="10 1 23 * * ?")
    public void loadingUrl() throws PlatformException {
        int count = sjzBasePinyinService.getCountByAll();

        for(int i = 1 ; i <= count ; i++){

            String[] urls = getUrl(i);
            if(urls==null){
                continue;
            }
            for(int j = 0 ; j < urls.length ; j++){
                try {
                      // 抓取页面
//                    crawlWebPage(urls[j]);

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

    public List<SjzDomainInfo> getListUrlByWaitCrwal(int currentPage,int pageSize) throws PlatformException {

        List<SjzDomainInfo> list = new ArrayList();
        SjzDomainInfo sjzDomainInfo = new SjzDomainInfo();
        // site 状态正常
        sjzDomainInfo.setCrawlStatus((short)200);
        // 当前时间节点 yyyy-MM-dd 00:00:00 以前的进行抓取
        Calendar lastCralTime = Calendar.getInstance();
        lastCralTime.set(Calendar.HOUR_OF_DAY,0);
        lastCralTime.set(Calendar.MINUTE,0);
        lastCralTime.set(Calendar.SECOND,0);
        lastCralTime.set(Calendar.MILLISECOND,0);

        sjzDomainInfo.setLastCrawlTime(lastCralTime.getTime());
        int count = sjzDomainInfoService.getCountByWaitCrawl(sjzDomainInfo);

        // 当前需要抓取页面数量==0 不需要抓取
        if(checkOfWaitCrawlUrl()){
            PageVo pageVo = new PageVo();
            pageVo.setPageSize(pageSize);
            pageVo.setCurrentPage(currentPage);
            pageVo = sjzDomainInfoService.getPageVoSjzDomainInfoForWaitCrawl(pageVo,sjzDomainInfo);
            list = pageVo.getVoList();
        }
        return list;
    }

    /**
     * 检查是否有等待抓取的页面
     * @return
     */
    private boolean checkOfWaitCrawlUrl(){
        SjzDomainInfo sjzDomainInfo = new SjzDomainInfo();
        // site 状态正常
        sjzDomainInfo.setCrawlStatus((short)200);
        // 当前时间节点 yyyy-MM-dd 00:00:00 以前的进行抓取
        Calendar lastCralTime = Calendar.getInstance();
        lastCralTime.set(Calendar.HOUR_OF_DAY,0);
        lastCralTime.set(Calendar.MINUTE,0);
        lastCralTime.set(Calendar.SECOND,0);
        lastCralTime.set(Calendar.MILLISECOND,0);

        sjzDomainInfo.setLastCrawlTime(lastCralTime.getTime());
        int count = sjzDomainInfoService.getCountByWaitCrawl(sjzDomainInfo);
        return count>0;
    }
}
