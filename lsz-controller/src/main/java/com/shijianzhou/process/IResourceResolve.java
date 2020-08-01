package com.shijianzhou.process;

import java.io.InputStream;

/**
 * IResouceResolve资源解析提取接口 <br/>
 *
 * @author lcyj
 * @date 2020-07-25 23:01
 * @since
 */
public interface IResourceResolve {


    /**
     * 根据资源提取
     */
    void resolve(InputStream in);

    /**
     *
     * @param content
     */
    void resolve(String content);
}
