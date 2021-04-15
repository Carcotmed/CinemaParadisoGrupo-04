package com.cinema.cinemaparadiso.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.ArtistService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/pro")
@Slf4j
public class ProController {
	//TODO PASAR DE DOLARES A EUROS
	
	@Autowired
	private ArtistService artistService;
	
	@GetMapping("")
	public String showProducts(Model model) {
		return "/pro/products";
	}
	
	
	@PostMapping("/confirmedPro")
	public String confirmedPro(Model model) {
		
		//TODO SEGURIDAD PA QUE NO SE NOS CUELEN POR LA PINCHE URL
		Map paymentDetails = (Map) model.getAttribute("paymentDetails");
		
		System.out.println(paymentDetails);
		
		//TODO VALIDAR EL PAYMENT DE ALGUNA FORMA
				
		Artist currentArtist = artistService.getPrincipal();
		Integer artistID = currentArtist.getId();
		
		artistService.incrementLeftProjects(artistID, 3);
		artistService.makePro(artistID);
		
		return "redirect:/artists/show/"+artistID;
	}
	
	@PostMapping("/confirmedProyect")
	public String confirmedProyect(Model model) {
		
		//TODO SEGURIDAD PA QUE NO SE NOS CUELEN POR LA PINCHE URL
		Map paymentDetails = (Map) model.getAttribute("paymentDetails");
		
		System.out.println(paymentDetails);
		
		//TODO VALIDAR EL PAYMENT DE ALGUNA FORMA
				
		Artist currentArtist = artistService.getPrincipal();
		Integer artistID = currentArtist.getId();
		
		artistService.incrementLeftProjects(artistID, 1);
		
		return "redirect:/artists/show/"+artistID;
	}

}
