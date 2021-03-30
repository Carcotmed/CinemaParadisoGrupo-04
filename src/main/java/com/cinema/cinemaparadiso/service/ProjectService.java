package com.cinema.cinemaparadiso.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.repository.ProjectRepository;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;

	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Iterable<Project> list() {
		return projectRepository.findAll();
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
	
	
	
	@Transactional(readOnly = true)
	public Project findProjectById(int id) throws DataAccessException {
		return projectRepository.findById(id).get();
	}


}
