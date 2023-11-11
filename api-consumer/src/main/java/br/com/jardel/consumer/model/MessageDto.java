package br.com.jardel.consumer.model;

import jakarta.validation.constraints.NotBlank;

public record MessageDto(@NotBlank String title) {
}