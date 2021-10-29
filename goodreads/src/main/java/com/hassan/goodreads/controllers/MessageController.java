package com.hassan.goodreads.controllers;

import com.hassan.goodreads.Models.Message;
import com.hassan.goodreads.Services.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageController {
    
    @Autowired
    MessageService messageService;
    
    @GetMapping("/message/{id}")
    @ResponseBody
    public Message getResults(@RequestParam("id") Integer id) {
        if(id != null) {

            return messageService.getMessageById(id);
		
		}
        return null;
               

    }
    
}
