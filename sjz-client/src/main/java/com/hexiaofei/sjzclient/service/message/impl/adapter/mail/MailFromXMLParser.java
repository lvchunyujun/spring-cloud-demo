/*
 * Copyright(c) 2012 by lejinwang
 * All Rights Reserved
 */
package com.hexiaofei.sjzclient.service.message.impl.adapter.mail;

import com.hexiaofei.sjzclient.service.message.impl.model.mail.FromAddress;
import com.hexiaofei.sjzclient.service.message.impl.model.mail.SmtpServer;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 从email_from_address.xml中读取发件人列表
 * 
 * @version 1.0
 */
public class MailFromXMLParser
{
    private static Logger logger = Logger.getLogger(MailFromXMLParser.class);

    // 发件人池子配置文件
    private static String EMAIL_FROM_FILE = null;

    static
    {
        logger.info("开始初始化发件人池子文件");
        try
        {
            EMAIL_FROM_FILE = MailFromXMLParser.class.getResource("/email_from_address.xml").getPath();
            logger.info("发件人池子文件路径:"+EMAIL_FROM_FILE);
        }
        catch (Exception e)
        {
            logger.error("初始化发件人池子文件错误", e);
        }
        logger.info("初始化发件人池子文件成功");
    }

    /**
     * 获取发件人列表
     * 
     * @return
     */
    protected static List<FromAddress> getFromAddressList()
    {

        List<FromAddress> fromAddressList = new ArrayList<FromAddress>();
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            //File file = new File(EMAIL_FROM_FILE);
            InputStream is=MailFromXMLParser.class.getResourceAsStream(EMAIL_FROM_FILE);  
            //BufferedReader br=new BufferedReader(new InputStreamReader(is)); 
            //if (file.exists())
            //{
                Document doc = db.parse(is);
                Element docEle = doc.getDocumentElement();

                NodeList studentList = docEle.getElementsByTagName("email");

                if (studentList != null && studentList.getLength() > 0)
                {
                    for (int i = 0; i < studentList.getLength(); i++)
                    {
                        Node node = studentList.item(i);

                        if (node.getNodeType() == Node.ELEMENT_NODE)
                        {

                            Element e = (Element) node;

                            NodeList nodeList = e.getElementsByTagName("username");
                            String fromAddress = nodeList.item(0).getChildNodes().item(0).getNodeValue();

                            nodeList = e.getElementsByTagName("password");
                            String password = nodeList.item(0).getChildNodes().item(0).getNodeValue();

                            nodeList = e.getElementsByTagName("displayname");
                            String displayName = nodeList.item(0).getChildNodes().item(0).getNodeValue();

                            if (isValidEmail(fromAddress))
                            {
                                FromAddress mailFrom = new FromAddress(displayName, fromAddress, password);

                                fromAddressList.add(mailFrom);
                            }

                        }
                    }
                }
//            }
//            else
//            {
//                logger.error("发件人池子文件未找到");
//            }

        }
        catch (Exception e)
        {
            logger.error("读取发件人池子时发生异常", e);
        }
        return fromAddressList;
    }

    /**
     * 从EMAIL_FROM_FILE获取SMTP服务器列表
     * 
     * @return
     */
    protected static List<SmtpServer> getSmtpList()
    {

        List<SmtpServer> smtpList = new ArrayList<SmtpServer>();
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            File file = new File(EMAIL_FROM_FILE);
            if (file.exists())
            {
                Document doc = db.parse(file);
                Element docEle = doc.getDocumentElement();

                NodeList studentList = docEle.getElementsByTagName("smtp");

                if (studentList != null && studentList.getLength() > 0)
                {
                    for (int i = 0; i < studentList.getLength(); i++)
                    {
                        Node node = studentList.item(i);

                        if (node.getNodeType() == Node.ELEMENT_NODE)
                        {

                            Element e = (Element) node;

                            NodeList nodeList = e.getElementsByTagName("address");
                            String smtpAddress = nodeList.item(0).getChildNodes().item(0).getNodeValue();

                            nodeList = e.getElementsByTagName("port");
                            int port = Integer.parseInt(nodeList.item(0).getChildNodes().item(0).getNodeValue());

                            nodeList = e.getElementsByTagName("description");
                            String description = nodeList.item(0).getChildNodes().item(0).getNodeValue();

                            SmtpServer smtpServer = new SmtpServer(smtpAddress, port, description);
                            smtpList.add(smtpServer);
                        }
                    }
                }
            }
            else
            {
                logger.error("发件人池子文件未找到");
            }

        }
        catch (Exception e)
        {
            logger.error("读取smtp配置文件发生异常", e);
        }
        return smtpList;
    }

    /**
     * 验证输入的邮箱格式是否符合
     * 
     * @param email
     * @return 是否合法
     */
    private static boolean isValidEmail(String email)
    {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find())
        {
            tag = false;
        }
        return tag;
    }
}
