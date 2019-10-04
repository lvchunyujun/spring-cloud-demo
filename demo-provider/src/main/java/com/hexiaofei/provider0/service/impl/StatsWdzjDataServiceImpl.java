package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.domain.StatsWdzjData;
import com.hexiaofei.provider0.service.IStatsWdzjDataService;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("statsWdzjDataService")
public class StatsWdzjDataServiceImpl implements IStatsWdzjDataService {
    @Override
    public void save(StatsWdzjData statsWdzjData) {

        MyBatisCursorItemReader myBatisCursorItemReader;

    }

    @Override
    public void saveStatsWdzjDataHandler(List<StatsWdzjData> list) throws Exception {

    }

    @Override
    public List<StatsWdzjData> findAllStatsWdzjDataByDt(String beginTime, String endTime) {
        return null;
    }

    @Override
    public void statsWdzjDataHandler() {

    }
}
