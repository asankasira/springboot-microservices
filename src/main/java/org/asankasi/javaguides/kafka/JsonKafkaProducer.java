package org.asankasi.javaguides.kafka;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.asankasi.javaguides.payload.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JsonKafkaProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    public void sendMessage(User usr) {
        log.info("JSON message to send --> : {}", usr);
        Message<User> m = MessageBuilder.withPayload(usr)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();
        kafkaTemplate.send(m);
    }
}
