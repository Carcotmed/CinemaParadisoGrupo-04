package com.cinema.cinemaparadiso.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
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

import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.UserService;
import com.cinema.cinemaparadiso.service.WriterService;


@WebMvcTest(controllers = WriterController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
classes = WebSecurityConfigurer.class),excludeAutoConfiguration= com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class WriterControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private WriterService writerService;
    
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldListWriters() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Writer writer1 = new Writer(user1, "writer1", "Descripcion1", 1, "writer1", "photo.photo.es");
    	User user2 = new User("user2", "user2", "email2@email.com");
    	Writer writer2 = new Writer(user2, "writer2", "Descripcion2", 2, "writer2", "photo.photo.es");
    	User user3 = new User("adminTest", "adminTest", "emailadmin@email.com");
    	Writer writer3 = new Writer(user3, "writer3", "Descripcion3", 3, "writer3", "photo.photo.es");
    	List<Writer> listado = new ArrayList<>();
    	listado.add(writer1);
    	listado.add(writer2);
    	listado.add(writer3);
    	
    	BDDMockito.given(writerService.list()).willReturn(listado);
		
		mockMvc.perform(get("/writers/list"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("writers"))
                .andExpect(MockMvcResultMatchers.model().attribute("writers", Matchers.iterableWithSize(3)))
                .andExpect(MockMvcResultMatchers.view().name("/writers/listWriter"));
	}

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldListFilteredWriters() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Writer writer1 = new Writer(user1, "writer1", "Descripcion1", 1, "writer1", "photo.photo.es");
    	User user2 = new User("user2", "user2", "email2@email.com");
    	Writer writer2 = new Writer(user2, "writer2", "Descripcion2", 2, "writer2", "photo.photo.es");
    	User user3 = new User("adminTest", "adminTest", "emailadmin@email.com");
    	Writer writer3 = new Writer(user3, "writer3", "Descripcion3", 3, "writer3", "photo.photo.es");
    	List<Writer> listado = new ArrayList<>();
    	listado.add(writer1);
    	listado.add(writer2);
    	listado.add(writer3);
    	
    	BDDMockito.given(writerService.list()).willReturn(listado);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/writers/list").param("user.username", "A").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("writers"))
                .andExpect(MockMvcResultMatchers.model().attribute("writers", Matchers.iterableWithSize(1)))
                .andExpect(MockMvcResultMatchers.view().name("/writers/listWriter"));
	}

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldShowWriter() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Writer writer1 = new Writer(user1, "writer1", "Descripcion1", 1, "writer1", "photo.photo.es");
    	User user2 = new User("user2", "user2", "email2@email.com");
    	Writer writer2 = new Writer(user2, "writer2", "Descripcion2", 2, "writer2", "photo.photo.es");
    	
    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(writerService.isActualWriter(1)).willReturn(false);
    	BDDMockito.given(writerService.findMyUser(1)).willReturn(user1);
    	BDDMockito.given(writerService.findWriterById(1)).willReturn(writer1);
    	BDDMockito.given(writerService.getPrincipal()).willReturn(writer2);
		
		mockMvc.perform(get("/writers/show/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("writer", writer1))
                .andExpect(MockMvcResultMatchers.model().attribute("sameWriter", false))
                .andExpect(MockMvcResultMatchers.model().attribute("stories", new ArrayList<>()))
                .andExpect(MockMvcResultMatchers.view().name("writers/showWriter"));
	}

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldInitCreateWriter() throws Exception {
		
		mockMvc.perform(get("/writers/create"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("writer"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.model().attribute("isNew", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.view().name("/writers/createOrUpdateWriterForm"));
	}
	
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldPostCreateWriter() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/writers/create")
				.param("name", "Name")
				.param("description", "Description")
				.param("surName", "Surname")
				.param("photo", "http://www.photo.es").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("Error"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/login"));
	}
    
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldInitUpdateWriter() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Writer writer1 = new Writer(user1, "writer1", "Descripcion1", 1, "writer1", "photo.photo.es");

    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(writerService.findWriterById(1)).willReturn(writer1);
		
		mockMvc.perform(get("/writers/update/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("writer", writer1))
                .andExpect(MockMvcResultMatchers.model().attribute("writerId", 1))
                .andExpect(MockMvcResultMatchers.view().name("writers/updateWriter"));
	}
	
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldPostUpdateWriter() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Writer writer1 = new Writer(user1, "writer1", "Descripcion1", 1, "writer1", "photo.photo.es");

    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(writerService.findWriterById(1)).willReturn(writer1);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/writers/update/1")
				.param("name", "Name")
				.param("description", "Description")
				.param("surName", "Surname")
				.param("photo", "http://www.photo.es").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("Error"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/writers/show/{writerId}"));
	}
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldDelete() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Writer writer1 = new Writer(user1, "writer1", "Descripcion1", 1, "writer1", "photo.photo.es");

    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(writerService.isActualWriter(1)).willReturn(false);
    	BDDMockito.given(writerService.findWriterById(1)).willReturn(writer1);
		
		mockMvc.perform(get("/writers/delete/1"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/writers/show/1"));
    }
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldActivate() throws Exception {

    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(writerService.isActualWriter(1)).willReturn(false);
		
		mockMvc.perform(get("/writers/activate/1"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/"));
    }
   
}
