package com.hexiaofei.provider0.web.admin;

import com.hexiaofei.provider0.domain.SjzDomainWordSort;
import com.hexiaofei.provider0.domain.SjzEventIndexTemp;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzDomainWordSortService;
import com.hexiaofei.provider0.vo.PageVo;
import com.hexiaofei.provider0.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class SjzDomainWordSortController extends AdminBaseController implements BaseController<SjzDomainWordSort> {

    public static Logger logger = LoggerFactory.getLogger(SjzDomainWordSortController.class);

    private final static String STATIC_BASE_URL = "domainWordSort";


    @Autowired
    private SjzDomainWordSortService sjzDomainWordSortService;

    @RequestMapping("domainWordSort/index")
    @Override
    public String index() {
        return STATIC_BASE_URL+"/domainWordSortIndex";
    }

    @RequestMapping("domainWordSort/toAdd")
    @Override
    public String toAdd() {
        return STATIC_BASE_URL+"/toAddDomainWordSort";
    }

    @RequestMapping(value ="domainWordSort/add",method = RequestMethod.POST)
    @Override
    public String add(SjzDomainWordSort sjzDomainWordSort) {
        int resultId = -1;
        try {
            sjzDomainWordSort.setCreateTime(new Date());
            resultId = sjzDomainWordSortService.addObject(sjzDomainWordSort);
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

    @RequestMapping("domainWordSort/toUpdate")
    @Override
    public ModelAndView toUpdate(Integer id) {
        return null;
    }

    @RequestMapping("domainWordSort/update")
    @Override
    public ModelAndView update(SjzDomainWordSort sjzDomainWordSort) {
        return null;
    }

    @RequestMapping(value = "domainWordSort/list/{currentPage}_{pageSize}")
    @ResponseBody
    @Override
    public String listEventIndex(SjzDomainWordSort sjzDomainWordSort, @PathVariable int currentPage,@PathVariable int pageSize) {
        ResultEntity re = getResultEntity();

        PageVo pageVo = new PageVo<SjzDomainWordSort>();
        if(currentPage>0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize>0){
            pageVo.setPageSize(pageSize);
        }
        try {
            pageVo = sjzDomainWordSortService.getPageVoObject(pageVo);
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

    @RequestMapping(value = "domainWordSort/delete/{id}")
    @ResponseBody
    @Override
    public String delete(@PathVariable Integer id) {
        ResultEntity re = getResultEntity();
        try {
            int resultId = sjzDomainWordSortService.deleteObjectById(id);
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
