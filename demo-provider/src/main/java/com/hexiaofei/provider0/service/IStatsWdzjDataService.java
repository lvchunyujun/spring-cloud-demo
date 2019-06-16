package com.hexiaofei.provider0.service;

import com.hexiaofei.provider0.domain.StatsWdzjData;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 * @author  hexiaofei
 * 统计网贷之家数据
 */
public interface IStatsWdzjDataService {

    void save(StatsWdzjData statsWdzjData);
    /**
     * 处理抓取数据
     * @param list
     * @throws Exception
     */
    void saveStatsWdzjDataHandler(List<StatsWdzjData> list) throws Exception;

    /**
     * 查询抓取数据列表更具指定日期
     * @param beginTime
     * @param endTime
     * @return
     */
    List<StatsWdzjData> findAllStatsWdzjDataByDt(String beginTime, String endTime);

    /**
     * 统计民信贷、网贷之家利率指数
     */
    void statsWdzjDataHandler();
}
