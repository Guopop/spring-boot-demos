package me.guopop.springbootrabbitmqdemo.message;

import java.io.Serializable;

/**
 * @author guopop
 * @date 2020/12/26 10:32
 */
public class FanoutExchangeMessage implements Serializable {

    public static final String QUEUE_A = "QUEUE_THREE_A";

    public static final String QUEUE_B = "QUEUE_THREE_B";

    public static final String EXCHANGE = "EXCHANGE_THREE";
}
