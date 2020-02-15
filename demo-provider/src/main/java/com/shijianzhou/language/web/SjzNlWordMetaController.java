package com.shijianzhou.language.web;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.vo.PageVo;
import com.hexiaofei.provider0.web.BaseController;
import com.hexiaofei.provider0.web.admin.AdminBaseController;
import com.shijianzhou.language.domain.SjzNlWordMeta;
import com.shijianzhou.language.service.SjzNlWordMetaService;
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
import java.util.List;

@Controller
public class SjzNlWordMetaController extends AdminBaseController implements BaseController<SjzNlWordMeta> {

    public static Logger LOGGER = LoggerFactory.getLogger(SjzNlWordMetaController.class);

    private final static String STATIC_BASE_URL = "/nl/wordMeta";

    @Autowired
    private SjzNlWordMetaService sjzNlWordMetaService;

    @Override
    @RequestMapping(STATIC_BASE_URL+"/index")
    public String index() {
        return STATIC_BASE_URL+"/wordMetaIndex";
    }

    @Override
    @RequestMapping(value = STATIC_BASE_URL+"/toAdd")
    public String toAdd() {
        return STATIC_BASE_URL+"/toAddWordMeta";
    }

    @Override
    @RequestMapping(value = STATIC_BASE_URL+"/add",method = RequestMethod.POST)
    public String add(SjzNlWordMeta sjzNlWordMeta) {

        int resultId = -1;
        try {
            sjzNlWordMeta.setCreateTime(new Date());
            resultId = sjzNlWordMetaService.addObject(sjzNlWordMeta);
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
    @RequestMapping(value = STATIC_BASE_URL+"/toUpdate/{id}")
    public ModelAndView toUpdate(@PathVariable Integer id) {
        ModelAndView modelAndView =
                new ModelAndView(STATIC_BASE_URL+"/toUpdateWordMeta");
        try {
            SjzNlWordMeta sjzNlWordMeta = sjzNlWordMetaService.getObjectById(id);
            if(sjzNlWordMeta!=null)
                modelAndView.addObject(sjzNlWordMeta);
        }catch (PlatformException e){

        }

        return modelAndView;
    }


    @Override
    @RequestMapping(value = STATIC_BASE_URL+"/updata",method = RequestMethod.POST)
    public ModelAndView update(SjzNlWordMeta sjzNlWordMeta) {
        ModelAndView modelAndView = new ModelAndView(STATIC_BASE_URL+"/toUpdateWordMeta");
        int resultId = -1;
        try {

            resultId = sjzNlWordMetaService.updateObject(sjzNlWordMeta);
            sjzNlWordMeta = sjzNlWordMetaService.getObjectById(sjzNlWordMeta.getId());
            if(sjzNlWordMeta!=null)
                modelAndView.addObject(sjzNlWordMeta);
            modelAndView.addObject("resultCode","0");
            modelAndView.addObject("resultMsg","修改成功！");
        }catch (PlatformException e){

        }

        return modelAndView;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/list/{currentPage}_{pageSize}")
    @Override
    @ResponseBody
    public String listEventIndex(SjzNlWordMeta sjzNlWordMeta,@PathVariable int currentPage,@PathVariable int pageSize) {
        ResultEntity re = getResultEntity();

        PageVo pageVo = new PageVo<SjzNlWordMeta>();
        if(currentPage>0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize>0){
            pageVo.setPageSize(pageSize);
        }
        try {
            pageVo = sjzNlWordMetaService.getPageVoObject(pageVo);
            re.setData(pageVo);
            re.setResultCode("0000");
            re.setResultMsg("success");
        } catch (Exception e) {
            re.setResultCode("9999");
            re.setResultMsg("网络异常，稍后重试！");
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
            int resultId = sjzNlWordMetaService.deleteObjectById(id);
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


    @RequestMapping(value = STATIC_BASE_URL+"/getListByPWMC/{parentWordMetaCode}")
    @ResponseBody
    public String getListByParentWordMetaCode(@PathVariable("parentWordMetaCode") Integer parentWordMetaCode){
        ResultEntity re = getResultEntity();
        List<SjzNlWordMeta> list ;

        try {
            list = sjzNlWordMetaService.getNextListWordMetaByWordMetaCode(parentWordMetaCode);
            re.setData(list);
            re.setResultCode("0000");
            re.setResultMsg("success！");
        } catch (PlatformException e) {
            re.setResultCode("9999");
            re.setResultMsg("网络异常，稍后重试！");
            LOGGER.error("查询异常！",e);
        }

        return re.toString();
    }

    @RequestMapping(value = STATIC_BASE_URL+"/getByWMC/{wordMetaCode}")
    @ResponseBody
    public String getWordMetaCodeByWordMetaCode(@PathVariable("wordMetaCode") Integer wordMetaCode){
        ResultEntity re = getResultEntity();

        SjzNlWordMeta sjzNlWordMeta;
        try {
            sjzNlWordMeta = sjzNlWordMetaService.getSjzNlWordMetaByWordMetaCode(wordMetaCode);
            re.setData(sjzNlWordMeta);
            re.setResultCode("0000");
            re.setResultMsg("success！");
        } catch (PlatformException e) {
            re.setResultCode("9999");
            re.setResultMsg("网络异常，稍后重试！");
            LOGGER.error("查询异常！",e);
        }

        return re.toString();
    }

}
