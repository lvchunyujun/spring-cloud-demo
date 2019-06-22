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
public class SjzEventIndexController extends BaseController{

    public static Logger logger = LoggerFactory.getLogger(SjzEventIndexController.class);
    @Autowired
    public SjzEventIndexService sjzEventIndexService;

    @RequestMapping("/{currentPage}_{pageSize}")
    @ResponseBody
    public String eventIndex(SjzEventIndex sjzEventIndex,@PathVariable int currentPage,@PathVariable int pageSize,String callback){

        PageVo pageVo = new PageVo<SjzEventIndex>();
        if(currentPage>0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize>0){
            pageVo.setPageSize(pageSize);
        }
        try {
            pageVo = sjzEventIndexService.getPageVoObject(pageVo);
            getResultEntity().setResultCode("0000");
            getResultEntity().setResultMsg("success");
            getResultEntity().setData(pageVo);
        } catch (Exception e) {
            logger.error("查询异常！",e);
            getResultEntity().setResultCode("9999");
            getResultEntity().setResultMsg("网络异常，稍后重试！");
        }

//        return getResultEntity().toString();
        return callback+"("+getResultEntity().toString()+")";
    }
}
