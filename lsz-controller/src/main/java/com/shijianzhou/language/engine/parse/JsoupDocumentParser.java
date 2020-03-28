package com.shijianzhou.language.engine.parse;

import com.hexiaofei.provider0.exception.PlatformException;
import com.hexiaofei.provider0.utils.DateUtils;
import com.shijianzhou.language.common.consts.SystemConsts;
import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsoupDocumentParser implements Parser{

    private static JsoupDocumentParser jsoupDocumentParser = new JsoupDocumentParser();

    private static final String PERIOD_ZH = "。";
    private static final String PERIOD_EN = ".";

    private static final String D_P1 = ".*(\\d{2,4}(年|-|/))?\\d{1,2}(月|-|/)\\d{1,2}(日?).*";
    private static final String D_P2 = ".*\\d{2,4}(年|-|/)\\d{1,2}(月|-|/)(\\d{1,2})?.*";
    private static final String D_P3 = ".*\\d{2,4}年(\\d{1,2}(月|-|/))?(\\d{1,2})?.*";


    private static final String DATE_F_1 = "(\\d{2,4}(年|-|/))?\\d{1,2}(月|-|/)\\d{1,2}(日?)";
    private static final String DATE_F_2 = "";
    private static final String DATE_F_3 = "";

    private JsoupDocumentParser(){}

    List<String> parserDocument(Document document){
       return null;
    }

    public static JsoupDocumentParser getInstance(){
        return jsoupDocumentParser;
    }

    public List<String> parserElement(Element element){
        if(element == null) return null;

        String txt = element.text();
        return parseString(txt);
    }

    public List<String> parseString(String txt){
        List<String> target = new ArrayList<>();

        if(StringUtils.isNotBlank(txt)){
            String[] ss = txt.split(PERIOD_ZH);
            for(String s : ss){
                if(marchStr(s,D_P1)){
                    target.add(s);
                }else if(marchStr(s,D_P1)){
                    target.add(s);
                }else if(marchStr(s,D_P3)){
                    target.add(s);
                }
            }
        }
        return target;
    }


    /**
     * 正则表达式匹配
     * @param resource
     * @param ptn
     * @return
     */
    public static boolean marchStr(String resource,String ptn){
        Pattern p = Pattern.compile(ptn);
        Matcher m=p.matcher(resource);
        return m.matches();//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
    }

    public static List<String> getMarchList(String resource,String ptn){
        Pattern p = Pattern.compile(ptn);
        Matcher m=p.matcher(resource);
        List<String> list = new ArrayList();
        while(m.find()){
            list.add(m.group());
        }
        return list;
    }

    /**
     * 语言类型，切割文本成句子
     * @param targetStr
     * @param languageType  zh-中文，en-英文
     * @return
     */
    public static String[] splitTextByLanguageType(String targetStr,String languageType) throws PlatformException {

        String flag = "";

        switch (languageType){
            case SystemConsts.LANGUAGE_EN: flag = PERIOD_EN; break;
            case SystemConsts.LANGUAGE_ZH: flag = PERIOD_ZH; break;
            default:flag = PERIOD_ZH;break;
        }

        if(StringUtils.isBlank(flag)){
            throw new PlatformException("不支持的语言类型！");
        }

        String[] ss = targetStr.split(flag);

        return ss;
    }

    /**
     * 默认语言类型，切割文本成句子
     * @param targetStr
     * @return
     */
    public static String[] splitTextByDefLanguageType(String targetStr){
        String[] ss = {};
        try {
             ss = splitTextByLanguageType(targetStr,SystemConsts.LANGUAGE_ZH);
        } catch (PlatformException e) {
        }

        return ss;
    }


    public static List<Date> splitDateStr(String str){
        List<String> ss = getMarchList(str,DATE_F_1);
        List<Date> dateList = new ArrayList<>();

        for(String s : ss){
            Date date = DateUtils.resolveStrToDate(s);
           if( date!= null){
               dateList.add(date);
           }
        }
        return dateList;
    }


    public static void main(String[] args) throws PlatformException {

        String ts = "1776年7月4日，在费城召开了第二次大陆会议，组成“大陆军”，由乔治·华盛顿任总司令，通过了《独";

        for(Date date : splitDateStr(ts)){
            System.out.println(date);
        }
    }

}
