package com.hexiaofei.provider0.service.spider;
import com.lcyj.common.bo.spider.UriBO;

/**
 * spider服务接口 <br/>
 *
 * @author lcyj
 * @date 2020-07-19 18:08
 * @since
 */
public interface ISpiderService {

    /**
     * 加载uri
     * @param lszUriBO
     */
    void downloadUrl(UriBO lszUriBO);

    void downloadUrl(UriBO lszUriBO,boolean recursionFlag);
}
