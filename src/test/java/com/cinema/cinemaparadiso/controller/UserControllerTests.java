package com.cinema.cinemaparadiso.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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

import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.service.UserService;
//import org.springframework.test.web.servlet.ResultMatcher;

@WebMvcTest(controllers = UserController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
classes = WebSecurityConfigurer.class),excludeAutoConfiguration= com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;
    
    @BeforeAll
    private void setup() {
    	BDDMockito.given(producerService.list()).willReturn((Iterable<Producer>)listado);
    }
    
    @Test
    public void listTest() throws Exception{
    	List <User> usersList = 
    	
    	mockMvc.perform(get("/list"))
    	.andExpect(status().is2xxSuccessful())
    	.andExpect(model().attributeExists("users"))
    	.andExpect(model().attribute("users", usersList));
    }

    @Test
    public void initFormCreateUserTest() throws Exception{
    	mockMvc.perform(get("/create")).andExpect(null);

    }
    
    @Test
    public void selectUserTest() throws Exception{
    	mockMvc.perform(get("select")).andExpect(null);

    }

    @Test
    public void createUserTest() throws Exception{
    	User user = new User ();
    	mockMvc.perform(post("/create", user))
    	.andExpect(status().is2xxSuccessful());

    }
    
    @Test
    public void myProfileTest() throws Exception {
    	mockMvc.perform(get("/miPerfil")).andExpect(null);

    }
    
    
    
    
    
    
    
    
    
    
    //-----------------------------------------------

     //He metido estos test como prueba para ver si el contexto carga correctamente.

//    @WithMockUser(username="admin",authorities= {"admin"})
//	@Test
//	void testInitial() throws Exception {
//		
//		mockMvc.perform(get("/"))
//                .andExpect(status().is2xxSuccessful());
//	}
//
//    @Test
//	void testInitial2() throws Exception {
//
//		mockMvc.perform(get("/users/create"))
//                .andExpect(status().is4xxClientError())
//                .andExpect(model().attributeExists("user"))
//				.andExpect(view().name("users/createUserForm"));
//
//	}
}
