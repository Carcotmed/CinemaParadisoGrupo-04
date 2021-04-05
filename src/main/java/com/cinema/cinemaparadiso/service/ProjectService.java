package com.cinema.cinemaparadiso.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.Rel_projects_artists;
import com.cinema.cinemaparadiso.repository.ProjectRepository;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private Rel_projects_artistsService rel_projects_artistsService;

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

	public List<Artist> findMembers(Integer projectId){
		List<Artist> members = new ArrayList<>();
		members = projectRepository.findMembers(projectId);
		return members;
	}
	
	
	@Transactional(readOnly = true)
	public Project findProjectById(int id) throws DataAccessException {
		return projectRepository.findById(id).get();
	}
	
	@Transactional
	public void deleteRelation(Integer projectId) throws DataAccessException{
		Integer actualId = artistService.getPrincipal().getId();
		Integer relacionId = rel_projects_artistsService.findRelation(actualId, projectId).getId();
		rel_projects_artistsService.delete(relacionId);
	}
	
	@Transactional
	public void createProject(Project project){
		Boolean isPro = this.artistService.getPrincipal().getPro();
		project.setPro(isPro);
		saveProject(project);
		//Creamos la relación
		Integer actualId = artistService.getPrincipal().getId();
		Integer projectId = project.getId();
		Rel_projects_artists relacion = new Rel_projects_artists();
		relacion.setArtist_id(actualId);
		relacion.setProject_id(projectId);
		rel_projects_artistsService.create(relacion);
	}
	
	@Transactional
	public void saveProject(Project project) throws DataAccessException{
			projectRepository.save(project);
	}
	
	@Transactional
	public void editProject(Project project) throws DataAccessException{
			Project project2 =findProjectById(project.getId());
			project2.setId(project.getId());
			project2.setTitle(project.getTitle());
			project2.setGenre(project.getGenre());
			project2.setDescription(project.getDescription());
			project2.setPhoto(project.getPhoto());
			saveProject(project2);	
		
	}
	
	@Transactional
	public Long count(){

		return this.projectRepository.count();
		
	}


	public void addRelationShip(int projectId, Integer artistId) {
		Rel_projects_artists relation = new Rel_projects_artists();
		relation.setArtist_id(artistId);
		relation.setProject_id(projectId);
		rel_projects_artistsService.save(relation);
	}


}