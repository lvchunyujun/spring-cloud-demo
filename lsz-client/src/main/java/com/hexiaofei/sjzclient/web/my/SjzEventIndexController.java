package com.hexiaofei.sjzclient.web.my;

import com.hexiaofei.sjzclient.common.EnumEventType;
import com.hexiaofei.sjzclient.common.EnumSjzEventState;
import com.hexiaofei.sjzclient.domain.SjzEventAuthor;
import com.hexiaofei.sjzclient.domain.SjzEventIndex;
import com.hexiaofei.sjzclient.domain.SjzSpiderWebsite;
import com.hexiaofei.sjzclient.domain.UserInfo;
import com.hexiaofei.sjzclient.exception.IllegalPlatformAugumentException;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.ISjzEventIndexService;
import com.hexiaofei.sjzclient.vo.PageVo;
import com.hexiaofei.sjzclient.web.BaseController;
import com.lcyj.common.consts.EnumResultCode;
import com.lcyj.common.consts.LszSystemConsts;
import com.lcyj.common.utils.DateUtils;
import com.lcyj.common.vo.ResultVo;
import com.lcyj.common.vo.event.SjzEventIndexVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class SjzEventIndexController extends MyBaseController implements BaseController<SjzEventIndex> {

    public static Logger LOGGER = LoggerFactory.getLogger(SjzDomainInfoController.class);

    private final static String STATIC_BASE_URL = "eventIndex";

    @Autowired
    private ISjzEventIndexService sjzEventIndexService;

    @RequestMapping(value = STATIC_BASE_URL+"/index")
    public ModelAndView index(SjzEventIndex sjzEventIndex,Integer currentPage,Integer pageSize){
        ModelAndView modelAndView = new ModelAndView("my/"+STATIC_BASE_URL+"/index");
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
            LOGGER.error("查询异常！",e);
        }

        return modelAndView;
    }

    @Override
    public String index() {
        return null;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/toAdd")
    @Override
    public String toAdd() {
        return "my/"+STATIC_BASE_URL+"/toAdd";
    }

    @Override
    public String add(SjzEventIndex sjzEventIndex) {
        return null;
    }

    /**
     * 添加事件
     * @param sjzEventIndex
     * @return
     */
    public ResultVo<SjzEventIndex> add(HttpServletRequest request,@RequestBody SjzEventIndex sjzEventIndex) {
        LOGGER.info("【增加事件】-->");

        int resultId = -1;
        SjzEventAuthor sjzEventAuthor = null;
        SjzSpiderWebsite sjzSpiderWebsite = null;
        ResultVo<SjzEventIndex> resultVo = new ResultVo<SjzEventIndex>("9999");

        try {

            resultVo.setData(sjzEventIndex);
            if(sjzEventIndex.getEventTime() == null){
                resultVo.setResultMsg("事件日期不能为空！");

                return resultVo;
            }

            if(StringUtils.isBlank(sjzEventIndex.getEventContent())){
                resultVo.setResultMsg("事件内容不能为空！");
                return resultVo;
            }

            if(sjzEventIndex.getEventContent().length() > 500){
                resultVo.setResultMsg("事件内容不能超过500个字符！");
                return resultVo;
            }

            // 1. 添加事件: 待审核状态
            sjzEventIndex.setEventState((byte)EnumSjzEventState.CHECK.getStatus());
            sjzEventIndex.setRecordCreateTime(new Date());
            sjzEventIndex.setEventType(EnumEventType.TEXT.getType());

            // 2. 作者
            UserInfo userInfo = getLoginUserInfo(request);
            sjzEventAuthor = new SjzEventAuthor();
            sjzEventAuthor.setUserId(userInfo.getId());
            sjzEventAuthor.setCreateTime(new Date());
            sjzEventAuthor.setNickName(userInfo.getNickName());

            sjzEventIndexService.addObject(sjzEventIndex,sjzSpiderWebsite,sjzEventAuthor);
            resultVo.setResultCode("0000");
            resultVo.setResultMsg("添加事件成功！");
            LOGGER.info("【增加事件】<--  success:");
        } catch (Exception e) {
            LOGGER.error("添加事件出现异常!",e);
            resultVo.setResultMsg("出现异常，稍后再试！");
        }

        return resultVo;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/add",method = RequestMethod.POST)
    @ResponseBody
    public ResultVo add(HttpServletRequest request,@RequestBody SjzEventIndexVo sjzEventIndexVo,Model model){
        LOGGER.info("【增加事件】-->");
        int resultId = -1;
        SjzEventAuthor sjzEventAuthor = null;
        SjzSpiderWebsite sjzSpiderWebsite = null;
        ResultVo<SjzEventIndex> resultVo = new ResultVo<SjzEventIndex>("9999");
        try {
            if(sjzEventIndexVo.getEventTime() == null || sjzEventIndexVo.getEventTime().trim().length() == 0){

                resultVo.setResultCode(EnumResultCode.EVENT_DATE_NULL.getCode());
                resultVo.setResultMsg(EnumResultCode.EVENT_DATE_NULL.getMsg());
                return resultVo;
            }
            sjzEventIndexVo.setEventTime(sjzEventIndexVo.getEventTime().trim());
            Date eventTime = DateUtils.parseStrToDate(sjzEventIndexVo.getEventTime());
            if(eventTime == null){
                resultVo.setResultCode(EnumResultCode.EVENT_DATE_FORMAT_ERROR.getCode());
                resultVo.setResultMsg(EnumResultCode.EVENT_DATE_FORMAT_ERROR.getMsg());
                return resultVo;
            }

            if(StringUtils.isBlank(sjzEventIndexVo.getEventContent())){
                resultVo.setResultCode(EnumResultCode.EVENT_CONTENT_NULL.getCode());
                resultVo.setResultMsg(EnumResultCode.EVENT_CONTENT_NULL.getMsg());
                return resultVo;
            }
            if(sjzEventIndexVo.getEventContent().trim().length() < LszSystemConsts.EVENT_CONTENT_MIN_LENGTH){
                resultVo.setResultCode(EnumResultCode.EVENT_CONTENT_MIN_ERROR.getCode());
                resultVo.setResultMsg(EnumResultCode.EVENT_CONTENT_MIN_ERROR.getMsg()+",最少"+LszSystemConsts.EVENT_CONTENT_MIN_LENGTH+"字符");
                return resultVo;
            }

            if(sjzEventIndexVo.getEventContent().length() > LszSystemConsts.EVENT_CONTENT_MAX_LENGTH){
                resultVo.setResultCode(EnumResultCode.EVENT_CONTENT_MAX_ERROR.getCode());
                resultVo.setResultMsg(EnumResultCode.EVENT_CONTENT_MAX_ERROR.getMsg()+",最多"+LszSystemConsts.EVENT_CONTENT_MAX_LENGTH+"字符");
                return resultVo;
            }

            SjzEventIndex sjzEventIndex = resolveVoToBo(sjzEventIndexVo);
            // 1. 添加事件: 待审核状态
            sjzEventIndex.setEventState((byte)EnumSjzEventState.CHECK.getStatus());
            sjzEventIndex.setRecordCreateTime(new Date());
            sjzEventIndex.setEventType(EnumEventType.TEXT.getType());

            // 2. 作者
            UserInfo userInfo = getLoginUserInfo(request);
            sjzEventAuthor = new SjzEventAuthor();
            sjzEventAuthor.setUserId(userInfo.getId());
            sjzEventAuthor.setCreateTime(new Date());
            sjzEventAuthor.setNickName(userInfo.getNickName());

            sjzEventIndexService.addObject(sjzEventIndex,sjzSpiderWebsite,sjzEventAuthor);
            resultVo.setResultCode(EnumResultCode.SUCCESS.getCode());
            resultVo.setResultMsg("/my/eventIndex/index");  // 成功跳转连接
            LOGGER.info("【增加事件】<--  success:");
        }catch (Exception e) {
            LOGGER.error("添加事件出现异常!",e);
            resultVo.setResultCode(EnumResultCode.FAILED.getCode());
            resultVo.setResultMsg(EnumResultCode.FAILED.getMsg());
        }

        return resultVo;
    }


    @RequestMapping(value = STATIC_BASE_URL+"/toUpdate/{id}")
    @Override
    public ModelAndView toUpdate(@PathVariable Integer id) {
        ModelAndView modelAndView =
                new ModelAndView("my/"+STATIC_BASE_URL+"/toUpdate");
        try {
            SjzEventIndex sjzEventIndex = sjzEventIndexService.getObjectById(id);
            if(sjzEventIndex!=null)
                modelAndView.addObject(sjzEventIndex);
        }catch (PlatformException e){

        }

        return modelAndView;
    }

    @Override
    public ModelAndView update(SjzEventIndex sjzEventIndex) {
        return null;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/update",method = RequestMethod.POST)
    @ResponseBody
    public ResultVo<SjzEventIndex> update(HttpServletRequest request,@RequestBody SjzEventIndexVo sjzEventIndexVo, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        ResultVo<SjzEventIndex> resultVo = new ResultVo<SjzEventIndex>("9999");
        int resultId = -1;
        try {
            if(sjzEventIndexVo.getEventTime() == null || sjzEventIndexVo.getEventTime().trim().length() == 0){

                resultVo.setResultCode(EnumResultCode.EVENT_DATE_NULL.getCode());
                resultVo.setResultMsg(EnumResultCode.EVENT_DATE_NULL.getMsg());
                return resultVo;
            }
            sjzEventIndexVo.setEventTime(sjzEventIndexVo.getEventTime().trim());
            Date eventTime = DateUtils.parseStrToDate(sjzEventIndexVo.getEventTime());
            if(eventTime == null){
                resultVo.setResultCode(EnumResultCode.EVENT_DATE_FORMAT_ERROR.getCode());
                resultVo.setResultMsg(EnumResultCode.EVENT_DATE_FORMAT_ERROR.getMsg());
                return resultVo;
            }

            if(StringUtils.isBlank(sjzEventIndexVo.getEventContent())){
                resultVo.setResultCode(EnumResultCode.EVENT_CONTENT_NULL.getCode());
                resultVo.setResultMsg(EnumResultCode.EVENT_CONTENT_NULL.getMsg());
                return resultVo;
            }
            if(sjzEventIndexVo.getEventContent().trim().length() < LszSystemConsts.EVENT_CONTENT_MIN_LENGTH){
                resultVo.setResultCode(EnumResultCode.EVENT_CONTENT_MIN_ERROR.getCode());
                resultVo.setResultMsg(EnumResultCode.EVENT_CONTENT_MIN_ERROR.getMsg()+",最少"+LszSystemConsts.EVENT_CONTENT_MIN_LENGTH+"字符");
                return resultVo;
            }

            if(sjzEventIndexVo.getEventContent().trim().length() > LszSystemConsts.EVENT_CONTENT_MAX_LENGTH){
                resultVo.setResultCode(EnumResultCode.EVENT_CONTENT_MAX_ERROR.getCode());
                resultVo.setResultMsg(EnumResultCode.EVENT_CONTENT_MAX_ERROR.getMsg()+",最多"+LszSystemConsts.EVENT_CONTENT_MAX_LENGTH+"字符");
                return resultVo;
            }

            SjzEventIndex sjzEventIndex = resolveVoToBo(sjzEventIndexVo);
            sjzEventIndexService.updateObject(sjzEventIndex);
            resultVo.setResultCode(EnumResultCode.SUCCESS.getCode());
            resultVo.setResultMsg("/my/"+STATIC_BASE_URL+"/index");
            sjzEventIndex = sjzEventIndexService.getObjectById(sjzEventIndex.getId());
            if(sjzEventIndex!=null){
                modelAndView.addObject(sjzEventIndex);
            }
            modelAndView.addObject("resultCode","0");
            modelAndView.addObject("resultMsg","修改成功！");
        }catch (PlatformException e){

        }

        return resultVo;
    }

    @Override
    public String listEventIndex(SjzEventIndex sjzEventIndex, int currentPage, int pageSize) {
        return null;
    }

    @Override
    public String delete(Integer id) {
        return null;
    }

    @RequestMapping(value = STATIC_BASE_URL+"/list/{currentPage}_{pageSize}")
    @ResponseBody
    public String listEventIndex(HttpServletRequest request, SjzEventIndex sjzEventIndex, @PathVariable int currentPage, @PathVariable int pageSize) {
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

            UserInfo userInfo = getLoginUserInfo(request);

            pageVo = sjzEventIndexService.getPageVoObjectByAuthorId(userInfo.getId(),null,pageVo);
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
    public ResultVo<SjzEventIndex> deleteById(@PathVariable("id") Integer id) {
        ResultEntity re = getResultEntity();
        ResultVo<SjzEventIndex> resultVo = new ResultVo<SjzEventIndex>();
        try {
            SjzEventIndex sjzEventIndex = sjzEventIndexService.getObjectById(id);
            if(EnumSjzEventState.CHECK_SUCCESS.getStatus() == sjzEventIndex.getEventState() ){
                resultVo.setResultCode(EnumResultCode.EVENT_DATE_NULL.getCode());
                resultVo.setResultMsg(EnumSjzEventState.CHECK_SUCCESS.getDescription()+"状态,"+EnumResultCode.EVENT_DELETE_NOT.getMsg());
            }else if(EnumSjzEventState.RELEASE.getStatus() == sjzEventIndex.getEventState()){
                resultVo.setResultCode(EnumResultCode.EVENT_DATE_NULL.getCode());
                resultVo.setResultMsg(EnumSjzEventState.RELEASE.getDescription()+"状态,"+EnumResultCode.EVENT_DELETE_NOT.getMsg());
            }else{
                int resultId = sjzEventIndexService.deleteObjectById(id);
                if(resultId > 0){
                    resultVo.setResultCode(EnumResultCode.SUCCESS.getCode());
                    resultVo.setResultMsg(EnumResultCode.SUCCESS.getMsg());
                }
            }
        } catch (PlatformException e) {
            LOGGER.error("删除事件异常",e);
            resultVo.setResultCode(EnumResultCode.FAILED.getCode());
            resultVo.setResultMsg(EnumResultCode.FAILED.getMsg());

        }
        return resultVo;
    }

    /**
     * 将bo转换成实体类
     * @param sjzEventIndexVo
     * @return
     * @throws IllegalPlatformAugumentException
     */
    private SjzEventIndex resolveVoToBo(SjzEventIndexVo sjzEventIndexVo) throws IllegalPlatformAugumentException {

        SjzEventIndex sjzEventIndex = new SjzEventIndex();
        sjzEventIndex.setId(sjzEventIndexVo.getId());
        Date eventTime = DateUtils.parseStrToDate(sjzEventIndexVo.getEventTime());
        if(eventTime == null){
           throw new IllegalPlatformAugumentException("日期格式错误！");
        }
        sjzEventIndex.setEventTime(eventTime);
        sjzEventIndex.setEventType(sjzEventIndexVo.getEventType());
        sjzEventIndex.setEventContent(sjzEventIndexVo.getEventContent());
        sjzEventIndex.setEventState(sjzEventIndexVo.getEventState());
        sjzEventIndex.setRecordCreateTime(sjzEventIndexVo.getRecordCreateTime());
        return sjzEventIndex;
    }
}
