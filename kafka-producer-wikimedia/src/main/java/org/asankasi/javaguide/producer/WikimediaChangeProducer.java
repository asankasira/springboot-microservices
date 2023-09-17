package org.asankasi.javaguide.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaChangeProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.streamData.url}")
    private String streamUrl;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        EventHandler eventHandler = new WikimediaChangeHandler(kafkaTemplate, topicName);
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(streamUrl));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }
}
