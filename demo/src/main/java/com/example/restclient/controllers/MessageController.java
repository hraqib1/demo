package com.example.restclient.controllers;

import com.example.restclient.DemoApplication;
import com.example.restclient.models.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageController {

    RestTemplate restTemplate = new RestTemplate();
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    
    @GetMapping(value = "/goodreads/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Message getResults(@PathVariable("id") Integer id) {
        if(id != null) {

            
            Message message = restTemplate.getForObject("http://localhost:8080/message/"+id, Message.class);
            log.info(message.toString());
            return message;
            
		
		}
        return null;
               

    }
    
}
