package com.shijianzhou.language.engine.parse;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsoupDocumentParser implements Parser{

    private static JsoupDocumentParser jsoupDocumentParser = new JsoupDocumentParser();

    private static final String PERIOD_CN = "。";
    private static final String PERIOD_EN = ".";

    private static final String D_P1 = ".*(\\d{2,4}(年|-|/))?\\d{1,2}(月|-|/)\\d{1,2}.*";
    private static final String D_P2 = ".*\\d{2,4}(年|-|/)\\d{1,2}(月|-|/)(\\d{1,2})?.*";
    private static final String D_P3 = ".*\\d{2,4}年(\\d{1,2}(月|-|/))?(\\d{1,2})?.*";

    private JsoupDocumentParser(){}

    List<String> parserDocument(Document document){
       return null;
    }

    public static JsoupDocumentParser getInstance(){
        return jsoupDocumentParser;
    }

    public List<String> parserElement(Element element){
        if(element == null) return null;
        List<String> target = new ArrayList<>();

        String txt = element.text();

        if(StringUtils.isNotBlank(txt)){
            String[] ss = txt.split(PERIOD_CN);
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
        // 解析子元素
        Elements elements = element.children();
        if(elements != null){
            Iterator<Element> iterable = elements.iterator();
            while(iterable.hasNext()){
                target.addAll(parserElement(iterable.next()));
            }
        }
        return target;
    }


    public static boolean marchStr(String resource,String ptn){
        Pattern p = Pattern.compile(ptn);
        Matcher m=p.matcher(resource);
        return m.matches();//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
    }


}
