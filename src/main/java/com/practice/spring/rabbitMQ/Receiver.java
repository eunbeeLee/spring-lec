package com.practice.spring.rabbitMQ;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {
    // CountDownLatch: 병행처리를 하기 위한 기능
    // new CountLatch(5) 최대 5개 쓰레드 동시 실행
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message){
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }
    public CountDownLatch getLatch(){
        return latch;
    }
}
