package me.guopop.springbootrabbitmqdemo.producer;

import me.guopop.springbootrabbitmqdemo.message.TopicExchangeMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2020/12/26 9:59
 */
@Component
public class TopicExchangeProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(String msg, String routingKey) {
        rabbitTemplate.convertAndSend(TopicExchangeMessage.EXCHANGE, routingKey, msg);
    }
}
