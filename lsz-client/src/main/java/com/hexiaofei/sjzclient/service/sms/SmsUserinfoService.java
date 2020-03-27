package com.hexiaofei.sjzclient.service.sms;

import com.lcyj.common.bo.sms.SmsUserinfo;
import com.lcyj.common.web.WebCommonConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "LCYJ-SMS")
public interface SmsUserinfoService {

    String BASE_MAPPING_URL = "/userinfo";

    @PostMapping(value = BASE_MAPPING_URL+"/"+WebCommonConstant.URL_ADD)
    String add(@RequestBody SmsUserinfo smsUserinfo);
}
