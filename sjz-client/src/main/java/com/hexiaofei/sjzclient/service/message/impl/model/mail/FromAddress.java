package com.hexiaofei.sjzclient.service.message.impl.model.mail;


/**
 * 发邮件时的发件人对象，包括发件人显示名，发件人地址等
 */
public class FromAddress
{
	/**
	 * sendcloud账户
	 */
	private String account;
	
    /**
     * 发件人显示名
     */
    private String displayName;
    
    /**
     * 发件人地址
     */
    private String address;
    
    private String password;
    

    /**
     * 构造函数
     * @param displayName 发件人显示名
     * @param address 发件人地址
     */
    public FromAddress(String displayName, String address, String password)
    {
        super();
        this.displayName = displayName;
        this.address = address;
        this.password = password;
    }

    /**
     * 构造函数
     * @param displayName 发件人显示名
     * @param address 发件人地址
     * @param account 使用的sendcloud账户
     * @param password 密码
     */
    public FromAddress(String displayName, String address, String account, String password){
    	super();
    	this.displayName = displayName;
        this.address = address;
        this.account = account;
        this.password = password;
    }
    
    /**
     * @return 发件人地址
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @return 发件人显示名
     */
    public String getDisplayName()
    {
        return displayName;
    }
   

    /**
     * @return smtp密码
     */
    public String getPassword()
    {
        return password;
    }

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
    public String toString()
    {
        return "FromAddress [displayName=" + displayName + ", address=" + address + "]";
    }

    /**
     * 从配置文件的一行中解析出一个MailFrom对象
     * @param originalLine
     * @return 一个新的MailFrom对象
     */
    
}
