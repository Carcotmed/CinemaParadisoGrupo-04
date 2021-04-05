package com.cinema.cinemaparadiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "stories/createOrUpdateStoryForm";
	}

	@PostMapping("/update/{storyId}")
	public String updateStory(@PathVariable("storyId") Integer storyId, BindingResult result) {
		try {
			storyService.editStory(storyId);
			log.info("Story Updated Successfully");
		} catch (Exception e) {
			log.error("Error Updating Story", e);
    }
    return "/";
  }
      
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

	@GetMapping("/list")
	public String list(Model model) {
		Iterable<Story> stories = storyService.list();
		model.addAttribute("stories", stories);
		log.info("Listing Stories..." + stories.toString());
		return "stories/listStory";
	}
	
	@GetMapping(value = { "/show/{storyId}" })
	public String showStory(@PathVariable("storyId") int storyId, Model model) {
		Story story = storyService.findStoryById(storyId);
		model.addAttribute("storyId", storyId);
		model.addAttribute("story", story);
		return "stories/showStory";
	}

}
