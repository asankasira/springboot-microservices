package org.asankasi.javaguide.orderservice.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.asankasi.javaguide.basedomains.dto.OrderEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQProducer {
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.routing-key}")
    private String routingKey;
    @Value("${rabbitmq.email-routing-key}")
    private String emailRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(OrderEvent orderEvent) {
        log.info("Published order event to order and email queues: {}", orderEvent);
        rabbitTemplate.convertAndSend(exchange, routingKey, orderEvent);
        rabbitTemplate.convertAndSend(exchange, emailRoutingKey, orderEvent);
    }
}
