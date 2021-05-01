package com.cinema.cinemaparadiso.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.service.ProducerService;
import com.cinema.cinemaparadiso.service.UserService;

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


@WebMvcTest(controllers = ProducerController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
classes = WebSecurityConfigurer.class),excludeAutoConfiguration= com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class ProducerControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private ProducerService producerService;
    
    @BeforeEach
	void setup() {
    	/*
    	User user1 = new User("user1", "user1", "email1@email.com");
    	User user2 = new User("user2", "user2", "email2@email.com");
    	User user3 = new User("adminTest", "adminTest", "emailadmin@email.com");
    	User user4 = new User("admin", "admin", "emailadmin@email.com");
    	Producer producer1 = new Producer(user1, "producer1", "Descripcion1", 1, "producer1", "photo.photo.es");
    	Producer producer2 = new Producer(user2, "producer2", "Descripcion2", 2, "producer2", "photo.photo.es");
    	Producer producer3 = new Producer(user3, "producer3", "Descripcion3", 3, "producer3", "photo.photo.es");
    	Producer producer4 = new Producer(user4, "producer4", "Descripcion4", 4, "producer4", "photo.photo.es");
    	this.producer1 = producer1;
    	this.producer2 = producer2;
    	this.producer3 = producer3;
    	this.producer4 = producer4;
    	List<Producer> listado = new ArrayList<>();
    	listado.add(producer1);
    	listado.add(producer2);
    	listado.add(producer3);
    	BDDMockito.given(producerService.list()).willReturn(listado);
    	BDDMockito.given(producerService.findProducerByUsername(user1.getUsername())).willReturn(producer1);
    	BDDMockito.given(producerService.findProducerByUsername("admin")).willReturn(producer4);
    	BDDMockito.given(userService.getUserByUsername("admin")).willReturn(user4);
    	BDDMockito.given(userService.getUserByUsername("adminTest")).willReturn(user3);
    	BDDMockito.given(producerService.isUniqueUsername("admin")).willReturn(true);
    	BDDMockito.given(producerService.isUniqueUsername("adminTest")).willReturn(false);
    	BDDMockito.given(producerService.findProducerById(4)).willReturn(producer4);
    	BDDMockito.given(producerService.findProducerById(3)).willReturn(producer3);
    	*/
    }

    // He metido estos test como prueba para ver si el contexto carga correctamente.

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldListProducers() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Producer producer1 = new Producer(user1, "producer1", "Descripcion1", 1, "producer1", "photo.photo.es");
    	User user2 = new User("user2", "user2", "email2@email.com");
    	Producer producer2 = new Producer(user2, "producer2", "Descripcion2", 2, "producer2", "photo.photo.es");
    	User user3 = new User("adminTest", "adminTest", "emailadmin@email.com");
    	Producer producer3 = new Producer(user3, "producer3", "Descripcion3", 3, "producer3", "photo.photo.es");
    	List<Producer> listado = new ArrayList<>();
    	listado.add(producer1);
    	listado.add(producer2);
    	listado.add(producer3);
    	
    	BDDMockito.given(producerService.list()).willReturn(listado);
		
		mockMvc.perform(get("/producers/list"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("producers"))
                .andExpect(MockMvcResultMatchers.model().attribute("producers", Matchers.iterableWithSize(3)))
                .andExpect(MockMvcResultMatchers.view().name("producers/listProducer"));
	}

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldListFilteredProducers() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Producer producer1 = new Producer(user1, "producer1", "Descripcion1", 1, "producer1", "photo.photo.es");
    	User user2 = new User("user2", "user2", "email2@email.com");
    	Producer producer2 = new Producer(user2, "producer2", "Descripcion2", 2, "producer2", "photo.photo.es");
    	User user3 = new User("adminTest", "adminTest", "emailadmin@email.com");
    	Producer producer3 = new Producer(user3, "producer3", "Descripcion3", 3, "producer3", "photo.photo.es");
    	List<Producer> listado = new ArrayList<>();
    	listado.add(producer1);
    	listado.add(producer2);
    	listado.add(producer3);
    	
    	BDDMockito.given(producerService.list()).willReturn(listado);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/producers/list").param("user.username", "A").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("producers"))
                .andExpect(MockMvcResultMatchers.model().attribute("producers", Matchers.iterableWithSize(1)))
                .andExpect(MockMvcResultMatchers.view().name("/producers/listProducer"));
	}

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldShowProducers() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Producer producer1 = new Producer(user1, "producer1", "Descripcion1", 1, "producer1", "photo.photo.es");
    	
    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(producerService.isActualProducer(1)).willReturn(false);
    	BDDMockito.given(producerService.findMyUser(1)).willReturn(user1);
    	BDDMockito.given(producerService.findProducerById(1)).willReturn(producer1);
    	BDDMockito.given(producerService.findMyprojects(1)).willReturn(new ArrayList<>());
		
		mockMvc.perform(get("/producers/show/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("producer", producer1))
                .andExpect(MockMvcResultMatchers.model().attribute("myProjects", Matchers.iterableWithSize(0)))
                .andExpect(MockMvcResultMatchers.model().attribute("showButton", true))
                .andExpect(MockMvcResultMatchers.view().name("producers/showProducer"));
	}

    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldInitCreateProducer() throws Exception {
		
		mockMvc.perform(get("/producers/create"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("producer"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
                .andExpect(MockMvcResultMatchers.model().attribute("isNew", Matchers.is(true)))
                .andExpect(MockMvcResultMatchers.view().name("producers/createUpdateProducerForm"));
	}
	
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldPostCreateProducer() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/producers/create")
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
	void shouldInitUpdateProducer() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Producer producer1 = new Producer(user1, "producer1", "Descripcion1", 1, "producer1", "photo.photo.es");

    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(producerService.findProducerById(1)).willReturn(producer1);
		
		mockMvc.perform(get("/producers/update/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("producer", producer1))
                .andExpect(MockMvcResultMatchers.model().attribute("producerId", 1))
                .andExpect(MockMvcResultMatchers.view().name("producers/updateProducer"));
	}
	
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldPostUpdateProducer() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Producer producer1 = new Producer(user1, "producer1", "Descripcion1", 1, "producer1", "photo.photo.es");

    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(producerService.findProducerById(1)).willReturn(producer1);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/producers/update/1")
				.param("name", "Name")
				.param("description", "Description")
				.param("surName", "Surname")
				.param("photo", "http://www.photo.es").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("Error"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/producers/show/{producerId}"));
	}
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldDelete() throws Exception {
    	User user1 = new User("user1", "user1", "email1@email.com");
    	Producer producer1 = new Producer(user1, "producer1", "Descripcion1", 1, "producer1", "photo.photo.es");

    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(producerService.isActualProducer(1)).willReturn(false);
    	BDDMockito.given(producerService.findProducerById(1)).willReturn(producer1);
		
		mockMvc.perform(get("/producers/delete/1"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/"));
    }
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldActivate() throws Exception {

    	BDDMockito.given(userService.isAdmin()).willReturn(true);
    	BDDMockito.given(producerService.isActualProducer(1)).willReturn(false);
		
		mockMvc.perform(get("/producers/activate/1"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/"));
    }
   
}
