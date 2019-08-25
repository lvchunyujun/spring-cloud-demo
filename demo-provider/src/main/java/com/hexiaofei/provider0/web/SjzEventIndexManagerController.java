package com.hexiaofei.provider0.web;

import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.vo.PageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@RequestMapping("/eventIndex")
public class SjzEventIndexManagerController extends AbstractBaseController<SjzEventIndex> implements BaseController<SjzEventIndex>{

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


    @Override
    public String index() {
        return null;
    }

    @Override
    public String toAdd() {
        return null;
    }

    @Override
    public String add(SjzEventIndex sjzEventIndex) {
        return null;
    }

    @Override
    public ModelAndView toUpadte(Integer id) {
        return null;
    }

    @Override
    public ModelAndView update(SjzEventIndex sjzEventIndex) {
        return null;
    }

    @Override
    public String listEventIndex(SjzEventIndex sjzEventIndex, int currentPage, int pageSize) {
        return null;
    }
}
