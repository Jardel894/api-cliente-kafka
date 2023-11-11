package br.com.jardel.producer.model;

import jakarta.validation.constraints.NotBlank;

public record MessageDto(@NotBlank String title) {
}