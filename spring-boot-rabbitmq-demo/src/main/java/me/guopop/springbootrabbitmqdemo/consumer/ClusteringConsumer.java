package me.guopop.springbootrabbitmqdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import me.guopop.springbootrabbitmqdemo.message.ClusteringMessage;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author guopop
 * @date 2021/1/4 10:31
 */
@Slf4j
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        name = ClusteringMessage.QUEUE + "-" + "GROUP-01"
                ),
                exchange = @Exchange(
                        name = ClusteringMessage.EXCHANGE,
                        type = ExchangeTypes.TOPIC,
                        declare = "false"
                ),
                key = "#"
        )
)
public class ClusteringConsumer {
    public void onMessage(ClusteringMessage message) {
        log.info("[onMessage][thread:{}][msg:{}]", Thread.currentThread().getId(), message);
    }
}
