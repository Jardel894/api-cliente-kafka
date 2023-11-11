package br.com.jardel.producer.service;

import br.com.jardel.producer.model.Message;
import org.springframework.stereotype.Service;

@Service
public interface Publisher {

     void send(String topic, Message message);
}
