package me.guopop.springbootrabbitmqdemo.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DirectExchangeProducerTest {

    @Autowired
    private DirectExchangeProducer producer;

    @Test
    void syncSend() throws InterruptedException {
        String message = "direct exchange message";
        producer.syncSend(message);
        log.info("[producer][message:{}][success]", message);

        new CountDownLatch(1).await();
    }

    @Test
    void syncSendDefault() throws InterruptedException {
        String message = "direct exchange message";
        producer.syncSendDefault(message);
        log.info("[producer][message:{}][success]", message);

        new CountDownLatch(1).await();
    }

    @Test
    void asyncSend() throws InterruptedException {
        String message = "direct exchange message";
        producer.asyncSend(message).addCallback(new ListenableFutureCallback<Void>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("[producer][message:{}][fail]", message);
            }

            @Override
            public void onSuccess(Void unused) {
                log.info("[producer][message:{}][success]", message);
            }
        });
        log.info("[producer][message:{}][complete]", message);

        new CountDownLatch(1).await();
    }
}