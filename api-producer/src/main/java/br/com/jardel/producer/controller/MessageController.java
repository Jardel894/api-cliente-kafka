package br.com.jardel.producer.controller;

import br.com.jardel.producer.model.Message;
import br.com.jardel.producer.model.MessageDto;
import br.com.jardel.producer.service.Publisher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/message")
public class MessageController {

    private final Publisher publisher;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void publishNews(@Valid @RequestBody MessageDto messageDto) {
        publisher.send("test-producer01", Message.toMessage(messageDto, Instant.now()));
    }
}