package com.hexiaofei.provider0.service.impl.spider;

import com.hexiaofei.provider0.service.AbstractTest;
import com.hexiaofei.provider0.service.spider.ISpiderService;
import com.lcyj.common.bo.spider.UriBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpiderServiceImplTest extends AbstractTest {

    @Autowired
    ISpiderService spiderService;

    String url = "https://www.baidu.com";



    @Test
    public void downloadUrl() {
        url = "https://www.qq.com/";
        UriBO uriBO = new UriBO();
        uriBO.setUri(url);
        uriBO.setUriId(121);
        uriBO.setUriLanguage("English");

        spiderService.downloadUrl(uriBO);
    }

}