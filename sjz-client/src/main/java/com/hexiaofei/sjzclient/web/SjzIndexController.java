package com.hexiaofei.sjzclient.web;

import com.hexiaofei.sjzclient.common.SjzEventStateEnum;
import com.hexiaofei.sjzclient.domain.SjzEventIndex;
import com.hexiaofei.sjzclient.service.SjzEventIndexService;
import com.hexiaofei.sjzclient.vo.PageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SjzIndexController {

    public static Logger logger = LoggerFactory.getLogger(SjzIndexController.class);

    private final static String STATIC_BASE_URL = "index";
    private final static int CURRENT_PAGE = 1;
    private final static int PAGE_SIZE = 10;

    @Autowired
    private SjzEventIndexService sjzEventIndexService;

    @RequestMapping(value = "/index")
    public ModelAndView index(SjzEventIndex sjzEventIndex,Integer currentPage,Integer pageSize){
        ModelAndView modelAndView = new ModelAndView("/index");
        PageVo pageVo = new PageVo<SjzEventIndex>();
        if(currentPage != null && currentPage > 0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize != null && pageSize > 0){
            pageVo.setPageSize(pageSize);
        }else{
            pageVo.setPageSize(10);
        }

        try {
            // 已经发布状态的列表
            sjzEventIndex = new SjzEventIndex();
            sjzEventIndex.setEventState(SjzEventStateEnum.RELEASE.getStatus());

            pageVo = sjzEventIndexService.getPageVoObjectBySjzEventIndex(sjzEventIndex,pageVo);
            modelAndView.addObject("eil",pageVo.getVoList());
            modelAndView.addObject("pages",pageVo.getPageIndex().getPages());
            modelAndView.addObject("currentPage",pageVo);
            modelAndView.addObject("pageCount",pageVo.getPageCount());
            modelAndView.addObject("pageVo",pageVo);
        } catch (Exception e) {
            logger.error("查询异常！",e);
        }

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value="/eventIndex/list/{currentPage}_{pageSize}",method = RequestMethod.GET)
    public String getEventIndex(@PathVariable(value="currentPage") Integer currentPage, @PathVariable(value="pageSize") Integer pageSize){


        return null;
    }
}
