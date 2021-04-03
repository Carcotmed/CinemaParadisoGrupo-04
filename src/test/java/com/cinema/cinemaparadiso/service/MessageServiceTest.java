package com.cinema.cinemaparadiso.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.cinema.cinemaparadiso.model.Message;
import com.cinema.cinemaparadiso.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageServiceTest {

    @Autowired
	private MessageService messageService;
	
	// Cuando se termine de hacer la funcionalidad y se concrete mejor el data
	// se descomenta estos comentarios 

    @Test
    public void shouldListUsernameMessages(){
		 
        Iterable<Message> msgs = messageService.findByUsername("user");
		for(Message msg: msgs){
            if(msg.getId()==1) assertThat(msg.getIssue()).isEqualTo("Bienvenido");
        }

    }

    
}
