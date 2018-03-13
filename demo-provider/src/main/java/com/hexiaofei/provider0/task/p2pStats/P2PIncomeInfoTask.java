package com.hexiaofei.provider0.task.p2pStats;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author
 * Created by Administrator on 2017/7/7.
 * P2P平台网站收益率信息抓取服务
 */
@Service
public class P2PIncomeInfoTask {

    private static final Logger LOGGER = Logger.getLogger(P2PIncomeInfoTask.class);

    private static final int thread_c = 1;


    private static final String lu_domain = "https://list.lu.com/list/dingqi?currentPage=";                       // 陆金所
    private static final String lup2p_domain = "https://www.lup2p.com/lup2p/p2p";
    private static final String yirendai_domain = "https://www.yirendai.com/finance/list/1";                       // 宜人贷_
    private static final String renrendai_domain = "https://www.renrendai.com/loan";                              // 人人贷
    private static final String renrendai_domain_1 = "https://www.renrendai.com/pc/p2p/uPlan/getFinancePlanList?startNum=0&limit=10&_=1499757167527";  // 人人贷_
    private static final String renrendai_domain_2 = "https://www.renrendai.com/lend/loanList!json.action?&_=1499574054780&pageIndex=";               // 人人贷_
    private static final String my089_domain = "https://investment.my089.com/credit";                // 红岭创投(证书)
    private static final String weidai_domain = "https://www.weidai.com.cn/list/showApList.html";    // 微贷网(证书)
    private static final String weidai_domain_1 = "https://www.weidai.com.cn/list/assetPacketList?type=0&periodType=0&rows=10&page=";    // 微贷网_
    private static final String weidai_domain_2 = "https://www.weidai.com.cn/list/bidList?type=0&periodType=0&sort=0&rows=10&page=";     // 微贷网_
    private static final String yooli_domain = "https://www.yooli.com/dingcunbao/";                   // 有利网
    private static final String eloancn_domain = "https://licai.eloancn.com/ynjh/";                  // 翼龙贷

    private static final String eloancn_domain_1 = "https://licai.eloancn.com/pcgway/gateway/v1/01?requesturl=%2Fappwmps%2Fapp004%2Fv2%2F01&platform=5&v=0.6299485266672507&pageNo="; // 翼龙贷_
    private static final String jimu_domain = "https://box.jimu.com/Project/List";                     // 积木盒子
    private static final String dianrong_domain = "https://www.dianrong.com/market";                   // 点融网（非定期产品）
    private static final String xinhehui_domain = "https://www.xinhehui.com/Financing/Invest/plist3";  // 鑫合汇（天标）


    /**
     * 统计民信贷平台过往平均收益率
     */
    public void autoStatsIncomeInfo(){
        LOGGER.info("【统计民信贷历史收益率】-->");
        try {
        } catch (Exception e) {
            LOGGER.error("【统计民信贷历史收益率】   异常！",e);
        }
        LOGGER.info("【统计民信贷历史收益率】<--");
    }

    /**
     * 自动抓取10大P2P平台数据
     */
    public void autoP2PIncomeInfo(){
        LOGGER.info("【抓取P2P平台】-->   ");

        int p2pCount = 5;

        long st = System.currentTimeMillis();

        // 抓取完成，统计数据
        if(p2pCount == 0){
            long et = System.currentTimeMillis();
            LOGGER.info("【抓取P2P平台】    完成  耗时："+((et-st)/1000)+"S  ");
        }else{
            LOGGER.info("【抓取P2P平台】  ");
        }
        LOGGER.info("【抓取P2P平台】<-- ");
    }

    /**
     * 自动抓取网贷之家数据
     */
    public void autoStatsWdzjDate(){
        String wdzj_domain = "http://shuju.wdzj.com";                                 // 网贷之家

        long st = System.currentTimeMillis();
        LOGGER.info("【抓取网贷之家】-->   ");
        // step1 抓取数据

        LOGGER.info("【抓取网贷之家】<-- ");
    }
}
