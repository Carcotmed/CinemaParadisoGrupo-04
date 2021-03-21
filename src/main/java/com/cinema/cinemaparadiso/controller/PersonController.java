package com.cinema.cinemaparadiso.controller;

import com.cinema.cinemaparadiso.model.Person;
import com.cinema.cinemaparadiso.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/persons")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public String list(Model model){
        Iterable<Person> persons = personService.list();
        model.addAttribute("persons", persons);
        log.info("Listing Persons..."+persons.toString());
        return "persons/listPerson";
    }

}
