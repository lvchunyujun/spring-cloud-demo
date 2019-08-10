package com.hexiaofei.provider0.web;

import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.vo.PageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventIndex")
public class SjzEventIndexManagerController extends BaseController{

    public static Logger logger = LoggerFactory.getLogger(SjzEventIndexManagerController.class);
    @Autowired
    public SjzEventIndexService sjzEventIndexService;


    @RequestMapping(value="/add")
    public String addSjzEventIndex(SjzEventIndex sjzEventIndex){
        int resultId = -1;
        try {
             resultId = sjzEventIndexService.addObject(sjzEventIndex);
        } catch (PlatformException e) {
            e.printStackTrace();
        }

        return ""+resultId;
    }

}
