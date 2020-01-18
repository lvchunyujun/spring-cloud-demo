package com.hexiaofei.provider0.task;

import com.hexiaofei.provider0.common.SpringContextUtil;
import com.hexiaofei.provider0.service.SjzDomainInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.SpiderListener;
import us.codecraft.webmagic.model.HttpRequestBody;

import java.util.Date;
import java.util.Map;

@Component
public class SjzHttpSpiderListener implements SpiderListener {

    private static Logger LOGGER = LoggerFactory.getLogger(WebSpiderTask.class);

    private Long startTime;

    @Autowired
    private SjzDomainInfoService sjzDomainInfoService;
    public SjzHttpSpiderListener(){
        sjzDomainInfoService = SpringContextUtil.getBean("sjzDomainInfoService");
    }

    @Override
    public void onSuccess(Request request) {
        LOGGER.info("【Spider处理页面onSUCCESS】-->  url[{}]",request.getUrl());

        Map<String, Object> extrasMap = request.getExtras();
        if(extrasMap != null){
            try{
                Short respCode = (Short)extrasMap.get("respCode");
                String respMsg = (String)extrasMap.get("respMsg");
                Map<String, String> header = request.getHeaders();
                String domainName = header.get("Host") != null ? header.get("Host") : "";
                int resultId = sjzDomainInfoService.updateStatusByUrl(request.getUrl(),new Date(),null,respCode,-1);
                LOGGER.error("【Spider处理页面onSUCCESS】    url[{}]  respCode:{},respMsg:{}",request.getUrl(),respCode,respMsg);
            }catch (Exception e){
                LOGGER.error("【Spider处理页面onSUCCESS】 ",e);
            }
        }

        LOGGER.info("【Spider处理页面onSUCCESS】<--  url[{}]",request.getUrl());
    }

    @Override
    public void onError(Request request) {
        LOGGER.error("【加载页面ERROR】-->  url[{}]",request.getUrl());
        try{
            HttpRequestBody httpResponseBody = request.getRequestBody();
            Map<String, String> header = request.getHeaders();
            if(header != null){
                String domainName = header.get("Host") != null ? header.get("Host") : "";
                int resultId = sjzDomainInfoService.updateStatusByUrl(request.getUrl(),new Date(),domainName,(short)-99,-1);
                LOGGER.error("【加载页面ERROR】保存页面完成 url[{}]",request.getUrl());
            }
        }catch (Exception e){
            LOGGER.error("【加载页面ERROR】ERROR  ",e);
        }finally{
            LOGGER.error("【加载页面ERROR】<--  url[{}]",request.getUrl());
        }
    }


}
