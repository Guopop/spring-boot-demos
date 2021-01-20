package me.guopop.springbootrabbitmqdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import me.guopop.springbootrabbitmqdemo.message.BatchMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2021/1/19 9:41
 */
@Component
@RabbitListener(queues = BatchMessage.QUEUE)
@Slf4j
public class BatchConsumer {

    @RabbitHandler
    public void onMessage(String msg) {
        log.info("[onMessage][thread: {}][msg: {}]", Thread.currentThread().getId(), msg);
    }
}
