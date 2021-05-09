package com.cinema.cinemaparadiso.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ArtistService artistService;
    
    @Autowired
    private StoryService storyService;
    
    @Autowired
    private ProducerService producerService;
    
    @Autowired
    private WriterService writerService;
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private Rel_projects_artistsService rel_projects_artistsService;
    
    @Autowired
    private Rel_projects_producersService rel_projects_producersService;
    
    @Autowired
    private RelUserStoryService relUserStoryService;
    
    @Autowired
    private Rel_story_writersService rel_story_writersService;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private MessageService messageService;
    
    @Autowired
    private AuthoritiesService authoritiesService;

    public long countUsers(){
        return userRepository.count();
    }
    
    public Iterable<User> list(){
        return userRepository.findAll();
    }

    public Boolean isAdmin(){
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("admin"));
    }
    
    public User getUserByUsername(String username) throws NoSuchElementException {
    	return userRepository.findById(username).get();
    }

    public void createUser(User user){
        String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
        user.setPassword(encryptedPassword);
        user.setEnabled(true);
        userRepository.save(user);
       
    }
    
    public void changePassword (String userName, String oldPassword, String newPassword) throws Exception, NoSuchElementException{
        String encryptedOldPassword = BCrypt.hashpw(oldPassword, BCrypt.gensalt(10));
        User retrievedUser = getUserByUsername(userName);
        if (retrievedUser.getPassword().equals(encryptedOldPassword)) {
        	String encryptedNewPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt(10));
        	retrievedUser.setPassword(encryptedNewPassword);
        	userRepository.save(retrievedUser);
        } else {
        	throw new Exception("The found user's password and the given old passwords dont match");
        }
    }
    
    public void enableUser(String userName) throws NoSuchElementException {
    	User retrievedUser = getUserByUsername(userName);
    	retrievedUser.setEnabled(true);
    	userRepository.save(retrievedUser);
    }
    
    public void disableUser(String userName) throws NoSuchElementException {
    	User retrievedUser = userRepository.findById(userName).get();
    	retrievedUser.setEnabled(false);
    	userRepository.save(retrievedUser);
    }
    

    //Comprobar user logeado

	public User getPrincipal() {
		User res = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			Optional<User> currentUser = findUser(userDetail.getUsername());
			
			if(currentUser.isPresent()) {
				res = currentUser.get();
			}
		}
		
		return res;
	}
  
	public Optional<User> findUser(String username) {
		return userRepository.findById(username);
	}
	
	public Optional<Artist> findArtistByUserUsername(String username){
		return this.userRepository.findArtistByUserUsername(username);
	}
	
	public Optional<Writer> findWriterByUserUsername(String username){
		return this.userRepository.findWriterByUserUsername(username);
	}
	
	public Optional<Producer> findProducerByUserUsername(String username){
		return this.userRepository.findProducerByUserUsername(username);
	}
	
    public List<User> getEnabledUsers() {
    	return userRepository.findEnabledUsers();
    }
    
    @Transactional
    public void deleteUser(User user) {
    	String username = user.getUsername();
    	this.postService.deletePostOfAnUser(username);
    	this.messageService.deleteMessagesOfAnUser(username);
    	this.authoritiesService.deleteAuthorities(username);
    	this.relUserStoryService.deleteRelationsUserStories(username);
    	this.commentService.deleteByUser(username);
    	//ARTIST
    	Optional<Artist> optionalArtist = this.userRepository.findArtistByUserUsername(username);
    	if(optionalArtist.isPresent()) {
    	this.rel_projects_artistsService.deleteRelationsArtistProjects(optionalArtist.get().getId());
    	this.artistService.deleteCompletelyArtist(optionalArtist.get());
    	}
    	//PRODUCER
    	Optional<Producer> optionalProducer = this.userRepository.findProducerByUserUsername(username);
    	if(optionalProducer.isPresent()) {
    	this.rel_projects_producersService.deleteRelationsProducerProjects(optionalProducer.get().getId());
    	this.producerService.deleteCompletelyProducer(optionalProducer.get());
    	}
    	//WRITER
    	Optional<Writer> optionalWriter = this.userRepository.findWriterByUserUsername(username);
    	if(optionalWriter.isPresent()) {
	    	//this.rel_story_writersService.deleteRelationsWriterStories(optionalWriter.get().getId());
	    	this.writerService.deleteCompletelyWriter(optionalWriter.get());
	    	this.commentService.deleteByUser(username);
	    	storyService.transferStoriesByWriterId(optionalWriter.get().getId());
    	}
    	this.userRepository.delete(user);
    }

}
