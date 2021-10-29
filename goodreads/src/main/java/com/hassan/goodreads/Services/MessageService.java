package com.hassan.goodreads.Services;

import com.hassan.goodreads.Models.Message;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    Message message = new Message();

    public MessageService() {
		message.setId(01);
        message.setMessage("hello world");
	}
    
    public Message getMessageById(Integer id){
        if(message.getId() == id) {
            return message;
        }

        return null;
    }
}
