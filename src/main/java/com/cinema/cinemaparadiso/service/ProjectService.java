package com.cinema.cinemaparadiso.service;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.Rel_projects_artists;
import com.cinema.cinemaparadiso.model.Rel_projects_producers;
import com.cinema.cinemaparadiso.repository.ProjectRepository;
import com.cinema.cinemaparadiso.service.exceptions.ProjectLimitException;

@Service
public class ProjectService {

	private ProjectRepository projectRepository;

	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private Rel_projects_artistsService rel_projects_artistsService;
	
	@Autowired
	private Rel_projects_storyService rel_projects_storyService;
	
	@Autowired
	private Rel_projects_producersService rel_projects_producersService;

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

	public List<Producer> findProducers(Integer projectId){
		List<Producer> producers = new ArrayList<>();
		producers = projectRepository.findProducers(projectId);
		return producers;
	}
	
	
	@Transactional(readOnly = true)
	public Project findProjectById(int id) throws DataAccessException {
		return projectRepository.findById(id).get();
	}
	
	@Transactional
	public void deleteRelation(Integer projectId,Boolean noEsArtista) throws DataAccessException{
		if(!noEsArtista) {
			Integer actualId = artistService.getPrincipal().getId();
			Integer relacionId = rel_projects_artistsService.findRelation(actualId, projectId).getId();
			rel_projects_artistsService.delete(relacionId);
		}else {
			Integer actualId = producerService.getPrincipal().getId();
			Integer relacionId = rel_projects_producersService.findRelation(actualId, projectId).getId();
			rel_projects_producersService.delete(relacionId);
		}
		
		Project project = findProjectById(projectId);
		Boolean proyectoVacio = this.rel_projects_artistsService.count(projectId) == 0;
		if(proyectoVacio) {
			projectRepository.delete(project);
		}else {
			if(!noEsArtista) {
				Integer actualId = artistService.getPrincipal().getId();
				String artistaUsername = artistService.findMyUser(actualId).getUsername();
				if(project.getMyAdmin().equals(artistaUsername)) {
					project.setMyAdmin(findAllMembersUsername(projectId).get(0));
					
				}
			}
		}
		
	}
	
	public List<String> findAllMembersUsername(Integer projectId){
		List<String> allMembersUsername = new ArrayList<>();
		
		allMembersUsername.addAll(findMembers(projectId).stream().map(s->s.getUser().getUsername()).collect(Collectors.toList()));
		allMembersUsername.addAll(findProducers(projectId).stream().map(s->s.getUser().getUsername()).collect(Collectors.toList()));
		
		return allMembersUsername;
	}
	@Transactional
	public void createProject(Project project) throws ProjectLimitException{
		Artist artist = artistService.getPrincipal();
		Boolean isPro = artist.getPro();
		project.setMyAdmin(artist.getUser().getUsername());
		project.setPro(isPro);
		project.setIsSponsored(false);
		if(artist.getLeftProjects()<=0) {
			throw new ProjectLimitException();
		}
		else {
		projectRepository.save(project);
		//Creamos la relación
		Integer actualId = artist.getId();
		Integer projectId = project.getId();
		Rel_projects_artists relacion = new Rel_projects_artists();
		relacion.setArtist_id(actualId);
		relacion.setProject_id(projectId);
		rel_projects_artistsService.create(relacion);
		artist.setLeftProjects(artist.getLeftProjects()-1);

		}
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
	public void addRelationShipProducer(int projectId, Integer producerId) {
		Rel_projects_producers relation = new Rel_projects_producers();
		relation.setProducer_id(producerId);
		relation.setProject_id(projectId);
		rel_projects_producersService.save(relation);
	}
	
	public Boolean isAdminProject(Integer projectId) {
		try {
			String artistUsername = artistService.getPrincipal().getUser().getUsername();
			String projectAdminUsername = findProjectById(projectId).getMyAdmin();
			
			return artistUsername.equals(projectAdminUsername);
		}catch(Exception e) {
			return false;
		}
	}


	public List<Project> findProjectByAdminUsername(String username) {
		return projectRepository.findByAdminUsername(username);
	}


	public void makeProjectSponsored(Integer projectID) {
		projectRepository.makeProjectSponsored(projectID);
	}
  
  
	public void deleteAllRelation(Integer projectId) {
		rel_projects_artistsService.deleteByProjectId(projectId);
		rel_projects_producersService.deleteByProjectId(projectId);
		rel_projects_storyService.deleteByProjectId(projectId);
	}


	public void deleteProject(Integer projectId) {
		projectRepository.delete(projectId);
	}


	public List<Project> findAllSponsoredProjects() {
		return projectRepository.findAllSponsoredProjects();
	}
	

}