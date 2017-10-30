package com.memory.shop.server.goods.message;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by wall on 2017/10/25.
 */
@Component
public class SendOrder {

    @Autowired
    private JmsTemplate jmsTemplate;

    javax.jms.Destination destinationQueue =  new ActiveMQQueue("createOrderQueue");

    javax.jms.Destination destinationTopic = new ActiveMQTopic("createOrderTopic");

    public void sendMessageQueue(long userId){
        jmsTemplate.convertAndSend(destinationQueue,userId);
    }

    public void sendMessageTopic(long userId){
        jmsTemplate.convertAndSend(destinationTopic,userId);
    }
}
