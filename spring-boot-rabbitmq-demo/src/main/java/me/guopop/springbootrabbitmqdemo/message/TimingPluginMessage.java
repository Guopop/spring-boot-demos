package me.guopop.springbootrabbitmqdemo.message;

import java.io.Serializable;

/**
 * @author guopop
 * @date 2020/12/28 9:49
 */
public class TimingPluginMessage implements Serializable {
    public static final String QUEUE = "TIMING_PLUGIN_QUEUE";

    public static final String EXCHANGE = "TIMING_PLUGIN_EXCHANGE";

    public static final String ROUTING_KEY = "TIMING_PLUGIN_ROUTING_KEY";
}
