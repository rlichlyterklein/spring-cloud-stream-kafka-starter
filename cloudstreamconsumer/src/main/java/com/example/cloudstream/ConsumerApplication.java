package com.example.cloudstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

interface MessageChannels {
    String INPUT = "input";

    @Input(MessageChannels.INPUT)
    SubscribableChannel input();
}


@EnableBinding(MessageChannels.class)
@SpringBootApplication
public class ConsumerApplication {
    private static Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @StreamListener(MessageChannels.INPUT)
    public void processString(String msg) {
        logger.info(msg);
    }

}
