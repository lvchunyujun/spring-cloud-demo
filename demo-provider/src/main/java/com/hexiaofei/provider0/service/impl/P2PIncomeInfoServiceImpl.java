package com.hexiaofei.provider0.service.impl;

import com.hexiaofei.provider0.domain.P2PIncomeInfo;
import com.hexiaofei.provider0.service.IP2PIncomeInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("p2PIncomeInfoService")
public class P2PIncomeInfoServiceImpl implements IP2PIncomeInfoService {
    @Override
    public void saveP2PIncomeInfoHandler(P2PIncomeInfo p2PIncomeInfo) {

    }

    @Override
    public void findP2PIncomeForStats() {

    }
}
