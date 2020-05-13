package com.hexiaofei.sjzclient.web.my;

import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.UserInfoService;
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
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/17.
 */
@Controller
public class UserInfoController extends MyBaseController implements BaseController<UserInfo> {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    private final static String BASE_URL = "userInfo";

    @Autowired
    private UserInfoService userInfoService;

    // 欢迎页面
    @RequestMapping("/welcome")
    public String welcome(){

        return "/my/index";
    }

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
        return BASE_URL+"/toAddUserInfo";
    }

    @RequestMapping(value = BASE_URL+"/add")
    @Override
    public String add(UserInfo userInfo) {
        int resultId = -1;
        try {

            // step1: 检查正则表达式是否存在、


            // step2: 序号是否正确


            userInfo.setRegisterDate(new Date());
            resultId = userInfoService.addObject(userInfo);
        } catch (PlatformException e) {
            LOGGER.error("查询异常！",e);
        }

        if(resultId>0){
            return ADD_SUCCESS_URL;
        }else{
            return ADD_FAIL_URL;
        }
    }

    @Override
    public ResultVo<UserInfo> add(HttpServletRequest request, UserInfo userInfo) {
        return null;
    }

    @RequestMapping(value = BASE_URL+"/toUpdate/{id}")
    @Override
    public ModelAndView toUpdate(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView(BASE_URL+"/toUpdateUserInfo");
        try {
            UserInfo userInfo = userInfoService.getObjectById(id);
            modelAndView.addObject("userInfo",userInfo);
        } catch (PlatformException e) {
            LOGGER.error("查询异常！",e);
        }

        return modelAndView;
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

    @RequestMapping(value = BASE_URL+"/update",method = RequestMethod.POST)
    @Override
    public ModelAndView update(UserInfo userInfo) {
        ModelAndView modelAndView = new ModelAndView(BASE_URL+"/toUpdateUserInfo");
        try {
            userInfoService.updateObject(userInfo);
            UserInfo targetUserInfo = userInfoService.getObjectById(userInfo.getId());
            modelAndView.addObject("userInfo",targetUserInfo);
        } catch (PlatformException e) {
            LOGGER.error("查询异常！",e);
        }

        return modelAndView;
    }

    @RequestMapping(value = BASE_URL+"/record")
    public ModelAndView recordInfo(HttpServletRequest request){
        LOGGER.info("【查看个人信息】--> ");
        ModelAndView modelAndView = new ModelAndView("/my/"+BASE_URL+"/recordInfo");
        UserInfo userInfo = getLoginUserInfo(request);

        try {
            UserInfo recordInof = userInfoService.getObjectById(userInfo.getId());
            modelAndView.addObject("nickName",recordInof.getNickName());
            modelAndView.addObject("userName",recordInof.getUserName());
            modelAndView.addObject("email",recordInof.getEmail());
            modelAndView.addObject("phone",recordInof.getPhone());
        } catch (PlatformException e) {
            LOGGER.error("【查看个人信息】 异常！",e);
        }

        LOGGER.info("【查看个人信息】<-- ");
        return modelAndView;
    }
}
