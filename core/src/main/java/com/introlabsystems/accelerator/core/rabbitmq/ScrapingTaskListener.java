package com.introlabsystems.accelerator.core.rabbitmq;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.introlabsystems.accelerator.core.model.FetchTask;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

@Component
@Slf4j
public class ScrapingTaskListener {

    @RabbitListener(queues = QueueConstants.FETCH_QUEUE)
    public void consume(FetchTask message) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            log.info(message.toString());
            message.setResponse("Scraped html content");

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {
                channel.queueDeclare(message.getReturnQueue(), true, false, false, null);
                channel.basicPublish("", message.getReturnQueue(), null, new ObjectMapper().writeValueAsString(message).getBytes());
                System.out.println(" [x] Sent '" + message + "'");
            } catch (IOException | TimeoutException e) {
                log.error(e.getMessage(), e);
            }

        });
    }

}
