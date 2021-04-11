package com.cinema.cinemaparadiso.service;

import java.time.Instant;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    	message.setIsRequest(0);
        return messageRepository.save(message);
    }

    public void delete(Message message) throws IllegalArgumentException{
    	messageRepository.delete(message);
    }
    
    public void requestToEnterProject(Integer projectId,Integer artistId) {
    	String adminProjectUsername = projectService.findProjectById(projectId).getMyAdmin();
    	Integer adminProjectId = artistService.findArtistByUsername(adminProjectUsername).getId();
    	User adminProjectUser = artistService.findMyUser(adminProjectId);
    	User requestArtistUser = artistService.findMyUser(artistId);
    	Artist requestArtist = artistService.findArtistById(artistId);
    	Project project = projectService.findProjectById(projectId);
    	Message message = new Message();
    	
    	message.setIssue("Quiero unirme a su proyecto");
    	message.setBody("Me gustaría entrar en su proyecto llamado "+ project.getTitle()+". Mi rol es "+requestArtist.getRole()+".");
    	message.setReceptor(adminProjectUser);
    	message.setEmisor(requestArtistUser);
    	message.setMessageDate(Date.from(Instant.now()));
    	message.setIsRequest(projectId);
    	
    	create(message);  
    }
    @Transactional
    public void acceptRequest(Integer messageId) {
    	
    	Message message = findById(messageId);
    	Integer projectId = message.getIsRequest();
    	Project project = projectService.findProjectById(projectId);
    	message.setIsRequest(0);
    	Artist artistAccepted = artistService.findArtistByUsername(message.getEmisor().getUsername());
    	Artist artistOwnerProject = artistService.findArtistByUsername(message.getReceptor().getUsername());
    	projectService.addRelationShip(projectId, artistAccepted.getId());
    	
    	Message message2 = new Message();
    	

    	message2.setIssue("Has sido aceptado.");
    	message2.setBody("El admin de "+ project.getTitle()+" ha aceptado su solicitud.");
    	message2.setReceptor(artistService.findMyUser(artistAccepted.getId()));
    	message2.setEmisor(artistService.findMyUser(artistOwnerProject.getId()));
    	message2.setMessageDate(Date.from(Instant.now()));
    	message2.setIsRequest(0);
    	
    	create(message2);  
    }
    
    @Transactional
    public void rejectRequest(Integer messageId) {
    	
    	Message message = findById(messageId);
    	Integer projectId = message.getIsRequest();
    	Project project = projectService.findProjectById(projectId);
    	message.setIsRequest(0);
    	Artist artistRejected = artistService.findArtistByUsername(message.getEmisor().getUsername());
    	Artist artistOwnerProject = artistService.findArtistByUsername(message.getReceptor().getUsername());
    	projectService.addRelationShip(projectId, artistRejected.getId());
    	
    	Message message2 = new Message();
    	

    	message2.setIssue("Has sido rechazado.");
    	message2.setBody("El admin de "+ project.getTitle()+" ha rechazado su solicitud.");
    	message2.setReceptor(artistService.findMyUser(artistRejected.getId()));
    	message2.setEmisor(artistService.findMyUser(artistOwnerProject.getId()));
    	message2.setMessageDate(Date.from(Instant.now()));
    	message2.setIsRequest(0);
    	
    	create(message2);  
    }
    
    
    
    
    
    
    
}