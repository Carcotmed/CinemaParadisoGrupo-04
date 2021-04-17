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
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.service.ProducerService;
import com.cinema.cinemaparadiso.service.UserService;
import com.cinema.cinemaparadiso.service.exceptions.UserUniqueException;

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
		Boolean showButton = producerService.isActualProducer(producerId);
		Boolean disabled = !producerService.findMyUser(producerId).isEnabled();
		model.addAttribute("producerUsername", producer.getUser().getUsername());
		model.addAttribute("producer", producer);
		model.addAttribute("showButton",showButton);
		model.addAttribute("userDisabled",disabled);

		return "producers/showProducer";
	}

	@GetMapping("/create")
    public String initFormCreateProducer(Model model) {
		User user = new User();
        Producer producer = new Producer();
        model.addAttribute("producer", producer);
        model.addAttribute("user",user);
        model.addAttribute("isNew", true);
        return "producers/createUpdateProducerForm";

    }

    @PostMapping("/create")
    public String createProducer(Model model, @ModelAttribute("producer") @Valid Producer producer,
              BindingResult result) throws UserUniqueException{
  
          if(!result.hasErrors()) {
			try{
				
				this.producerService.createProducer(producer);
			}
			catch(UserUniqueException ex) {
				result.rejectValue("user.username", "unique", "Este usuario ya existe, pruebe con otro");
				return "producers/createUpdateProducerForm";
			}
			log.info("Producer Created Successfully");
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
		model.addAttribute("producerId", producerId);
		model.addAttribute("producer", producer);
		return "producers/updateProducer";
	}

	@PostMapping("/update/{producerId}")
	public String updateProducer(@ModelAttribute("producer") @Valid Producer producer,BindingResult result, Model model, @PathVariable("producerId") Integer producerId) {
		producer.setId(producerId);
		
		if(!producerService.isActualProducer(producerId)) {
			return "error/error-403";
		}
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