package com.shijianzhou.language.web;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.vo.PageVo;
import com.hexiaofei.provider0.web.BaseController;
import com.hexiaofei.provider0.web.admin.AdminBaseController;
import com.shijianzhou.language.domain.SjzNlRegExp;
import com.shijianzhou.language.service.SjzNlRegExpService;
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
public class SjzNlRegExpController extends AdminBaseController implements BaseController<SjzNlRegExp> {

    public static Logger logger = LoggerFactory.getLogger(SjzNlRegExpController.class);

    private final static String STATIC_BASE_URL = "/nl/regexp";

    @Autowired
    private SjzNlRegExpService sjzNlRegExpService;

    @Override
    @RequestMapping("/nlRegExp/index")
    public String index() {
        return STATIC_BASE_URL+"/regexpIndex";
    }

    @Override
    @RequestMapping(value = "/nlRegExp/toAdd")
    public String toAdd() {
        return STATIC_BASE_URL+"/toAddRegexp";
    }

    @Override
    @RequestMapping(value = "/nlRegExp/addEventIndex",method = RequestMethod.POST)
    public String add(SjzNlRegExp sjzNlRegExp) {

        int resultId = -1;
        try {
            sjzNlRegExp.setCreateTime(new Date());
            resultId = sjzNlRegExpService.addObject(sjzNlRegExp);
        } catch (PlatformException e) {
            e.printStackTrace();
        }

        if(resultId>0){
            return ADD_SUCCESS_URL;
        }else{
            return ADD_FAIL_URL;
        }
    }


    @Override
    @RequestMapping(value = "/nlRegExp/toUpdate/{id}")
    public ModelAndView toUpdate(@PathVariable Integer id) {
        ModelAndView modelAndView =
                new ModelAndView(STATIC_BASE_URL+"/toUpdateRegexp");
        try {
            SjzNlRegExp sjzNlRegExp = sjzNlRegExpService.getObjectById(id);
            if(sjzNlRegExp!=null)
                modelAndView.addObject(sjzNlRegExp);
        }catch (PlatformException e){

        }

        return modelAndView;
    }


    @Override
    @RequestMapping(value = "/nlRegExp/updata")
    public ModelAndView update(SjzNlRegExp sjzNlRegExp) {
        ModelAndView modelAndView = new ModelAndView(STATIC_BASE_URL+"/toUpdateRegexp");
        int resultId = -1;
        try {

            resultId = sjzNlRegExpService.updateObject(sjzNlRegExp);
            sjzNlRegExp = sjzNlRegExpService.getObjectById(sjzNlRegExp.getId());
            if(sjzNlRegExp!=null)
                modelAndView.addObject(sjzNlRegExp);
            modelAndView.addObject("resultCode","0");
            modelAndView.addObject("resultMsg","修改成功！");
        }catch (PlatformException e){

        }

        return modelAndView;
    }

    @RequestMapping(value = "/nlRegExp/list/{currentPage}_{pageSize}")
    @Override
    @ResponseBody
    public String listEventIndex(SjzNlRegExp sjzNlRegExp,@PathVariable int currentPage,@PathVariable int pageSize) {
        ResultEntity re = getResultEntity();

        PageVo pageVo = new PageVo<SjzNlRegExp>();
        if(currentPage>0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize>0){
            pageVo.setPageSize(pageSize);
        }
        try {
            pageVo = sjzNlRegExpService.getPageVoObject(pageVo);
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
            int resultId = sjzNlRegExpService.deleteObjectById(id);
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



    @RequestMapping(value = "/nlRegExp/check")
    @ResponseBody
    public String getRegExpMarchCheck(SjzNlRegExp sjzNlRegExp){
        ResultEntity re = getResultEntity();
        try {
            boolean checked = sjzNlRegExpService.getNlRegExpCheck(sjzNlRegExp);
            if(checked){
                re.setResultCode("0000");
                re.setResultMsg("success");
            }else{
                re.setResultCode("1000");
                re.setResultMsg("fail！");
            }
        } catch (Exception e) {
            re.setResultCode("9999");
            re.setResultMsg("网络异常，稍后重试！");
            logger.error("查询异常！",e);
        }

        return re.toString();
    }
}
