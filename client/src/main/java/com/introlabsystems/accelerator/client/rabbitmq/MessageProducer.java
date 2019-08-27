package com.introlabsystems.accelerator.client.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.introlabsystems.accelerator.client.model.FetchTask;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceProduct(FetchTask fetchTask) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(QueueConstants.FETCH_EXCHANGE, QueueConstants.FETCH_ROUTING_KEY, fetchTask);
    }


}
