package br.com.jardel.producer.service.serviceImpl;

import br.com.jardel.producer.model.Message;
import br.com.jardel.producer.service.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class PublisherImpl implements Publisher {

    private final StreamBridge streamBridge;

    public void send(String topic, Message message) {
        streamBridge.send(topic, message);
        log.info("{} sent!", message);
    }
}