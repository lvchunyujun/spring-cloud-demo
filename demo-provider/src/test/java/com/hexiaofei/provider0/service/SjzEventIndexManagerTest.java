package com.hexiaofei.provider0.service;

import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.exception.PlatformException;
import org.apache.http.client.utils.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Date;


//@RunWith(PowerMockRunner.class)
public class SjzEventIndexManagerTest extends BaseTest{

    String base_url = "/eventIndex";

    @Autowired
    private SjzEventIndexService sjzEventIndexService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testAdd() throws PlatformException {
        SjzEventIndex sjzEventIndex = new SjzEventIndex();
        sjzEventIndex.setEventContent("hello world!");
        sjzEventIndex.setEventTime(new Date());
        sjzEventIndex.setEventType((byte)1);
        sjzEventIndex.setEventState((byte)10);
        sjzEventIndex.setRecordCreateTime(new Date());

        int resultId = sjzEventIndexService.addObject(sjzEventIndex);
        System.out.println(resultId);
    }

    @Test
    public void testAdd2() throws PlatformException {
        SjzEventIndex sjzEventIndex = new SjzEventIndex();
        sjzEventIndex.setEventContent("hello world!");
        sjzEventIndex.setEventTime(new Date());
        sjzEventIndex.setEventType((byte)1);
        sjzEventIndex.setEventState((byte)10);
        sjzEventIndex.setRecordCreateTime(new Date());

        SjzSpiderWebsite sjzSpiderWebsite = new SjzSpiderWebsite();
        sjzSpiderWebsite.setWebsiteUrl("http://helloworld!");

        int resultId = sjzEventIndexService.addEventIndexAndUser(sjzEventIndex,sjzSpiderWebsite);
        System.out.println(resultId);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)



    @Test
    public void testMvcAdd() throws Exception {

        String api = "/add";

        //参数正确
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap();

        paramMap.add("sjzEventIndex.eventContent","https//www.baidunew.com");
        paramMap.add("sjzEventIndexeventTime", DateUtils.formatDate(new Date(),"yyyy-MM-dd"));


        RequestBuilder request = MockMvcRequestBuilders
                .post(base_url + api)
                .params(paramMap);


        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        System.out.println(content);
    }
}
