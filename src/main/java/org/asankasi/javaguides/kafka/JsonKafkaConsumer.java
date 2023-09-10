package org.asankasi.javaguides.kafka;

import lombok.extern.slf4j.Slf4j;
import org.asankasi.javaguides.payload.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User usr) {
        log.info("Consumer received json message: {}", usr);
    }
}
