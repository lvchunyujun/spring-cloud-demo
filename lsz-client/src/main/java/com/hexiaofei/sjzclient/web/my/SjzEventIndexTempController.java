package com.hexiaofei.sjzclient.web.my;

import com.hexiaofei.sjzclient.domain.SjzEventIndexTemp;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.ISjzEventIndexTempService;
import com.hexiaofei.sjzclient.vo.PageVo;
import com.hexiaofei.sjzclient.web.BaseController;
import com.lcyj.common.vo.ResultVo;
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

@Controller
public class SjzEventIndexTempController extends MyBaseController implements BaseController<SjzEventIndexTemp> {

    public static Logger logger = LoggerFactory.getLogger(SjzEventIndexController.class);

    private final static String STATIC_BASE_URL = "eventIndexTemp";

    @Autowired
    private ISjzEventIndexTempService sjzEventIndexTempService;

    @RequestMapping(STATIC_BASE_URL+"/index")
    @Override
    public String index() {
        return STATIC_BASE_URL+"/eventIndexTemp";
    }

    @RequestMapping(STATIC_BASE_URL+"/toAdd")
    @Override
    public String toAdd() {
        return STATIC_BASE_URL+"/toAddEventIndexTmp";
    }

    @RequestMapping(STATIC_BASE_URL+"/add")
    @Override
    public String add(SjzEventIndexTemp sjzEventIndexTemp) {
        int resultId = -1;
        try {

            resultId = sjzEventIndexTempService.addObject(sjzEventIndexTemp);
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

    @Override
    public ResultVo<SjzEventIndexTemp> add(HttpServletRequest request, SjzEventIndexTemp sjzEventIndexTemp) {
        return null;
    }

    /**
     * 跳转到更新页面
     * @return
     */
    @RequestMapping(value = STATIC_BASE_URL+"/toUpdate/{id}")
    @Override
    public ModelAndView toUpdate(@PathVariable Integer id) {
        ModelAndView modelAndView =
                new ModelAndView(STATIC_BASE_URL+"/toUpdateEventIndexTemp");
        try {
            SjzEventIndexTemp sjzEventIndexTemp = sjzEventIndexTempService.getObjectById(id);
            if(sjzEventIndexTemp!=null)
                modelAndView.addObject("sjzEventIndexTemp",sjzEventIndexTemp);
        }catch (PlatformException e){
            logger.error("查询异常！",e);
        }

        return modelAndView;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/update",method = RequestMethod.POST)
    @Override
    public ModelAndView update(SjzEventIndexTemp sjzEventIndexTemp) {
        ModelAndView modelAndView = new ModelAndView(STATIC_BASE_URL+"/toUpdateEventIndexTemp");
        int resultId = -1;
        try {

            resultId = sjzEventIndexTempService.updateObject(sjzEventIndexTemp);
            sjzEventIndexTemp = sjzEventIndexTempService.getObjectById(sjzEventIndexTemp.getId());
            if(sjzEventIndexTemp!=null)
                modelAndView.addObject("sjzEventIndexTemp",sjzEventIndexTemp);
            modelAndView.addObject("resultCode","0");
            modelAndView.addObject("resultMsg","修改成功！");
        }catch (PlatformException e){
            logger.error("修改异常！",e);
        }

        return modelAndView;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/list/{currentPage}_{pageSize}")
    @ResponseBody
    @Override
    public String listEventIndex(SjzEventIndexTemp sjzEventIndexTemp, @PathVariable int currentPage,@PathVariable int pageSize) {
        ResultEntity re = getResultEntity();

        PageVo pageVo = new PageVo<SjzEventIndexTemp>();
        if(currentPage>0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize>0){
            pageVo.setPageSize(pageSize);
        }
        try {
            pageVo = sjzEventIndexTempService.getPageVoObject(pageVo);
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
            int resultId = sjzEventIndexTempService.deleteObjectById(id);
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
