package com.hexiaofei.provider0.service;

import com.hexiaofei.provider0.domain.SjzDomainInfo;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.IBaseService;
import com.hexiaofei.provider0.vo.PageVo;

import java.util.Date;

public interface SjzDomainInfoService extends IBaseService<SjzDomainInfo> {

    /**
     * 获取等待抓取域名的列表
     * @param pageVo
     * @return
     * @throws PlatformException
     */
    public PageVo<SjzDomainInfo> getPageVoSjzDomainInfoForWaitCrawl(PageVo<SjzDomainInfo> pageVo,SjzDomainInfo sjzDomainInfo) throws PlatformException;

    /**
     * 获取等待抓取域名的总数
     * @param sjzDomainInfo
     * @return
     */
    public int getCountByWaitCrawl(SjzDomainInfo sjzDomainInfo);

    /**
     * 根据抓取结果更新域名信息
     * @param sjzDomainInfo
     * @return
     */
    public int updateByCrawlResult(SjzDomainInfo sjzDomainInfo);

    /**
     * 根据url 更新状态
     * @param url
     * @param lastCrawlTime
     * @param domainName
     * @param status
     * @param crawlUseTime
     * @return
     */
    public int updateStatusByUrl(String url, Date lastCrawlTime, String domainName, Short status, Integer crawlUseTime);
}
