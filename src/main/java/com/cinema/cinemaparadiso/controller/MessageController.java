package com.cinema.cinemaparadiso.controller;

import com.cinema.cinemaparadiso.model.Message;
import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.service.MessageService;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/messages")
@Slf4j
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/list")
    public String list(Model model){
        Iterable<Message> messages = messageService.list();
        model.addAttribute("messages", messages);
        log.info("Listing Messages..."+messages.toString());
        return "messages/listMessage";
    }

    @GetMapping("/show/{messageId}")
    public String show(Model model, String messageId){
    	try {
	        Message message = messageService.findById(messageId);
	        model.addAttribute("message", message);
	        log.info("Showing Message..."+message.toString());
    	}catch (NoSuchElementException e) {
	        log.error("Error Showing Message..."+messageId.toString());
		}
        return "messages/showMessage";
    }

    @PostMapping("/create/{userId}")
    public String create(Model model, String userId, Message message){
    	try {
    		messageService.create(message);
    		model.addAttribute("Estado", "Exito");
    	}catch (IllegalArgumentException e) {
    		model.addAttribute("Estado", "Error, entidad incorrecta");
		}
        log.info("Creating Messages..."+message.toString());
        return "messages/createMessage";
    }

    @DeleteMapping("/delete/{messageId}")
    public String delete(Model model, String messageId){
    	try {
    		Message message = messageService.findById(messageId);
    		messageService.delete(message);
    		model.addAttribute("Estado", "Exito");
            log.info("Deleting Messages..."+message.toString());
    	}catch (NoSuchElementException e) {
    		model.addAttribute("Estado", "Error, identificador incorrecto");
            log.error("Error Deleting Message..."+messageId);
		}
        return "messages/deleteMessage";
    }
}