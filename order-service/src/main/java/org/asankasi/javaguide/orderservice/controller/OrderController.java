package org.asankasi.javaguide.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.asankasi.javaguide.basedomains.dto.Order;
import org.asankasi.javaguide.basedomains.dto.OrderEvent;
import org.asankasi.javaguide.orderservice.kafka.OrderProducer;
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

    private final OrderProducer producer;

    @PostMapping("/orders")
    public ResponseEntity<String> submitOrder(@RequestBody Order order) {
        OrderEvent event = new OrderEvent();
        event.setStatus("PENDING");
        event.setMessage("Placing order");
        event.setOrder(order);
        order.setOrderId(UUID.randomUUID().toString());

        producer.sendMessage(event);
        return ResponseEntity.ok("Order placed successfully...");
    }
}
