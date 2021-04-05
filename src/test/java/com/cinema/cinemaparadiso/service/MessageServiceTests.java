package com.cinema.cinemaparadiso.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import com.cinema.cinemaparadiso.model.Message;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Sql("/db/test.sql")
@Transactional
public class MessageServiceTests {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
/*
    @Test
	public void shouldFindMessageById() {
    	Message message = messageService.findByUsername("userTest1").iterator().next();
    	Message sameMessage = messageService.findById(message.getId());
    	
    	assertEquals(message, sameMessage);
	}
    
    @Test
    public void shouldFindMessagesByUsername() {
    	Message message = messageService.findByUsername("userTest1").iterator().next();
    	assertEquals(message.getBody(), "Test Body 1");
    }
    
    @Test
    public void shouldCreateMessage() {
    	Message message = new Message();
    	message.setIssue("New Test Issue");
    	message.setBody("New Test Body");
    	message.setEmisor(userService.getUserByUsername("userTest1"));
    	message.setReceptor(userService.getUserByUsername("userTest1"));
    	
    	messageService.create(message);
    	Message savedMessage = messageService.findById(message.getId());
    	assertNotNull(savedMessage);
    	assertEquals(savedMessage.getBody(), "New Test Body");
    	assertEquals(savedMessage.getIssue(), "New Test Issue");

    }
    
    @Test
    public void shouldDeleteMessage() {
    	Message message = messageService.findByUsername("userTest1").iterator().next();
    	Integer messageId = message.getId();
    	
    	messageService.delete(message);
    	
    	assertThrows(NoSuchElementException.class, () -> messageService.findById(messageId));
    }
    
    */

}
