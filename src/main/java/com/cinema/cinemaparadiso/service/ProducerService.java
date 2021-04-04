package com.cinema.cinemaparadiso.service;

import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.repository.ProducerRepository;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    
    @Autowired
    private ProducerRepository producerRepository;
    
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
    
    public void saveProducer(Producer producer){
    	producerRepository.save(producer);
    }
    
	public void deleteProducer(String producerUsername) throws NoSuchElementException {
		Producer producerToDelete = producerRepository.findByUser(producerUsername);
    	producerRepository.delete(producerToDelete);
		
	}
    

    

    

}
