package com.cinema.cinemaparadiso.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.service.ArtistService;
import com.cinema.cinemaparadiso.service.MessageService;
import com.cinema.cinemaparadiso.service.ProducerService;
import com.cinema.cinemaparadiso.service.ProjectService;
import com.cinema.cinemaparadiso.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/projects")
@Slf4j
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userService;

	@Autowired
	private ArtistService artistService;

	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private MessageService messageService;

	@GetMapping("/list")
	public String list(Model model) {
		Iterable<Project> projects = projectService.list();
		List<Genre> genres = Arrays.asList(Genre.values());
		List<Project> proProjects = projectService.listProProjects();
		List<Project> noProProjects = projectService.listNoProProjects();
		Project projectsFiltered = new Project();
		model.addAttribute("projects", projects);
		model.addAttribute("genres", genres);
		model.addAttribute("projectsPro", proProjects);
		model.addAttribute("projectsNoPro", noProProjects);
		model.addAttribute("projectsFiltered", projectsFiltered);
		log.info("Listing Projects..." + projects.toString());
		return "projects/listProject";
	}
	
	@PostMapping("/list")
	public String list(@ModelAttribute("projectsFiltered") Project projectsFiltered,Model model) {
		List<Genre> genres = Arrays.asList(Genre.values());
		List<Project> projects = projectService.list();
		
		model.addAttribute("projects", projects);
		model.addAttribute("projectsFiltered", projectsFiltered);

		List<Project> projectsProFiltrados = projects.stream()
				.filter(a -> a.getPro()==true
				&& a.getTitle().toLowerCase().contains(projectsFiltered.getTitle().toLowerCase()) 
				&&(!genres.contains(projectsFiltered.getGenre()) || a.getGenre().equals(projectsFiltered.getGenre()))
				).collect(Collectors.toList());
		
		List<Project> projectsNoProFiltrados = projects.stream()
				.filter(a -> a.getPro()==false
				&& a.getTitle().toLowerCase().contains(projectsFiltered.getTitle().toLowerCase()) 
				&&(!genres.contains(projectsFiltered.getGenre()) || a.getGenre().equals(projectsFiltered.getGenre()))
				).collect(Collectors.toList());
		
		
		model.addAttribute("projectsPro", projectsProFiltrados);
		model.addAttribute("projectsNoPro", projectsNoProFiltrados);
		model.addAttribute("genres", genres);
		
		return "projects/listProject";
	}
	
	@GetMapping("/joinArtist/{projectId}")
	public String joinProjectArtist(Model model, @PathVariable("projectId") int projectId) {
    	Artist artist;
    	try {
    		artist = artistService.getPrincipal();
    	}catch(Exception e) {artist = null;}
    	if(artist==null) {
    		model.addAttribute("Error", "No eres un artista");
			return "/error/error";
    	}
		if(artist.getProjects().stream().anyMatch(p->p.getId().equals(projectId))) {
			model.addAttribute("Error", "Ya perteneces a este equipo");
			return "/error";
		}
		messageService.requestToEnterProjectArtist(projectId, artist.getId());
		return "redirect:/messages/listSend";
	}
	
	@GetMapping("/joinProducer/{projectId}")
	public String joinProjectProducer(Model model, @PathVariable("projectId") int projectId) {
    	Producer producer;
    	try {
    		producer = producerService.getPrincipal();
    	}catch(Exception e) {producer = null;}
    	if(producer==null) {
    		model.addAttribute("Error", "No eres un producer");
			return "/error/error";
    	}
		if(producer.getProjects().stream().anyMatch(p->p.getId().equals(projectId))) {
			model.addAttribute("Error", "Ya perteneces a este equipo");
			return "/error";
		}
		messageService.requestToEnterProjectProducer(projectId, producer.getId());
		return "redirect:/messages/listSend";
	}
	
	@GetMapping(value = { "/show/{projectId}" })
	public String showProject(@PathVariable("projectId") int projectId, Model model) {
		Project project = projectService.findProjectById(projectId);
		List<Artist> members = projectService.findMembers(projectId);
		List<Producer> producers = projectService.findProducers(projectId);
		Boolean isAdminProject = false;
		try {
		 isAdminProject = projectService.isAdminProject(projectId);
		}catch (Exception e){
			
		}
		model.addAttribute("projectId", projectId);
		model.addAttribute("project", project);
		model.addAttribute("members",members);
		model.addAttribute("producers",producers);
		model.addAttribute("artistUsername", members.get(0).getUser().getUsername());
		model.addAttribute("isAdminProject", isAdminProject);
		Artist artist;
    	try {
    		artist = artistService.getPrincipal();
    	}catch(Exception e) {artist = null;}
    	if(artist==null) {
			model.addAttribute("pertenece", false);
			model.addAttribute("noPuede",true);
    	}else if(artist.getProjects().stream().anyMatch(p->p.getId().equals(projectId))) {
			model.addAttribute("pertenece", true);
			model.addAttribute("noPuede",false);
		}else {
			model.addAttribute("pertenece", false);
			model.addAttribute("noPuede",false);
		}
    	
    	Producer producer;
    	try {
    		producer = producerService.getPrincipal();
    	}catch(Exception e) {producer = null;}
    	if(producer==null) {
			model.addAttribute("perteneceP", false);
			model.addAttribute("noPuedeP",true);
    	}else if(producer.getProjects().stream().anyMatch(p->p.getId().equals(projectId))) {
			model.addAttribute("perteneceP", true);
			model.addAttribute("noPuedeP",false);
		}else {
			model.addAttribute("perteneceP", false);
			model.addAttribute("noPuedeP",false);
		}
		return "projects/showProject";
	}
	
	@GetMapping("/delete/{projectId}")
	public String deleteProject(@PathVariable("projectId") Integer projectId) {
		Boolean noEsArtista = false;
		try {
			this.artistService.getPrincipal().getId();
		}catch (Exception e) {
			noEsArtista = true;
		}
		try {
			projectService.deleteRelation(projectId,noEsArtista);
			log.info("Project Deleted Successfully");
		} catch (Exception e) {
			log.error("Error Deleting Project", e);
		}
		return "redirect:/projects/list";
	}
	
	@GetMapping("/create")
	public String initFormCreateProject(Model model) {
		Integer artistId = artistService.getPrincipal().getId();
		Integer projectsLeft = artistService.leftProjects(artistId);
		if(projectsLeft == null) {
			return "error/error-403";
		}
		Project project = new Project();
		List<Genre> genres = Arrays.asList(Genre.values());
		model.addAttribute("buttonCreate",true);
		model.addAttribute("project", project);
		model.addAttribute("genres", genres);
		return "projects/createOrUpdateProjectForm";
	}

	@PostMapping("/create")
	public String createProject(@ModelAttribute("project") @Valid Project project, BindingResult result, Model model) {
		List<Genre> genres = Arrays.asList(Genre.values());
		Integer actualId = this.artistService.getPrincipal().getId();
		model.addAttribute("genres", genres);
		if(!result.hasErrors()) {
			projectService.createProject(project);
		}else {
			return "projects/createOrUpdateProjectForm";
		}
		return "redirect:/artists/show/"+actualId;
	}
	
	@GetMapping("/update/{projectId}")
	public String initFormUpdateProject(Model model, @PathVariable("projectId") Integer projectId) {
		Project project = projectService.findProjectById(projectId);
		List<Genre> genres = Arrays.asList(Genre.values());
		if(!projectService.isAdminProject(projectId)) {
			return "error/error-403";
		}
		model.addAttribute("buttonCreate",false);
		model.addAttribute("genres", genres);
		model.addAttribute("projectId", projectId);
		model.addAttribute("project", project);
		return "projects/createOrUpdateProjectForm";
	}

	@PostMapping("/update/{projectId}")
	public String updateProject(@ModelAttribute("project") @Valid Project project, BindingResult result, Model model, @PathVariable("projectId") Integer projectId) {
		project.setId(projectId);
		Integer actualId = this.artistService.getPrincipal().getId();
		List<Genre> genres = Arrays.asList(Genre.values());
		model.addAttribute("genres", genres);
		model.addAttribute("project", project);
		model.addAttribute("buttonCreate",false);
		if(!result.hasErrors()) {
			projectService.editProject(project);
			log.info("Project Updated Successfully");
			return "redirect:/artists/show/"+actualId;
		} else {
			return "redirect:/artists/show/"+actualId;
		}
	}


}