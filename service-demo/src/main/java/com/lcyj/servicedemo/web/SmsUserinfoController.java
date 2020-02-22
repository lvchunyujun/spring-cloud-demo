package com.lcyj.servicedemo.web;


import com.lcyj.servicedemo.exception.PlatformException;
import com.lcyj.servicedemo.model.SmsUserinfo;
import com.lcyj.servicedemo.service.SmsUserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Api(description = "SmsUserinfo 接口")
@Controller
public class SmsUserinfoController extends AbstractController implements BaseController<SmsUserinfo> {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserinfoController.class);

    private final static String BASE_MAPPING_URL = "/smsUserinfo";
    private final static String OK = "OK";

    @Autowired
    private SmsUserinfoService smsUserinfoService;


    @ApiOperation(value="查询SMS index", notes="", produces="application/json")
    @RequestMapping(value = BASE_MAPPING_URL+"/"+URL_INDEX,method = RequestMethod.GET)
    public String index(){
        return BASE_MAPPING_URL+"/"+URL_INDEX;
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping(value = BASE_MAPPING_URL+"/"+URL_TO_ADD,method = RequestMethod.GET)
    public String toAdd(){
        return BASE_MAPPING_URL+"/"+URL_TO_ADD;
    }


    @ApiOperation(httpMethod = "POST",value = "添加SMS用户信息" ,produces = MediaType.TEXT_HTML_VALUE,tags = "smsUserinfo/add",notes = "参数")

    @RequestMapping(value = BASE_MAPPING_URL+"/"+URL_ADD,method = RequestMethod.POST)
    @ResponseBody
    @Override
    public String add(@RequestBody SmsUserinfo smsUserinfo) {
        int resultId = -1;
        try {
            resultId = smsUserinfoService.addObject(smsUserinfo);
        } catch (PlatformException e) {
            LOGGER.error("增加SMS用户信息失败！",e);
        }
        return OK;
    }

    @RequestMapping(value = BASE_MAPPING_URL+"/"+URL_TO_UPDATE,method = RequestMethod.GET)
    @Override
    public ModelAndView toUpdate(Integer id) {
        return null;
    }

    @RequestMapping(value = BASE_MAPPING_URL+"/"+URL_UPDATE,method = RequestMethod.POST)
    @Override
    public ModelAndView update(SmsUserinfo smsUserinfo) {
        return null;
    }


    @ApiOperation(value="查询SMS用户信息", notes="查询用户", produces="application/json")
    @ApiImplicitParam(name = "id", value = "SMS用户信息ID", paramType = "path",defaultValue = "1",dataType = "Integer")
    @RequestMapping(value = BASE_MAPPING_URL+"/"+URL_GET+"/{id}",method = RequestMethod.GET)
    @ResponseBody
    @Override
    public SmsUserinfo getObject(@PathVariable("id") Integer id) {
        return smsUserinfoService.getObjectById(id);
    }

    @RequestMapping(value = BASE_MAPPING_URL+"/"+URL_LIST,method = RequestMethod.GET)
    @Override
    public String listEventIndex(SmsUserinfo smsUserinfo, int currentPage, int pageSize) {


        return null;
    }

    @RequestMapping(value = BASE_MAPPING_URL+"/"+URL_DELETE,method = RequestMethod.DELETE)
    @Override
    public String delete(Integer id) {
        return null;
    }

}
