package com.cinema.cinemaparadiso.repository;

import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends CrudRepository<Producer,String>{
	
	Producer findByUser(String userName);

	//List<User> findByEnabled(Boolean enabled);

	Optional<Producer> findByNif(String nif);
    
}
