package com.cinema.cinemaparadiso.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.Writer;
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
		if(!storyService.isMyWriter(storyId)) {
			return "error/error-403";
		}
		Story story = storyService.findStoryById(storyId);
		List<Genre> genres = Arrays.asList(Genre.values());
		model.addAttribute("storyId", storyId);
		model.addAttribute("story", story);
		model.addAttribute("genres", genres);
		return "stories/updateStory";
	}

	@PostMapping("/update/{storyId}")
	public String updateStory(@ModelAttribute("story") @Valid Story story,BindingResult result, Model model, @PathVariable("storyId") Integer storyId) {
		story.setId(storyId);
		if(!storyService.isMyWriter(storyId)) {
			return "error/error-403";
		}
		List<Genre> genres = Arrays.asList(Genre.values());
		model.addAttribute("genres", genres);
		model.addAttribute("story", story);
		model.addAttribute("storyId", storyId);
		if(!result.hasErrors()) {
			storyService.editStory(story);
			log.info("Story Updated Successfully");
			return "redirect:/stories/show/{storyId}";
		} else {
			return "stories/updateStory";
		}
 
  }
      
	@GetMapping("/create")
	public String initFormCreateStory(Model model) {
		Story story = new Story();
		List<Genre> genres = Arrays.asList(Genre.values());
		
		model.addAttribute("story", story);
		model.addAttribute("genres",genres);
		return "stories/createStory";
	}

	@PostMapping("/create")
	public String createStory(@Validated Story story, BindingResult result,Model model) {
		List<Genre> genres = Arrays.asList(Genre.values());
		model.addAttribute("genres",genres);
		try {
			storyService.createStory(story);
			log.info("Story Created Successfully");
		} catch (Exception e) {
			log.error("Error Create Story", e);
			return "stories/createStory";
		}
		return "redirect:/stories/list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		Iterable<Story> stories = storyService.list();
		List<Genre> genres = Arrays.asList(Genre.values());
		Story storiesFiltered = new Story();
		
		model.addAttribute("stories", stories);
		model.addAttribute("genres",genres);
		model.addAttribute("storiesFiltered",storiesFiltered);
		log.info("Listing Stories..." + stories.toString());
		return "stories/listStory";

	}
	
	@PostMapping("/list")
	public String list(@ModelAttribute("storiesFiltered") Story storiesFiltered,Model model) {
		List<Story> stories = storyService.list();
		List<Genre> genres = Arrays.asList(Genre.values());
		
		model.addAttribute("stories", stories);
		model.addAttribute("storiesFiltered",storiesFiltered);
		
		
		List<Story> storiesFiltrados = stories.stream()
				.filter(s->s.getTitle().toLowerCase().contains(storiesFiltered.getTitle().toLowerCase()) 
				&&(!genres.contains(storiesFiltered.getGenre()) || s.getGenre().equals(storiesFiltered.getGenre()))
				).collect(Collectors.toList());
		
		model.addAttribute("stories",storiesFiltrados);
		model.addAttribute("genres", genres);
		
		return "stories/listStory";

	}
	
	@GetMapping(value = { "/show/{storyId}" })
	public String showStory(@PathVariable("storyId") int storyId, Model model) {
		Story story = storyService.findStoryById(storyId);
		Writer myWriter = storyService.findMyWriter(storyId);
		Boolean showButton = storyService.isMyWriter(storyId);
		model.addAttribute("storyId", storyId);
		model.addAttribute("story", story);
		model.addAttribute("myWriter",myWriter);
		model.addAttribute("writerUsername", myWriter.getUser().getUsername());
		model.addAttribute("showButton",showButton);

		return "stories/showStory";
	}
	
	@GetMapping("/delete/{storyId}")
	public String deleteStory(@PathVariable("storyId") Integer storyId) {
		if(!storyService.isMyWriter(storyId)) {
			return "error/error-403";
		}
		try {
			storyService.deleteStory(storyId);
			log.info("Project Deleted Successfully");
		} catch (Exception e) {
			log.error("Error Deleting Project", e);
		}
		return "redirect:/stories/list";
	}

}
