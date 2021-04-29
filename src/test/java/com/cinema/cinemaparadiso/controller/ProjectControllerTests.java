package com.cinema.cinemaparadiso.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.cinema.cinemaparadiso.service.exceptions.ProjectLimitException;

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

	private static Project project1 = new Project("Test Project 1", "Test Desc 1", Genre.ACCION, 1, "testUser1", "http://www.photo.com", true, false);
	private static Project project2 = new Project("Test Project 2", "Test Desc 2", Genre.CIENCIA_FICCION, 1, "testUser2", "http://www.photo.com", false, false);
	private static Project project3 = new Project("Project 3", "Desc 3", Genre.ACCION, 1, "testUser2", "http://www.photo.com", false, false);
	private static Project sponsoredProject = new Project("Test Project Pro", "Test Desc Pro", Genre.ACCION, 1, "testUser2", "http://www.photo.com", false, true);
	
	private static Artist artist1 = new Artist(1, Role.ACTOR, new ArrayList<>(), new ArrayList<>(), 2, false, user1);

	private static Writer writer1 = new Writer(user1, "testWriter1", "Test Writer Desc", 1, "surname", "http://www.photo.com");
	
	private static Producer producer1 = new Producer(user1, "testProducer1", "Test Producer Desc", 1, "surname", "http://www.photo.com", new ArrayList<>());
	private static Producer producer2 = new Producer(user2, "testProducer2", "Test Producer Desc", 2, "surname", "http://www.photo.com", Arrays.asList(project1));

		private static Artist artist2 = new Artist(2, Role.ACTOR, Arrays.asList(project1), new ArrayList<>(), 2, false, user2);
	
	private static List<Project> projectsList = Arrays.asList(project1, project2, project3, sponsoredProject);
	private static List<Project> proProjectsList = Arrays.asList(project1);
	private static List<Project> noProProjectsList = Arrays.asList(project2, project3, sponsoredProject);
	private static List<Project> sponsoredProjectsList = Arrays.asList(sponsoredProject);


	@WithMockUser(username = "user1", authorities = { "artist" })
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
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void filteredListTest() throws Exception {
		BDDMockito.given(projectService.list()).willReturn(projectsList);
		BDDMockito.given(projectService.findAllSponsoredProjects()).willReturn(sponsoredProjectsList);
		
		Project projectsFiltered = new Project();
		projectsFiltered.setTitle("Test");
		projectsFiltered.setGenre(Genre.CIENCIA_FICCION);
		projectsFiltered.setHaveStory("false");
		
		mockMvc.perform(post("/projects/list").with(csrf())
				.param("title", "Test")
				.param("genre", "CIENCIA_FICCION")
				.param("haveStory", "false"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("projectsPro"))
		.andExpect(model().attributeExists("projectsNoPro"))
		.andExpect(model().attributeExists("genres"))
		.andExpect(model().attributeExists("sponsoredProjects"))
		.andExpect(model().attribute("projectsPro", new ArrayList<>()))
		.andExpect(model().attribute("projectsNoPro", Arrays.asList(project2)))
		.andExpect(model().attribute("sponsoredProjects", sponsoredProjectsList))
		.andExpect(view().name("projects/listProject"));

		//PETA PORQUE NO HAY HISTORIAS VINCULADAS A LOS PROYECTOS, PERO NO DEBERÍA SER NECESARIO
		//(ARREGLAR LINEAS 124-129 DE PROJECTCONTROLLER)
		
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void joinProjectArtistTest() throws Exception{
   	
	BDDMockito.given(artistService.getPrincipal()).willReturn(artist1);
	//BDDMockito.given(messageService.requestToEnterProjectArtist(projectId, artist1.getId()));

	mockMvc.perform(get("/projects/joinArtist/1"))
	.andExpect(status().is3xxRedirection())
	.andExpect(view().name("redirect:/messages/listSend"));
	
	}
	
	@WithMockUser(username = "user1", authorities = { "producer" })
	@Test
	public void joinProjectNotArtistTest() throws Exception{
   	
	BDDMockito.given(artistService.getPrincipal()).willReturn(null);
	//BDDMockito.given(messageService.requestToEnterProjectArtist(projectId, artist1.getId()));

	mockMvc.perform(get("/projects/joinArtist/1"))
	.andExpect(model().attributeExists("Error"))
	.andExpect(model().attribute("Error", "No eres un artista"))
	.andExpect(view().name("/error/error"));
	
	}
	
	@WithMockUser(username = "user2", authorities = { "artist" })
	@Test
	public void joinProjectAgainArtistTest() throws Exception{
		   	
	BDDMockito.given(artistService.getPrincipal()).willReturn(artist2);
	//BDDMockito.given(messageService.requestToEnterProjectArtist(projectId, artist1.getId()));

	mockMvc.perform(get("/projects/joinArtist/1"))
	.andExpect(model().attributeExists("Error"))
	.andExpect(model().attribute("Error", "Ya perteneces a este equipo"))
	.andExpect(view().name("/error"));
	
	}
	
	
	@WithMockUser(username = "user1", authorities = { "producer" })
	@Test
	public void joinProjectProducerTest() throws Exception{
   	
	BDDMockito.given(producerService.getPrincipal()).willReturn(producer1);
	//BDDMockito.given(messageService.requestToEnterProjectArtist(projectId, artist1.getId()));

	mockMvc.perform(get("/projects/joinProducer/1"))
	.andExpect(status().is3xxRedirection())
	.andExpect(view().name("redirect:/messages/listSend"));
	
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void joinProjectNotProducerTest() throws Exception{
   	
	BDDMockito.given(producerService.getPrincipal()).willReturn(null);
	//BDDMockito.given(messageService.requestToEnterProjectArtist(projectId, artist1.getId()));

	mockMvc.perform(get("/projects/joinProducer/1"))
	.andExpect(model().attributeExists("Error"))
	.andExpect(model().attribute("Error", "No eres un producer"))
	.andExpect(view().name("/error/error"));
	
	}
	
	@WithMockUser(username = "user2", authorities = { "producer" })
	@Test
	public void joinProjectAgainProducerTest() throws Exception{
		   	
	BDDMockito.given(producerService.getPrincipal()).willReturn(producer2);
	//BDDMockito.given(messageService.requestToEnterProjectArtist(projectId, artist1.getId()));

	mockMvc.perform(get("/projects/joinProducer/1"))
	.andExpect(model().attributeExists("Error"))
	.andExpect(model().attribute("Error", "Ya perteneces a este equipo"))
	.andExpect(view().name("/error"));
	
	}
	
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void showProjectTest() throws Exception {
		Integer projectId = 1;
		
		BDDMockito.given(projectService.findProjectById(projectId)).willReturn(project1);
		BDDMockito.given(projectService.findMembers(projectId)).willReturn(Arrays.asList(artist1));
		BDDMockito.given(projectService.findProducers(projectId)).willReturn(Arrays.asList(producer1));
		BDDMockito.given(postService.listPostOfProject(projectId)).willReturn(new ArrayList<>());
		BDDMockito.given(projectService.isAdminProject(projectId)).willReturn(true);
		BDDMockito.given(artistService.getPrincipal()).willReturn(artist1);
		BDDMockito.given(userService.isAdmin()).willReturn(false);

		mockMvc.perform(get("/projects/show/1"))
		.andExpect(status().is2xxSuccessful())

		.andExpect(model().attribute("projectId", 1))
		.andExpect(model().attribute("project", project1))
		.andExpect(model().attribute("members", Arrays.asList(artist1)))
		.andExpect(model().attribute("producers", Arrays.asList(producer1)))
		.andExpect(model().attribute("artistUsername", artist1.getUser().getUsername()))
		.andExpect(model().attribute("isAdminProject", true))
		.andExpect(model().attribute("isAdmin", false))
		.andExpect(model().attribute("posts", new ArrayList<>()))
		.andExpect(model().attribute("perteneceP", false))
		.andExpect(model().attribute("noPuedeP", true))
		
		.andExpect(view().name("projects/showProject"));

	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void deleteProjectTest() throws Exception {
		mockMvc.perform(get("/projects/delete/1"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/projects/list"));
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void initFormCreateProjectTest() throws Exception {
		BDDMockito.given(artistService.getPrincipal()).willReturn(artist1);
		BDDMockito.given(artistService.leftProjects(artist1.getId())).willReturn(2);

		mockMvc.perform(get("/projects/create"))
		.andExpect(status().is2xxSuccessful())
		
		.andExpect(model().attributeExists("buttonCreate"))
		.andExpect(model().attributeExists("project"))
		.andExpect(model().attributeExists("genres"))
		.andExpect(model().attribute("buttonCreate", true))
		.andExpect(model().attribute("project", new Project()))
		.andExpect(model().attribute("genres", Arrays.asList(Genre.values())))

		.andExpect(view().name("projects/createOrUpdateProjectForm"));
		
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void createProjectTest() throws Exception{
		BDDMockito.given(artistService.getPrincipal()).willReturn(artist1);
		
		mockMvc.perform(post("/projects/create").with(csrf())
				.param("title", "Test")
				.param("genre", "CIENCIA_FICCION")
				.param("description", "Test description")
				.param("photo", "http://photo"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/artists/show/"+artist1.getId()));
		
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void createProjectWithErrorsTest() throws Exception{
		BDDMockito.given(artistService.getPrincipal()).willReturn(artist1);
		
		mockMvc.perform(post("/projects/create").with(csrf())
				.param("title", "Test")
				.param("genre", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
				.param("description", "Test description")
				.param("photo", "http://photo"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeHasErrors("project"))
		.andExpect(model().attributeHasFieldErrors("project","genre"))
		.andExpect(view().name("projects/createOrUpdateProjectForm"));
		
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void initFormUpdateProjectTest() throws Exception {
		BDDMockito.given(projectService.findProjectById(1)).willReturn(project1);
		BDDMockito.given(projectService.isAdminProject(1)).willReturn(true);
		BDDMockito.given(userService.isAdmin()).willReturn(false);

		mockMvc.perform(get("/projects/update/1"))
		.andExpect(status().is2xxSuccessful())
		
		.andExpect(model().attributeExists("buttonCreate"))
		.andExpect(model().attributeExists("projectId"))
		.andExpect(model().attributeExists("project"))
		.andExpect(model().attributeExists("genres"))
		.andExpect(model().attribute("buttonCreate", false))
		.andExpect(model().attribute("projectId", 1))
		.andExpect(model().attribute("project", project1))
		.andExpect(model().attribute("genres", Arrays.asList(Genre.values())))

		.andExpect(view().name("projects/createOrUpdateProjectForm"));
		
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void initFormUnauthorizedUpdateProjectTest() throws Exception {
		BDDMockito.given(projectService.findProjectById(1)).willReturn(project1);
		BDDMockito.given(projectService.isAdminProject(1)).willReturn(false);
		BDDMockito.given(userService.isAdmin()).willReturn(false);

		mockMvc.perform(get("/projects/update/1"))
		.andExpect(status().is2xxSuccessful())

		.andExpect(view().name("error/error-403"));
		
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void updateProjectTest() throws Exception {
		BDDMockito.given(projectService.isAdminProject(1)).willReturn(true);
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		BDDMockito.given(artistService.getPrincipal()).willReturn(artist1);

		mockMvc.perform(post("/projects/update/1").with(csrf())
				.param("title", "TITULO EDITADO")
				.param("genre", "ACCION")
				.param("description", "Test description")
				.param("photo", "http://photo"))
		.andExpect(status().is3xxRedirection())
		
		//.andExpect(model().attributeExists("project"))
		//.andExpect(model().attributeExists("genres"))
		//.andExpect(model().attribute("project", project1))
		//.andExpect(model().attribute("genres", Arrays.asList(Genre.values())))
		
		.andExpect(view().name("redirect:/projects/show/1"));
		
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void updateProjectUnauthorizedTest() throws Exception {
		BDDMockito.given(projectService.isAdminProject(1)).willReturn(false);
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		BDDMockito.given(artistService.getPrincipal()).willReturn(artist1);

		mockMvc.perform(post("/projects/update/1").with(csrf())
				.param("title", "TITULO EDITADO")
				.param("genre", "ACCION")
				.param("description", "Test description")
				.param("photo", "http://photo"))
		.andExpect(status().is2xxSuccessful())
		
		.andExpect(view().name("error/error-403"));
		
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void updateProjectWithErrorsTest() throws Exception {
		BDDMockito.given(projectService.isAdminProject(1)).willReturn(true);
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		BDDMockito.given(artistService.getPrincipal()).willReturn(artist1);

		mockMvc.perform(post("/projects/update/1").with(csrf())
				.param("title", "TITULO EDITADO")
				.param("genre", "AAAAAAAAAAAAAAAAAAAAAAAAAA")
				.param("description", "Test description")
				.param("photo", "http://photo"))
		.andExpect(status().is2xxSuccessful())
		
		//.andExpect(model().attributeHasErrors("project"))
		//.andExpect(model().attributeHasFieldErrors("project", "genre"))
		
		.andExpect(view().name("projects/createOrUpdateProjectForm"));
		
	}
	
	
}
