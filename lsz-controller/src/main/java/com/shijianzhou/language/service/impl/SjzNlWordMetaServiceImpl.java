package com.shijianzhou.language.service.impl;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.AbstractService;
import com.hexiaofei.provider0.vo.PageVo;
import com.shijianzhou.language.common.consts.NlWordMetaConsts;
import com.shijianzhou.language.dao.mapper.SjzNlWordMetaMapper;
import com.shijianzhou.language.domain.SjzNlWordMeta;
import com.shijianzhou.language.service.SjzNlWordMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Controller("sjzNlWordMetaService")
public class SjzNlWordMetaServiceImpl extends AbstractService implements SjzNlWordMetaService {

    @Autowired
    private SjzNlWordMetaMapper sjzNlWordMetaMapper;

    @Override
    public boolean getNlRegExpCheck(SjzNlWordMeta sjzNlWordMeta) throws PlatformException {
        return false;
    }

    @Override
    public SjzNlWordMeta getObjectForRegExp(SjzNlWordMeta sjzNlWordMeta) throws PlatformException {
        return null;
    }

    @Override
    public boolean getMarchResultForRegExpCode(String targetStr, String regExpCode) throws PlatformException {
        return false;
    }

    @Override
    public List<String> getListMarchForRegExpCode(String targetStr, String regExpCode) throws PlatformException {
        return null;
    }

    @Override
    public SjzNlWordMeta getSjzNlWordMetaByWordMetaCode(Integer wordMetaCode) throws PlatformException {
        return sjzNlWordMetaMapper.selectByWordMetaCode(wordMetaCode);
    }

    @Override
    public SjzNlWordMeta getParentWordMetaByWordMetaCode(Integer wordMetaCode) throws PlatformException {
        return null;
    }

    @Override
    public List<SjzNlWordMeta> getNextListWordMetaByWordMetaCode(Integer wordMetaCode) throws PlatformException {
        return sjzNlWordMetaMapper.selectNextListWordMetaByWordMetaCode(wordMetaCode);
    }

    @Override
    public int getMinSameLevelWordMetaCodeByParentWordMetaCode(Integer wordMetaCode) throws PlatformException {
        return sjzNlWordMetaMapper.selectMinSameLevelWordMetaCodeByParentWordMetaCode(wordMetaCode);
    }

    @Override
    public int getMaxSameLevelWordMetaCodeByParentWordMetaCode(Integer wordMetaCode) throws PlatformException {
        return sjzNlWordMetaMapper.selectMaxSameLevelWordMetaCodeByParentWordMetaCode(wordMetaCode);
    }

    @Override
    public int addObject(SjzNlWordMeta sjzNlWordMeta) throws PlatformException {

        Integer thisWordMetaCode = null;
        SjzNlWordMeta parentWordMeta = null;

        if(sjzNlWordMeta.getWordMetaCode() == null || sjzNlWordMeta.getWordMetaCode() < 0 ){
            sjzNlWordMeta.setWordMetaCode(0);
        }

        // step1: 父类编码设置，当为空是默认为一级词
        if(sjzNlWordMeta.getParentWordMetaCode() == null || sjzNlWordMeta.getParentWordMetaCode() == NlWordMetaConsts.ORIGINAL_WORD_META_CODE){
            sjzNlWordMeta.setParentWordMetaCode(NlWordMetaConsts.ORIGINAL_WORD_META_CODE);
        }else if((parentWordMeta = getSjzNlWordMetaByWordMetaCode(sjzNlWordMeta.getParentWordMetaCode())) == null){
            throw new PlatformException("所属父类单词编码不存在！");
        }

        // step2: 设置当前单词的级别
        int parentWordMetaCode = sjzNlWordMeta.getParentWordMetaCode();
        if(parentWordMeta==null){
            sjzNlWordMeta.setLevel((short)1);
        }else{
            sjzNlWordMeta.setLevel((short)(parentWordMeta.getLevel()+1));
        }

        // step3: 设置当前单词的编码： 不存在同级单词
        List<SjzNlWordMeta> nextList = getNextListWordMetaByWordMetaCode(parentWordMetaCode);
        if(nextList == null || nextList.size() == 0){
            // 不存在同级，不存父类
            if(parentWordMetaCode == NlWordMetaConsts.ORIGINAL_WORD_META_CODE){
                thisWordMetaCode = NlWordMetaConsts.FIRST_LEVEL_START_WORD_META_CODE;
            }else{
            /*
            *  不存在同级，存在父类。例如：pCode=600000,mincode=null,maxcode=null
            *                        1.  600000     6位
            *                        2.  thiscode = 10000=10^(6-2)
            *                        3.  thiscode = 600000 + thiscode;
            *                        4.  thiscode = 610000
            */
                String strCode = String.valueOf(parentWordMetaCode);
                int codeLen = strCode.length();
                if((codeLen -= sjzNlWordMeta.getLevel()) < 0){
                    throw new PlatformException("不能再增加单词的下一级！");
                }
                double wmCode = Math.pow(NlWordMetaConsts.LEVEL_COUNT,codeLen);
                thisWordMetaCode = sjzNlWordMeta.getParentWordMetaCode();
                thisWordMetaCode += (int)wmCode;
            }
        }else {
        /*
         *存在同级单词,例如： pcode=600000, mincode=610000，maxcode=620000;
         *                1. thiscode = 610000-600000;
         *                2. thiscode = 620000+thiscode;
         *                3. thiscode = 630000;
        */
            int maxCode = getMaxSameLevelWordMetaCodeByParentWordMetaCode(parentWordMetaCode);
            int minCode = getMinSameLevelWordMetaCodeByParentWordMetaCode(parentWordMetaCode);
            thisWordMetaCode = minCode - parentWordMetaCode;
            thisWordMetaCode = maxCode + thisWordMetaCode;

        }
        sjzNlWordMeta.setWordMetaCode(thisWordMetaCode);


        return sjzNlWordMetaMapper.insert(sjzNlWordMeta);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return sjzNlWordMetaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateObject(SjzNlWordMeta mob) throws PlatformException {
        int resultId = -1;
        SjzNlWordMeta targetObj = getObjectById(mob.getId());
        targetObj = refreshObjectForNotNullVal(targetObj,mob);
        resultId = sjzNlWordMetaMapper.updateByPrimaryKey(targetObj);
        return resultId;
    }

    @Override
    public SjzNlWordMeta getObjectById(int id) throws PlatformException {
        return sjzNlWordMetaMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVo<SjzNlWordMeta> getPageVoObject(PageVo<SjzNlWordMeta> pageVo) throws PlatformException {
        List<SjzNlWordMeta> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = sjzNlWordMetaMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzNlWordMetaMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzNlWordMeta> getAllObject() throws PlatformException {
        return null;
    }


}
