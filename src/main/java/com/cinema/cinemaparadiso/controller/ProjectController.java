package com.cinema.cinemaparadiso.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
import com.cinema.cinemaparadiso.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/projects")
@Slf4j
public class ProjectController {

	@Autowired
	private ProjectService projectService;

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
	
	@GetMapping(value = { "/show/{projectId}" })
	public String showProject(@PathVariable("projectId") int projectId, Model model) {
		Project project = projectService.findProjectById(projectId);
		List<Artist> members = projectService.findMembers(projectId);
		model.addAttribute("projectId", projectId);
		model.addAttribute("project", project);
		model.addAttribute("members",members);
		return "projects/showProject";
	}
	
	@PostMapping("/delete/{projectId}")
	public String deleteProject(@PathVariable("projectId") Integer projectId, BindingResult result) {
		try {
			projectService.deleteProject(projectId);
			log.info("Project Deleted Successfully");
		} catch (Exception e) {
			log.error("Error Deleting Project", e);
		}
		return "project/listProject";
	}
	
	@GetMapping("/create")
	public String initFormCreateProject(Model model) {
		Project project = new Project();
		List<Genre> genres = Arrays.asList(Genre.values());
		model.addAttribute("buttonCreate",true);
		model.addAttribute("genres", genres);
		model.addAttribute("project", project);
		return "projects/createOrUpdateProjectForm";
	}

	@PostMapping("/create")
	public String createProject(@Validated Project project, BindingResult result) {
		try {
			projectService.createProject(project);
			log.info("Project Created Successfully");
		} catch (Exception e) {
			log.error("Error Create Project", e);
		}
		return "project/listProject";
	}
	
	@GetMapping("/update/{projectId}")
	public String initFormUpdateProject(Model model, @PathVariable("projectId") Integer projectId) {
		Project project = projectService.findProjectById(projectId);
		List<Genre> genres = Arrays.asList(Genre.values());
		model.addAttribute("buttonCreate",false);
		model.addAttribute("genres", genres);
		model.addAttribute("projectId", projectId);
		model.addAttribute("project", project);
		return "projects/createOrUpdateProjectForm";
	}

	@PostMapping("/update/{projectId}")
	public String updateProject(@PathVariable("projectId") Integer projectId, BindingResult result) {
		try {
			projectService.editProject(projectId);
			log.info("Project Updated Successfully");
		} catch (Exception e) {
			log.error("Error Updating Project", e);
		}
		return "project/listProject";
	}


}