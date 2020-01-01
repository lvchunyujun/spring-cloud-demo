package com.hexiaofei.sjzclient.service.message.impl.queue;


public class SMSQueue extends AbstractTaskQueue
{

    private static final long serialVersionUID = 7523844113171678946L;
    
    
    private static SMSQueue instance;

    public static SMSQueue getInstance()
    {
        if (instance == null)
        {
            instance = new SMSQueue();
        }
        return instance;
    }
}
