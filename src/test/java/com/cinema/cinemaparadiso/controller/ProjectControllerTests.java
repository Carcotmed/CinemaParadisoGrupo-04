package com.cinema.cinemaparadiso.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
//import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.Role;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.ArtistService;
import com.cinema.cinemaparadiso.service.MessageService;
import com.cinema.cinemaparadiso.service.PostService;
import com.cinema.cinemaparadiso.service.ProducerService;
import com.cinema.cinemaparadiso.service.ProjectService;
import com.cinema.cinemaparadiso.service.Rel_projects_storyService;
import com.cinema.cinemaparadiso.service.StoryService;
import com.cinema.cinemaparadiso.service.UserService;
//import org.springframework.test.web.servlet.ResultMatcher;

//@TestInstance(Lifecycle.PER_CLASS)
@WebMvcTest(controllers = ProjectController.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class), excludeAutoConfiguration = com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class ProjectControllerTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private ProjectService projectService;
	
	@MockBean
	private Rel_projects_storyService rel_projects_storyService;
	@MockBean
	private ArtistService artistService;
	@MockBean
	private UserService userService;
	@MockBean
	private ProducerService producerService;
	@MockBean
	private MessageService messageService;
	@MockBean
	private StoryService storyService;
	@MockBean
	private PostService postService;
	

	private static User user1 = new User("testUser1", "testPassword1", "testEmail1@gmail.com");
	private static User user2 = new User("testUser2", "testPassword2", "testEmail2@gmail.com");

	private static Artist artist1 = new Artist(1, Role.ACTOR, new ArrayList<>(), new ArrayList<>(), 2, false, user1);

	private static Writer writer1 = new Writer(user1, "testWriter1", "Test Writer Desc", 1, "surname", "http://www.photo.com");
	
	private static Producer producer1 = new Producer(user1, "testProducer1", "Test Producer Desc", 1, "surname", "http://www.photo.com");
	
	private static Project project1 = new Project("Test Project 1", "Test Desc 1", Genre.ACCION, 1, "testUser1", "http://www.photo.com", true, false);
	private static Project project2 = new Project("Test Project 2", "Test Desc 2", Genre.ACCION, 1, "testUser2", "http://www.photo.com", false, false);
	private static Project sponsoredProject = new Project("Test Project 2", "Test Desc 2", Genre.ACCION, 1, "testUser2", "http://www.photo.com", false, true);

	private static List<Project> projectsList = Arrays.asList(project1, project2);
	private static List<Project> proProjectsList = Arrays.asList(project1);
	private static List<Project> noProProjectsList = Arrays.asList(project2);
	private static List<Project> sponsoredProjectsList = Arrays.asList(sponsoredProject);


	@WithMockUser(username = "testUser1", authorities = { "artist" })
	@Test
	public void listTest() throws Exception {
		BDDMockito.given(projectService.list()).willReturn(projectsList);
		BDDMockito.given(projectService.listProProjects()).willReturn(proProjectsList);
		BDDMockito.given(projectService.listNoProProjects()).willReturn(noProProjectsList);
		BDDMockito.given(projectService.findAllSponsoredProjects()).willReturn(sponsoredProjectsList);


		mockMvc.perform(get("/projects/list"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(model().attributeExists("projectsPro"))
				.andExpect(model().attributeExists("projectsNoPro"))
				.andExpect(model().attributeExists("genres"))
				.andExpect(model().attributeExists("sponsoredProjects"))

				.andExpect(model().attribute("projectsPro", proProjectsList))
				.andExpect(model().attribute("projectsNoPro", noProProjectsList))
				.andExpect(model().attribute("sponsoredProjects", sponsoredProjectsList))

				.andExpect(view().name("projects/listProject"));
	}
	
	@WithMockUser(username = "testUser1", authorities = { "artist" })
	@Test
	public void filteredListTest() throws Exception {
		
	}
	
	
	
	
	
	
}
