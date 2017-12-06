package com.hexiaofei.springfeignconsumer.service;

import com.hexiaofei.springfeignconsumer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/11/20.
 */
@FeignClient(value = "spring-cloud-provider-2")
public interface UserService {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.POST)
    User getUserById(@PathVariable(value ="id") Integer id);
}
