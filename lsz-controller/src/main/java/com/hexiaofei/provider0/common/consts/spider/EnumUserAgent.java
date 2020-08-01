package com.hexiaofei.provider0.common.consts.spider;

/**
 * 浏览器客户端UserAgent字符串 <br/>
 *
 * @author lcyj
 * @date 2020-07-25 18:06
 * @since
 */
public enum EnumUserAgent {

    MAC_CHROME("MAC_CHROME","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36"),
    WIN_FIREFOX("WIN_FIREFOX","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:56.0) Gecko/20100101 Firefox/56.0");
    private String os_borwser;
    private String user_agent;

    EnumUserAgent(String os_borwser, String user_agent) {
        this.os_borwser = os_borwser;
        this.user_agent = user_agent;
    }

    public String getOs_borwser() {
        return os_borwser;
    }

    public String getUser_agent() {
        return user_agent;
    }

}
