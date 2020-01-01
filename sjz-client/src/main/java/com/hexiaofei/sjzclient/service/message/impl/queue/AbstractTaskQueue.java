package com.hexiaofei.sjzclient.service.message.impl.queue;

import com.hexiaofei.sjzclient.service.message.impl.model.ThirdPartyTask;
import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 所有Queue的父类
 * @version 1.0
 */
public abstract class AbstractTaskQueue extends LinkedBlockingQueue<ThirdPartyTask>
{

    private static final long serialVersionUID = -3645243155204152472L;
    
    private static Logger logger = Logger.getLogger(AbstractTaskQueue.class);
    
    @Override
    public void put(ThirdPartyTask e) 
    {
        try
        {
            super.put(e);
        }
        catch(InterruptedException ie)
        {
            logger.error("InterruptedException while put new task in", ie);
        }
    }

    /**
     * 取队列头部的一个Task对象
     */
    @Override
    public ThirdPartyTask take()
    {
        try
        {
            return super.take();
        }
        catch(InterruptedException ie)
        {
            logger.error("InterruptedException while put new task in", ie);
            return null;
        }
    }

    
}
