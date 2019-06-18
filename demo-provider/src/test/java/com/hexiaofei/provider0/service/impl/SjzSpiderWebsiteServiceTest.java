package com.hexiaofei.provider0.service.impl;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.BaseTest;
import com.hexiaofei.provider0.service.SjzSpiderWebsiteService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class SjzSpiderWebsiteServiceTest extends BaseTest {

    @Autowired
    private SjzSpiderWebsiteService sjzSpiderWebsiteService;

    @Test
    public void testInsert() throws PlatformException {
        SjzSpiderWebsite ssw = new SjzSpiderWebsite();
        ssw.setWebsiteUrl("https//www.baidunew.com");
        ssw.setWebsiteTitle("百度新闻");
        ssw.setWebsiteContent("习近平对四川长宁6.0级地震作出重要指示");
        ssw.setCreateTime(new Date());
        ssw.setWebsiteDescri("百度新闻是包含海量资讯的新闻服务平台，真实反映每时每刻的新闻热点。您可以搜索新闻事件、热点话题、人物动态、产品资讯等，快速了解它们的最新进展。");
        sjzSpiderWebsiteService.addObject(ssw);
    }
}