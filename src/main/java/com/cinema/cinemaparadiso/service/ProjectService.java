package com.cinema.cinemaparadiso.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.repository.ProjectRepository;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;

	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}


	public List<Project> list() {
		List<Project> project = new ArrayList<>();
		projectRepository.findAll().forEach(p -> project.add(p));
		return project;
	}
	public List<Project> listProProjects() {
		List<Project> proProjects = new ArrayList<>();
		proProjects = projectRepository.listProProjects();
		return proProjects;
	}
	
	public List<Project> listNoProProjects() {
		List<Project> noProProjects = new ArrayList<>();
		noProProjects = projectRepository.listNoProProjects();
		return noProProjects;
	}
	
	public List<Project> projectFiltered(Genre filterGenre,String filterTitle) {
		List<Project> projectByGenreAndTitle = new ArrayList<>();
		projectByGenreAndTitle =projectRepository.findProjectByGenreAndTitle(filterGenre,filterTitle);
		return projectByGenreAndTitle;
	}
	
	
	
	@Transactional(readOnly = true)
	public Project findProjectById(int id) throws DataAccessException {
		return projectRepository.findById(id).get();
	}


}
