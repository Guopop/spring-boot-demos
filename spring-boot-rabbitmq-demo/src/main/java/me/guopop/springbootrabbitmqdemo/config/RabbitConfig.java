package me.guopop.springbootrabbitmqdemo.config;

import me.guopop.springbootrabbitmqdemo.message.DeadQueueMessage;
import me.guopop.springbootrabbitmqdemo.message.DirectExchangeMessage;
import me.guopop.springbootrabbitmqdemo.message.FanoutExchangeMessage;
import me.guopop.springbootrabbitmqdemo.message.TopicExchangeMessage;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guopop
 * @date 2020/12/26 9:10
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue directQueue() {
        return new Queue(DirectExchangeMessage.QUEUE);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DirectExchangeMessage.EXCHANGE);
    }

    @Bean
    public Binding directBinding() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(DirectExchangeMessage.ROUTING_KEY);
    }

    //------------------------------------------------------------------------------------------------

    @Bean
    public Queue topicQueue() {
        return new Queue(TopicExchangeMessage.QUEUE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TopicExchangeMessage.EXCHANGE);
    }

    @Bean
    public Binding topicBinding() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(TopicExchangeMessage.ROUTING_KEY);
    }

    //------------------------------------------------------------------------------------------------

    @Bean
    public Queue fanoutQueueA() {
        return new Queue(FanoutExchangeMessage.QUEUE_A);
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue(FanoutExchangeMessage.QUEUE_B);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FanoutExchangeMessage.EXCHANGE);
    }

    @Bean
    public Binding fanoutBindingA() {
        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingB() {
        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
    }

    //------------------------------------------------------------------------------------------------

    @Bean
    public Queue deadQueue() {
        return QueueBuilder
                .durable(DeadQueueMessage.QUEUE)
                .exclusive()
                .autoDelete()
                .deadLetterExchange(DeadQueueMessage.EXCHANGE)
                .deadLetterRoutingKey(DeadQueueMessage.DEAD_ROUTING_KEY)
                .build();
    }

    @Bean
    public Queue deadQueueDead() {
        return new Queue(DeadQueueMessage.DEAD_QUEUE);
    }

    @Bean
    public DirectExchange deadQueueExchange() {
        return new DirectExchange(DeadQueueMessage.EXCHANGE);
    }

    @Bean
    public Binding deadQueueBinding() {
        return BindingBuilder.bind(deadQueue()).to(deadQueueExchange()).with(DeadQueueMessage.ROUTING_KEY);
    }

    @Bean
    public Binding deadQueueDeadBinding() {
        return BindingBuilder.bind(deadQueueDead()).to(deadQueueExchange()).with(DeadQueueMessage.DEAD_ROUTING_KEY);
    }
}
