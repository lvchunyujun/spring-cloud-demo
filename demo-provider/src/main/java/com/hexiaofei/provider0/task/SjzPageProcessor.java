package com.hexiaofei.provider0.task;

import com.hexiaofei.provider0.common.SpringContextUtil;
import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzDomainInfoService;
import com.hexiaofei.provider0.service.SjzSpiderWebsiteService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class SjzPageProcessor implements PageProcessor {

    private final static Logger LOGGER = LoggerFactory.getLogger(SjzPageProcessor.class);
    private Site site = Site.me().setRetryTimes(1).setSleepTime(5000);

    @Autowired
    private SjzSpiderWebsiteService sjzSpiderWebsiteService ;

    @Autowired
    private SjzDomainInfoService sjzDomainInfoService;

    private Long startCrawlTime;


    public SjzPageProcessor() {
        sjzSpiderWebsiteService = SpringContextUtil.getBean("sjzSpiderWebsiteService");
    }

    public SjzPageProcessor(Long startCrawlTime){
        sjzSpiderWebsiteService = SpringContextUtil.getBean("sjzSpiderWebsiteService");
        sjzDomainInfoService = SpringContextUtil.getBean("sjzDomainInfoService");
        this.startCrawlTime = startCrawlTime;
    }


    @Override
    public void process(Page page) {
        LOGGER.info("【解析网站页面】--> {}",page.getUrl());
        Html html = page.getHtml();
        String url = page.getUrl().toString();
        Document document = html.getDocument();
        Element headElement = document.head();
        Map<String, List<String>> header = page.getHeaders();
        parseHead(headElement,url,header);
        LOGGER.info("【解析网站页面】--> {}",page.getUrl());
    }

    /**
     * 解析 HTML HEAD part
     * @param head
     * @param url
     */
    public void parseHead(Element head,String url,Map<String, List<String>> header){
        LOGGER.info("【解析网站页面HEAD】--> [url:{}]",url);
        String title = "";
        String descri = "";

        Elements titleEmt = head.getElementsByTag("title");
        title = titleEmt.text();
        LOGGER.info("【解析网站页面HEAD】[url:{}], title:{}",url,(title!=null?title:""));
        Elements metas = head.getElementsByTag("meta");
        int metaSize = metas.size();
        for(int i = 0 ; i < metaSize ; i++){
            Element meta = metas.get(i);
            String attrName = meta.attr("name");
            if("description".equals(attrName)){
                descri = meta.attr("content");
                LOGGER.info("【解析网站页面HEAD】[url:{}], description:{}",url,meta.attr("content"));
            }
        }


        SjzSpiderWebsite ssw = new SjzSpiderWebsite();
        ssw.setWebsiteUrl(url);
        ssw.setWebsiteTitle(title);
        ssw.setWebsiteContent(descri);
        ssw.setCreateTime(new Date());
        ssw.setWebsiteDescri(descri);
        try {
            int pageResultId = sjzSpiderWebsiteService.addObject(ssw);
            LOGGER.info("【解析网站页面HEAD】 保存页面HEAD成功 ID:{}, [url:{}] ",pageResultId,url);

            int crawlResultId =  modifySjzDomainInfo(url,header);
            LOGGER.info("【解析网站页面HEAD】 更新抓取结果成功 ID:{}, [url:{}]",crawlResultId,url);
        } catch (PlatformException e) {
            LOGGER.error("【解析网站页面HEAD】保存页面信息异常!",e);
        }
        LOGGER.info("【解析网站页面HEAD】<-- [url:{}]",url);
    }

    /**
     * 解析 HTML BODY part
     */
    public void parseBody(){

    }
    @Override
    public Site getSite() {
        return site;
    }

    public int modifySjzDomainInfo(String url,Map<String, List<String>> header){
        SjzDomainInfo sjzDomainInfo = new SjzDomainInfo();

        String domainName = header.get("Host") != null ? header.get("Host").get(0) : "";
        sjzDomainInfo.setDomainUrl(url);

        sjzDomainInfo.setDomainName(domainName);
        sjzDomainInfo.setLastCrawlTime(new Date());
        sjzDomainInfo.setCrawlStatus((short)200);
        // 耗时
        long endCrawlTime = System.currentTimeMillis();
        sjzDomainInfo.setCrawlUseTime((int)(endCrawlTime -startCrawlTime));

        int crawlResult = sjzDomainInfoService.updateByCrawlResult(sjzDomainInfo);
        return crawlResult;
    }
}
