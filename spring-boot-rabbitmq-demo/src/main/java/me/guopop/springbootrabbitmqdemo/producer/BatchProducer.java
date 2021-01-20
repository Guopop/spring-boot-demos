package me.guopop.springbootrabbitmqdemo.producer;

import me.guopop.springbootrabbitmqdemo.message.BatchMessage;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2021/1/19 9:37
 */
@Component
public class BatchProducer {

    @Autowired
    private BatchingRabbitTemplate batchingRabbitTemplate;

    public void syncSend(String msg) {
        batchingRabbitTemplate.convertAndSend(BatchMessage.EXCHANGE, BatchMessage.ROUTING_KEY, msg);
    }
}
