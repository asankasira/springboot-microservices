package org.asankasi.javaguide.rabbitmq.contoller;

import lombok.RequiredArgsConstructor;
import org.asankasi.javaguide.rabbitmq.dto.User;
import org.asankasi.javaguide.rabbitmq.publish.RabbitMQJsonProducer;
import org.asankasi.javaguide.rabbitmq.publish.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMQProducer producer;
    private final RabbitMQJsonProducer jsonProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> passMessage(@RequestParam("message") String msg) {
        producer.sendMessage(msg);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

    @PostMapping("/json/publish")
    public ResponseEntity<String> passJsonMessage(@RequestBody User usr) {
        jsonProducer.sendJsonMessage(usr);
        return ResponseEntity.ok("Json request sent to RabbitMQ ...");
    }
}
