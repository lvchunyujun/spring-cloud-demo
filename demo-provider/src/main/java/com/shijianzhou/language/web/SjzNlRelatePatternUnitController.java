package com.shijianzhou.language.web;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.vo.PageVo;
import com.hexiaofei.provider0.web.BaseController;
import com.hexiaofei.provider0.web.admin.AdminBaseController;
import com.shijianzhou.language.domain.SjzNlRegExp;
import com.shijianzhou.language.domain.SjzNlRelatePatternUnit;
import com.shijianzhou.language.service.SjzNlRelatePatternUnitService;
import com.shijianzhou.language.vo.SjzNlRelatePatternUnitVo;
import org.aspectj.weaver.ast.Var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class SjzNlRelatePatternUnitController extends AdminBaseController implements BaseController<SjzNlRelatePatternUnit> {

    private final static String STATIC_BASE_URL = "nl/relatePatternUnit";

    private static final Logger LOGGER = LoggerFactory.getLogger(SjzNlRelatePatternUnitController.class);

    @Autowired
    private SjzNlRelatePatternUnitService sjzNlRelatePatternUnitService;

    @RequestMapping("rpu/index")
    @Override
    public String index() {
        return STATIC_BASE_URL+"/rpuIndex";
    }

    @RequestMapping("rpu/toAdd")
    @Override
    public String toAdd() {
        return STATIC_BASE_URL+"/toAddRpu";
    }

    @RequestMapping("rpu/add")
    @Override
    public String add(SjzNlRelatePatternUnit sjzNlRelatePatternUnit) {
        int resultId = -1;
        try {

            // step1: 检查正则表达式是否存在、


            // step2: 序号是否正确


            sjzNlRelatePatternUnit.setCreateTime(new Date());
            resultId = sjzNlRelatePatternUnitService.addObject(sjzNlRelatePatternUnit);
        } catch (PlatformException e) {
            e.printStackTrace();
        }

        if(resultId>0){
            return ADD_SUCCESS_URL;
        }else{
            return ADD_FAIL_URL;
        }
    }

    @RequestMapping(value = "rpu/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String deleteById(@PathVariable Integer id){
        ResultEntity re = getResultEntity();

        try {
            int resultId = sjzNlRelatePatternUnitService.deleteObjectById(id);
            re.setResultCode("0000");
            re.setResultMsg("success");
        } catch (PlatformException e) {
            re.setResultCode("9999");
            re.setResultMsg("网络异常，稍后重试！");
            LOGGER.error("删除异常！",e);
        }

        return re.toString();
    }

    @RequestMapping("rpu/toUpdate")
    @Override
    public ModelAndView toUpdate(Integer id) {
        ModelAndView modelAndView =
                new ModelAndView(STATIC_BASE_URL+"/toUpdate");
        try {
            SjzNlRelatePatternUnit sjzNlRelatePatternUnit = sjzNlRelatePatternUnitService.getObjectById(id);
            if(sjzNlRelatePatternUnit!=null)
                modelAndView.addObject(sjzNlRelatePatternUnit);
        }catch (PlatformException e){

        }

        return modelAndView;
    }

    @RequestMapping("rpu/toUpdateUnit/{patternName}")
    public ModelAndView toUpdate(@PathVariable String patternName) {
        ModelAndView modelAndView = new ModelAndView(STATIC_BASE_URL+"/toUpdateRpu");
        try {
            SjzNlRelatePatternUnit rpu = new SjzNlRelatePatternUnit();
            rpu.setPatternName(patternName);

            List<SjzNlRelatePatternUnit> volist = sjzNlRelatePatternUnitService.getListObject(rpu);
            if(volist == null){
                volist = new ArrayList<>();
            }
            modelAndView.addObject("volist",volist);
        }catch (PlatformException e){
            LOGGER.error("查询异常！",e);
        }

        return modelAndView;
    }

    @RequestMapping("rpu/update")
    @Override
    public ModelAndView update(SjzNlRelatePatternUnit volist) {


        return null;
    }

    @RequestMapping("rpu/updateList")
    public ModelAndView update(SjzNlRelatePatternUnitVo volist) {

        ModelAndView modelAndView = new ModelAndView();
        List<Map<String,Object>> resultMap;
        String patternName = volist.getVolist().get(0).getPatternName();
        try {
            resultMap = sjzNlRelatePatternUnitService.updateOrAddForList(volist.getVolist());
            modelAndView.addObject("resultMap",resultMap);

            SjzNlRelatePatternUnit rpu = new SjzNlRelatePatternUnit();
            rpu.setPatternName(patternName);
            List<SjzNlRelatePatternUnit> list = sjzNlRelatePatternUnitService.getListObject(rpu);

            modelAndView.addObject("volist",list);
            modelAndView.setViewName(STATIC_BASE_URL+"/toUpdateRpu");
        } catch (PlatformException e) {
            LOGGER.error("查询异常！",e);
        }

        return modelAndView;
    }

    @RequestMapping(value = "rpu/list/{currentPage}_{pageSize}")
    @ResponseBody
    @Override
    public String listEventIndex(SjzNlRelatePatternUnit sjzNlRelatePatternUnit, @PathVariable int currentPage,@PathVariable int pageSize) {
        ResultEntity re = getResultEntity();

        PageVo pageVo = new PageVo<SjzNlRelatePatternUnit>();
        if(currentPage>0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize>0){
            pageVo.setPageSize(pageSize);
        }
        try {
            pageVo = sjzNlRelatePatternUnitService.getPageVoObject(pageVo);
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
            int resultId = sjzNlRelatePatternUnitService.deleteObjectById(id);
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


}
