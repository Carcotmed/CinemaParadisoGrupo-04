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
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Role;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.ArtistService;
import com.cinema.cinemaparadiso.service.UserService;
//import org.springframework.test.web.servlet.ResultMatcher;

//@TestInstance(Lifecycle.PER_CLASS)
@WebMvcTest(controllers = UserController.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class), excludeAutoConfiguration = com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class UserControllerTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private UserService userService;

	private static User user1 = new User("testUser1", "testPassword1", "testEmail1@gmail.com");
	private static User user2 = new User("testUser2", "testPassword2", "testEmail2@gmail.com");

	private static Artist artist1 = new Artist(1, Role.ACTOR, new ArrayList<>(), new ArrayList<>(), 2, false, user1);

	private static Writer writer1 = new Writer(user1, "testWriter1", "Test Writer Desc", 1, "surname", "http://www.photo.com");
	
	private static Producer producer1 = new Producer(user1, "testProducer1", "Test Producer Desc", 1, "surname", "http://www.photo.com");
	
	private static List<User> userList = Arrays.asList(user1, user2);

	@WithMockUser(username = "testUser1", authorities = { "artist" })
	@Test
	public void listTest() throws Exception {
		BDDMockito.given(userService.list()).willReturn((Iterable<User>) userList);

		mockMvc.perform(get("/users/list")).andExpect(status().is2xxSuccessful())
				.andExpect(model().attributeExists("users")).andExpect(model().attribute("users", userList))
				.andExpect(view().name("users/listUser"));
	}

	@WithMockUser(username = "testUser1", authorities = { "artist" })
	@Test
	public void selectUserTest() throws Exception {
		mockMvc.perform(get("/users/select"))
		.andExpect(status().is2xxSuccessful());

	}

	@WithMockUser(username = "testUser1", authorities = { "artist" })
	@Test
	public void myArtistProfileTest() throws Exception {

		BDDMockito.given(userService.findArtistByUserUsername("testUser1")).willReturn(Optional.of(artist1));
		BDDMockito.given(userService.getPrincipal()).willReturn(user1);

		mockMvc.perform(get("/users/miPerfil"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/artists/show/1"));
	}
	
	@WithMockUser(username = "testUser1", authorities = { "writer" })
	@Test
	public void myWriterProfileTest() throws Exception {

		BDDMockito.given(userService.findWriterByUserUsername("testUser1")).willReturn(Optional.of(writer1));
		BDDMockito.given(userService.getPrincipal()).willReturn(user1);

		mockMvc.perform(get("/users/miPerfil"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/writers/show/1"));
	}
	
	@WithMockUser(username = "testUser1", authorities = { "writer" })
	@Test
	public void myProducerProfileTest() throws Exception {

		BDDMockito.given(userService.findProducerByUserUsername("testUser1")).willReturn(Optional.of(producer1));
		BDDMockito.given(userService.getPrincipal()).willReturn(user1);

		mockMvc.perform(get("/users/miPerfil"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/producers/show/1"));
	}

}
