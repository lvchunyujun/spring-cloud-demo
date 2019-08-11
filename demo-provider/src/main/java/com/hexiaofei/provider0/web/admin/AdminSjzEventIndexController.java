package com.hexiaofei.provider0.web.admin;

import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.vo.PageVo;
import com.hexiaofei.provider0.web.BaseController;
import com.hexiaofei.provider0.web.SjzEventIndexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class AdminSjzEventIndexController extends AdminBaseController {

    public static Logger logger = LoggerFactory.getLogger(SjzEventIndexController.class);

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


    @RequestMapping(value = "eventIndex/list/{currentPage}_{pageSize}")
    @ResponseBody
    public String listEventIndex(SjzEventIndex sjzEventIndex,@PathVariable int currentPage,@PathVariable int pageSize){

        ResultEntity re = getResultEntity();

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
            re.setData(pageVo);
            re.setResultCode("0000");
            re.setResultMsg("success");
        } catch (Exception e) {
            re.setResultCode("9999");
            re.setResultMsg("网络异常，稍后重试！");
            logger.error("查询异常！",e);
        }


        return re.toString();
    }
}
