package com.hexiaofei.provider0.web.admin;

import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.domain.UserInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.UserInfoService;
import com.hexiaofei.provider0.vo.PageVo;
import com.hexiaofei.provider0.web.AbstractBaseController;
import com.hexiaofei.provider0.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/17.
 */
@Controller
public class AdminUserInfoController extends AdminBaseController implements BaseController<UserInfo> {

    private final static Logger LOGGER = LoggerFactory.getLogger(AdminUserInfoController.class);

    private final static String BASE_URL = "userInfo";

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(BASE_URL+"/{id}")
    @ResponseBody
    public String findUserInfoById(@PathVariable Integer id){
        ResultEntity re = getResultEntity();


        try {
            UserInfo user = userInfoService.getObjectById(id);

            TimeUnit.MILLISECONDS.sleep(100);
            re.setResultCode("000000");
            re.setResultMsg("success");
            re.setData(user);
        }catch (PlatformException e){
            re.setResultCode("999999");
            re.setResultMsg("系统异常！");
            e.printStackTrace();
        }catch (InterruptedException e) {
            re.setResultCode("999999");
            re.setResultMsg("系统异常！");
            e.printStackTrace();
        }
        LOGGER.info("【{}】查询客户id={},详情{}",id,re.toString());
        return re.toString();
    }

    @RequestMapping(value = BASE_URL+"/index")
    @Override
    public String index() {
        return BASE_URL+"/userInfoIndex";
    }

    @RequestMapping(value = BASE_URL+"/toAdd")
    @Override
    public String toAdd() {
        return null;
    }

    @RequestMapping(value = BASE_URL+"/add")
    @Override
    public String add(UserInfo o) {
        return null;
    }

    @RequestMapping(value = BASE_URL+"/toUpdate")
    @Override
    public ModelAndView toUpdate(Integer id) {
        return null;
    }

    @RequestMapping(value = BASE_URL+"/list/{currentPage}_{pageSize}")
    @Override
    @ResponseBody
    public String listEventIndex(UserInfo o,@PathVariable int currentPage,@PathVariable int pageSize) {
        ResultEntity re = getResultEntity();

        PageVo pageVo = new PageVo<UserInfo>();
        if(currentPage>0){
            pageVo.setCurrentPage(currentPage);
        }else{
            pageVo.setCurrentPage(1);
        }
        if(pageSize>0){
            pageVo.setPageSize(pageSize);
        }
        try {
            pageVo = userInfoService.getPageVoObject(pageVo);
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

    @RequestMapping(value = BASE_URL+"/delete/{id}")
    @Override
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        ResultEntity re = getResultEntity();
        try {
            int resultId = userInfoService.deleteObjectById(id);
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

    @RequestMapping(value = BASE_URL+"/update")
    @Override
    public ModelAndView update(UserInfo userInfo) {
        return null;
    }
}
