package com.cinema.cinemaparadiso.repository;

import com.cinema.cinemaparadiso.model.Message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message,String>{

	@Query("SELECT message FROM Message message WHERE message.emisor.username =: username")
	public Iterable<Message> findByUsername(@Param("username") String username);
	
}
