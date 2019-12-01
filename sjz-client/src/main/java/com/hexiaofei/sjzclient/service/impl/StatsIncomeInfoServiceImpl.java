package com.hexiaofei.sjzclient.service.impl;

import com.hexiaofei.sjzclient.domain.StatsIncomeInfo;
import com.hexiaofei.sjzclient.service.IStatsIncomeInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("statsIncomeInfoService")
public class StatsIncomeInfoServiceImpl implements IStatsIncomeInfoService {
    @Override
    public void saveStatsIncomeInfo(StatsIncomeInfo statsIncomeInfo) throws Exception {

    }

    @Override
    public void saveYesterdayIncomeForBatchHandler() {

    }

    @Override
    public void statsIncomeInfoForYesterday() throws Exception {

    }

    @Override
    public List<StatsIncomeInfo> findStatsIncomeInfoByDt(String beginTime, String endTime) {
        return null;
    }
}
