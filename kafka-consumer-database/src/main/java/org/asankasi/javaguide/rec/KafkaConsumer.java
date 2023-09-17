package org.asankasi.javaguide.rec;

import lombok.extern.slf4j.Slf4j;
import org.asankasi.javaguide.entity.WikiMedia;
import org.asankasi.javaguide.repository.WikiMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    private WikiMediaRepository repository;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info("Event message received: -> {}", message);
        WikiMedia wkm = new WikiMedia();
        wkm.setWikData(message);
        repository.save(wkm);
    }

    @Autowired
    public void setRepository(WikiMediaRepository repository) {
        this.repository = repository;
    }
}
