package org.asankasi.javaguides.controller;

import lombok.AllArgsConstructor;
import org.asankasi.javaguides.kafka.JsonKafkaProducer;
import org.asankasi.javaguides.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private final JsonKafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User userData) {
        kafkaProducer.sendMessage(userData);
        return ResponseEntity.ok("Json message send to the topic");
    }
}
