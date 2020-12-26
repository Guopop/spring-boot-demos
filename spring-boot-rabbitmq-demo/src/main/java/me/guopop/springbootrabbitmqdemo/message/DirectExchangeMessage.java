package me.guopop.springbootrabbitmqdemo.message;

import java.io.Serializable;

/**
 * @author guopop
 * @date 2020/12/26 9:32
 */
public class DirectExchangeMessage implements Serializable {

    public static final String QUEUE = "QUEUE_ONE";

    public static final String EXCHANGE = "EXCHANGE_ONE";

    public static final String ROUTING_KEY = "ROUTING_KEY_ONE";
}
