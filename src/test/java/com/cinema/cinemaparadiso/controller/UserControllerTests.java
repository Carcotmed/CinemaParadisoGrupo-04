package com.cinema.cinemaparadiso.controller;

/*
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
*/
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.cinema.cinemaparadiso.service.UserService;

//import org.junit.Assert;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;

@WebMvcTest(controllers = UserController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
classes = WebSecurityConfigurer.class),excludeAutoConfiguration= com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @BeforeEach
	void setup() {
	
    }

    // He metido estos test como prueba para ver si el contexto carga correctamente.

    //@WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void testInitial() throws Exception {
		
		mockMvc.perform(get("/"))
                .andExpect(status().is4xxClientError());
	}

    @Test
	void testInitial2() throws Exception {
/*
		mockMvc.perform(get("/users/create"))
                .andExpect(status().is4xxClientError())
                .andExpect(model().attributeExists("user"))
				.andExpect(view().name("users/createUserForm"));
*/
	}
   
}
