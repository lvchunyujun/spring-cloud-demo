package com.hexiaofei.sjzclient.service;

import com.hexiaofei.AbstractTest;
import com.hexiaofei.sjzclient.common.SjzEventStateEnum;
import com.hexiaofei.sjzclient.domain.SjzEventIndex;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.vo.PageVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SjzEventIndexServiceImplTest extends AbstractTest {


    @Autowired
    private SjzEventIndexService sjzEventIndexService;

    @Test
    public void addEventIndexAndUser() {
    }

    @Test
    public void getPageVoObjectBySjzEventIndex() throws PlatformException {

        SjzEventIndex sjzEventIndex = new SjzEventIndex();
        sjzEventIndex.setEventState(SjzEventStateEnum.RELEASE.getStatus());

        PageVo<SjzEventIndex> pageVo = new PageVo();
        pageVo.setCurrentPage(1);
        pageVo.setPageSize(5);

        pageVo = sjzEventIndexService.getPageVoObjectBySjzEventIndex(sjzEventIndex,pageVo);

        Assert.assertTrue("查询失败！",pageVo.getVoList().size()>0);
    }

    @Test
    public void addObject() {
    }

    @Test
    public void deleteObjectById() {
    }

    @Test
    public void updateObject() {
    }

    @Test
    public void getObjectById() {
    }

    @Test
    public void getPageVoObject() {
    }

    @Test
    public void getAllObject() {
    }
}