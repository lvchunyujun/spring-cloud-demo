package com.hexiaofei.provider0.task;

import com.hexiaofei.provider0.common.SpringContextUtil;
import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.exception.PlatformException;
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

import java.util.Date;

@Component
public class HttpSpider implements PageProcessor {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpSpider.class);
    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);

    @Autowired
    private SjzSpiderWebsiteService sjzSpiderWebsiteService ;


    public HttpSpider() {
        sjzSpiderWebsiteService = SpringContextUtil.getBean("sjzSpiderWebsiteService");
    }


    @Override
    public void process(Page page) {
        LOGGER.info("【解析网站页面】-->  ");
        Html html = page.getHtml();
        String url = page.getUrl().toString();
        Document document = html.getDocument();
        Element headElement = document.head();
        parseHead(headElement,url);
    }

    public void parseHead(Element head,String url){
        String title = "";
        String descri = "";

        Elements titleEmt = head.getElementsByTag("title");
        title = titleEmt.text();
        LOGGER.info("title：  "+(title!=null?title:""));
        Elements metas = head.getElementsByTag("meta");
        int metaSize = metas.size();
        for(int i = 0 ; i < metaSize ; i++){
            Element meta = metas.get(i);
            String attrName = meta.attr("name");
            if("description".equals(attrName)){
                descri = meta.attr("content");
                LOGGER.info(meta.attr("name")+";  "+meta.attr("content"));
            }
        }


        SjzSpiderWebsite ssw = new SjzSpiderWebsite();
        ssw.setWebsiteUrl(url);
        ssw.setWebsiteTitle(title);
        ssw.setWebsiteContent(descri);
        ssw.setCreateTime(new Date());
        ssw.setWebsiteDescri(descri);
        try {
            int result = sjzSpiderWebsiteService.addObject(ssw);
            LOGGER.info("保存页面成功:"+url);
        } catch (PlatformException e) {
            LOGGER.error("保存页面信息异常",e);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
