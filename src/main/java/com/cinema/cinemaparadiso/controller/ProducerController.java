package com.cinema.cinemaparadiso.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/list")
    public String list(Model model){
        List<Producer> producers = producerService.list();
        model.addAttribute("producers", producers);
        return "producers/listProducer";
    }
    
    @GetMapping(value = { "/show/{producerId}" })
	public String showProducer(@PathVariable("producerId") Integer producerId, Model model) {
		Producer producer = producerService.findProducerById(producerId);
		model.addAttribute("producerUsername", producer.getUser().getUsername());
		model.addAttribute("producer", producer);
		return "producers/showProducer";
	}

	@GetMapping("/create")
    public String initFormCreateProducer(Model model) {
		User user = new User();
        Producer producer = new Producer();
        List<Skill> skill = Arrays.asList(Skill.values());
        model.addAttribute("producer", producer);
        model.addAttribute("user",user);
        model.addAttribute("isNew", true);
        model.addAttribute("skill", skill);
        return "producers/createUpdateProducerForm";

    }

    @PostMapping("/create")
    public String createProducer(Model model, @ModelAttribute("producer") @Valid Producer producer,
              BindingResult result) {
  
    	List<Skill> skill = Arrays.asList(Skill.values());
    	model.addAttribute("skill", skill);
          if(!result.hasErrors()) {
              this.producerService.createProducer(producer);
          }else {
        	  return "producers/createUpdateProducerForm";
          }
          return "redirect:/producers/list";
      }
    

    @GetMapping("/update/{producerId}")
	public String initFormUpdateProducer(Model model, @PathVariable("producerId") Integer producerId) {
		if(!producerService.isActualProducer(producerId)) {
			return "error/error-403";
		}
		Producer producer = producerService.findProducerById(producerId);
		List<Skill> skill = Arrays.asList(Skill.values());
		model.addAttribute("producerId", producerId);
		model.addAttribute("producer", producer);
		model.addAttribute("skill", skill);
		return "producers/updateProducer";
	}

	@PostMapping("/update/{producerId}")
	public String updateProducer(@ModelAttribute("producer") @Valid Producer producer,BindingResult result, Model model, @PathVariable("producerId") Integer producerId) {
		producer.setId(producerId);
		
		if(!producerService.isActualProducer(producerId)) {
			return "error/error-403";
		}
		List<Skill> skill = Arrays.asList(Skill.values());
		model.addAttribute("skill", skill);
		if(!result.hasErrors()) {
			producerService.editProducer(producer);
			return "redirect:/producers/show/{producerId}";
		} else {
			return "producers/updateProducer";
		}
  }
	

	@GetMapping("/delete/{producerId}")
	public String deleteProducer(@PathVariable("producerId") Integer producerId) {
		if(!producerService.isActualProducer(producerId)) {
			return "error/error-403";
		}
		try {
			producerService.deleteProducer(producerId);
			SecurityContextHolder.clearContext();
			log.info("Producer Deleted Successfully");
		} catch (Exception e) {
			log.error("Error Deleting Producer", e);
		}
		return "redirect:/";
	}
}