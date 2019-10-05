package com.shijianzhou.language.engine.content;

import com.shijianzhou.language.engine.parse.JsoupDocumentParser;
import com.shijianzhou.language.engine.parse.ParserFactory;

import java.util.List;


public class SjzNlStringContentConsume implements SjzNlContentConsume<String> {


    @Override
    public void doProcess(String str) {

        ParserFactory parserFactory = ParserFactory.getInstance();
        JsoupDocumentParser jsoupDocumentParser = parserFactory.getJsoupDocumentParser();
        List<String> target = jsoupDocumentParser.parseString(str);

        //
    }
}
