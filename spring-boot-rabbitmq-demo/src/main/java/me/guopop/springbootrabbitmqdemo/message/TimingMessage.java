package me.guopop.springbootrabbitmqdemo.message;

import java.io.Serializable;

/**
 * @author guopop
 * @date 2020/12/28 9:04
 */
public class TimingMessage implements Serializable {
    public static final String QUEUE = "TIMING_QUEUE";
    public static final String DELAY_QUEUE = "TIMING_QUEUE_DELAY";

    public static final String EXCHANGE = "TIMING_EXCHANGE";

    public static final String ROUTING_KEY = "TIMING_ROUTING_KEY";
    public static final String DELAY_ROUTING_KEY = "TIMING_ROUTING_KEY_DELAY";
}
