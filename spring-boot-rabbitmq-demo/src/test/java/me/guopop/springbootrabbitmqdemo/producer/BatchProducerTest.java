package me.guopop.springbootrabbitmqdemo.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BatchProducerTest {

    @Autowired
    private BatchProducer batchProducer;

    @Test
    void syncSend() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            String msg = "msg " + i;
            batchProducer.syncSend(msg);
            log.info("[producer][msg: {}][success]", msg);
            Thread.sleep(10 * 1000);
        }

        new CountDownLatch(1).await();
    }
}