package com.cinema.cinemaparadiso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Story;

@Repository
public interface StoryRepository extends CrudRepository<Story,Integer>{
	
}
