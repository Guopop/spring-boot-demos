package me.guopop.springbootrabbitmqdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import me.guopop.springbootrabbitmqdemo.message.TimingPluginMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2020/12/28 10:00
 */
@Slf4j
@Component
@RabbitListener(queues = TimingPluginMessage.QUEUE)
public class TimingPluginConsumer {

    @RabbitHandler
    public void onMessage(String msg) {
        log.info("[consumer][thread:{}][message:{}]", Thread.currentThread().getId(), msg);
    }
}
