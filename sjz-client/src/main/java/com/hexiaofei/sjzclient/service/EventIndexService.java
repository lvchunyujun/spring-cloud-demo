package com.hexiaofei.sjzclient.service;

import com.hexiaofei.sjzclient.vo.ResultEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "demo-provider")
public interface EventIndexService {

    @RequestMapping(value = "admin/eventIndex/list/{currentPage}_{pageSize}")
    ResultEntity getListByPaging(@PathVariable(value="currentPage") Integer currentPage, @PathVariable(value="pageSize") Integer pageSize);
}
