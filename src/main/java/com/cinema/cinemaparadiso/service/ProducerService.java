package com.cinema.cinemaparadiso.service;

import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.repository.ProducerRepository;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    
    @Autowired
    private ProducerRepository producerRepository;
    
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
    
	public void deleteProducer(String producerUsername) throws NoSuchElementException {
		Producer producerToDelete = producerRepository.findByUser(producerUsername);
    	producerRepository.delete(producerToDelete);
		
	}
    

    

    

}
