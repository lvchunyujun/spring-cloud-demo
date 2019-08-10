package com.hexiaofei.provider0.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.BaseTest;
import com.hexiaofei.provider0.service.SjzSpiderWebsiteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Rollback
public class SjzSpiderWebsiteServiceTest extends BaseTest {




    // api接口路径
    private static final String url = "/eventIndex";
    private static String api;


    @Autowired
    private SjzSpiderWebsiteService sjzSpiderWebsiteService;

    @Test
    public void testInsert() throws Exception {

        api = "/1_1";

        //参数正确
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap();






        RequestBuilder request = MockMvcRequestBuilders
                .post(url + api)
//                .param("page","1")
//                .param("pageSize","10")
                .params(paramMap);


        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        System.out.println(content);

    }
}