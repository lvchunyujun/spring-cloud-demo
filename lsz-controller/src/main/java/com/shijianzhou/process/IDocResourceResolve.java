package com.shijianzhou.process;

/**
 * 文档资源分解提取服务 <br/>
 *
 * @author lcyj
 * @date 2020-07-25 23:14
 * @since
 */
public interface IDocResourceResolve extends IResourceResolve {

    void resolve(IResource resource);
}
