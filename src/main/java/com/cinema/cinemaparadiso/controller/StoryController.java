package com.cinema.cinemaparadiso.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
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

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.ArtistService;
import com.cinema.cinemaparadiso.service.MessageService;
import com.cinema.cinemaparadiso.service.ProjectService;
import com.cinema.cinemaparadiso.service.Rel_projects_storyService;
import com.cinema.cinemaparadiso.service.StoryService;
import com.cinema.cinemaparadiso.service.UserService;
import com.cinema.cinemaparadiso.service.WriterService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/stories")
@Slf4j
public class StoryController {

	@Autowired
	private StoryService storyService;

	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private WriterService writerService;

	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private Rel_projects_storyService rel_projects_storyService;

	@Transactional
	@GetMapping("/request/{storyId}/{projectId}")
	public String request(Model model, @PathVariable("projectId") int projectId, @PathVariable("storyId") int storyId) {
    	Artist artist;
    	Project project;
    	try {
    		artist = artistService.getPrincipal();
    		project = projectService.findProjectById(projectId);
    	}catch(Exception e) {artist = null; project = null;}
    	if(artist==null) {
    		model.addAttribute("Error", "No eres un artista");
			return "/error/error";
    	}
    	if(project==null) {
    		model.addAttribute("Error", "Este proyecto no existe");
			return "/error/error";
    	}
		if(!project.getMyAdmin().equals(artist.getUser().getUsername())) {
			model.addAttribute("Error", "No eres administrador de este proyecto");
			return "/error/error";
		}
		if(rel_projects_storyService.countByProjectId(projectId)!=0) {
			model.addAttribute("Error", "Este proyecto ya posee una historia");
			return "/error/error";
		}
		messageService.requestToEnterProjectStory(projectId, storyId);
		return "redirect:/messages/listSend";
	}
	

	@GetMapping("/update/{storyId}")
	public String initFormUpdateStory(Model model, @PathVariable("storyId") Integer storyId) {
		if(!storyService.isMyWriter(storyId) && !userService.isAdmin()) {
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
		if(!storyService.isMyWriter(storyId) && !userService.isAdmin()) {
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
		Integer actualId = writerService.getPrincipal().getId();
		List<Genre> genres = Arrays.asList(Genre.values());
		model.addAttribute("genres",genres);
		try {
			storyService.createStory(story);
			log.info("Story Created Successfully");
		} catch (Exception e) {
			log.error("Error Create Story", e);
			return "stories/createStory";
		}
		return "redirect:/writers/show/"+actualId;
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
		
		//HISTORIAS ANUNCIADAS
		List <Story> allSponsoredStories = storyService.findAllSponsoredStories();
		Integer size;
		List <Story> chosenSponsoredStories = new ArrayList<Story>();
		if(allSponsoredStories.size()>=3) {
			size=3;
		}else {
			size=allSponsoredStories.size();
		}
		if(size!=0) {
			List<Integer> list = new ArrayList<Integer>();
	        for (int i=0; i<allSponsoredStories.size(); i++) {
	            list.add(i);
	        }
	        Collections.shuffle(list);
	        for (int i=0; i<size; i++) {
	        	chosenSponsoredStories.add(allSponsoredStories.get(list.get(i)));
	        }
		}
		System.out.println(allSponsoredStories);
        model.addAttribute("sponsoredStories",chosenSponsoredStories);
		
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
		
		//HISTORIAS ANUNCIADAS
		List <Story> allSponsoredStories = storyService.findAllSponsoredStories();
		Integer size;
		List <Story> chosenSponsoredStories = new ArrayList<Story>();
		if(allSponsoredStories.size()>=3) {
			size=3;
		}else {
			size=allSponsoredStories.size();
		}
		if(size!=0) {
			List<Integer> list = new ArrayList<Integer>();
	        for (int i=0; i<allSponsoredStories.size(); i++) {
	            list.add(i);
	        }
	        Collections.shuffle(list);
	        for (int i=0; i<size; i++) {
	        	chosenSponsoredStories.add(allSponsoredStories.get(list.get(i)));
	        }
		}
        model.addAttribute("sponsoredStories",chosenSponsoredStories);
		
		return "stories/listStory";

	}
	
	@GetMapping(value = { "/show/{storyId}" })
	public String showStory(@PathVariable("storyId") int storyId, Model model) {
		Story story = storyService.findStoryById(storyId);
		Writer myWriter = storyService.findMyWriter(storyId);
		Boolean showButton = storyService.isMyWriter(storyId) || userService.isAdmin();
		List<Project> myProjectsRel = storyService.findMyProjects(storyId);
		model.addAttribute("storyId", storyId);
		model.addAttribute("story", story);
		model.addAttribute("myWriter",myWriter);
		model.addAttribute("myProjectsRel",myProjectsRel);
		model.addAttribute("writerUsername", myWriter.getUser().getUsername());
		model.addAttribute("showButton",showButton);
		model.addAttribute("isAdmin",userService.isAdmin());
		try {
			Artist artist = artistService.getPrincipal();
			List<Project> projects = projectService.findProjectByAdminUsername(artist.getUser().getUsername());
			model.addAttribute("projects",projects);
		}catch(Exception e) {model.addAttribute("projects",new ArrayList<Project>());}
		
		
		//HISTORIAS ANUNCIADAS
		List <Story> allSponsoredStories = storyService.findAllSponsoredStories();
		
		List <Story> chosenSponsoredStories = new ArrayList<Story>();
		
		List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<allSponsoredStories.size(); i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i=0; i<3; i++) {
        	chosenSponsoredStories.add(allSponsoredStories.get(i));
        }
        
        model.addAttribute("sponsoredStories",chosenSponsoredStories);

		return "stories/showStory";
	}
	
	@GetMapping("/delete/{storyId}")
	public String deleteStory(@PathVariable("storyId") Integer storyId) {
		if(!storyService.isMyWriter(storyId) && !userService.isAdmin()) {
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
