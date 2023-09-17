package org.asankasi.javaguide;

import org.asankasi.javaguide.producer.WikimediaChangeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerWikimediaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerWikimediaApplication.class, args);
    }
    private WikimediaChangeProducer changeProducer;

    @Override
    public void run(String... args) throws Exception {
        changeProducer.sendMessage();
    }

    @Autowired
    public void setChangeProducer(WikimediaChangeProducer changeProducer) {
        this.changeProducer = changeProducer;
    }
}
