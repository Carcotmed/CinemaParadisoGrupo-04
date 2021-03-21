package com.cinema.cinemaparadiso.repository;

import com.cinema.cinemaparadiso.model.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Integer>{
    
}
