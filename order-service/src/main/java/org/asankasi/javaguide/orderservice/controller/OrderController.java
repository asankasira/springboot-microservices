package org.asankasi.javaguide.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.asankasi.javaguide.basedomains.dto.Order;
import org.asankasi.javaguide.basedomains.dto.OrderEvent;
import org.asankasi.javaguide.orderservice.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class OrderController {

    private final RabbitMQProducer producer;

    @PostMapping("/publish")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent event = new OrderEvent();
        event.setOrder(order);
        event.setStatus("PENDING");
        event.setMessage("Order is in pending state");

        producer.sendMessage(event);
        return ResponseEntity.ok("Order sent to RabbitMQ ..");
    }
}
