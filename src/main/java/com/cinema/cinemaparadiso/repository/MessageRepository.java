package com.cinema.cinemaparadiso.repository;

import com.cinema.cinemaparadiso.model.Message;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message,String>{
	
}
