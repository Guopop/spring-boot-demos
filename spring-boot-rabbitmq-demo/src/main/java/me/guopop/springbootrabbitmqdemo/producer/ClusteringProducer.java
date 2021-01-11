package me.guopop.springbootrabbitmqdemo.producer;

import me.guopop.springbootrabbitmqdemo.message.ClusteringMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2020/12/31 17:14
 */
@Component
public class ClusteringProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(String msg) {
        rabbitTemplate.convertAndSend(ClusteringMessage.EXCHANGE, null, msg);
    }
}
