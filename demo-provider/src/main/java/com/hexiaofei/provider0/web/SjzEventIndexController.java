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

@RestController
@RequestMapping("/eventIndex")
public class SjzEventIndexController extends AbstractBaseController implements BaseController<SjzEventIndex>{

    public static Logger logger = LoggerFactory.getLogger(SjzEventIndexController.class);
    @Autowired
    public SjzEventIndexService sjzEventIndexService;

    @RequestMapping("/{currentPage}_{pageSize}")
    @ResponseBody
    public String eventIndex(SjzEventIndex sjzEventIndex,@PathVariable int currentPage,@PathVariable int pageSize,String callback){
        ResultEntity re = new ResultEntity();
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
            re.setResultCode("0000");
            re.setResultMsg("success");
            re.setData(pageVo);
        } catch (Exception e) {
            logger.error("查询异常！",e);
            re.setResultCode("9999");
            re.setResultMsg("网络异常，稍后重试！");
        }

//        return getResultEntity().toString();
        return callback+"("+re.toString()+")";
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
    public ModelAndView toUpdate(Integer id) {
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

    @Override
    public String delete(Integer id) {
        return null;
    }


}
