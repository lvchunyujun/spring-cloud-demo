package com.hexiaofei.sjzclient.service.message.impl.model.mail;

/**
 * SMTP服务器配置信息的类
 *
 */
public class SmtpServer
{

    private String address;
    private int port;
    private String description;
    
    
    public SmtpServer(String address, int port, String description)
    {
        super();
        this.address = address;
        this.port = port;
        this.description = description;
    }


    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }


    /**
     * @return the port
     */
    public int getPort()
    {
        return port;
    }


    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }
    
}
