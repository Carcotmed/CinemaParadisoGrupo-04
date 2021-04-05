package com.cinema.cinemaparadiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.WriterService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/writers")
@Slf4j
public class WriterController {

	@Autowired
	private WriterService writerService;

	@GetMapping("/list")
	public String list(Model model) {
		Iterable<Writer> writers = writerService.list();
		model.addAttribute("writers", writers);
		log.info("Listing Writers..." + writers.toString());
		return "writers/listWriter";
	}
	
	@GetMapping(value = { "/show/{writerId}" })
	public String showWriter(@PathVariable("writerId") int writerId, Model model) {
		Writer writer = writerService.findWriterById(writerId);
		model.addAttribute("writerId", writerId);
		model.addAttribute("writer", writer);
		return "writers/showWriter";
	}

}
