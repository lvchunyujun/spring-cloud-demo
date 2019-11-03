package com.hexiaofei.provider0.web.admin;

import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzDomainInfoService;
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
public class AdminSjzDomainInfoController extends AdminBaseController implements BaseController<SjzDomainInfo> {

    public static Logger logger = LoggerFactory.getLogger(SjzEventIndexController.class);

    private final static String STATIC_BASE_URL = "domain";

    @Autowired
    private SjzDomainInfoService sjzDomainInfoService;

    @RequestMapping("domainInfo/index")
    public String index(){

        return STATIC_BASE_URL+"/domainInfoIndex";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @RequestMapping(value = "domainInfo/toAddDomainInfo")
    public String toAdd(){
        return STATIC_BASE_URL+"/toAddDomainInfo";
    }

    /**
     * 添加事件
     * @param sjzDomainInfo
     * @return
     */
    @RequestMapping(value = "domainInfo/addDomainInfo",method = RequestMethod.POST)
    public String add(SjzDomainInfo sjzDomainInfo){
        int resultId = -1;
        try {

            resultId = sjzDomainInfoService.addObject(sjzDomainInfo);
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
    @RequestMapping(value = "domainInfo/toUpdate/{id}")
    public ModelAndView toUpdate(@PathVariable Integer id){
        ModelAndView modelAndView =
                new ModelAndView(STATIC_BASE_URL+"/toUpdateDomainInfo");
        try {
            SjzDomainInfo sjzDomainInfo = sjzDomainInfoService.getObjectById(id);
            if(sjzDomainInfo!=null)
            modelAndView.addObject(sjzDomainInfo);
        }catch (PlatformException e){

        }

        return modelAndView;
    }

    /**
     * 更新域名信息
     * @return
     */
    @RequestMapping(value = "domainInfo/update",method = RequestMethod.POST)
    public ModelAndView update(SjzDomainInfo sjzDomainInfo){

        ModelAndView modelAndView = new ModelAndView(STATIC_BASE_URL+"/toUpdateDomainInfo");
        int resultId = -1;
        try {

            resultId = sjzDomainInfoService.updateObject(sjzDomainInfo);
            sjzDomainInfo = sjzDomainInfoService.getObjectById(sjzDomainInfo.getId());
            if(sjzDomainInfo!=null)
                modelAndView.addObject(sjzDomainInfo);
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
     * @param sjzDomainInfo
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "domainInfo/list/{currentPage}_{pageSize}")
    @ResponseBody
    public String listEventIndex(SjzDomainInfo sjzDomainInfo,@PathVariable int currentPage,@PathVariable int pageSize){

        ResultEntity re = getResultEntity();

        PageVo pageVo = new PageVo<SjzDomainInfo>();
        if(currentPage>0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize>0){
            pageVo.setPageSize(pageSize);
        }
        try {
            pageVo = sjzDomainInfoService.getPageVoObject(pageVo);
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
            int resultId = sjzDomainInfoService.deleteObjectById(id);
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
