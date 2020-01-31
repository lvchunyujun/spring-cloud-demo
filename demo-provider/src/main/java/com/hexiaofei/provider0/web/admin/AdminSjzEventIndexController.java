package com.hexiaofei.provider0.web.admin;

import com.hexiaofei.provider0.common.consts.SjzEventStateEnum;
import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.utils.DateUtils;
import com.hexiaofei.provider0.vo.PageVo;
import com.hexiaofei.provider0.vo.SjzEventIndexVo;
import com.hexiaofei.provider0.web.BaseController;
import com.hexiaofei.provider0.web.SjzEventIndexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;

@Controller
public class AdminSjzEventIndexController extends AdminBaseController implements BaseController<SjzEventIndex> {

    public static Logger LOGGER = LoggerFactory.getLogger(SjzEventIndexController.class);

    @Autowired
    public SjzEventIndexService sjzEventIndexService;

    private final static String STATIC_BASE_URL = "/eventIndex";

    @RequestMapping("/eventIndex")
    public String index(){

        return "/event/eventIndex";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping(value = "/toAddEventIndex")
    public String toAdd(){
        return "/event/toAddEventIndex";
    }

    @Override
    public String add(SjzEventIndex sjzEventIndex) {
        return null;
    }

    /**
     * 添加事件
     * @param sjzEventIndexVo
     * @return
     */
    @RequestMapping(value = "/addEventIndex",method = RequestMethod.POST)
    public String add(SjzEventIndexVo sjzEventIndexVo){
        int resultId = -1;
        try {
            SjzEventIndex sjzEventIndex = resolveVoToBo(sjzEventIndexVo);

            sjzEventIndex.setEventState(SjzEventStateEnum.CHECK.getStatus());
            sjzEventIndex.setRecordCreateTime(new Date());
            resultId = sjzEventIndexService.addObject(sjzEventIndex);
        } catch (Exception e) {
            e.printStackTrace();
            resultId = -99;
        }
        if(resultId>0){
            return ADD_SUCCESS_URL;
        }else{
            return ADD_FAIL_URL;
        }
    }

    /**
     * 跳转到更新页面
     * @return
     */
    @RequestMapping(value = "/event/toUpdate/{id}")
    public ModelAndView toUpdate(@PathVariable Integer id){
        ModelAndView modelAndView =
                new ModelAndView("/event/toUpdateEventIndex");
        try {
            SjzEventIndex sjzEventIndex = sjzEventIndexService.getObjectById(id);
            if(sjzEventIndex!=null)
            modelAndView.addObject(sjzEventIndex);
        }catch (PlatformException e){

        }

        return modelAndView;
    }

    @Override
    public ModelAndView update(SjzEventIndex sjzEventIndex) {
        return null;
    }

    /**
     * 更新事件
     * @return
     */
    @RequestMapping(value = "/event/upadte",method = RequestMethod.POST)
    public ModelAndView update(SjzEventIndexVo sjzEventIndexVo){

        ModelAndView modelAndView = new ModelAndView("/event/toUpdateEventIndex");
        int resultId = -1;
        try {

            SjzEventIndex sjzEventIndex = resolveVoToBo(sjzEventIndexVo);

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

    @Override
    public String listEventIndex(SjzEventIndex sjzEventIndex, int currentPage, int pageSize) {
        return null;
    }

    public String toDelete(){
        return "";
    }

    public String delete(){
        return "";
    }

    /**
     * 分页查询事件列表
     *
     * @param sjzEventIndexVo
     * @return
     */
    @RequestMapping(value = "/eventIndex/list",method = {RequestMethod.POST})
    @ResponseBody
    public String listEventIndex(@RequestBody SjzEventIndexVo sjzEventIndexVo){
        ResultEntity re = getResultEntity();

        int currentPage = sjzEventIndexVo.getPageVo().getCurrentPage();
        int pageSize = sjzEventIndexVo.getPageVo().getPageSize();

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
            pageVo = sjzEventIndexService.getPageVoObjectByAuthorId(null,sjzEventIndexVo,pageVo);

            re.setData(pageVo);
            re.setResultCode("0000");
            re.setResultMsg("success");
        } catch (Exception e) {
            re.setResultCode("9999");
            re.setResultMsg("网络异常，稍后重试！");
            re.setData(new PageVo());
            LOGGER.error("查询异常！",e);
        }


        return re.toString();
    }

    @RequestMapping(value = STATIC_BASE_URL+"/delete/{id}")
    @ResponseBody
    @Override
    public String delete(@PathVariable Integer id) {
        ResultEntity re = getResultEntity();
        try {
            int resultId = sjzEventIndexService.deleteObjectById(id);
            if(resultId > 0){
                re.setResultCode("0000");
                re.setResultMsg("success");
            }
        } catch (PlatformException e) {
            re.setResultCode("9999");
            re.setResultMsg("网络异常，稍后重试！");
            LOGGER.error("查询异常！",e);
        }
        return re.toString();
    }


    private SjzEventIndex resolveVoToBo(SjzEventIndexVo sjzEventIndexVo) throws PlatformException {

        SjzEventIndex sjzEventIndex = new SjzEventIndex();
        sjzEventIndex.setId(sjzEventIndexVo.getId());
        try {
            Date eventTime = DateUtils.strToDate(sjzEventIndexVo.getEventTime());
            sjzEventIndex.setEventTime(eventTime);
        } catch (ParseException e) {
            LOGGER.error("时间日期格式错误！",e);
            throw new PlatformException("时间日期格式错误！");
        }
        sjzEventIndex.setEventType(sjzEventIndexVo.getEventType());
        sjzEventIndex.setEventContent(sjzEventIndexVo.getEventContent());
        sjzEventIndex.setEventState(sjzEventIndexVo.getEventState());
        sjzEventIndex.setRecordCreateTime(sjzEventIndexVo.getRecordCreateTime());
        return sjzEventIndex;
    }

}
