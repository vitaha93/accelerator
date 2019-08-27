package com.introlabsystems.accelerator.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.introlabsystems.accelerator.client.model.FetchTask;
import com.introlabsystems.accelerator.client.rabbitmq.MessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(ClientApplication.class, args).getBean(MessageProducer.class).produceProduct(new FetchTask("http://google.com","result.queue","ttt"));
    }


}
