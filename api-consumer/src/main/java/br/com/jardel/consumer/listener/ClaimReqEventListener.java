package br.com.jardel.consumer.listener;

import br.com.jardel.consumer.entity.Cliente;
import br.com.jardel.consumer.model.ClienteMessage;
import br.com.jardel.consumer.model.Message;
import br.com.jardel.consumer.repository.ClienteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Component
public class ClaimReqEventListener {


    private final ClienteRepository clienteRepository;

    @KafkaListener(id = "group01", topics = "test-producer01")
    public void handleClaimRequestEvent(Message message)  {
        log.info("Claim request received: {}", message);

    }

    @KafkaListener(id = "group02", topics = "topic.cliente")
    public void handleClaimRequestEventCliente(Message message)  {
        log.info("Claim request received: {}", message);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Cliente cliente = objectMapper.readValue(message.title(), Cliente.class);
            cliente.getEndereco().setCliente(cliente);
            clienteRepository.save(cliente);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}