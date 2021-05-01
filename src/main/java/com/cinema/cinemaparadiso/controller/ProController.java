package com.cinema.cinemaparadiso.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.service.ArtistService;
import com.cinema.cinemaparadiso.service.MessageService;
import com.cinema.cinemaparadiso.service.ProjectService;
import com.cinema.cinemaparadiso.service.StoryService;
import com.cinema.cinemaparadiso.service.WriterService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/pro")
@Slf4j
public class ProController {
	//TODO PASAR DE DOLARES A EUROS
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private StoryService storyService;
	
	@Autowired
	private WriterService writerService;
	
	@Autowired
	private MessageService messageService;
	
	
	@GetMapping("")
	public String showProducts(Model model) {		
		return "/pro/products";
	}
	
	
	@PostMapping("/confirmedPro")
	public String confirmedPro(Model model) {
		
		Map paymentDetails = (Map) model.getAttribute("paymentDetails");
							
		Artist currentArtist = artistService.getPrincipal();
		Integer artistID = currentArtist.getId();
		
		artistService.incrementLeftProjects(artistID, 3);
		artistService.makePro(artistID);
		Integer messageID=messageService.messageConfirmPaymentArtist(artistID);
		
		
		return "redirect:/messages/show/"+messageID;
	}
	
	@PostMapping("/confirmedProyect")
	public String confirmedProyect(Model model) {
		
		Map paymentDetails = (Map) model.getAttribute("paymentDetails");		
				
		Artist currentArtist = artistService.getPrincipal();
		Integer artistID = currentArtist.getId();
		
		artistService.incrementLeftProjects(artistID, 1);
		Integer messageID=messageService.messageConfirmPaymentArtist(artistID);
		
		return "redirect:/messages/show/"+messageID;
	}
	
	@PostMapping("/confirmedAd")
	public String confirmedAd(@ModelAttribute("projectID") Integer projectID, Model model) {
		
		//CON EL CSRF NO DEBERIA HABER FORMA DE COLARSE AQUI CON URL
		Map paymentDetails = (Map) model.getAttribute("paymentDetails");
		
		Integer artistID = artistService.getPrincipal().getId();
		projectService.makeProjectSponsored(projectID);
		Integer messageID=messageService.messageConfirmPaymentArtist(artistID);
		
		return "redirect:/messages/show/"+messageID;
	}
	
	@PostMapping("/confirmedAdStory")
	public String confirmedStoryAd(@ModelAttribute("storyID") Integer storyID, Model model) {
		
		//CON EL CSRF NO DEBERIA HABER FORMA DE COLARSE AQUI CON URL
		Map paymentDetails = (Map) model.getAttribute("paymentDetails");
		Integer writerId = writerService.getPrincipal().getId();
		storyService.makeStorySponsored(storyID);
		Integer messageID=messageService.messageConfirmPaymentWriter(writerId);
		
		return "redirect:/messages/show/"+messageID;
	}

}
