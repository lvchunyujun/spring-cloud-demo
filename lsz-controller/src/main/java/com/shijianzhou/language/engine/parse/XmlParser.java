package com.shijianzhou.language.engine.parse;

import com.shijianzhou.language.engine.resource.Resource;
import com.shijianzhou.language.engine.target.TargetMessage;
import com.shijianzhou.language.engine.template.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

public interface XmlParser extends DocumentParser,Parser {

    List<String> parseDocument(Document document);

    List<String> parseElement(Element element);
}
