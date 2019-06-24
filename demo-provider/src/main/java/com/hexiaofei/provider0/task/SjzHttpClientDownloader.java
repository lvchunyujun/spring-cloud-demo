package com.hexiaofei.provider0.task;

import com.hexiaofei.provider0.service.SjzDomainInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.downloader.HttpClientDownloader;

import java.util.HashMap;
import java.util.Map;


public class SjzHttpClientDownloader extends HttpClientDownloader {

    private static final Logger LOGGER = LoggerFactory.getLogger(SjzHttpClientDownloader.class);

    protected void onError(Request request) {
        LOGGER.info(request.getUrl());
        Map<String, Object> extrasMap = request.getExtras();
        extrasMap = extrasMap !=null ? extrasMap :new HashMap<String, Object>();
        extrasMap.put("respCode",(short)-99);
        extrasMap.put("respMsg","nodename nor servname provided, or not known");
        request.setExtras(extrasMap);
    }

}
