package com.shijianzhou.language.service.impl;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.service.base.AbstractService;
import com.hexiaofei.provider0.vo.PageVo;
import com.shijianzhou.language.common.RegExpUtils;
import com.shijianzhou.language.dao.mapper.SjzNlRegExpMapper;
import com.shijianzhou.language.domain.SjzNlRegExp;
import com.shijianzhou.language.service.SjzNlRegExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Transactional
@Service("sjzNlRegExpService")
public class SjzNlRegExpServiceImpl extends AbstractService implements SjzNlRegExpService {

    @Autowired
    private SjzNlRegExpMapper sjzNlRegExpMapper;

    @Override
    public int addObject(SjzNlRegExp sjzNlRegExp) throws PlatformException {
        return sjzNlRegExpMapper.insert(sjzNlRegExp);
    }

    @Override
    public int deleteObjectById(int id) throws PlatformException {
        return 0;
    }

    @Override
    public int updateObject(SjzNlRegExp sjzNlRegExp) throws PlatformException {
        int resultId = -1;
        SjzNlRegExp targetObj = getObjectById(sjzNlRegExp.getId());
        targetObj = refreshObjectForNotNullVal(targetObj,sjzNlRegExp);
        resultId = sjzNlRegExpMapper.updateByPrimaryKey(targetObj);
        return resultId;
    }

    @Override
    public SjzNlRegExp getObjectById(int id) throws PlatformException {
        return sjzNlRegExpMapper.selectByPrimaryKey(id);
    }



    @Override
    public PageVo getPageVoObject(PageVo pageVo) throws PlatformException {
        List<SjzNlRegExp> list = new ArrayList<>();

        // step1: 查询当前总记录条数
        int recordCount = sjzNlRegExpMapper.selectCountByAll();
        pageVo.setRecordCount(recordCount);

        // step2: 开始位置
        int offset = pageVo.getCurrentPage()-1<1?0:pageVo.getCurrentPage()-1;
        // step3: 结果集
        list = sjzNlRegExpMapper.selectListByPaging(pageVo.getPageSize()*offset,pageVo.getPageSize());
        pageVo.setVoList(list);

        return pageVo;
    }

    @Override
    public List<SjzNlRegExp> getAllObject() throws PlatformException {
        return null;
    }


    @Override
    public boolean getNlRegExpCheck(SjzNlRegExp sjzNlRegExp) throws PlatformException {
        return RegExpUtils.stringMarchStrCheck(sjzNlRegExp.getRegExpDemo(),sjzNlRegExp.getRegExpPattern());
    }

    @Override
    public SjzNlRegExp getObjectForRegExp(SjzNlRegExp sjzNlRegExp) throws PlatformException {
        return null;
    }

    @Override
    public List<String> getListMarchForRegExpCode(String targetStr, String regExpCode) throws PlatformException {
        List<String> list = new ArrayList<String>();

        SjzNlRegExp sjzNlRegExp = sjzNlRegExpMapper.selectByExgExpCode(regExpCode);
        if(sjzNlRegExp == null){
            throw new PlatformException("正则表达式不存在！");
        }

        list = marchFor(targetStr,sjzNlRegExp.getRegExpPattern());

        return list;
    }

    public boolean getMarchResultForRegExpCode(String targetStr, String regExpCode)throws PlatformException {

        SjzNlRegExp sjzNlRegExp = sjzNlRegExpMapper.selectByExgExpCode(regExpCode);

        if(sjzNlRegExp == null){
            throw new PlatformException("正则表达式不存在！");
        }

        return marchStr(targetStr,sjzNlRegExp.getRegExpPattern());
    }



    /**
     *
     * @param resource 目标字符串
     * @param ptn 匹配模板
     * @return
     */
    boolean marchStr(String resource,String ptn){
        Pattern p = Pattern.compile("("+ptn+")");
        Matcher m=p.matcher(resource);
        return m.matches();//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
    }

    List<String> marchFor(String resource,String ptn){
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile("("+ptn+")");
        Matcher m = p.matcher(resource); // 获取 matcher 对象

        while(m.find()) {
            list.add(m.group(1));
        }

        return list;
    }

    public static void main(String[] args){
        List li = null;
        String[] ts = {"https://gw.22.cn/fuwu/?s=20180720gw_daohang",
        "www.om.cn/members/messages/notify",
        "http://www.3dmax8.com",
        "https://whois.west.cn/xufengnongji",
        "https://news.west.cn/62129.html",
        "http://a.ap-_p.qq.com/o/simple.jsp?pkgname=com.aiming.domain"};

        String p = "(?=^.{3,255}$)(http(s)?:\\/\\/)(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*";

        p="(?=^.{3,255}$)(http(s)?:\\/\\/)(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*";
        for(String ss : ts){
            System.out.println( new SjzNlRegExpServiceImpl().marchStr(ss,p));
            li = new SjzNlRegExpServiceImpl().marchFor(ss,p);
            li.forEach(s->{
                System.out.println(s);
            });
        }


    }
}
