package me.guopop.springbootrabbitmqdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import me.guopop.springbootrabbitmqdemo.message.TopicExchangeMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2020/12/26 9:26
 */
@Slf4j
@Component
@RabbitListener(queues = TopicExchangeMessage.QUEUE)
public class TopicExchangeConsumer {

    @RabbitHandler
    public void onMessage(String msg) {
        log.info("[consumer][thread:{}][message:{}]", Thread.currentThread().getId(), msg);
    }
}
