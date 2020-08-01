package com.hexiaofei.provider0.web.admin.spider;

import com.hexiaofei.provider0.service.spider.ISpiderService;
import com.hexiaofei.provider0.web.BaseController;
import com.hexiaofei.provider0.web.admin.AdminBaseController;
import com.lcyj.common.bo.spider.UriBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * 人工操作抓取网站
 * artificial spider
 */
@Controller
public class ArtificialSpiderWebsiteController extends AdminBaseController implements BaseController<HashMap> {

    public static Logger LOGGER = LoggerFactory.getLogger(ArtificialSpiderWebsiteController.class);

    private final static String STATIC_BASE_URL = "/spider/artificial";

    @Autowired
    ISpiderService spiderService;

    @RequestMapping(STATIC_BASE_URL+"/index")
    @Override
    public String index() {
        return STATIC_BASE_URL+"/index";
    }

    @Override
    public String toAdd() {
        return null;
    }

    @Override
    public String add(HashMap sjzSpiderWebsite) {
        return null;
    }

    @Override
    public ModelAndView toUpdate(Integer id) {
        return null;
    }

    @Override
    public ModelAndView update(HashMap sjzSpiderWebsite) {
        return null;
    }

    @ResponseBody
    public String list(HashMap sjzSpiderWebsite, @PathVariable int currentPage,@PathVariable  int pageSize) {
        ResultEntity re = getResultEntity();


        return re.toString();
    }

    @Override
    public String delete(@PathVariable Integer id) {
        ResultEntity re = getResultEntity();

        return re.toString();
    }

    @RequestMapping(STATIC_BASE_URL+"/req")
    @ResponseBody
    public ResultEntity request(String uri,String queue, HttpServletRequest request){
        LOGGER.info("【手动搜索】-->");
        ResultEntity re = getResultEntity();
        // https://www.google.com.hk/search
        // https://www.baidu.com/s
        StringBuffer uriStr = new StringBuffer(uri);
        uriStr.append("?");
        uriStr.append("hl=");
        uriStr.append("zh-CN");

        uriStr.append("&");
        uriStr.append("wd=");
        try {
            uriStr.append(URLEncoder.encode(queue,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        request.getHeader("userAgent");

        UriBO uriBO = new UriBO();
        uriBO.setUri(uriStr.toString());

        spiderService.downloadUrl(uriBO,false);

        re.setResultCode("0000");
        re.setResultMsg("success");
        LOGGER.info("【手动搜索】<--");
        return re;
    }


}
