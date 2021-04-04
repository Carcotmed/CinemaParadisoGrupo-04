package com.cinema.cinemaparadiso.repository;

import com.cinema.cinemaparadiso.model.Message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message,Integer>{

	@Query("SELECT ALL m FROM Message m WHERE m.emisor.username = :usernameQuery")
	public Iterable<Message> findByUsername(@Param("usernameQuery") String username);
	
}
