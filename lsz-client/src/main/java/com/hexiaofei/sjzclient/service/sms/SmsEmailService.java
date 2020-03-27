package com.hexiaofei.sjzclient.service.sms;

import com.lcyj.common.bo.sms.SmsEmail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "LCYJ-SMS")
public interface SmsEmailService {

    String BASE_MAPPING_URL = "/sms/email";

    @PostMapping(value = BASE_MAPPING_URL+"/send")
    String send(@RequestBody SmsEmail smsEmail);
}
