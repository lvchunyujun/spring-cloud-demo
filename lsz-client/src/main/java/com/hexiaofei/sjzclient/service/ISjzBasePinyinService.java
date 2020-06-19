package com.hexiaofei.sjzclient.service;


import com.hexiaofei.sjzclient.domain.SjzBasePinyin;
import com.hexiaofei.sjzclient.service.base.IBaseService;

public interface ISjzBasePinyinService extends IBaseService<SjzBasePinyin> {

    int getCountByAll();
}
