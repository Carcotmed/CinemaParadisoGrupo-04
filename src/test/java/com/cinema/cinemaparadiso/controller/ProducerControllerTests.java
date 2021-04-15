//package com.cinema.cinemaparadiso.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.cinema.cinemaparadiso.model.Producer;
//import com.cinema.cinemaparadiso.model.User;
//import com.cinema.cinemaparadiso.service.ProducerService;
//import com.cinema.cinemaparadiso.service.UserService;
//
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.BDDMockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.request.RequestPostProcessor;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//
//@WebMvcTest(controllers = ProducerController.class,
//excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
//classes = WebSecurityConfigurer.class),excludeAutoConfiguration= com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
//public class ProducerControllerTests {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @MockBean
//    private ProducerService producerService;
//
//    Producer producer1;
//    Producer producer2;
//    Producer producer3;
//    Producer producer4;
//    @BeforeEach
//	void setup() {
//    	User user1 = new User("user1", "user1", true);
//    	User user2 = new User("user2", "user2", true);
//    	User user3 = new User("adminTest", "adminTest", true);
//    	User user4 = new User("admin", "admin", true);
//    	Producer producer1 = new Producer("1234567A", "Descripcion1", user1);
//    	Producer producer2 = new Producer("1234567B", "Descripcion2", user2);
//    	Producer producer3 = new Producer("1234567C", "Descripcion3", user3);
//    	Producer producer4 = new Producer("1234567D", "Descripcion4", user4);
//    	producer4.setId(4);
//    	producer3.setId(3);
//    	this.producer1 = producer1;
//    	this.producer2 = producer2;
//    	this.producer3 = producer3;
//    	this.producer4 = producer4;
//    	List<Producer> listado = new ArrayList<>();
//    	listado.add(producer1);
//    	listado.add(producer2);
//    	listado.add(producer3);
//    	BDDMockito.given(producerService.list()).willReturn((Iterable<Producer>)listado);
//    	BDDMockito.given(producerService.getProducerByUsername(user1.getUsername())).willReturn(producer1);
//    	BDDMockito.given(producerService.getProducerByUsername("admin")).willReturn(producer4);
//    	BDDMockito.given(userService.getUserByUsername("admin")).willReturn(user4);
//    	BDDMockito.given(userService.getUserByUsername("adminTest")).willReturn(user3);
//    	BDDMockito.given(producerService.existeProducerByUsername("admin")).willReturn(false);
//    	BDDMockito.given(producerService.existeProducerByUsername("adminTest")).willReturn(true);
//    	BDDMockito.given(producerService.getProducerById(4)).willReturn(producer4);
//    	BDDMockito.given(producerService.getProducerById(3)).willReturn(producer3);
//    }
//
//    // He metido estos test como prueba para ver si el contexto carga correctamente.
//
//    @WithMockUser(username="admin",authorities= {"admin"})
//	@Test
//	void shouldListProducers() throws Exception {
//		
//		mockMvc.perform(get("/producers/list"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.model().attributeExists("producers"))
//                .andExpect(MockMvcResultMatchers.model().attribute("producers", Matchers.iterableWithSize(3)))
//                .andExpect(MockMvcResultMatchers.view().name("/producers/listProducer"));
//	}
//    
////    @WithMockUser(username="admin",authorities= {"admin"})
////	@Test
////	void shouldShowProducers() throws Exception {
////		
////		mockMvc.perform(get("/producers/show/user1"))
////                .andExpect(status().isOk())
////                .andExpect(MockMvcResultMatchers.model().attributeExists("producer"))
////                .andExpect(MockMvcResultMatchers.model().attribute("producer", Matchers.is(producer1)))
////                .andExpect(MockMvcResultMatchers.view().name("/producers/showProducer"));
////	}
//    /*
//    @WithMockUser(username="admin",authorities= {"admin"})
//	@Test
//	void shouldInitCreateProducer() throws Exception {
//		
//		mockMvc.perform(get("/producers/create"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.model().attributeExists("producer"))
//                .andExpect(MockMvcResultMatchers.model().attribute("producer", Matchers.samePropertyValuesAs(new Producer(), "")))
//                .andExpect(MockMvcResultMatchers.model().attribute("isNew", Matchers.is(true)))
//                .andExpect(MockMvcResultMatchers.view().name("/producers/createUpdateProducerForm"));
//	}
//	
//    @WithMockUser(username="admin",authorities= {"admin"})
//	@Test
//	void shouldPostCreateProducer() throws Exception {
//		
//		mockMvc.perform(MockMvcRequestBuilders.post("/producers/create")
//				.param("nif", "12345678D")
//				.param("description", "Description").with(SecurityMockMvcRequestPostProcessors.csrf()))
//                .andExpect(status().isFound())
//                .andExpect(MockMvcResultMatchers.model().attributeDoesNotExist("Error"))
//                .andExpect(MockMvcResultMatchers.view().name("redirect:/producers/list"));
//	}
//	
//    @WithMockUser(username="adminTest",authorities= {"admin"})
//	@Test
//	void shouldNotPostCreateProducerWithRepeatedUser() throws Exception {
//		
//		mockMvc.perform(MockMvcRequestBuilders.post("/producers/create")
//				.param("nif", "12345678E")
//				.param("description", "Description2").with(SecurityMockMvcRequestPostProcessors.csrf()))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.model().attribute("Error", "Este usuario ya posee un productor"))
//                .andExpect(MockMvcResultMatchers.view().name("/error"));
//	}
//    */
//    @WithMockUser(username="admin",authorities= {"admin"})
//	@Test
//	void shouldInitUpdateProducer() throws Exception {
//		
//		mockMvc.perform(get("/producers/update/admin"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.model().attributeExists("producer"))
//                .andExpect(MockMvcResultMatchers.model().attribute("producer", Matchers.samePropertyValuesAs(producer4)))
//                .andExpect(MockMvcResultMatchers.model().attribute("isNew", Matchers.is(false)))
//                .andExpect(MockMvcResultMatchers.view().name("/producers/createUpdateProducerForm"));
//	}
//   
//}
