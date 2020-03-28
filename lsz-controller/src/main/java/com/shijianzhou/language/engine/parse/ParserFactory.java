package com.shijianzhou.language.engine.parse;

import java.util.ArrayList;
import java.util.List;

public class ParserFactory {

    private static ParserFactory parserFactory ;

    private ParserFactory(){}

    public static ParserFactory getInstance(){

        if(parserFactory == null){
            synchronized(ParserFactory.class){
                if(parserFactory == null){
                    parserFactory = new ParserFactory();
                }
            }
        }
        return parserFactory;
    }

    public Parser getXmlParser(){
        return null;
    }

    public JsoupDocumentParser getJsoupDocumentParser(){
        return JsoupDocumentParser.getInstance();
    }

}
