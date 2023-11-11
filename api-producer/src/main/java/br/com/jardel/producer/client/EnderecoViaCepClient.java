package br.com.jardel.producer.client;

import br.com.jardel.producer.model.EnderecoViaCep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-endereco", url = "https://viacep.com.br/ws")
public interface EnderecoViaCepClient {

    @GetMapping("/{cep}/json")
    EnderecoViaCep buscarViaCep(@PathVariable String cep);

}
