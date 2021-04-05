package com.cinema.cinemaparadiso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Writer;

@Repository
public interface WriterRepository extends CrudRepository<Writer,Integer>{
	
}
