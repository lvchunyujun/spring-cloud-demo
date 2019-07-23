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
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.*;

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
        Map<String, List<String>> header = page.getHeaders();
        List<String> list = new ArrayList<String>();
        list.add(String.valueOf(page.getStatusCode()));
        header.put("statusCode",list);
        String url = page.getUrl().toString();

        // 200：返回成功
        if(page.getStatusCode() == 200){
            Html html = page.getHtml();
            Document document = html.getDocument();
            Element headElement = document.head();
            parseHead(headElement,url,header);

            // parseBody
            parseBody(page,document.body());
        }else{
            int crawlResultId =  modifySjzDomainInfo(url,header);
            LOGGER.info("【解析网站页面】网站异常{}  statusCode:{}",page.getUrl(),page.getStatusCode());
        }
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

            modifySjzDomainInfo(url,header);
        } catch (PlatformException e) {
            LOGGER.error("【解析网站页面HEAD】保存页面信息异常!",e);
        }
        LOGGER.info("【解析网站页面HEAD】<-- [url:{}]",url);
    }

    /**
     * 解析 HTML BODY part
     */
    public void parseBody(Page page,Element bodyEls){
        String url = page.getUrl().toString();
        LOGGER.debug("【解析body】--> {}",url);
        Elements cse = bodyEls.children();
        Iterator<Element> itsEl = cse.iterator();
        Element e;
        while (itsEl.hasNext()){
            e = itsEl.next();
            if(e==null){
                break;
            }
            String tagName = e.tagName();
//            LOGGER.info("【解析body】 url={},tagName={}",url,tagName);
            if(HtmlTag.A_TAG.equals(tagName)){
                String href = e.attr("href");
                String text = e.text();
                LOGGER.info("【解析body】 url=[{}],tagName={},href=[{}],text={}",url,tagName,href,text);
                page.addTargetRequest(new Request(href));
            }else if(HtmlTag.TITLE_TAG.equals(tagName)){

            }else if(HtmlTag.IMG_TAG.equals(tagName)){

            }else if(HtmlTag.AREA_TAG.equals(tagName)){

            }else {
//                LOGGER.info("【解析body】 url={},tagName={}",url,tagName);
            }
            // 如果存在子节点
            Elements ncses;
            if((ncses = e.children()) != null){
                Iterator<Element> nItsEl = ncses.iterator();
                Element ce;
                while (nItsEl.hasNext()){
                    if((ce = nItsEl.next())!=null){
                        parseBody(page,ce);
                    }
                }
            }

        }

        LOGGER.debug("【解析body】<-- {}",url);
    }

    @Override
    public Site getSite() {
        return site;
    }

    /**
     *
     * @param url
     * @param header
     * @return
     */
    public int modifySjzDomainInfo(String url,Map<String, List<String>> header){
        SjzDomainInfo sjzDomainInfo = new SjzDomainInfo();

        String domainName = header.get("Host") != null ? header.get("Host").get(0) : "";
        sjzDomainInfo.setDomainUrl(url);

        sjzDomainInfo.setDomainName(domainName);
        sjzDomainInfo.setLastCrawlTime(new Date());
        short statusCode = (Short.valueOf(header.get("statusCode").get(0)));
        sjzDomainInfo.setCrawlStatus(statusCode);
        // 耗时
        long endCrawlTime = System.currentTimeMillis();
        sjzDomainInfo.setCrawlUseTime((int)(endCrawlTime -startCrawlTime));

        int crawlResult = sjzDomainInfoService.updateByCrawlResult(sjzDomainInfo);
        LOGGER.info("【解析网站页面HEAD】 更新抓取结果成功 ID:{}, [url:{}]",crawlResult,url);
        return crawlResult;
    }
}
