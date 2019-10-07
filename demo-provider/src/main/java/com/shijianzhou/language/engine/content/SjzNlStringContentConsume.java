package com.shijianzhou.language.engine.content;

import com.hexiaofei.provider0.common.consts.SjzSystemConsts;
import com.hexiaofei.provider0.domain.SjzEventIndex;
import com.hexiaofei.provider0.domain.SjzEventIndexTemp;
import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.SjzEventIndexService;
import com.hexiaofei.provider0.service.SjzEventIndexTempService;
import com.shijianzhou.language.common.consts.RelatePatternUnitUseStatusEnuma;
import com.shijianzhou.language.domain.SjzNlRelatePatternUnit;
import com.shijianzhou.language.engine.parse.JsoupDocumentParser;
import com.shijianzhou.language.engine.parse.ParserFactory;
import com.shijianzhou.language.service.SjzNlRelatePatternUnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class SjzNlStringContentConsume implements SjzNlContentConsume<String> {

    private final static Logger LOGGER = LoggerFactory.getLogger(SjzNlStringContentConsume.class);

    @Autowired
    private SjzNlRelatePatternUnitService sjzNlRelatePatternUnitService;

    @Autowired
    private SjzEventIndexTempService sjzEventIndexTempService;

    @Autowired
    private SjzEventIndexService sjzEventIndexService;

    /**
     * //  1. 获取关联模板匹配名称
     * //  2. 判断关联模板使用状态
     * //  3. 根据模板名称返回匹配单元列表；
     * //  4. 根据匹配单元做匹配
     * //  5. 符合条件的记录到 缓存表+事件表， 不符合条件的只记录 缓存表
     *
     * @param textStr 待处理的目标文本字符串
     */
    @Override
    public void doProcess(String textStr) {
//        try {
//            //  1. 获取关联模板匹配名称
//            List<Map<String,Object>> patternNameList =  sjzNlRelatePatternUnitService.getGroupListByPatternName();
//
//            for(Map map : patternNameList){
//                int useStatus = (Integer) map.get("useStatus");
//                String patternName = (String)map.get("patternName");
//                if(useStatus == RelatePatternUnitUseStatusEnuma.OPEN.getCode()){
//                    parseConsumeByPatternName(textStr,patternName);
//                }
//            }
//
//        } catch (PlatformException e) {
//            LOGGER.error("文本消费出现异常！",e);
//        }

    }


    private void parseConsumeByPatternName(String targetStr,String patternName) throws PlatformException {
//
//        SjzNlRelatePatternUnit obj = new SjzNlRelatePatternUnit();
//        obj.setPatternName(patternName);
//
//        // step1： 切割目标字符串
//        String[] ss =  JsoupDocumentParser.splitTextByDefLanguageType(targetStr);
//
//        for (int i = 0 ; i < ss.length ; i++ ) {
//            /**
//             * rpuList 必须是根据序列号顺序排列
//             */
//            List<SjzNlRelatePatternUnit> rpuList = sjzNlRelatePatternUnitService.getListObject(obj);
//            parseConsumeByRelatePatternUnitList(targetStr,rpuList);
//        }
    }
//
//    private void parseConsumeByRelatePatternUnitList(String targetStr,List<SjzNlRelatePatternUnit> rpuList){
//
//        for(int j = 0 ; j < rpuList.size() ; j++ ){
//
//            SjzNlRelatePatternUnit rpu = rpuList.get(j);
//            if(!checkMatchByRegExp( targetStr, rpu)){
//                // 不匹配： 判断顺序号=1 不保存；否则保存到 事件缓存列表中去
//                if(j>0){
//                    addEventIndexTemp(targetStr,rpu);
//                }else{
//                    break;
//                }
//            }else{
//                /*
//                 * 匹配已经完成: 顺序号==list.size()-1 表示保存到事件列表
//                 * 匹配未完成：  循环继续
//                 */
//                if(rpu.getUnitSerialNo() == (rpuList.size()-1)){
//                    addEventIndex(targetStr);
//                    addEventIndexTemp(targetStr,rpu);
//                }
//            }
//        }
//
//    }
//
//    private boolean checkMatchByRegExp(String targetStr, SjzNlRelatePatternUnit rpu){
//        String regExp = rpu.getRegExpPattern();
//        short relateType = rpu.getRelateType();
//
//        boolean flag = false;
//
//        switch (relateType){
//            case 0: flag = JsoupDocumentParser.marchStr(targetStr,regExp);
//            case 10: flag = !JsoupDocumentParser.marchStr(targetStr,regExp);
//        }
//        return flag;
//    }
//
//    private void addEventIndex(String eventCount){
//        SjzEventIndex sjzEventIndex = new SjzEventIndex();
//        sjzEventIndex.setEventType(SjzSystemConsts.EVENT_TYPE_TXT);
//        sjzEventIndex.setEventState(SjzSystemConsts.EVENT_STATE_SHOW);
//        sjzEventIndex.setEventTime();
//        sjzEventIndex.setEventContent(eventCount);
//        sjzEventIndex.setRecordCreateTime(new Date());
//
//        try {
//            sjzEventIndexService.addObject(sjzEventIndex);
//        } catch (PlatformException e) {
//            LOGGER.error("保存事件异常！",e);
//        }
//
//    }
//
//    private void addEventIndexTemp(String eventCount,SjzNlRelatePatternUnit rpu){
//        SjzEventIndexTemp sjzEventIndexTemp = new SjzEventIndexTemp();
//        sjzEventIndexTemp.setDomainName();
//        sjzEventIndexTemp.setEventContent(eventCount);
//        sjzEventIndexTemp.setEventTime();
//        sjzEventIndexTemp.setEventState(SjzSystemConsts.EVENT_STATE_SHOW);
//        sjzEventIndexTemp.setEventType(SjzSystemConsts.EVENT_TYPE_TXT);
//        sjzEventIndexTemp.setPatternName(rpu.getPatternName());
//        sjzEventIndexTemp.setUnitSerialNo(rpu.getUnitSerialNo());
//        sjzEventIndexTemp.setCreateTime(new Date());
//
//        try {
//            sjzEventIndexTempService.addObject(sjzEventIndexTemp);
//        } catch (PlatformException e) {
//            LOGGER.error("保存事件异常！",e);
//        }
//    }


}
