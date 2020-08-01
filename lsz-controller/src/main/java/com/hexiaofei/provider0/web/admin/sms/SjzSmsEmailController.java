package com.hexiaofei.provider0.web.admin.sms;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.sms.SmsEmailService;
import com.hexiaofei.provider0.web.BaseController;
import com.hexiaofei.provider0.web.admin.AdminBaseController;
import com.lcyj.common.bo.sms.SmsEmail;
import com.lcyj.common.vo.PageVo;
import com.lcyj.common.vo.ResultVo;
import com.lcyj.common.vo.sms.SmsEmailVo;
import com.lcyj.common.web.WebCommonConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SjzSmsEmailController extends AdminBaseController implements BaseController<SmsEmail> {

    public static Logger logger = LoggerFactory.getLogger(SjzSmsEmailController.class);

    private final static String STATIC_BASE_URL = "/sms/email";

    @Autowired
    private SmsEmailService smsEmailService;

    @RequestMapping(STATIC_BASE_URL+"/"+WebCommonConstant.URL_INDEX)
    @Override
    public String index() {
        return STATIC_BASE_URL+"/"+WebCommonConstant.URL_INDEX;
    }

    @Override
    public String toAdd() {
        return null;
    }

    @Override
    public String add(SmsEmail smsEmail) {
        return null;
    }

    @Override
    public ModelAndView toUpdate(Integer id) {
        return null;
    }

    @Override
    public ModelAndView update(SmsEmail smsEmail) {
        return null;
    }

    @Override
    public String list(SmsEmail smsEmail, int currentPage, int pageSize) {
        return null;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/list")
    @ResponseBody
    public String list(@RequestBody SmsEmailVo<SmsEmail> smsEmailVo) {
        ResultEntity re = getResultEntity();
        ResultVo resultVo = null;

        PageVo<SmsEmail> pageVo = smsEmailVo.getPageVo();
        if(pageVo.getCurrentPage()>0){
            pageVo.setCurrentPage(pageVo.getCurrentPage());
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageVo.getPageSize()>0){
            pageVo.setPageSize(pageVo.getPageSize());
        }
        try {
            resultVo = smsEmailService.listByPaging(smsEmailVo);
            re.setData(pageVo);
            re.setResultCode("0000");
            re.setResultMsg("success");
        } catch (Exception e) {
            re.setResultCode("9999");
            re.setResultMsg("网络异常，稍后重试！");
            logger.error("查询异常！",e);
        }


        return resultVo.toString();
    }

    @RequestMapping(value = STATIC_BASE_URL+"/delete/{id}")
    @ResponseBody
    @Override
    public String delete(@PathVariable Integer id) {
        ResultEntity re = getResultEntity();
        try {
            int resultId = smsEmailService.deleteObjectById(id);
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
