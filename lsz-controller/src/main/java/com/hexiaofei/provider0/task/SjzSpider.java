package com.hexiaofei.provider0.task;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Iterator;

public class SjzSpider extends Spider {
    public SjzSpider(PageProcessor pageProcessor) {
        super(pageProcessor);
    }

    private void onDownloadSuccess(Request request, Page page) {
        if (this.site.getAcceptStatCode().contains(page.getStatusCode())) {
            this.pageProcessor.process(page);
            this.extractAndAddRequests(page, this.spawnUrl);
            if (!page.getResultItems().isSkip()) {
                Iterator var3 = this.pipelines.iterator();

                while(var3.hasNext()) {
                    Pipeline pipeline = (Pipeline)var3.next();
                    pipeline.process(page.getResultItems(), this);
                }
            }
        } else {
            this.pageProcessor.process(page);
            this.logger.info("page status code error, page {} , code: {}", request.getUrl(), page.getStatusCode());
        }

        this.sleep(this.site.getSleepTime());
    }


}
