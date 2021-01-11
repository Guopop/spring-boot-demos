package me.guopop.springbootrabbitmqdemo.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@Slf4j
@SpringBootTest
class ClusteringProducerTest {

    @Autowired
    private ClusteringProducer producer;

    @Test
    void mock() throws InterruptedException {
        new CountDownLatch(1).await();
    }

    @Test
    void syncSend() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            String msg = "msg " + i;
            producer.syncSend(msg);
            log.info("[producer][msg:{}][success]", msg);
        }

        new CountDownLatch(1).await();
    }
}