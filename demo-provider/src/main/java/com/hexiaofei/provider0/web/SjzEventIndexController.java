package com.hexiaofei.provider0.web;

import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.vo.PageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventIndex")
public class SjzEventIndexController extends BaseController{

    public static Logger logger = LoggerFactory.getLogger(SjzEventIndexController.class);
    @Autowired
    public SjzEventIndexService sjzEventIndexService;

    @RequestMapping("/")
    @ResponseBody
    public String eventIndex(SjzEventIndex sjzEventIndex,int currentPage){

        PageVo pageVo = new PageVo<SjzEventIndex>();
        pageVo.setCurrentPage(currentPage);
        try {
            pageVo = sjzEventIndexService.getPageVoObject(pageVo);
            getResultEntity().setData(pageVo);
        } catch (PlatformException e) {
            logger.error("查询异常！",e);
        }

        return getResultEntity().toString();
    }
}
