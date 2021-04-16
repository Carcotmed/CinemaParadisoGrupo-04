package com.cinema.cinemaparadiso.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Message;
import com.cinema.cinemaparadiso.model.Producer;
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
	
	@Autowired
    private ProducerService producerService;

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

    @Transactional
    public void delete(Message message) throws IllegalArgumentException{
    	messageRepository.delete(message);
    }
    
    public void requestToEnterProjectArtist(Integer projectId,Integer artistId) {
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
    
    public void requestToEnterProjectProducer(Integer projectId,Integer producerId) {
    	String adminProjectUsername = projectService.findProjectById(projectId).getMyAdmin();
    	Integer adminProjectId = artistService.findArtistByUsername(adminProjectUsername).getId();
    	User adminProjectUser = artistService.findMyUser(adminProjectId);
    	User requestProducerUser = producerService.findMyUser(producerId);
    	Project project = projectService.findProjectById(projectId);
    	Message message = new Message();
    	
    	message.setIssue("Quiero unirme a su proyecto");
    	message.setBody("Me gustaría entrar en su proyecto llamado "+ project.getTitle()+". Mi rol es Productor.");
    	message.setReceptor(adminProjectUser);
    	message.setEmisor(requestProducerUser);
    	message.setMessageDate(Date.from(Instant.now()));
    	message.setIsRequest(projectId);
    	
    	create(message);  
    }
    @Transactional
    public void acceptRequestArtist(Integer messageId) {
    	
    	Message message = findById(messageId);
    	Integer projectId = message.getIsRequest();
    	Project project = projectService.findProjectById(projectId);
    	message.setIsRequest(null);
    	Artist artistAccepted = artistService.findArtistByUsername(message.getEmisor().getUsername());
    	Artist artistOwnerProject = artistService.findArtistByUsername(message.getReceptor().getUsername());
    	projectService.addRelationShip(projectId, artistAccepted.getId());
    	
    	Message message2 = new Message();
    	

    	message2.setIssue("Has sido aceptado.");
    	message2.setBody("El admin de "+ project.getTitle()+" ha aceptado su solicitud.");
    	message2.setReceptor(artistService.findMyUser(artistAccepted.getId()));
    	message2.setEmisor(artistService.findMyUser(artistOwnerProject.getId()));
    	message2.setMessageDate(Date.from(Instant.now()));
    	message2.setIsRequest(null);
    	
    	create(message2);  
    }
    
    @Transactional
    public void rejectRequestArtist(Integer messageId) {
    	
    	Message message = findById(messageId);
    	Integer projectId = message.getIsRequest();
    	Project project = projectService.findProjectById(projectId);
    	message.setIsRequest(null);
    	Artist artistRejected = artistService.findArtistByUsername(message.getEmisor().getUsername());
    	Artist artistOwnerProject = artistService.findArtistByUsername(message.getReceptor().getUsername());
    	
    	Message message2 = new Message();
    	
    	message2.setIssue("Has sido rechazado.");
    	message2.setBody("El admin de "+ project.getTitle()+" ha rechazado su solicitud.");
    	message2.setReceptor(artistService.findMyUser(artistRejected.getId()));
    	message2.setEmisor(artistService.findMyUser(artistOwnerProject.getId()));
    	message2.setMessageDate(Date.from(Instant.now()));
    	message2.setIsRequest(null);
    	
    	create(message2);  
    }
    
    @Transactional
    public void acceptRequestProducer(Integer messageId) {
    	
    	Message message = findById(messageId);
    	Integer projectId = message.getIsRequest();
    	Project project = projectService.findProjectById(projectId);
    	message.setIsRequest(null);
    	Producer producerAccepted = producerService.findProducerByUsername(message.getEmisor().getUsername());
    	Artist artistOwnerProject = artistService.findArtistByUsername(message.getReceptor().getUsername());
    	projectService.addRelationShipProducer(projectId, producerAccepted.getId());
    	
    	Message message2 = new Message();
    	

    	message2.setIssue("Has sido aceptado.");
    	message2.setBody("El admin de "+ project.getTitle()+" ha aceptado su solicitud.");
    	message2.setReceptor(producerService.findMyUser(producerAccepted.getId()));
    	message2.setEmisor(artistService.findMyUser(artistOwnerProject.getId()));
    	message2.setMessageDate(Date.from(Instant.now()));
    	message2.setIsRequest(null);
    	
    	create(message2);  
    }
    
    @Transactional
    public void rejectRequestProducer(Integer messageId) {
    	
    	Message message = findById(messageId);
    	Integer projectId = message.getIsRequest();
    	Project project = projectService.findProjectById(projectId);
    	message.setIsRequest(null);
    	Artist artistRejected = artistService.findArtistByUsername(message.getEmisor().getUsername());
    	Artist artistOwnerProject = artistService.findArtistByUsername(message.getReceptor().getUsername());
    	
    	Message message2 = new Message();
    	
    	message2.setIssue("Has sido rechazado.");
    	message2.setBody("El admin de "+ project.getTitle()+" ha rechazado su solicitud.");
    	message2.setReceptor(artistService.findMyUser(artistRejected.getId()));
    	message2.setEmisor(artistService.findMyUser(artistOwnerProject.getId()));
    	message2.setMessageDate(Date.from(Instant.now()));
    	message2.setIsRequest(null);
    	
    	create(message2);  
    }
    
    
    public List<Message> findAllReceivedMessages(String username){
    	
    	return messageRepository.findAllMessagesReceived(username); 
    }
    
    public List<Message> findAllSentsMessages(String username){
    	
    	return messageRepository.findAllMessagesSents(username); 
    }
    
    
    
    
    
    
    
}