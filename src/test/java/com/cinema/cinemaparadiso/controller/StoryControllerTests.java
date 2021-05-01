package com.cinema.cinemaparadiso.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.Role;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.WriterService;
import com.cinema.cinemaparadiso.service.ArtistService;
import com.cinema.cinemaparadiso.service.MessageService;
import com.cinema.cinemaparadiso.service.ProjectService;
import com.cinema.cinemaparadiso.service.RelUserStoryService;
import com.cinema.cinemaparadiso.service.Rel_projects_storyService;
import com.cinema.cinemaparadiso.service.StoryService;
import com.cinema.cinemaparadiso.service.UserService;
import com.cinema.cinemaparadiso.service.WriterService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(controllers = StoryController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
classes = WebSecurityConfigurer.class),excludeAutoConfiguration= com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class StoryControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
	private StoryService storyService;

    @MockBean
	private ArtistService artistService;
	
    @MockBean
	private WriterService writerService;

    @MockBean
	private UserService userService;

    @MockBean
	private MessageService messageService;

    @MockBean
	private ProjectService projectService;

    @MockBean
	private Rel_projects_storyService rel_projects_storyService;
	
    @MockBean
	private RelUserStoryService relUserStoryService;
    
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldListStories() throws Exception {
//    	User user1 = new User("user1", "user1", "email1@email.com");
//    	Writer writer1 = new Writer(user1, "writer1", "Descripcion1", 1, "writer1", "photo.photo.es");
//    	User user2 = new User("user2", "user2", "email2@email.com");
//    	Writer writer2 = new Writer(user2, "writer2", "Descripcion2", 2, "writer2", "photo.photo.es");
//    	User user3 = new User("adminTest", "adminTest", "emailadmin@email.com");
//    	Writer writer3 = new Writer(user3, "writer3", "Descripcion3", 3, "writer3", "photo.photo.es");
//    	List<Writer> listado = new ArrayList<>();
    	Story story1 = new Story(1, "Story1", "Bodyyyyyyyy1", Genre.ACCION, 1000, "http://www.photo.es");
    	Story story2 = new Story(2, "Story2", "Bodyyyyyyyy2", Genre.CIENCIA_FICCION, 1000, "htttp://www.photo.es");
    	Story story3 = new Story(3, "Story3", "Bodyyyyyyyy3", Genre.ACCION, 1000, "http://www.photo.es");
    	
    	List<Story> listado = new ArrayList<>();
    	listado.add(story1);
    	listado.add(story2);
    	listado.add(story3);
    	BDDMockito.given(storyService.list()).willReturn(listado);
    	BDDMockito.given(storyService.sortByLikes(listado)).willReturn(listado);
		
		mockMvc.perform(get("/stories/list"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("stories"))
                .andExpect(MockMvcResultMatchers.model().attribute("stories", Matchers.iterableWithSize(3)))
                .andExpect(MockMvcResultMatchers.view().name("stories/listStory"));
    }

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldListFilteredStories() throws Exception {
    	Story story1 = new Story(1, "Story1", "Bodyyyyyyyy1", Genre.ACCION, 1000, "http://www.photo.es");
    	Story story2 = new Story(2, "Story2", "Bodyyyyyyyy2", Genre.CIENCIA_FICCION, 1000, "htttp://www.photo.es");
    	Story story3 = new Story(3, "Story3", "Bodyyyyyyyy3", Genre.ACCION, 1000, "http://www.photo.es");

    	List<Story> listado = new ArrayList<>();
    	listado.add(story1);
    	listado.add(story2);
    	listado.add(story3);
    	
    	List<Story> listado2 = new ArrayList<>();
    	listado2.add(story1);
    	listado2.add(story3);
    	BDDMockito.given(storyService.list()).willReturn(listado);
    	BDDMockito.given(storyService.sortByLikesList(listado)).willReturn(listado);
    	BDDMockito.given(storyService.sortByLikesList(listado2)).willReturn(listado2);
    	BDDMockito.given(rel_projects_storyService.haveStoryProject(1)).willReturn("false");
    	BDDMockito.given(rel_projects_storyService.haveStoryProject(2)).willReturn("false");
    	BDDMockito.given(rel_projects_storyService.haveStoryProject(3)).willReturn("false");
		
		mockMvc.perform(MockMvcRequestBuilders.post("/stories/list").param("genre", "ACCION")
				.param("title", "Story").param("body", "Body")
				.param("haveProject", "uiehafh").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("stories"))
                .andExpect(MockMvcResultMatchers.model().attribute("stories", Matchers.iterableWithSize(2)))
                .andExpect(MockMvcResultMatchers.view().name("stories/listStory"));
	}
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldRequest() throws Exception {
    	User user1 = new User("testAUser1", "testPassword1", "testEmail1@gmail.com");
    	Artist artist1 = new Artist(1, Role.ACTOR, new ArrayList<>(), new ArrayList<>(), 2, true, user1);
    	Project project1 = new Project("Test Project 1", "Test Desc 1", Genre.ACCION, 1, "testAUser1", "http://www.photo.com", true, false);
    	
    	Story story1 = new Story(1, "Story1", "Bodyyyyyyyy1", Genre.ACCION, 1000, "http://www.photo.es");
    	Story story2 = new Story(2, "Story2", "Bodyyyyyyyy2", Genre.CIENCIA_FICCION, 1000, "htttp://www.photo.es");
    	Story story3 = new Story(3, "Story3", "Bodyyyyyyyy3", Genre.ACCION, 1000, "http://www.photo.es");
    	
    	List<Story> listado = new ArrayList<>();
    	listado.add(story1);
    	listado.add(story2);
    	listado.add(story3);
    	BDDMockito.given(storyService.sortByLikes(listado)).willReturn(listado);
    	BDDMockito.given(storyService.list()).willReturn(listado);
    	BDDMockito.given(artistService.getPrincipal()).willReturn(artist1);
    	BDDMockito.given(projectService.findProjectById(1)).willReturn(project1);
		
		mockMvc.perform(get("/stories/list"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("stories"))
                .andExpect(MockMvcResultMatchers.model().attribute("stories", Matchers.iterableWithSize(3)))
                .andExpect(MockMvcResultMatchers.view().name("stories/listStory"));
    }

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldInitCreateStory() throws Exception {
    	BDDMockito.given(storyService.isMyWriter(1)).willReturn(true);
    	BDDMockito.given(userService.isAdmin()).willReturn(false);
    	
		mockMvc.perform(get("/stories/create"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("story"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("genres"))
                .andExpect(MockMvcResultMatchers.view().name("stories/createStory"));
	}
	
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldPostCreateStory() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Writer writer1 = new Writer(user1, "writer1", "Descripcion1", 1, "writer1", "photo.photo.es");
    	
    	BDDMockito.given(storyService.isMyWriter(1)).willReturn(true);
    	BDDMockito.given(userService.isAdmin()).willReturn(false);
    	BDDMockito.given(writerService.getPrincipal()).willReturn(writer1);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/stories/create")
				.param("name", "Name")
				.param("description", "Description")
				.param("surName", "Surname")
				.param("photo", "http://www.photo.es").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("Error"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/writers/show/1"));
	}

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldInitUpdateStory() throws Exception {
    	Story story1 = new Story(1, "Story1", "Bodyyyyyyyy1", Genre.ACCION, 1000, "htttp://www.photo.es");
    	
    	BDDMockito.given(storyService.isMyWriter(1)).willReturn(true);
    	BDDMockito.given(userService.isAdmin()).willReturn(false);
    	BDDMockito.given(storyService.findStoryById(1)).willReturn(story1);
    	
		mockMvc.perform(get("/stories/update/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("story"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("genres"))
                .andExpect(MockMvcResultMatchers.view().name("stories/updateStory"));
	}
	
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldPostUpdateStory() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Writer writer1 = new Writer(user1, "writer1", "Descripcion1", 1, "writer1", "photo.photo.es");
    	
    	BDDMockito.given(storyService.isMyWriter(1)).willReturn(true);
    	BDDMockito.given(userService.isAdmin()).willReturn(false);
    	BDDMockito.given(writerService.getPrincipal()).willReturn(writer1);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/stories/update/1")
				.param("name", "Name")
				.param("description", "Description")
				.param("surName", "Surname")
				.param("title", "Title1")
				.param("body", "Bodyyyyyyyyyyy1")
				.param("genre", "ACCION")
				.param("photo", "http://www.photo.es").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("Error"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/stories/show/{storyId}"));
	}
    
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldShowStory() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Writer writer1 = new Writer(user1, "writer1", "Descripcion1", 1, "writer1", "photo.photo.es");
    	Story story1 = new Story(1, "Story1", "Bodyyyyyyyy1", Genre.ACCION, 1000, "http://www.photo.es");

    	BDDMockito.given(userService.getPrincipal()).willReturn(user1);
    	BDDMockito.given(relUserStoryService.actualUserLiked(1, "user1")).willReturn(true);
    	BDDMockito.given(storyService.findStoryById(1)).willReturn(story1);
    	BDDMockito.given(storyService.findMyWriter(1)).willReturn(writer1);
    	BDDMockito.given(storyService.isMyWriter(1)).willReturn(true);
		
		mockMvc.perform(get("/stories/show/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("story", story1))
                .andExpect(MockMvcResultMatchers.model().attribute("showButton", true))
                .andExpect(MockMvcResultMatchers.view().name("stories/showStory"));
	}

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldDelete() throws Exception {
    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(storyService.isMyWriter(1)).willReturn(false);
		
		mockMvc.perform(get("/stories/delete/1"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/stories/list"));
    }

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldLike() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	BDDMockito.given(userService.getPrincipal()).willReturn(user1);
    	BDDMockito.given(relUserStoryService.actualUserLiked(1, "user1")).willReturn(false);
		
		mockMvc.perform(get("/stories/like/1"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/stories/show/1"));
    }

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldDislike() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	BDDMockito.given(userService.getPrincipal()).willReturn(user1);
    	BDDMockito.given(relUserStoryService.actualUserLiked(1, "user1")).willReturn(false);
		
		mockMvc.perform(get("/stories/notLike/1"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/stories/show/1"));
    }
   
}
