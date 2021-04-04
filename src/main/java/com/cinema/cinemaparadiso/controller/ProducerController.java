package com.cinema.cinemaparadiso.controller;

import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.service.ProducerService;
import com.cinema.cinemaparadiso.service.UserService;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    	System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        Iterable<Producer> producers = producerService.list();
        model.addAttribute("producers", producers);
        log.info("Listing Producers..."+producers.toString());
        return "producers/listProducer";
    }
    
    @GetMapping(value = { "/show/{producerUsername}" })
	public String showArtist(@PathVariable("producerUsername") String producerUsername, Model model) {
		Producer producer = producerService.getProducerByUsername(producerUsername);
		model.addAttribute("producerUsername", producerUsername);
		model.addAttribute("producer", producer);
		return "producers/showProducer";
	}

    @GetMapping("/create")
    public String initFormCreateProducer(Model model){
    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
    	if(producerService.existeProducerByUsername(username)) {
            return "redirect:/producers/list";
    	}else {
            Producer producer = new Producer();
            model.addAttribute("producer", producer);
            model.addAttribute("isNew", true);
            return "/producers/createUpdateProducerForm";
    	}
    }

    @PostMapping("/create")
    public String createProducer(Model model, @ModelAttribute("producer") @Valid Producer producer, BindingResult result){
        try{
        	String username = SecurityContextHolder.getContext().getAuthentication().getName();
        	User user = userService.getUserByUsername(username);
        	producer.setUser(user);
        	if (result.hasErrors()) {
                return "error";
            }
            producerService.saveProducer(producer);
            log.info("Producer Created Successfully");
        }catch(Exception e){
            log.error("Error Create Producer", e);
        }
        return "redirect:/producers/list";
    }
    
    @GetMapping("/update/{producerUsername}")
    public String initFormUpdateProducer(Model model, @PathVariable("producerUsername") String producerUsername){
        Producer producer = producerService.getProducerByUsername(producerUsername);
    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
    	if(!producer.getUser().getUsername().equals(username)) {
    		model.addAttribute("Error", "No posees esta entidad");
    		return "redirect:/producers/list";
    	}
        model.addAttribute("producer", producer);
        model.addAttribute("isNew", false);
        return "producers/createUpdateProducerForm";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new PreProcessProducerValidator(binder.getValidator(), userService));
    }

    @PostMapping("/update/{producerUsername}")
    public String updateProducer(Model model, @Valid @ModelAttribute("producer") Producer producer, BindingResult result, @PathVariable("producerUsername") String producerUsername){
        try{
        	if (result.hasErrors()) {
                return "error";
            }
        	String username = SecurityContextHolder.getContext().getAuthentication().getName();
        	Producer oldProducer = producerService.getProducerById(producer.getId());
        	if(!oldProducer.getUser().getUsername().equals(username)) {
        		model.addAttribute("Error", "No posees esta entidad");
        		return "redirect:/producers/list";
        	}
        	oldProducer.setNif(producer.getNif());
        	oldProducer.setDescription(producer.getDescription());
            producerService.saveProducer(oldProducer);
            log.info("Producer Updated Successfully");
        }catch(Exception e){
            log.error("Error Update Producer", e);
        }
        return "redirect:/producers/list";
    }
    
    @GetMapping("/delete/{producerUsername}")
	public String deleteProducer(Model model, @PathVariable("producerUsername") String producerUsername) {
		try {
	    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
	    	if(!producerUsername.equals(username)) {
	    		model.addAttribute("Error", "No posees esta entidad");
	    		return "redirect:/producers/list";
	    	}
			producerService.deleteProducer(producerUsername);
			log.info("Producer Deleted Successfully");
		} catch (Exception e) {
			log.error("Error Deleting Producer", e);
		}
		return "redirect:/producers/list";
	}
}
class PreProcessProducerValidator implements Validator {
    private final Validator validator;
    private final UserService userService;

    public PreProcessProducerValidator(Validator validator, UserService userService) {
        this.validator = validator;
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return validator.supports(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof Producer) {
        	Producer producer = (Producer) target;
        	producer.setNif(producer.getNif().toUpperCase());
        	if(producer.getUser()==null)
        		producer.setUser(userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        }
        validator.validate(target, errors);
    }
}
