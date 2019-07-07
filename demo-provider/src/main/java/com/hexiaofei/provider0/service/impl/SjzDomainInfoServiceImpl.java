package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.dao.mapper.SjzDomainInfoMapper;
import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzDomainInfoService;
import com.hexiaofei.provider0.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service("sjzDomainInfoService")
public class SjzDomainInfoServiceImpl implements SjzDomainInfoService {

    @Autowired
    private SjzDomainInfoMapper sjzDomainInfoMapper;
    @Override
    public int addObject(SjzDomainInfo mob) throws PlatformException {
        int result = sjzDomainInfoMapper.insert(mob);
        return result;
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return 0;
    }

    @Override
    public int updateObject(SjzDomainInfo mob) throws PlatformException {
        return 0;
    }

    @Override
    public SjzDomainInfo getObjectById(int id) throws PlatformException {
        return null;
    }

    @Override
    public PageVo<SjzDomainInfo> getPageVoObject(PageVo<SjzDomainInfo> pageVo) throws PlatformException {


        return null;
    }

    @Override
    public List<SjzDomainInfo> getAllObject() throws PlatformException {
        return null;
    }


    @Override
    public PageVo<SjzDomainInfo> getPageVoSjzDomainInfoForWaitCrawl(PageVo<SjzDomainInfo> pageVo, SjzDomainInfo sjzDomainInfo) throws PlatformException {


        // step1: 总记录条数
        int recordCount = sjzDomainInfoMapper.selectCountByPaging(sjzDomainInfo.getCrawlStatus(),sjzDomainInfo.getLastCrawlTime());
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;

        List<SjzDomainInfo> list = sjzDomainInfoMapper.selectListByPaging(sjzDomainInfo.getCrawlStatus(),sjzDomainInfo.getLastCrawlTime(),offset*pageVo.getPageSize(),pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public PageVo<SjzDomainInfo> getPageVoSjzDomainInfoForWaitCrawl1(PageVo<SjzDomainInfo> pageVo, SjzDomainInfo sjzDomainInfo) throws PlatformException {
        // step1: 总记录条数
        int recordCount = sjzDomainInfoMapper.selectCountByPaging1(sjzDomainInfo);
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;

        List<SjzDomainInfo> list = sjzDomainInfoMapper.selectListByPaging1(sjzDomainInfo,offset*pageVo.getPageSize(),pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public int getCountByWaitCrawl1(SjzDomainInfo sjzDomainInfo) {
        int resourceId = sjzDomainInfoMapper.selectCountByPaging1(sjzDomainInfo);
        return resourceId;
    }

    @Override
    public int getCountByWaitCrawl(SjzDomainInfo sjzDomainInfo) {
        int recordCount = sjzDomainInfoMapper.selectCountByPaging(sjzDomainInfo.getCrawlStatus(),sjzDomainInfo.getLastCrawlTime());
        return recordCount;
    }

    @Override
    public int updateByCrawlResult(SjzDomainInfo sjzDomainInfo) {
        int resut = sjzDomainInfoMapper.updateByCrawlResult(sjzDomainInfo);
        return resut;
    }

    @Override
    public int updateStatusByUrl(String url,Date lastCrawlTime, String domainName, Short crawlStatus, Integer crawlUseTime) {
        SjzDomainInfo sjzDomainInfo = new SjzDomainInfo();


        sjzDomainInfo.setDomainUrl(url);
        sjzDomainInfo.setDomainName(domainName);
        sjzDomainInfo.setLastCrawlTime(lastCrawlTime);
        sjzDomainInfo.setCrawlStatus(crawlStatus);

        sjzDomainInfo.setCrawlUseTime(crawlUseTime);

        int resut = updateByCrawlResult(sjzDomainInfo);
        return resut;
    }


}
