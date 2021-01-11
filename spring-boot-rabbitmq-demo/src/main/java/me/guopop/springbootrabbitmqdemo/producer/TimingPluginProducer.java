package me.guopop.springbootrabbitmqdemo.producer;

import me.guopop.springbootrabbitmqdemo.message.TimingPluginMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2020/12/28 9:57
 */
@Component
public class TimingPluginProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(String msg, Integer delay) {
        rabbitTemplate.convertAndSend(TimingPluginMessage.EXCHANGE, TimingPluginMessage.ROUTING_KEY, msg, message -> {
            message.getMessageProperties().setHeader("x-delay", delay);
            return message;
        });
    }
}
