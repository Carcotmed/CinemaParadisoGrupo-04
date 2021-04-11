package com.cinema.cinemaparadiso.service;

import java.time.Instant;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Message;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.repository.MessageRepository;

@Service
public class MessageService {
    
	@Autowired
    private MessageRepository messageRepository;
	
	@Autowired
    private ProjectService projectService;
	
	@Autowired
    private ArtistService artistService;

    public Message findById(Integer id) throws NoSuchElementException{
        return messageRepository.findById(id).get();
    }

    public Iterable<Message> findByEmisorUsername(String username) throws NoSuchElementException{
            return messageRepository.findByEmisorUsername(username);
    }

    public Iterable<Message> findByReceptorUsername(String username) throws NoSuchElementException{
            return messageRepository.findByReceptorUsername(username);
    }

    public Message create(Message message) throws IllegalArgumentException{

        return messageRepository.save(message);
    }

    public void delete(Message message) throws IllegalArgumentException{
    	messageRepository.delete(message);
    }
    
    public void requestToEnterProject(Integer projectId,Integer artistId) {
    	String adminProjectUsername = projectService.findProjectById(projectId).getMyAdmin();
    	System.out.println("********************************************************************************+"+ adminProjectUsername);
    	Integer adminProjectId = artistService.findArtistByUsername(adminProjectUsername).getId();
    	System.out.println("********************************************************************************+");
    	User adminProjectUser = artistService.findMyUser(adminProjectId);
    	System.out.println("********************************************************************************+");
    	User requestArtistUser = artistService.findMyUser(artistId);
    	System.out.println("********************************************************************************+");
    	Artist requestArtist = artistService.findArtistById(artistId);
    	System.out.println("********************************************************************************+");
    	Project project = projectService.findProjectById(projectId);
    	Message message = new Message();
    	
    	message.setIssue("Petición unirse a su proyecto");
    	message.setBody("Me gustaría entrar en su proyecto llamado "+ project.getTitle()+". Mi rol es "+requestArtist.getRole()+".");
    	message.setReceptor(adminProjectUser);
    	message.setEmisor(requestArtistUser);
    	message.setMessageDate(Date.from(Instant.now()));
    	
    	create(message);
    	
    	
    }
}