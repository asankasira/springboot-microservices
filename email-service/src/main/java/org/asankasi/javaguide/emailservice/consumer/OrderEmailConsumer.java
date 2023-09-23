package org.asankasi.javaguide.emailservice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.asankasi.javaguide.basedomains.dto.OrderEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderEmailConsumer {

    @RabbitListener(queues = "${rabbitmq.email-queue}")
    public void consume(OrderEvent orderEvent) {
        log.info("Order event received for email service -> {}", orderEvent);
        //Send email notification to client
    }
}
