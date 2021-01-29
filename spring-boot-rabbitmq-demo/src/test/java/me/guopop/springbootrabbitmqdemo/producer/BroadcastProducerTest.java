package me.guopop.springbootrabbitmqdemo.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@Slf4j
@SpringBootTest
class BroadcastProducerTest {

    @Autowired
    private BroadcastProducer broadcastProducer;

    @Test
    void mock() throws InterruptedException {
        new CountDownLatch(1).await();
    }

    @Test
    void syncSend() throws InterruptedException {
        broadcastProducer.syncSend("broadcast");
        log.info("[producer][msg: {}][success]", "broadcast");
    }
}