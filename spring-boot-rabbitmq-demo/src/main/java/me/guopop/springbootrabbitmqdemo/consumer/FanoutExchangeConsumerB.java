package me.guopop.springbootrabbitmqdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import me.guopop.springbootrabbitmqdemo.message.FanoutExchangeMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2020/12/26 10:44
 */
@Slf4j
@Component
@RabbitListener(queues = FanoutExchangeMessage.QUEUE_B)
public class FanoutExchangeConsumerB {

    @RabbitHandler
    public void onMessage(String msg) {
        log.info("[consumer][thread:{}][message:{}]", Thread.currentThread().getId(), msg);
    }
}
