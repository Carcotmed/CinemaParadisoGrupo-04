package com.cinema.cinemaparadiso.repository;

import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends CrudRepository<Producer,String>{
	
	Producer findByUserName(String userName);

	List<User> findByEnabled(Boolean enabled);
    
}
