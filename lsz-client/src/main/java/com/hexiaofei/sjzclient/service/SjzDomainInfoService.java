package com.hexiaofei.sjzclient.service;

import com.hexiaofei.sjzclient.domain.SjzDomainInfo;
import com.hexiaofei.sjzclient.exception.PlatformException;
import com.hexiaofei.sjzclient.service.base.IBaseService;
import com.hexiaofei.sjzclient.vo.PageVo;

import java.util.Date;
import java.util.List;

public interface SjzDomainInfoService extends IBaseService<SjzDomainInfo> {

    /**
     * 获取等待抓取域名的列表
     * @param pageVo
     * @return
     * @throws PlatformException
     */
    PageVo<SjzDomainInfo> getPageVoSjzDomainInfoForWaitCrawl(PageVo<SjzDomainInfo> pageVo, SjzDomainInfo sjzDomainInfo) throws PlatformException;

    /**
     * 获取等待抓取域名的列表 查询没有抓取的，不按时间
     * @param pageVo
     * @param sjzDomainInfo
     * @return
     * @throws PlatformException
     */
    PageVo<SjzDomainInfo> getPageVoSjzDomainInfoForWaitCrawl1(PageVo<SjzDomainInfo> pageVo, SjzDomainInfo sjzDomainInfo)throws PlatformException;;

    /**
     *
     * @param sjzDomainInfo
     * @return
     */
    int getCountByWaitCrawl1(SjzDomainInfo sjzDomainInfo);
    /**
     * 获取等待抓取域名的总数
     * @param sjzDomainInfo
     * @return
     */
    int getCountByWaitCrawl(SjzDomainInfo sjzDomainInfo);

    /**
     * 根据抓取结果更新域名信息
     * @param sjzDomainInfo
     * @return
     */
    int updateByCrawlResult(SjzDomainInfo sjzDomainInfo);

    /**
     * 根据url 更新状态
     * @param url
     * @param lastCrawlTime
     * @param domainName
     * @param status
     * @param crawlUseTime
     * @return
     */
    int updateStatusByUrl(String url, Date lastCrawlTime, String domainName, Short status, Integer crawlUseTime);

    /**
     * 如果域名不存在则添加域名对象
     * @param sjzDomainInfo
     * @return
     */
    int addObjectForNotExist(SjzDomainInfo sjzDomainInfo)throws PlatformException;

    /**
     *
     * @param url
     * @return
     * @throws PlatformException
     */
    SjzDomainInfo getObjectForUrl(String url) throws PlatformException;


    List<SjzDomainInfo> getListByNewUrl(int pageSize, int currentPage) throws PlatformException;
}
