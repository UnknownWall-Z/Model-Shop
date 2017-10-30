package com.memory.shop.api.goods.event;

import com.memory.shop.api.goods.domain.Log;
import org.springframework.context.ApplicationEvent;

/**
 * Created by wall on 2017/10/17.
 */
public class SendEvent extends ApplicationEvent {

    private Log log;

    public SendEvent(Object source,Log log) {
        super(source);
        this.log = log;
    }
    public Log getLog(){
        return log;
    }
}
