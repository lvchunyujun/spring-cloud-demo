package com.hexiaofei.sjzclient.web.my;

import com.hexiaofei.sjzclient.domain.SjzEventIndex;
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

    @Override
    public String toAdd() {
        return null;
    }

    /**
     * 添加事件
     * @param sjzEventIndex
     * @return
     */
    @RequestMapping(value = STATIC_BASE_URL+"/addDomainInfo",method = RequestMethod.POST)
    @Override
    public String add(SjzEventIndex sjzEventIndex) {
        return null;
    }

    @Override
    public ModelAndView toUpdate(Integer id) {
        return null;
    }

    @Override
    public ModelAndView update(SjzEventIndex sjzEventIndex) {
        return null;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/list/{currentPage}_{pageSize}")
    @ResponseBody
    public String listEventIndex(SjzEventIndex sjzEventIndex, @PathVariable int currentPage,@PathVariable int pageSize) {
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

    @Override
    public String delete(Integer id) {
        return null;
    }
}
