package me.guopop.springbootrabbitmqdemo.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DeadQueueProducerTest {

    @Autowired
    private DeadQueueProducer producer;

    @Test
    void syncSend() throws InterruptedException {
        String message = "dead queue message";
        producer.syncSend(message);
        log.info("[producer][message:{}][success]", message);

        new CountDownLatch(1).await();
    }
}