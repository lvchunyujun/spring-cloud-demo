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
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class AdminSjzEventIndexController extends AdminBaseController implements BaseController<SjzEventIndex> {

    public static Logger logger = LoggerFactory.getLogger(SjzEventIndexController.class);

    @Autowired
    public SjzEventIndexService sjzEventIndexService;



    @RequestMapping("/eventIndex")
    public String index(){

        return "event/eventIndex";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping(value = "/toAddEventIndex")
    public String toAdd(){
        return "event/toAddEventIndex";
    }

    /**
     * 添加事件
     * @param sjzEventIndex
     * @return
     */
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

    /**
     * 跳转到更新页面
     * @return
     */
    @RequestMapping(value = "/event/toUpdate/{id}")
    public ModelAndView toUpadte(@PathVariable Integer id){
        ModelAndView modelAndView =
                new ModelAndView("event/toUpdateEventIndex");
        try {
            SjzEventIndex sjzEventIndex = sjzEventIndexService.getObjectById(id);
            if(sjzEventIndex!=null)
            modelAndView.addObject(sjzEventIndex);
        }catch (PlatformException e){

        }

        return modelAndView;
    }

    /**
     * 更新事件
     * @return
     */
    @RequestMapping(value = "/event/upadte",method = RequestMethod.POST)
    public ModelAndView update(SjzEventIndex sjzEventIndex){

        ModelAndView modelAndView = new ModelAndView("event/toUpdateEventIndex");
        int resultId = -1;
        try {

            resultId = sjzEventIndexService.updateObject(sjzEventIndex);
            sjzEventIndex = sjzEventIndexService.getObjectById(sjzEventIndex.getId());
            if(sjzEventIndex!=null)
                modelAndView.addObject(sjzEventIndex);
            modelAndView.addObject("resultCode","0");
            modelAndView.addObject("resultMsg","修改成功！");
        }catch (PlatformException e){

        }

        return modelAndView;
    }

    public String toDelete(){
        return "";
    }

    public String delete(){
        return "";
    }

    /**
     * 分页查询事件列表
     * @param sjzEventIndex
     * @param currentPage
     * @param pageSize
     * @return
     */
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
