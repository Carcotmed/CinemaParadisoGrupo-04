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
import com.cinema.cinemaparadiso.model.Rel_projects_story;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
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
    private StoryService storyService;
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private Rel_projects_storyService rel_projects_storyService;

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
    
    public void requestStory(Integer projectId, Integer storyId) {
    	Story story = storyService.findStoryById(storyId);
    	Project project = projectService.findProjectById(projectId);
    	Artist admin = artistService.findArtistByUsername(project.getMyAdmin());
    	Message message = new Message();
    	
    	message.setIssue("Quiero usar su historia");
    	message.setBody("Me gustaría usar su historia en mi proyecto " + project.getTitle() + ".");
    	message.setReceptor(storyService.findMyWriter(storyId).getUser());
    	message.setEmisor(admin.getUser());
    	message.setMessageDate(Date.from(Instant.now()));
    	message.setStory(story);
    	message.setIsRequest(projectId);
    	
    	create(message);  
    }
    public void acceptRequest(Integer messageId) {
    	
    	Message message = findById(messageId);
    	Integer projectId = message.getIsRequest();
    	Project project = projectService.findProjectById(projectId);
    	message.setIsRequest(null);
    	messageRepository.save(message);
    	
    	if(message.getStory()==null) {
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
    	}else {
    		if(rel_projects_storyService.countByProjectId(projectId)!=0) {
        		Story story = message.getStory();
        		Writer writer = storyService.findMyWriter(story.getId());
    			message.setStory(null);
    			message.setIsRequest(null);
    			messageRepository.save(message);
    			
    			Message message2 = new Message();
    	    	
    	    	message2.setIssue("Ocurrio un error");
    	    	message2.setBody("Su respuesta no se pudo enviar con exito ya que el proyecto " + project.getTitle() + " ya posee una historia.");
    	    	message2.setReceptor(writer.getUser());
    	    	message2.setEmisor(userService.getUserByUsername("admin"));
    	    	message2.setMessageDate(Date.from(Instant.now()));
    	    	message2.setIsRequest(null);
    	    	create(message2);
    		}else {
    			
	    		Artist admin = artistService.findArtistByUsername(message.getEmisor().getUsername());
	    		Story story = message.getStory();
	    		Writer writer = storyService.findMyWriter(story.getId());
	    		Rel_projects_story relacion = new Rel_projects_story();
				relacion.setProject_id(projectId);
				relacion.setStory_id(story.getId());
	    		rel_projects_storyService.save(relacion);
	    		System.out.println("before save project");
	    		projectService.saveProject(project);
	
		    	Message message2 = new Message();
		    	
		    	message2.setIssue("Su peticion ha sido aceptada");
		    	message2.setBody("El escritor "+ writer.getName()+" ha aceptado su solicitud para usar la historia " + story.getTitle() + ".");
		    	message2.setReceptor(admin.getUser());
		    	message2.setEmisor(writer.getUser());
		    	message2.setMessageDate(Date.from(Instant.now()));
		    	message2.setIsRequest(null);
	
	    		System.out.println("before save message");
		    	create(message2);
	    		System.out.println("after save message");
    		
    		}
    	}
    }
    
    @Transactional
    public void rejectRequest(Integer messageId) {
    	
    	Message message = findById(messageId);
    	Integer projectId = message.getIsRequest();
    	Project project = projectService.findProjectById(projectId);
    	message.setIsRequest(null);
    	messageRepository.save(message);
    	if(message.getStory()==null) {
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
    	}else {
    		if(rel_projects_storyService.countByProjectId(projectId)!=0) {
        		Story story = message.getStory();
        		Writer writer = storyService.findMyWriter(story.getId());
    			message.setStory(null);
    			message.setIsRequest(null);
    			messageRepository.save(message);
    			
    			Message message2 = new Message();
    	    	
    	    	message2.setIssue("Ocurrio un error");
    	    	message2.setBody("Su respuesta no se pudo enviar con exito ya que el proyecto " + project.getTitle() + " ya posee una historia.");
    	    	message2.setReceptor(writer.getUser());
    	    	message2.setEmisor(userService.getUserByUsername("admin"));
    	    	message2.setMessageDate(Date.from(Instant.now()));
    	    	message2.setIsRequest(null);
    	    	create(message2);
    		}else {
	    		Artist admin = artistService.findArtistByUsername(message.getEmisor().getUsername());
	    		Story story = message.getStory();
	    		Writer writer = storyService.findMyWriter(story.getId());
	
		    	Message message2 = new Message();
		    	
		    	message2.setIssue("Su peticion ha sido rechazada");
		    	message2.setBody("El escritor "+ writer.getName()+" ha rechazado su solicitud para usar la historia " + story.getTitle() + ".");
		    	message2.setReceptor(admin.getUser());
		    	message2.setEmisor(writer.getUser());
		    	message2.setMessageDate(Date.from(Instant.now()));
		    	message2.setIsRequest(null);
	
		    	create(message2);
    		}
    	}
    }
    
    
    
    
    
    
    
}