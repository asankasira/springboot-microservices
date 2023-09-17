package org.asankasi.javaguide.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.asankasi.javaguide.rabbitmq.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.json-name}")
    public void consumeJsonMessage(User user) {
        log.info("Received json message -> {}", user);
    }
}
