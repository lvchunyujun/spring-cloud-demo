package com.hexiaofei.provider0.web;


import com.hexiaofei.provider0.domain.SjzEventContent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/eventIndex")
public class SjzEventContentController extends AbstractBaseController implements BaseController<SjzEventContent>{

    @Override
    public String index() {
        return null;
    }

    @Override
    public String toAdd() {
        return null;
    }

    @Override
    public String add(SjzEventContent sjzEventContent) {
        return null;
    }

    @Override
    public ModelAndView toUpdate(Integer id) {
        return null;
    }

    @Override
    public ModelAndView update(SjzEventContent sjzEventContent) {
        return null;
    }

    @Override
    public String list(SjzEventContent sjzEventContent, int currentPage, int pageSize) {
        return null;
    }

    @Override
    public String delete(Integer id) {
        return null;
    }


}
