package me.guopop.springbootrabbitmqdemo.producer;

import me.guopop.springbootrabbitmqdemo.message.FanoutExchangeMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2020/12/26 10:36
 */
@Component
public class FanoutExchangeProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(String msg) {
        rabbitTemplate.convertAndSend(FanoutExchangeMessage.EXCHANGE, null, msg);
    }
}
