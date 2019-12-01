package com.hexiaofei.sjzclient.service;


import com.hexiaofei.sjzclient.domain.StatsIncomeInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 * 民信贷收益统计接口
 */
public interface IStatsIncomeInfoService {

    /**
     * 保存统计信息
     * @param statsIncomeInfo
     * @throws Exception
     */
    void saveStatsIncomeInfo(StatsIncomeInfo statsIncomeInfo) throws Exception;

    /**
     * 批量保存昨日收益统计
     */
    void saveYesterdayIncomeForBatchHandler();

    /**
     * 统计民信贷昨天历史收益(民信贷指数接口_1)
     * @throws Exception
     */
    void statsIncomeInfoForYesterday() throws Exception;

    /**
     * 获取指定日期的民信贷统计数据
     * @param beginTime
     * @param endTime
     * @return
     */
    List<StatsIncomeInfo> findStatsIncomeInfoByDt(String beginTime, String endTime);
}
