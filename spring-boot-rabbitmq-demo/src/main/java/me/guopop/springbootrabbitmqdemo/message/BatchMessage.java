package me.guopop.springbootrabbitmqdemo.message;

import java.io.Serializable;

/**
 * @author guopop
 * @date 2021/1/19 9:28
 */
public class BatchMessage implements Serializable {

    public static final String QUEUE = "BATCH_QUEUE";

    public static final String EXCHANGE = "BATCH_EXCHANGE";

    public static final String ROUTING_KEY = "BATCH_ROUTING_KEY";
}
