package com.cinema.cinemaparadiso.service;

import com.cinema.cinemaparadiso.model.Message;
import com.cinema.cinemaparadiso.repository.MessageRepository;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
	@Autowired
    private MessageRepository messageRepository;

    public Message findById(String id) throws NoSuchElementException{
        return messageRepository.findById(id).get();
    }

    public Iterable<Message> findByUsername(String username) throws NoSuchElementException{
            return messageRepository.findByUsername(username);
    }

    public Iterable<Message> list(String username){
        return messageRepository.findByUsername(username);
    }

    public Message create(Message message) throws IllegalArgumentException{
        return messageRepository.save(message);
    }

    public void delete(Message message) throws IllegalArgumentException{
    	messageRepository.delete(message);
    }
}