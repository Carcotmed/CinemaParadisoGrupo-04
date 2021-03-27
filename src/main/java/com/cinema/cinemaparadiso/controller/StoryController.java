package com.cinema.cinemaparadiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.service.StoryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/stories")
@Slf4j
public class StoryController {

	@Autowired
	private StoryService storyService;

	@GetMapping("/create")
	public String initFormCreateStory(Model model) {
		Story story = new Story();
		model.addAttribute("story", story);
		return "story/createOrUpdateStoryForm";
	}

	@PostMapping("/create")
	public String createStory(@Validated Story story, BindingResult result) {
		try {
			storyService.createStory(story);
			log.info("Story Created Successfully");
		} catch (Exception e) {
			log.error("Error Create Story", e);
		}
		return "story/listStory";
	}



}
