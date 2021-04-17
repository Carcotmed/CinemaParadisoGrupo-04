package com.cinema.cinemaparadiso.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;


    

    public long countUsers(){
        return userRepository.count();
    }
    
    public void deleteUser(User user) {
    	userRepository.delete(user);
    }

    public Iterable<User> list(){
        return userRepository.findAll();
    }
    
    public List<User> getEnabledUsers() {
    	return userRepository.findByEnabled(true);
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

}
