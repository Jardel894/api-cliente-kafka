package br.com.jardel.producer.service;

import br.com.jardel.producer.model.ClienteRequest;
import org.springframework.stereotype.Service;


public interface ClienteService {

    void cadastrarCliente(ClienteRequest clienteRequest);

}
