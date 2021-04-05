package com.cinema.cinemaparadiso.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.repository.AuthoritiesRepository;
import com.cinema.cinemaparadiso.repository.ProducerRepository;
import com.cinema.cinemaparadiso.repository.UserRepository;

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

    public void createProducer(Producer producer){
    	userService.createUser(producer.getUser());
		 Authorities authorities = new Authorities(producer.getUser().getUsername(),"producer");
	     authoritiesRepository.save(authorities);
	    saveProducer(producer);
    }
    
	@Transactional
	public void saveProducer(Producer producer) throws DataAccessException{

			producerRepository.save(producer);	
		
	}

    public void deleteProducer(String producerUsername) throws NoSuchElementException {
        Producer producerToDelete = producerRepository.findByUser(producerUsername);
        producerRepository.delete(producerToDelete);

    }






}