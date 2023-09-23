package org.asankasi.javaguide.stockservice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.asankasi.javaguide.basedomains.dto.OrderEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderStockConsumer {

    @RabbitListener(queues = "${rabbitmq.order-queue}")
    public void consume(OrderEvent orderEvent) {
        log.info("Order event received for stock service -> {}", orderEvent);
        //save order stock information
    }
}
