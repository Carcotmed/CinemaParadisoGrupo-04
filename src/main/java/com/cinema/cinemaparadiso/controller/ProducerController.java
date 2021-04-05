package com.cinema.cinemaparadiso.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.service.ProducerService;
import com.cinema.cinemaparadiso.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/producers")
@Slf4j
public class ProducerController {
	@Autowired
	private ProducerService producerService;

	@Autowired
	private UserService userService;

	
	
	
	
	
	@GetMapping("/create")
    public String initFormCreateProducer(Model model) {

        
        Producer producer = new Producer();
        model.addAttribute("producer", producer);
        
        model.addAttribute("isNew", true);
        return "/producers/createUpdateProducerForm";

    }

    @PostMapping("/create")
    public String createProducer(Model model, @ModelAttribute("producer") @Valid Producer producer,
              BindingResult result) {
          log.info("================================"+ producer.getName());
        if(!result.hasErrors()) {
            producerService.saveProducer(producer);
            
        }else {
            return "/producers/createUpdateProducerForm";
        }
        return "redirect:/producers/list";
    }
}
