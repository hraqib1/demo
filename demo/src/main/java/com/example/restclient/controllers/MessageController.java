package com.example.restclient.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.file.Paths;
import java.time.Duration;

import com.example.restclient.DemoApplication;
import com.example.restclient.models.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
public class MessageController {

    RestTemplate restTemplate = new RestTemplate();
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    
    @GetMapping(value = "/goodreads/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Message> getMessage(@PathVariable("id") Integer id) throws URISyntaxException {
        Flux<Message> messageFlux = WebClient.create()
          .get()
          .uri(new URI("http://localhost:8080/message/"+id))
          .retrieve()
          .bodyToFlux(Message.class);
    
        messageFlux.subscribe(message -> log.info(message.toString()));
        return messageFlux;
    }
    
}
