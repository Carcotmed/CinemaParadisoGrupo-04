package com.cinema.cinemaparadiso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;

@Repository
public interface ProducerRepository extends CrudRepository<Producer,Integer>{
	
	@Query("SELECT producer FROM Producer producer WHERE producer.user.username = :username")
	public Optional<Producer> findByUserUsername(String username);
	
	@Query("SELECT user FROM User user WHERE user.username = :username")
	public Optional<User> findUserByProducerUsername(String username);

	
	
    
}
