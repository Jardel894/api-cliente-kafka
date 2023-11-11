package br.com.jardel.consumer.model;

import br.com.jardel.consumer.entity.Endereco;

public record ClienteMessage(String nome, String email, Endereco endereco) {
}
