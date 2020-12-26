package me.guopop.springbootrabbitmqdemo.message;

import java.io.Serializable;

/**
 * @author guopop
 * @date 2020/12/26 9:54
 */
public class TopicExchangeMessage implements Serializable {

    public static final String QUEUE = "QUEUE_TWO";

    public static final String EXCHANGE = "EXCHANGE_TWO";

    public static final String ROUTING_KEY = "#.work.me";
}
