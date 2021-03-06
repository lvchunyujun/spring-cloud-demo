package com.hexiaofei.provider0.task;

import com.hexiaofei.provider0.common.SpringContextUtil;
import com.hexiaofei.provider0.common.consts.DomainManageStatusEnum;
import com.hexiaofei.provider0.common.consts.DomainStatusEnum;
import com.hexiaofei.provider0.common.consts.DomainTypeEnum;
import com.hexiaofei.provider0.common.consts.SjzSystemConsts;
import com.hexiaofei.provider0.common.consts.spider.EnumUserAgent;
import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzDomainInfoService;
import com.hexiaofei.provider0.service.SjzSpiderWebsiteService;
import com.shijianzhou.language.engine.content.SjzNlContentConsume;
import com.shijianzhou.language.engine.content.SjzNlContentConsumeFactory;
import com.shijianzhou.language.engine.content.SjzNlMapStringContentConsumeFactory;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.utils.UrlUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 页面处理器
 */
@Component
@DependsOn("springContextUtil")
public class SjzPageProcessor implements PageProcessor {

    private final static Logger LOGGER = LoggerFactory.getLogger(SjzPageProcessor.class);
    /**
     * 设置请求头模仿浏览器，避免发生 403问题
     */
    private final static Site site = Site.me()
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:56.0) Gecko/20100101 Firefox/56.0")
            .setRetryTimes(1)
            .setSleepTime(5000);


    /**
     * 缓存已经执行了的URL，避免重复
     */
    private static ConcurrentHashMap<String,Set<String>> concurrentHashMap;

    @Autowired
    private SjzSpiderWebsiteService sjzSpiderWebsiteService ;

    @Autowired
    private SjzDomainInfoService sjzDomainInfoService;

    private Long startCrawlTime;

    public SjzPageProcessor() {
        EnumUserAgent.MAC_CHROME.getUser_agent();
        sjzSpiderWebsiteService = SpringContextUtil.getBean("sjzSpiderWebsiteService");
        sjzDomainInfoService = SpringContextUtil.getBean("sjzDomainInfoService");
    }

    public SjzPageProcessor(Long startCrawlTime){
        sjzSpiderWebsiteService = SpringContextUtil.getBean("sjzSpiderWebsiteService");
        sjzDomainInfoService = SpringContextUtil.getBean("sjzDomainInfoService");
        this.startCrawlTime = startCrawlTime;
    }

    /**
     * 处理页面
     * @param page
     */
    @Override
    public void process(Page page) {
        LOGGER.info("【解析网站页面】--> url={}",page.getUrl());
        LOGGER.info("【解析网站页面】--> request.url={}",page.getUrl());
        Map<String, List<String>> header = page.getHeaders();
        List<String> list = new ArrayList<String>();
        list.add(String.valueOf(page.getStatusCode()));
        header.put("statusCode",list);
        String url = page.getUrl().toString();


        //  step2: response  200：返回成功
        if(page.getStatusCode() == 200){
            Html html = page.getHtml();

            Document document = html.getDocument();
            Element headElement = document.head();
            // step2.1: parseHead
            parseHead(headElement,url,header);

            // step2.2: parseBody
            parseBody(page,document.body());
        }else{
            int crawlResultId =  modifySjzDomainInfo(url,header);
            LOGGER.info("【解析网站页面】网站异常{}  statusCode:{}",page.getUrl(),page.getStatusCode());
        }
        LOGGER.info("【解析网站页面】<-- {}",page.getUrl());
    }

    /**
     * 解析 HTML HEAD part
     * @param head
     * @param url
     */
    private void parseHead(Element head,String url,Map<String, List<String>> header){
        LOGGER.info("【解析网站页面HEAD】--> [url:{}]",url);
        String title = "";
        String descri = "";
        try {
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
        }catch (Exception e){
            LOGGER.error("【解析网站页面HEAD】异常！",e);
        }

        LOGGER.info("【解析网站页面HEAD】<-- [url:{}]",url);
    }

    /**
     * 解析 HTML BODY part
     */
    private void parseBody(Page page,Element bodyEls){
        String url = page.getUrl().toString();
        LOGGER.info("【解析body】--> {}",url);
        LOGGER.info("【解析body】--> request.ur{}",page.getRequest().getUrl());
        Elements cse = bodyEls.children();
        Iterator<Element> itsEl = cse.iterator();
        Element e;

        // step1: 消费标签内容
        doConsumeContent(page,bodyEls);

        // step2: 解析标签内容
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
                LOGGER.info("【解析body】<a> url=[{}],tagName={},href=[{}],text={}",url,tagName,href,text);
                addNewDomainUrlIfNotExist(href);
                // step2 : 递归重新加载页面
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

        LOGGER.info("【解析body】<-- {}",url);
    }



    /**
     * 如果域名不存在则新增域名
     */
    public void addNewDomainUrlIfNotExist(String url){
        SjzDomainInfo sjzDomainInfo = new SjzDomainInfo();
        sjzDomainInfo.setType(DomainTypeEnum.OTHER.getType());
        sjzDomainInfo.setCrawlStatus(DomainStatusEnum.NEW_INIT.getCode());
        sjzDomainInfo.setDomainName(UrlUtils.getDomain(url));
        sjzDomainInfo.setDomainUrl(url);
        sjzDomainInfo.setCreateTime(new Date());
        sjzDomainInfo.setSource("0100");
        sjzDomainInfo.setManageStatus(DomainManageStatusEnum.NORMAL.getCode());

        try {
            sjzDomainInfoService.addObjectForNotExist(sjzDomainInfo);
        } catch (PlatformException e) {
            LOGGER.error("【保存新域名地址】保存异常",e);
        } catch (Exception e){
            LOGGER.error("【保存新域名地址】保存异常",e);
        }
    }

    /**
     * 消费Element内容
     * @param element
     */
    private void doConsumeContent(Page page,Element element){
        doConsumeContent(page,element.text());
    }

    /**
     * 消费String内容
     * @param str
     */
    private void doConsumeContent(Page page,String str){

            try {
            if(StringUtils.isNotBlank(str)) {
                SjzNlContentConsumeFactory contentConsumeFactory = new SjzNlMapStringContentConsumeFactory();
                SjzNlContentConsume contentConsume = contentConsumeFactory.getContentConsume();

                Map<String, Object> sourceMap = new HashMap<>();
                sourceMap.put(SjzSystemConsts.CONSUME_SOURCE_MAP_URL, page.getUrl().toString());
                sourceMap.put(SjzSystemConsts.CONSUME_SOURCE_MAP_TXT, str);

                contentConsume.doProcess(sourceMap);
            }
        }catch (Exception e){
            LOGGER.error("【处理页面内容】异常！",e);
        }

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
