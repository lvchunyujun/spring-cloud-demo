package com.hexiaofei.sjzclient.web.my;

import com.hexiaofei.sjzclient.domain.SjzEventIndex;
import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.SjzEventIndexService;
import com.hexiaofei.sjzclient.vo.PageVo;
import com.hexiaofei.sjzclient.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class SjzEventIndexController extends MyBaseController implements BaseController<SjzEventIndex> {

    public static Logger logger = LoggerFactory.getLogger(SjzDomainInfoController.class);

    private final static String STATIC_BASE_URL = "eventIndex";

    @Autowired
    private SjzEventIndexService sjzEventIndexService;

    @RequestMapping(value = STATIC_BASE_URL+"/index")
    public ModelAndView index(SjzEventIndex sjzEventIndex,Integer currentPage,Integer pageSize){
        ModelAndView modelAndView = new ModelAndView("/my/"+STATIC_BASE_URL+"/index");
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
            pageVo = sjzEventIndexService.getPageVoObject(pageVo);
            modelAndView.addObject("eil",pageVo.getVoList());
        } catch (Exception e) {
            logger.error("查询异常！",e);
        }

        return modelAndView;
    }

    @Override
    public String index() {
        return null;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/toAdd")
    @Override
    public String toAdd() {
        return "my/"+STATIC_BASE_URL+"/toAdd";
    }

    /**
     * 添加事件
     * @param sjzEventIndex
     * @return
     */
    @RequestMapping(value = STATIC_BASE_URL+"/add",method = RequestMethod.POST)
    @Override
    public String add(SjzEventIndex sjzEventIndex) {
        int resultId = -1;
        try {
            // 1. 添加事件
            sjzEventIndex.setEventState((byte)0);
            sjzEventIndex.setRecordCreateTime(new Date());
            resultId = sjzEventIndexService.addObject(sjzEventIndex);

            // 2.添加作者


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

    @RequestMapping(value = STATIC_BASE_URL+"/toUpdate/{id}")
    @Override
    public ModelAndView toUpdate(@PathVariable Integer id) {
        ModelAndView modelAndView =
                new ModelAndView("my/"+STATIC_BASE_URL+"/toUpdate");
        try {
            SjzEventIndex sjzEventIndex = sjzEventIndexService.getObjectById(id);
            if(sjzEventIndex!=null)
                modelAndView.addObject(sjzEventIndex);
        }catch (PlatformException e){

        }

        return modelAndView;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/upadte",method = RequestMethod.POST)
    @Override
    public ModelAndView update(SjzEventIndex sjzEventIndex) {
        ModelAndView modelAndView = new ModelAndView("my/"+STATIC_BASE_URL+"/toUpdate");
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

    @Override
    public String listEventIndex(SjzEventIndex sjzEventIndex, int currentPage, int pageSize) {
        return null;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/list/{currentPage}_{pageSize}")
    @ResponseBody
    public String listEventIndex(HttpServletRequest request, SjzEventIndex sjzEventIndex, @PathVariable int currentPage, @PathVariable int pageSize) {
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

            UserInfo userInfo = getLoginUserInfo(request);

            pageVo = sjzEventIndexService.getPageVoObjectByAuthorId(userInfo.getId(),null,pageVo);
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

    @RequestMapping(value = STATIC_BASE_URL+"/delete/{id}")
    @ResponseBody
    @Override
    public String delete(Integer id) {
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
            logger.error("查询异常！",e);
        }
        return re.toString();
    }
}
