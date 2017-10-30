package com.memory.shop.server.order.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
/**
 * Created by wall on 2017/10/25.
 */
@Component
public class MessageConsumerQueue {

    @JmsListener(destination="createOrderQueue",containerFactory="jmsListenerContainerQueue")
    public void receiveMessage(long userId){
        System.out.println(userId);
    }

}
