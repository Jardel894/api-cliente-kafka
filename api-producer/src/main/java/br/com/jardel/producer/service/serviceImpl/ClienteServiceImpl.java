package br.com.jardel.producer.service.serviceImpl;

import br.com.jardel.producer.client.EnderecoViaCepClient;
import br.com.jardel.producer.model.*;
import br.com.jardel.producer.service.ClienteService;
import br.com.jardel.producer.service.Publisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {


   private final EnderecoViaCepClient enderecoViaCepClient;

   private final Publisher publisher;
    @Override
    public void cadastrarCliente(ClienteRequest clienteRequest) {
     EnderecoViaCep enderecoViaCep =
             enderecoViaCepClient.buscarViaCep(clienteRequest.cep());

        Endereco endereco = new Endereco(
                enderecoViaCep.cep(),
                enderecoViaCep.logradouro(),
                enderecoViaCep.complemento(),
                enderecoViaCep.bairro(),
                enderecoViaCep.localidade(),
                enderecoViaCep.uf(),
                clienteRequest.numero());

        ClienteMessage cliente = new ClienteMessage(clienteRequest.nome(), clienteRequest.email(), endereco);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String clienteString = objectMapper.writeValueAsString(cliente);
            Message message = new Message(clienteString, Instant.now());
            publisher.send("topic.cliente", message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
