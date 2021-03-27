package com.cinema.cinemaparadiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/update/{storyId}")
	public String initFormUpdateStory(Model model, @PathVariable("storyId") Integer storyId) {
		Story story = storyService.findStoryById(storyId);
		model.addAttribute("storyId", storyId);
		model.addAttribute("story", story);
		return "storys/createOrUpdateStoryForm";
	}

	@PostMapping("/update/{storyId}")
	public String updateStory(@PathVariable("storyId") Integer storyId, BindingResult result) {
		try {
			storyService.editStory(storyId);
			log.info("Story Updated Successfully");
		} catch (Exception e) {
			log.error("Error Updating Story", e);
		}
		return "story/listStory";
	}

}
