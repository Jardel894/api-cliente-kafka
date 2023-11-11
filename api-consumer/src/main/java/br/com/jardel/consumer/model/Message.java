package br.com.jardel.consumer.model;

import java.time.Instant;

public record Message(String title, Instant createdOn) {

    public static Message toMessage(MessageDto messageDto, Instant createdOn){
        return new Message(messageDto.title(), createdOn);
    }
}