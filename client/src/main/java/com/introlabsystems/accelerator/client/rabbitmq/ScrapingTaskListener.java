package com.introlabsystems.accelerator.client.rabbitmq;


import com.introlabsystems.accelerator.client.model.FetchTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScrapingTaskListener {

    @RabbitListener(queues = "result.queue")
    public void consume(FetchTask message) {
        log.info(message.toString());
    }

}
