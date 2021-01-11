package me.guopop.springbootrabbitmqdemo.producer;

import me.guopop.springbootrabbitmqdemo.message.TimingMessage;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2020/12/28 9:15
 */
@Component
public class TimingProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(String msg, Integer delay) {
        rabbitTemplate.convertAndSend(TimingMessage.EXCHANGE, TimingMessage.ROUTING_KEY, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                if (delay != null && delay > 0) {
                    message.getMessageProperties().setExpiration(String.valueOf(delay));
                }
                return message;
            }
        });
    }
}
