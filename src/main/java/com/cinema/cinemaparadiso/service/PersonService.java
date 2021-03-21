package com.cinema.cinemaparadiso.service;

import com.cinema.cinemaparadiso.model.Person;
import com.cinema.cinemaparadiso.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> list(){
        return personRepository.findAll();
    }

}
