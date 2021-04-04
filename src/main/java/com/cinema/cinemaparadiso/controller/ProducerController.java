package com.cinema.cinemaparadiso.controller;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.service.ProducerService;
import com.cinema.cinemaparadiso.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/producers")
@Slf4j
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/list")
    public String list(Model model){
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
        Producer producer = new Producer();
        model.addAttribute("producer", producer);
        return "producers/createUpdateProducerForm";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("producer") Producer producer, BindingResult result){
        try{
            producerService.saveProducer(producer);
            log.info("Producer Created Successfully");
        }catch(Exception e){
            log.error("Error Create Producer", e);
        }
        return "index";
    }
    
    @GetMapping("/update/{producerUsername}")
    public String initFormUpdateProducer(Model model, @RequestAttribute String producerUsername){
        Producer producer = producerService.getProducerByUsername(producerUsername);
        model.addAttribute("producer", producer);
        return "producers/createUpdateProducerForm";
    }

    @PostMapping("/update/{producerUsername}")
    public String updateProducer(@Validated @ModelAttribute("producer") Producer producer, BindingResult result, @RequestAttribute String producerUsername){
        try{
            producerService.saveProducer(producer);
            log.info("Producer Updated Successfully");
        }catch(Exception e){
            log.error("Error Update Producer", e);
        }
        return "index";
    }
    
    @PostMapping("/delete/{producerUsername}")
	public String deleteArtist(@PathVariable("producerUsername") String producerUsername, BindingResult result) {
		try {
			producerService.deleteProducer(producerUsername);
			log.info("Producer Deleted Successfully");
		} catch (Exception e) {
			log.error("Error Deleting Producer", e);
		}
		return "producer/listProducer";
	}
}
