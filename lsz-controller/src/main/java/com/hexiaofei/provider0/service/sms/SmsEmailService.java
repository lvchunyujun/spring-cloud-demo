package com.hexiaofei.provider0.service.sms;

import com.hexiaofei.provider0.exception.PlatformException;
import com.lcyj.common.bo.sms.SmsEmail;
import com.lcyj.common.vo.ResultVo;
import com.lcyj.common.vo.sms.SmsEmailVo;
import com.lcyj.common.web.WebCommonConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "LCYJ-SMS")
public interface SmsEmailService {

    String BASE_MAPPING_URL = "/sms/email";

    @PostMapping(value = BASE_MAPPING_URL+"/send")
    String send(@RequestBody SmsEmail smsEmail);

    @PostMapping(value = BASE_MAPPING_URL+"/"+WebCommonConstant.URL_ADD)
    int addObject(SmsEmail smsEmail)throws PlatformException;

    @PostMapping(value = BASE_MAPPING_URL+"/"+WebCommonConstant.URL_DELETE)
    int deleteObjectById(int id)throws PlatformException;

    @PostMapping(value = BASE_MAPPING_URL+"/"+WebCommonConstant.URL_UPDATE)
    int updateObject(SmsEmail smsEmail)throws PlatformException;

    @PostMapping(value = BASE_MAPPING_URL+"/"+WebCommonConstant.URL_GET)
    SmsEmail getObjectById(int id)throws PlatformException;

    @PostMapping(value = BASE_MAPPING_URL+"/"+WebCommonConstant.URL_LIST)
    ResultVo<SmsEmail> listByPaging(@RequestBody SmsEmailVo smsEmail);
}
