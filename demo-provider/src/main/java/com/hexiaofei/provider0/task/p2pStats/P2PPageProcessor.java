package com.hexiaofei.provider0.task.p2pStats;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hexiaofei.provider0.common.SpringContextUtil;
import com.hexiaofei.provider0.domain.P2PIncomeInfo;
import com.hexiaofei.provider0.domain.StatsWdzjData;
import com.hexiaofei.provider0.service.IP2PIncomeInfoService;
import com.hexiaofei.provider0.service.IStatsWdzjDataService;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hexiaofei on 2017/7/7.
 */
public class P2PPageProcessor implements PageProcessor {

    private static Logger logger = Logger.getLogger(P2PPageProcessor.class);
    private Site site = Site.me().setRetryTimes(3).setSleepTime(10000);

    private IP2PIncomeInfoService p2PIncomeInfoService;
    private IStatsWdzjDataService statsWdzjDataService;
    private String domain;

    /**
     * 域名
     * @param domain
     */
    public P2PPageProcessor(String domain) {
        this.domain = domain;
        p2PIncomeInfoService = SpringContextUtil.getBean("p2PIncomeInfoServiceImpl");
        statsWdzjDataService = SpringContextUtil.getBean("statsWdzjDataServiceImpl");
    }

    public void process(Page page) {
        logger.info("【解析网站页面】-->  domain="+domain);
        Html html = page.getHtml();
        Document document = html.getDocument();

        // step1:
        if(domain.equals("lu")){
            parseLu(document);
        }else if(domain.equals("lup2p")){
            parseLu(document);
        }else if(domain.equals("yirendai")){
            parseYirendai(page);
        }else if(domain.equals("renrendai")){
            parseRenrendai(page);
        }else if(domain.equals("my089")){
            parseMy089(document);
        }else if(domain.equals("weidai")){
            parseWeidai(document);
        }else if(domain.equals("yooli")){
            parseYooli(page);
        }else if(domain.equals("eloancn")){
            parseEloancn(page);
        }else if(domain.equals("jimu")){
            parseJimu(page);
        }else if(domain.equals("dianrong")){

        }else if(domain.equals("xinhehui")){

        }else if(domain.equals("wdzj")){
            parseWdzj(document);
        }

        logger.info("【解析网站页面】<--  domain="+domain);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Site getSite() {
        return site;
    }

    public void parseYirendai(Page page){

        Html html = page.getHtml();
        Document document = html.getDocument();

        Elements es = document.select("table.m-financeList");                                  // 需要修改
        Element ulNode = es.get(0);
        Elements listEls = ulNode.select("tr");                                          // 需要修改
        logger.info("【抓取:"+domain+"】产品数量："+listEls.size());
        for(int i = 0 ;i < listEls.size() ; i++ ){
            try{
                P2PIncomeInfo p2PIncomeInfo = new P2PIncomeInfo();
                p2PIncomeInfo.setDomainName(domain);
                // 产品名称
                Element product_ = listEls.get(i).select("a").get(0);
                String product = product_.text();
                p2PIncomeInfo.setProduct(product);

                String href_ = product_.attributes().get("href");

                //   logger.info("【解析数据】  url="+href_);
                int sNo = href_.lastIndexOf("view/")+5;                             // 需要修改
                int eNo = href_.indexOf("?")>=0?href_.indexOf("?"):href_.length();  // 需要修改
                String productNo = href_.substring(sNo,eNo);
                p2PIncomeInfo.setProductNo(productNo);

                //  年化收益
                Element income_ = listEls.get(i).child(2).select("p").first();
                String income = income_.text();
                int et = income.indexOf("%")<0?income.length():income.indexOf("%");
                income = income.substring(0,et);
                p2PIncomeInfo.setAnnualIncome(Double.valueOf(income));

                //  期限
                Element period_ = listEls.get(i).child(3).select("p").first();
                String periodText = period_.text();
                String period = regex(periodText,"^\\d*");                                    // 匹配期数数字
                p2PIncomeInfo.setLoanPeriod(Integer.valueOf(period));

                //  期限类型 0=天 1=月 2=年
                String periodType = regex(periodText,"天|月|年");
                p2PIncomeInfo.setPeriodType(regexPeriodType(periodType));
                p2PIncomeInfoService.saveP2PIncomeInfoHandler(p2PIncomeInfo);
                logger.info("【解析数据】          "+productNo+"  "+product+"  "+income+"  "+period+"   "+periodType);
            }catch(Exception e){
                logger.error("【解析数据】  异常！",e);
            }
        }

        // step2: 分页信息
        Element divPage = ulNode.select("dev.m-page").first();
        Elements aPage = divPage.select("a.m-pageNum");
        String yrdUrl = "https://www.yirendai.com/finance/list/";
        List<String> requests = new ArrayList<String>();

        for(int i = 0 ; i < aPage.size() ; i++){
            Element a_ = aPage.get(0);
            Integer pageNo = Integer.valueOf(a_.text());
            requests.add(yrdUrl+pageNo);
        }
        page.addTargetRequests(requests);

    }

    public void parseLu(Document document){
        String topUl = "ul.main-list";
        if(domain.equals("lu")){
            topUl = "ul.main-list";
        }else if(domain.equals("lup2p")){
            topUl = "ul.product-rows";
        }
        Elements es = document.select(topUl);
        Element ulNode = es.get(0);
        Elements lis = ulNode.children();
        logger.info("【解析数据】 "+domain+"  产品数量："+lis.size());
        for(int i = 0 ;i < lis.size() ; i++ ){
            try{
                P2PIncomeInfo p2PIncomeInfo = new P2PIncomeInfo();
                p2PIncomeInfo.setDomainName(domain);
                // 产品名称
                Element product_ = lis.get(i).select("a").get(0);
                String product = product_.text();
                p2PIncomeInfo.setProduct(product);

                String href_ = product_.attributes().get("href");
                int sNo = href_.lastIndexOf("productId=")+10;
                int eNo = href_.indexOf("&")>=0?href_.indexOf("&"):href_.length();
                String productNo = href_.substring(sNo,eNo);
                p2PIncomeInfo.setProductNo(productNo);

                //  年化收益
                Element income_ = lis.get(i).select("p.num-style").get(0);
                String income = income_.text();
                income = income.substring(0,income.indexOf("%"));
                p2PIncomeInfo.setAnnualIncome(Double.valueOf(income));

                //  期限
                Element period_ = lis.get(i).select("li.invest-period").get(0).select("p").first();
                String periodText = period_.text();
                String period = regex(periodText,"^\\d*");                                    // 匹配期数数字
                p2PIncomeInfo.setLoanPeriod(Integer.valueOf(period));

                //  期限类型 0=天 1=月 2=年
                String periodType = regex(periodText,"天|月|年");
                p2PIncomeInfo.setPeriodType(regexPeriodType(periodType));

                p2PIncomeInfoService.saveP2PIncomeInfoHandler(p2PIncomeInfo);
                logger.info("【解析数据】  "+domain+"      产品名称："+product+"  "+income+"  "+period+"   "+periodType);
            }catch(Exception e){
                logger.error("【解析数据】  异常！",e);
            }
        }
    }

    public void parseLup2p(Document document){
        Elements es = document.select("ul.product-rows");
        Element ulNode = es.get(0);
        Elements lis = ulNode.children();
        System.out.println("产品数量："+lis.size());

        for(int i = 0 ;i < lis.size() ; i++ ){
            try{
                P2PIncomeInfo p2PIncomeInfo = new P2PIncomeInfo();
                p2PIncomeInfo.setDomainName(domain);
                // 产品名称
                Element product_ = lis.get(i).select("a").get(0);
                String product = product_.text();
                p2PIncomeInfo.setProduct(product);


                String href_ = product_.attributes().get("href");
                int sNo = href_.lastIndexOf("productId=")+10;
                int eNo = href_.indexOf("&")>=0?href_.indexOf("&"):href_.length();
                String productNo = href_.substring(sNo,eNo);

                //  年化收益
                Element income_ = lis.get(i).select("p.num-style").get(0);
                String income = income_.text();
                income = income.substring(0,income.indexOf("%"));
                p2PIncomeInfo.setAnnualIncome(Double.valueOf(income));

                //  期限
                Element period_ = lis.get(i).select("li.invest-period").get(0).select("p").first();
                String periodText = period_.text();
                String period = regex(periodText,"^\\d*");                                    // 匹配期数数字
                p2PIncomeInfo.setLoanPeriod(Integer.valueOf(period));
                logger.info("【解析数据】  period="+href_);

                //  期限类型 0=天 1=月 2=年
                String periodType = regex(periodText,"天|月|年");
                p2PIncomeInfo.setPeriodType(regexPeriodType(periodType));
                logger.info("【解析数据】    域名:lu    "+productNo+"    "+product+"  "+income+"  "+period);
            }catch(Exception e){
                logger.error("【解析数据】  异常！",e);
            }
        }
    }

    public void parseRenrendai(Page page){
        Html html = page.getHtml();
        Document document = html.getDocument();

        String loanInfo = StringEscapeUtils.unescapeHtml(document.body().html());
        JSONObject jsonObject = JSONObject.parseObject(loanInfo);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray jsonArray = data.getJSONArray("list");

        for(int i = 0 ; i < jsonArray.size() ; i++ ){
            P2PIncomeInfo p2PIncomeInfo = new P2PIncomeInfo();
            p2PIncomeInfo.setDomainName(domain);
            JSONObject json = jsonArray.getJSONObject(i);

            Integer productNo = json.getInteger("id");
            p2PIncomeInfo.setProductNo(String.valueOf(productNo));                                     // 产品编号

            String product = json.getString("name");                                                   // 产品名称
            p2PIncomeInfo.setProduct(product);

            double annualIncome = json.getDoubleValue("baseInterestRate");
            p2PIncomeInfo.setAnnualIncome(annualIncome);                                               // 年化收益

            int lockPeriod = json.getIntValue("lockPeriod");
            p2PIncomeInfo.setLoanPeriod(lockPeriod);                                                   //  期数

            p2PIncomeInfo.setPeriodType(1);                                                            //  期数类型（月）
            p2PIncomeInfoService.saveP2PIncomeInfoHandler(p2PIncomeInfo);
        }
        // 计算页面数
        int total = (Integer)data.get("totalCount");
        int pageCount = total%10!=0 ? total/10+1 : total/10;
        String url = "https://www.renrendai.com/pc/p2p/uPlan/getFinancePlanList?limit=10&_=1499757167527&startNum=";
        pagingRequest(1,pageCount,url,page);
    }

    private void pagingRequest(int startNo,int pageCount,String url,Page page){
        List<String> listUrl = new ArrayList<String>();
        for(int i = startNo ; i < pageCount ; i++ ){
            String urlList = url+i;
            listUrl.add(urlList);
        }
        page.addTargetRequests(listUrl);
    }

    public void parseMy089(Document document){

        Elements es = document.select("div.Loan_box");                                  // 需要修改
        Element ulNode = es.get(0);
        Elements listEls = ulNode.select("dl");                                          // 需要修改
        System.out.println("产品数量："+listEls.size());
        for(int i = 0 ;i < listEls.size() ; i++ ){
            try{
                P2PIncomeInfo p2PIncomeInfo = new P2PIncomeInfo();
                p2PIncomeInfo.setDomainName(domain);
                // 产品名称
                Element product_ = listEls.get(i).select("a.lf").get(1);
                String product = product_.text();
                p2PIncomeInfo.setProduct(product);

                String href_ = product_.attributes().get("href");

                //   logger.info("【解析数据】  url="+href_);
                int sNo = href_.lastIndexOf("sid=")+4;                             // 需要修改
                int eNo = href_.indexOf("&")>=0?href_.indexOf("&"):href_.length();  // 需要修改
                String productNo = href_.substring(sNo,eNo);
                p2PIncomeInfo.setProductNo(productNo);

                //  年化收益
                Element income_ = listEls.get(i).child(2).select("p").first();
                String income = income_.text();
                int et = income.indexOf("%")<0?income.length():income.indexOf("%");
                income = income.substring(0,et);
                p2PIncomeInfo.setAnnualIncome(Double.valueOf(income));

                //  期限
                Element period_ = listEls.get(i).child(3).select("p").first();
                String periodText = period_.text();
                String period = regex(periodText,"^\\d*");                                    // 匹配期数数字
                p2PIncomeInfo.setLoanPeriod(Integer.valueOf(period));

                //  期限类型 0=天 1=月 2=年
                String periodType = regex(periodText,"天|月|年");
                p2PIncomeInfo.setPeriodType(regexPeriodType(periodType));
                p2PIncomeInfoService.saveP2PIncomeInfoHandler(p2PIncomeInfo);
                logger.info("【解析数据】          "+productNo+"  "+product+"  "+income+"  "+period+"   "+periodType);
            }catch(Exception e){
                logger.error("【解析数据】  异常！",e);
            }
        }
    }

//    public void parseEloancn(Document document){
//
//        Elements es = document.select("div#yn-list");                                  // 需要修改
//        Element ulNode = es.get(0);
//        Elements listEls = ulNode.select("div.list-cont  over-list");                                          // 需要修改
//        System.out.println("产品数量："+listEls.size());
//        for(int i = 0 ;i < listEls.size() ; i++ ){
//            try{
//                P2PIncomeInfo p2PIncomeInfo = new P2PIncomeInfo();
//                p2PIncomeInfo.setDomainName(domain);
//
//
//                // 产品名称
//                Element product_ = listEls.get(i).select("div.list-tit").first().select("h3").first();
//                String product = product_.text();
//                p2PIncomeInfo.setProduct(product);
//
//                // 产品编号
//                Element productNo_ = product_.nextElementSibling();
//                String pNo_ = productNo_.text();
//                String productNo = regex(pNo_,"^\\d*");
//                p2PIncomeInfo.setProductNo(productNo);
//
//                //  年化收益
//                Element income_ = listEls.get(i).select("div.list-txt f-cb").first().select("div.majorrate").first();
//                String income = income_.text();
//                int et = income.indexOf("%")<0?income.length():income.indexOf("%");
//                income = income.substring(0,et);
//                p2PIncomeInfo.setAnnualIncome(Double.valueOf(income));
//
//                //  期限
//                Element period_ = listEls.get(i).select("div.list-txt f-cb").first().select("p.day").first();
//                String periodText = period_.text();
//                String period = regex(periodText,"^\\d*");                                    // 匹配期数数字
//                p2PIncomeInfo.setLoanPeriod(Integer.valueOf(period));
//
//                //  期限类型 0=天 1=月 2=年
//                String periodType = regex(periodText,"天|月|年");
//                p2PIncomeInfo.setPeriodType(regexMonth(periodType));
//                p2PIncomeInfoService.saveP2PIncomeInfo(p2PIncomeInfo);
//                logger.info("【解析数据】          "+productNo+"  "+product+"  "+income+"  "+period+"   "+periodType);
//            }catch(Exception e){
//                logger.error("【解析数据】  异常！",e);
//            }
//        }
//    }

    public void parseYooli(Page page){
        Html html = page.getHtml();
        Document document = html.getDocument();

        Elements es = document.select("div.loan-items");                                  // 需要修改
        Element ulNode = es.get(0);
        Elements listEls = ulNode.select("div");                                          // 需要修改

        logger.info("【抓取:"+domain+"】产品数量："+listEls.size());

        for(int i = 2 ; i < listEls.size() ; i++ ){                 // 剔除新手专享、表头
            try{
                P2PIncomeInfo p2PIncomeInfo = new P2PIncomeInfo();
                p2PIncomeInfo.setDomainName(domain);
                Element div_ = listEls.first();
                Elements lis_ = div_.select("li");

                // 产品名称
                Element li1 = lis_.get(0);
                Element a_ = li1.select("a").first();
                String product = a_.text();
                p2PIncomeInfo.setProduct(product);


                String url = a_.attr("href");
                int sn = url.indexOf("detail/")+7;
                int en = url.lastIndexOf(".");
                String productNo = url.substring(sn,en);
                p2PIncomeInfo.setProductNo(productNo);

                // 年化收益
                Element li2 = lis_.get(0);
                Element em_ = li2.select("em").first();
                String emText_ = em_.text();
                double annualIncome = Double.valueOf(emText_);
                p2PIncomeInfo.setAnnualIncome(annualIncome);

                // 期限
                Element li3 = lis_.get(0);
                String li3Text = li3.text();
                String period = regex(li3Text, "^\\d*");
                p2PIncomeInfo.setLoanPeriod(Integer.valueOf(period));

                // 期数类型
                String periodType = regex(li3Text, "天|月|年");
                p2PIncomeInfo.setPeriodType(regexPeriodType(periodType));

                p2PIncomeInfoService.saveP2PIncomeInfoHandler(p2PIncomeInfo);
                logger.info("【解析数据】  product="+product+"  productNo="+productNo+"  annualIncome="+annualIncome+"  period="+period+"  periodType="+periodType);
            }catch (Exception e){
                logger.error("【解析数据】  异常！",e);
            }
        }
    }

    public void parseEloancn(Page page){

        Html html = page.getHtml();
        Document document = html.getDocument();
        logger.info("【抓取网站数据:"+domain+"】  ");
        logger.info(StringEscapeUtils.unescapeHtml(document.body().html()));
        JSONObject jsonObject = JSONObject.parseObject (StringEscapeUtils.unescapeHtml(document.body().html()));
        JSONObject dataJson = jsonObject.getJSONObject("data");
        JSONArray dataJsonArray =  dataJson.getJSONArray("data");
        for(int i = 0 ; i < dataJsonArray.size() ; i++ ){
            try {
                P2PIncomeInfo p2PIncomeInfo = new P2PIncomeInfo();
                p2PIncomeInfo.setDomainName(domain);

                // 产品名称
                JSONObject json = dataJsonArray.getJSONObject(i);
                String product = json.getString("wholeTitle");
                p2PIncomeInfo.setProduct(product);

                // 产品编号
                String productNo = json.getString("id");
                p2PIncomeInfo.setProductNo(productNo);

                // 利率
                String income = json.getString("strInterestrate");
                int et = income.indexOf("%") < 0 ? income.length() : income.indexOf("%");
                income = income.substring(0, et);
                p2PIncomeInfo.setAnnualIncome(Double.valueOf(income));

                // 期限
                String loanPeriod = json.getString("strPhases");
                String period = regex(loanPeriod, "^\\d*");
                p2PIncomeInfo.setLoanPeriod(Integer.valueOf(period));
                String periodType = regex(loanPeriod, "天|月|年");
                p2PIncomeInfo.setPeriodType(regexPeriodType(periodType));

                p2PIncomeInfoService.saveP2PIncomeInfoHandler(p2PIncomeInfo);
                logger.info("【抓取网站数据:"+domain+"】    " + product + "   " + productNo + "   " + income + "   " + period + "   " + periodType);
            }catch (Exception e){
                logger.error("【抓取网站数据:"+domain+"】",e);
            }
        }
        try{
            // 分页
            int total = (Integer)dataJson.get("total");
            String url = "https://licai.eloancn.com/pcgway/gateway/v1/01?requesturl=%2Fappwmps%2Fapp004%2Fv2%2F01&platform=5&v=0.6299485266672507&pageNo=";
            pagingRequest(2,total,url,page);
        }catch (Exception e){
            logger.error("【抓取网站数据:"+domain+"】",e);
        }
    }

    public void parseWeidai(Document document){
            logger.info(StringEscapeUtils.unescapeHtml(document.body().html()));
            JSONObject jsonObject = JSONObject.parseObject (StringEscapeUtils.unescapeHtml(document.body().html()));
            JSONObject dataJson = jsonObject.getJSONObject("data");
            JSONArray dataJsonArray =  dataJson.getJSONArray("data");

            for(int i = 0 ; i < dataJsonArray.size() ; i++ ){
                P2PIncomeInfo p2PIncomeInfo = new P2PIncomeInfo();
                p2PIncomeInfo.setDomainName(domain);

                // 产品名称
                JSONObject json = dataJsonArray.getJSONObject(i);
                String product = json.getString("title");
                p2PIncomeInfo.setProduct(product);

                // 产品编号
                String productNo = json.getString("bid");
                p2PIncomeInfo.setProductNo(productNo);

                // 利率
                double income = json.getDouble("annualizedRate");
                income *=100;
                p2PIncomeInfo.setAnnualIncome(income);

                // 期限
                String loanPeriod = json.getString("periods");
                p2PIncomeInfo.setLoanPeriod(Integer.valueOf(loanPeriod));
                String periodType = json.getString("durationTimeUnit");
                p2PIncomeInfo.setPeriodType(regexPeriodType(periodType));

                p2PIncomeInfoService.saveP2PIncomeInfoHandler(p2PIncomeInfo);
                logger.info("【抓取产品信息】    "+product+"   "+productNo+"   "+income+"   "+loanPeriod+"   "+periodType);
            }
    }

    public void parseWdzj(Document document){

        String[] plats = {"红岭创投","微贷网","陆金服","翼龙贷","宜人贷","人人贷","有利网","积木盒子","点融网","鑫合汇"};

        Elements es = document.select("div#platTableTmpl");                                  // 需要修改
        Element ulNode = es.first();
        Elements tNodes =ulNode.select("table.normal-table-two");
        Element tNode = tNodes.first();
        Elements listEls = tNode.select("tr");                                          // 需要修改
        logger.info("【抓取网站数据:"+domain+"】    数量="+listEls.size());
        List<StatsWdzjData> list = new ArrayList();
        for(int i = 0 ;i < listEls.size() ; i++ ){
            try{
                StatsWdzjData statsWdzjData = new StatsWdzjData();
                // 产品名称
                Element product_ = listEls.get(i).select("a").get(0);
                String product = product_.text();
                statsWdzjData.setPlatform(product);

                Element bAmount_ = listEls.get(i).select("td").get(2);
                double businessAmount = Double.valueOf(bAmount_.text());
                statsWdzjData.setBusinessAmount(businessAmount);

                String href_ = product_.attributes().get("href");
                //  年化收益
                Element income_ = listEls.get(i).select("td").get(3);
                String income = income_.text();
                int et = income.indexOf("%")<0?income.length():income.indexOf("%");
                income = income.substring(0,et);
                statsWdzjData.setAvgIncome(Double.valueOf(income));

                //  期限
                Element period_ = listEls.get(i).select("td").get(3);
                String periodText = period_.text();
                String period = regex(periodText,"^\\d*");
                // 匹配期数数字
                statsWdzjData.setAvgPeriod(Double.valueOf(period));

                //  期限类型 0=天 1=月 2=年
                statsWdzjData.setPeriodType(1);

                for(int j = 0 ; j < plats.length ; j++){
                    if(plats[j].equals(StringUtils.trim(statsWdzjData.getPlatform()))){
                        list.add(statsWdzjData);
                        logger.info("【解析数据】           "+product+"  "+income+"  "+period);
                        break;
                    }
                }
            }catch(Exception e){
                logger.error("【解析数据】  异常！",e);
            }
        }
        try {
            statsWdzjDataService.saveStatsWdzjDataHandler(list);
        } catch (Exception e) {
            logger.error("【解析数据】  异常！",e);
        }
    }

    public void parseJimu(Page page){
        Html html = page.getHtml();
        Document document = html.getDocument();

        Element div_ = document.select("div.project-list").first();
        Elements divs_ = div_.select("div.span3");
        for(int i = 0 ; i <  divs_.size() ; i++) {
            try{
                P2PIncomeInfo p2PIncomeInfo = new P2PIncomeInfo();
                p2PIncomeInfo.setDomainName(domain);

                // 产品名称
                Element dev_pro_ = divs_.get(i);
                Element title_ =  dev_pro_.select("div.invest-item-title").first();
                String product = title_.text();
                p2PIncomeInfo.setProduct(product);
                // 编号
                Element a_ = dev_pro_.select("a").first();
                String href = a_.attr("href");
                int sn = href.indexOf("=")+1;
                int en = href.length();
                String productNo = href.substring(sn,en);
                p2PIncomeInfo.setProductNo(productNo);

                // 利率
                Element span_ = dev_pro_.select("span.invest-item-profit").first();
                String income =  span_.text();

                income = income.substring(0,income.indexOf("%")==-1?income.length():income.indexOf("%"));
                p2PIncomeInfo.setAnnualIncome(Double.valueOf(income));

                // 期数
                Element span_period_ = dev_pro_.select("span.invest-item-profit").get(1);
                String periStr = span_period_.text();
                int loanPeriod = Integer.valueOf(periStr);
                p2PIncomeInfo.setLoanPeriod(loanPeriod);

                // 期数类型
                Element devPerType_ = span_period_.parent().nextElementSibling();
                String periodType_ = devPerType_.text();
                String periodType = regex(periodType_,"天|月|年");
                p2PIncomeInfo.setPeriodType(regexPeriodType(periodType));

                p2PIncomeInfoService.saveP2PIncomeInfoHandler(p2PIncomeInfo);
                logger.info("【抓取产品信息】    "+product+"   "+productNo+"   "+income+"   "+loanPeriod+"   "+periodType);
            }catch(Exception e){
                logger.info("【抓取产品信息】",e);
            }
        }
        // 分页
        Element dev_Page_ = document.select("div.pagination").first();
        Element dev_next_ = dev_Page_.select("a.next").first();
        if(dev_next_!=null){
            String href = "https://box.jimu.com";
            href += dev_next_.attr("href");
            int cs = href.indexOf("page=")+5;
            int ce = href.indexOf("&status");
            Integer current = Integer.valueOf(href.substring(cs,ce));
            // 暂时只抓取 100页
            if(current <= 100){
                page.addTargetRequest(new Request(href));
            }
        }
    }

    /**
     * 匹配字符串
     * @param targetStr
     * @param patternStr
     * @return
     */
    private static String regex(String targetStr,String patternStr){
        Pattern r = Pattern.compile(patternStr);
        Matcher m = r.matcher(targetStr);
        m.find();
        return m.group();
    }

    private static Integer regexPeriodType(String periodType){
        if("天".equals(periodType)){
            return 0;
        }else if("月".equals(periodType)){
            return 1;
        }else if("年".equals(periodType)){
            return 2;
        }
        return null;
    }
}
