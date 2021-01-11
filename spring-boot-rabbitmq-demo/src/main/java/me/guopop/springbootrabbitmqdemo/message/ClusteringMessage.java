package me.guopop.springbootrabbitmqdemo.message;

import java.io.Serializable;

/**
 * @author guopop
 * @date 2020/12/31 15:06
 */
public class ClusteringMessage implements Serializable {

    public static final String QUEUE = "QUEUE_CLUSTERING";

    public static final String EXCHANGE = "EXCHANGE_CLUSTERING";
}
