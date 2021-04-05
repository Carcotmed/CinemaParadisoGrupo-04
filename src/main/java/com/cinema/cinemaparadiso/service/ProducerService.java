package com.cinema.cinemaparadiso.service;

import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.repository.AuthoritiesRepository;
import com.cinema.cinemaparadiso.repository.ProducerRepository;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    
    @Autowired
    private ProducerRepository producerRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthoritiesRepository authoritiesRepository;
    
    public boolean existeProducerByUsername(String username) {
    	Integer count = producerRepository.countByUsername(username);
    	return count != 0;
    }
    

    public long countProducers(){
        return producerRepository.count();
    }

    public Iterable<Producer> list(){
        return producerRepository.findAll();
    }
    
    public Producer getProducerByNif(String nif) throws NoSuchElementException {
    	return producerRepository.findByNif(nif).get();
    }
    
    public Producer getProducerByUsername(String username) throws NoSuchElementException {
    	return producerRepository.findByUser(username);
    }
    
    public Producer getProducerById(Integer id) throws NoSuchElementException {
    	return producerRepository.findById(id).get();
    }
    
    public void saveProducer(Producer producer){
    	producerRepository.save(producer);
    }

    public void createProducer(Producer producer){
    	userService.createUser(producer.getUser());
		 Authorities authorities = new Authorities(producer.getUser().getUsername(),"producer");
	     authoritiesRepository.save(authorities);
	    saveProducer(producer);
    }

    public void deleteProducer(Producer producer){
    	authoritiesRepository.delete(authoritiesRepository.findByUsername(producer.getUser().getUsername()));
    	producerRepository.delete(producer);
    	userService.deleteUser(producer.getUser());
	    saveProducer(producer);
    }
    

    

    

}

