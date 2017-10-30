package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.Log;
import com.memory.shop.api.goods.event.Attonity;
import com.memory.shop.api.goods.event.SendEvent;
import com.memory.shop.api.goods.service.IZMsgService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by wall on 2017/10/17.
 */
@Service
public class ZMsg implements IZMsgService,ApplicationListener<ApplicationEvent>{

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof SendEvent)
            sendMsg(((SendEvent) event).getLog());
        else if(event instanceof Attonity)
            attonity();
    }
    private void sendMsg(Log log){
        System.out.println("################强势包裹#####################");

        System.out.println(log);

        System.out.println("############################################");
    }
    private void attonity(){
        System.out.println("今天不上班");
    }

}
