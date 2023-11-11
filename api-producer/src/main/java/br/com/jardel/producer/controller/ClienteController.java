package br.com.jardel.producer.controller;

import br.com.jardel.producer.model.ClienteRequest;
import br.com.jardel.producer.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("v1/cliente")
@RestController
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public void criarCliente(@RequestBody ClienteRequest clienteRequest){
        clienteService.cadastrarCliente(clienteRequest);
    }

}
