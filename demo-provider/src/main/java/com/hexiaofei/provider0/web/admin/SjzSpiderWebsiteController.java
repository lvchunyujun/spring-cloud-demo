package com.hexiaofei.provider0.web.admin;

import com.hexiaofei.provider0.domain.SjzSpiderWebsite;
import com.hexiaofei.provider0.service.SjzSpiderWebsiteService;
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

@Controller
public class SjzSpiderWebsiteController extends AdminBaseController implements BaseController<SjzSpiderWebsite> {

    public static Logger logger = LoggerFactory.getLogger(SjzSpiderWebsiteController.class);

    private final static String STATIC_BASE_URL = "spidersite";

    @Autowired
    private SjzSpiderWebsiteService sjzSpiderWebsiteService;

    @RequestMapping("spiderWebsite/index")
    @Override
    public String index() {
        return STATIC_BASE_URL+"/spiderWebsiteIndex";
    }

    @Override
    public String toAdd() {
        return null;
    }

    @Override
    public String add(SjzSpiderWebsite sjzSpiderWebsite) {
        return null;
    }

    @Override
    public ModelAndView toUpadte(Integer id) {
        return null;
    }

    @Override
    public ModelAndView update(SjzSpiderWebsite sjzSpiderWebsite) {
        return null;
    }

    @RequestMapping(value = "spiderWebsite/list/{currentPage}_{pageSize}")
    @Override
    @ResponseBody
    public String listEventIndex(SjzSpiderWebsite sjzSpiderWebsite, @PathVariable int currentPage,@PathVariable  int pageSize) {
        ResultEntity re = getResultEntity();

        PageVo pageVo = new PageVo<SjzSpiderWebsite>();
        if(currentPage>0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize>0){
            pageVo.setPageSize(pageSize);
        }
        try {
            pageVo = sjzSpiderWebsiteService.getPageVoObject(pageVo);
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
}
