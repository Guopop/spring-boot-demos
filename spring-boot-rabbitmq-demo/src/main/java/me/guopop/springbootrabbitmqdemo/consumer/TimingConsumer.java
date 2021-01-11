package me.guopop.springbootrabbitmqdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import me.guopop.springbootrabbitmqdemo.message.TimingMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2020/12/28 9:19
 */
@Slf4j
@Component
@RabbitListener(queues = TimingMessage.DELAY_QUEUE)
public class TimingConsumer {

    @RabbitHandler
    public void onMessage(String msg) {
        log.info("[consumer][thread:{}][message:{}]", Thread.currentThread().getId(), msg);
    }
}
