package org.asankasi.javaguides.kafka;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public void sendMessage(String message) {
        log.info("Message sent: {}", message);
        kafkaTemplate.send(topicName, message);
    }
}
