package com.cinema.cinemaparadiso.controller;

import java.util.Arrays;
import java.util.List;

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
import com.cinema.cinemaparadiso.model.Skill;
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
		User user = new User();
        Producer producer = new Producer();
        List<Skill> skill = Arrays.asList(Skill.values());
        model.addAttribute("producer", producer);
        model.addAttribute("user",user);
        model.addAttribute("isNew", true);
        model.addAttribute("skill", skill);
        return "/producers/createOrUpdateProducerForm";

    }

    @PostMapping("/create")
    public String createProducer(Model model, @ModelAttribute("producer") @Valid Producer producer,
              BindingResult result) {
    	List<Skill> skill = Arrays.asList(Skill.values());
    	model.addAttribute("skill", skill);
          log.info("================================"+ producer.getName());
          try {
  			producerService.createProducer(producer);
  			log.info("Artist Created Successfully");
  		} catch (Exception e) {
  			log.info(producer.getUser().getUsername()+"/"+producer.getUser().getEmail()+"/"+producer.getUser().getPassword()+"/"+ producer.getUser().isEnabled());
  			log.error("Error Create Producer", e);
  		}
  		return "index";
    }
}
