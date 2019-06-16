package com.hexiaofei.provider0.service;


import com.hexiaofei.provider0.domain.P2PIncomeInfo;


/**
 * @author  hexiaofei
 * Created by Administrator on 2017/7/7.
 * P2P平台网站收益率信息抓取服务
 */
public interface IP2PIncomeInfoService {

    /**
     *  抓取收益率信息入库
     * @param p2PIncomeInfo
     */
    void saveP2PIncomeInfoHandler(P2PIncomeInfo p2PIncomeInfo);

    /**
     * 统计当天抓取10大p2p平台收益情况
     *   平均收益
     *   最高收益
     *   最低收益
     */
    void findP2PIncomeForStats();
}
