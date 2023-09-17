package org.asankasi.javaguide.stockservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.asankasi.javaguide.basedomains.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent) {
        log.info("Order event received for stock service -> {}", orderEvent);
        //Persist order information to DB
    }
}
