package com.hexiaofei.provider0.web.admin;

import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class AdminSjzEventIndexController extends AdminBaseController {


    @Autowired
    public SjzEventIndexService sjzEventIndexService;



    @RequestMapping("/eventIndex")
    public String index(){
        return "event/eventIndex";
    }

    @RequestMapping(value = "/toAddEventIndex")
    public String toAdd(){
        return "event/toAddEventIndex";
    }

    @RequestMapping(value = "/addEventIndex",method = RequestMethod.POST)
    public String add(SjzEventIndex sjzEventIndex){
        int resultId = -1;
        try {
            sjzEventIndex.setEventState((byte)0);
            sjzEventIndex.setRecordCreateTime(new Date());
            resultId = sjzEventIndexService.addObject(sjzEventIndex);
        } catch (Exception e) {
            e.printStackTrace();
            resultId = -99;
        }
        if(resultId>0){
            return "event/addSuccess";
        }else{
            return "event/addFail";
        }
    }

    @RequestMapping(value = "/toUpadteEventIndex")
    public String toUpadte(){
        return "event/addEventIndex";
    }

    @RequestMapping(value = "/upadteEventIndex")
    public String upadte(){
        return "event/updateOk";
    }

    public String toDelete(){
        return "";
    }

    public String delete(){
        return "";
    }


    public String listEventIndex(){
        return "";
    }
}
