package com.hexiaofei.provider0.web.admin;

import com.hexiaofei.provider0.domain.SjzDomainSpiderTask;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzDomainSpiderTaskService;
import com.hexiaofei.provider0.vo.PageVo;
import com.hexiaofei.provider0.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class SjzDomainSpiderTaskController extends AdminBaseController implements BaseController<SjzDomainSpiderTask> {

    public static Logger logger = LoggerFactory.getLogger(SjzDomainSpiderTaskController.class);

    private final static String STATIC_BASE_URL = "domainSpiderTask";

    @Autowired
    private SjzDomainSpiderTaskService sjzDomainSpiderTaskService;

    @RequestMapping(STATIC_BASE_URL+"/index")
    @Override
    public String index() {
        return STATIC_BASE_URL+"/spiderTaskIndex";
    }

    @RequestMapping(STATIC_BASE_URL+"/toAdd")
    @Override
    public String toAdd() {
        return STATIC_BASE_URL+"/toAddDomainSpiderTask";
    }

    @RequestMapping(STATIC_BASE_URL+"/add")
    @Override
    public String add(SjzDomainSpiderTask sjzDomainSpiderTask) {
        int resultId = -1;
        try {
            sjzDomainSpiderTask.setSpiderTaskCreateTime(new Date());
            resultId = sjzDomainSpiderTaskService.addObject(sjzDomainSpiderTask);
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

    @RequestMapping(STATIC_BASE_URL+"/toUpdate")
    @Override
    public ModelAndView toUpdate(Integer id) {
        return null;
    }

    @RequestMapping(STATIC_BASE_URL+"/update")
    @Override
    public ModelAndView update(SjzDomainSpiderTask sjzDomainSpiderTask) {
        return null;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/list/{currentPage}_{pageSize}")
    @ResponseBody
    @Override
    public String listEventIndex(SjzDomainSpiderTask sjzDomainSpiderTask,@PathVariable int currentPage,@PathVariable int pageSize) {
        ResultEntity re = getResultEntity();

        PageVo pageVo = new PageVo<SjzDomainSpiderTask>();
        if(currentPage>0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize>0){
            pageVo.setPageSize(pageSize);
        }
        try {
            pageVo = sjzDomainSpiderTaskService.getPageVoObject(pageVo);
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
    public String delete(@PathVariable Integer id) {
        ResultEntity re = getResultEntity();
        try {
            int resultId = sjzDomainSpiderTaskService.deleteObjectById(id);
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
