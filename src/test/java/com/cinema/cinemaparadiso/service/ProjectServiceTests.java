package com.cinema.cinemaparadiso.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.service.exceptions.ProjectLimitException;


@SpringBootTest
@Sql("/db/testing-data/projectServiceTests/testing-data.sql")
@Transactional
public class ProjectServiceTests {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	UserService userService;
	
	@Test
	public void shouldList() {
		List <Project> allProjectsOrderedById = projectService.list().stream().sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
		//assertEquals(1L, allProjectsOrderedById.size());
		
		Project firstProject = allProjectsOrderedById.get(0);
		assertEquals("First Project", firstProject.getTitle());
		
		Project secondProject = allProjectsOrderedById.get(1);
		assertEquals("Second Project", secondProject.getTitle());
		
	}
	
	@Test
	public void shouldListProProjects() {
		List <Project> proProjectsOrderedById = projectService.listProProjects().stream().sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
		//assertEquals(1L, allProjectsOrderedById.size());
		
		Project firstProProject = proProjectsOrderedById.get(0);
		assertEquals("First Project", firstProProject.getTitle());
	}
	
	@Test
	public void shouldListNoProProjects() {
		List <Project> nonProProjectsOrderedById = projectService.listNoProProjects().stream().sorted(Comparator.comparing(Project::getId)).collect(Collectors.toList());
		//assertEquals(1L, allProjectsOrderedById.size());
		
		Project firstProProject = nonProProjectsOrderedById.get(0);
		assertEquals("Second Project", firstProProject.getTitle());
	}

	@Test
	public void shouldFindMembers(){
		Integer projectId = 3;
		
		List <Artist> membersOfProject = projectService.findMembers(projectId);
		
		assertEquals(2, membersOfProject.size());
		assertEquals("Artist 1", membersOfProject.get(0).getName());
		assertEquals("Artist 2", membersOfProject.get(1).getName());
	}

	@Test
	public void shouldFindProducers(){
		Integer projectId = 3;
		
		List <Producer> producersOfProject = projectService.findProducers(projectId);
		
		assertEquals(2, producersOfProject.size());
		assertEquals("Producer 1", producersOfProject.get(0).getName());
		assertEquals("Producer 2", producersOfProject.get(1).getName());
		
	}
	
	@Test
	public void shouldFindProjectById(){
		int id = 3;
		
		assertEquals("Project with members", projectService.findProjectById(id).getTitle());
	}
	
	@WithMockUser(username="artistUser4",authorities={"artist"})
	@Test
	public void shouldDeleteArtistRelation(){
		Integer projectId = 4;
		Boolean noEsArtista = false;
		
		assertEquals(2, projectService.findMembers(projectId).size());
		assertEquals("Artist 4", projectService.findMembers(projectId).get(1).getName());
		
		projectService.deleteRelation(projectId, noEsArtista);
		
		assertEquals(1, projectService.findMembers(projectId).size());
		assertThrows(IndexOutOfBoundsException.class, ()->{projectService.findMembers(projectId).get(1);});
	}
	
	@WithMockUser(username="producerUser4",authorities={"producer"})
	@Test
	public void shouldDeleteProducerRelation(){
		Integer projectId = 4;
		Boolean noEsArtista = true;
		
		assertEquals(2, projectService.findProducers(projectId).size());
		assertEquals("Producer 4", projectService.findProducers(projectId).get(1).getName());
		
		projectService.deleteRelation(projectId, noEsArtista);
		
		assertEquals(1, projectService.findProducers(projectId).size());
		assertThrows(IndexOutOfBoundsException.class, ()->{projectService.findProducers(projectId).get(1);});
	}
	
	
	@Test
	public void shouldFindAllMembersUsername(){
		Integer projectId = 3;
		
		List <String> membersUsernames = projectService.findAllMembersUsername(projectId);
		assertEquals("artistUser1", membersUsernames.get(0));
		assertEquals("artistUser2", membersUsernames.get(1));

	}
	
	@WithMockUser(username="artistUser4",authorities={"artist"})
	@Test
	public void shouldCreateProject() throws ProjectLimitException{
		Integer projectId = 99;
		Project project = new Project("New Test Project", "New Description", Genre.ACCION, projectId, "artistUser4", "http://photo");
		
		assertThrows(NoSuchElementException.class, () -> projectService.findProjectById(projectId));
		
		projectService.createProject(project);
		
		assertEquals("New Test Project", projectService.findProjectByAdminUsername("artistUser4").get(2).getTitle());
	}

	
	@Test
	public void shouldEditProject(){
		Project project = projectService.findProjectById(5);
		
		assertEquals("Unedited Project", project.getTitle());
		
		project.setTitle("Edited title");
		
		projectService.editProject(project);
		
		assertEquals("Edited title", projectService.findProjectById(5).getTitle());
		
	}
	
	@Test
	public void shouldCount(){
		
		assertEquals(6L, projectService.count());
	}

	@WithMockUser(username="artistUser4",authorities={"artist"})
	@Test
	public void checkIfIsAdminProject() {
		Integer projectId = 5;
		
		assertEquals(userService.getPrincipal().getUsername(), projectService.findProjectById(projectId).getMyAdmin());
		
		assertTrue(projectService.isAdminProject(projectId));
	}
	
	@WithMockUser(username="artistUser3",authorities={"artist"})
	@Test
	public void checkIfIsNotAdminProject() {
		Integer projectId = 3;
		
		assertFalse(projectService.isAdminProject(projectId));
	}

	@Test
	public void shouldFindProjectByAdminUsername() {
		List <Project> projectsOfJarrod = projectService.findProjectByAdminUsername("JarrodHuffman");
		assertEquals(4, projectsOfJarrod.size());
		
		Project project1 = projectsOfJarrod.get(0);
		assertEquals("First Project",project1.getTitle());
		
		Project project2 = projectsOfJarrod.get(1);
		assertEquals("Second Project",project2.getTitle());
		
		Project project3 = projectsOfJarrod.get(2);
		assertEquals("Project with members",project3.getTitle());
		
		Project project4 = projectsOfJarrod.get(3);
		assertEquals("Project with members to remove",project4.getTitle());
		
		
	}

	@Test
	public void shouldMakeProjectSponsored() {
		Integer projectId = 5;
		projectService.makeProjectSponsored(projectId);
		assertTrue(projectService.findProjectById(projectId).getIsSponsored());
	}
  
	@Test
	public void shouldDeleteProject() {
		Integer projectId = 6;
		
		//assertEquals("Project To Delete", projectService.findProjectById(projectId).getTitle());
		projectService.deleteProject(projectId);
		assertThrows(NoSuchElementException.class, () -> projectService.findProjectById(projectId));
	}

	@Test
	public void shouldFindAllSponsoredProjects() {
		List <Project> sponsoredProjects = projectService.findAllSponsoredProjects();
		
		assertEquals(2, sponsoredProjects.size());
		
		assertEquals("First Project", sponsoredProjects.get(0).getTitle());
		assertEquals("Second Project", sponsoredProjects.get(1).getTitle());
	}
}
