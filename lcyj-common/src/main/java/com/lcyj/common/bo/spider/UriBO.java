package com.lcyj.common.bo.spider;

/**
 * URI-历史轴统一资源定位符 <br/>
 *
 * @author lcyj
 * @date 2020-07-19 18:13
 * @since
 */
public class UriBO {

    private Integer uriId;

    private String uri;

    /**
     * uri所属语言
     */
    private String uriLanguage;

    public Integer getUriId() {
        return uriId;
    }

    public void setUriId(Integer uriId) {
        this.uriId = uriId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUriLanguage() {
        return uriLanguage;
    }

    public void setUriLanguage(String uriLanguage) {
        this.uriLanguage = uriLanguage;
    }
}
