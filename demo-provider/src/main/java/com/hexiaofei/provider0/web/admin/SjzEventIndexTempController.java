package com.hexiaofei.provider0.web.admin;

import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.domain.SjzEventIndexTemp;
import com.hexiaofei.provider0.service.SjzEventIndexTempService;
import com.hexiaofei.provider0.vo.PageVo;
import com.hexiaofei.provider0.web.BaseController;
import com.hexiaofei.provider0.web.SjzEventIndexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SjzEventIndexTempController extends AdminBaseController implements BaseController<SjzEventIndexTemp> {

    public static Logger logger = LoggerFactory.getLogger(SjzEventIndexController.class);

    private final static String STATIC_BASE_URL = "eventTemp";

    @Autowired
    private SjzEventIndexTempService sjzEventIndexTempService;

    @RequestMapping("eventIndexTemp/index")
    @Override
    public String index() {
        return STATIC_BASE_URL+"/eventIndexTemp";
    }

    @RequestMapping("eventIndexTemp/toAdd")
    @Override
    public String toAdd() {
        return STATIC_BASE_URL+"/toAddEventIndexTmp";
    }

    @RequestMapping("eventIndexTemp/add")
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
    public ModelAndView toUpdate(Integer id) {
        return null;
    }

    @Override
    public ModelAndView update(SjzEventIndexTemp sjzEventIndexTemp) {
        return null;
    }

    @RequestMapping(value = "eventIndexTemp/list/{currentPage}_{pageSize}")
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
}
