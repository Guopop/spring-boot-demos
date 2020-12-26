package me.guopop.springbootrabbitmqdemo.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class TopicExchangeProducerTest {

    @Autowired
    private TopicExchangeProducer producer;

    @Test
    void syncSendSuccess() throws InterruptedException {
        String message = "topic exchange message";
        producer.syncSend(message, "happy.work.me");
        log.info("[producer][message:{}][success]", message);

        new CountDownLatch(1).await();
    }

    @Test
    void syncSendFail() throws InterruptedException {
        String message = "topic exchange message";
        producer.syncSend(message, "work.me.yes");
        log.info("[producer][message:{}][success]", message);

        new CountDownLatch(1).await();
    }
}