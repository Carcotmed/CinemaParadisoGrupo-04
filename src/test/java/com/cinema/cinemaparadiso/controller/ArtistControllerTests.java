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

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
//import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Role;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.service.ArtistService;
import com.cinema.cinemaparadiso.service.UserService;

//@TestInstance(Lifecycle.PER_CLASS)
@WebMvcTest(controllers = ArtistController.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class), excludeAutoConfiguration = com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class ArtistControllerTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private ArtistService artistService;

	@MockBean
	private UserService userService;


	private static User user1 = new User("testAUser1", "testPassword1", "testEmail1@gmail.com");
	private static User user2 = new User("testUser2", "testPassword2", "testEmail2@gmail.com");
	private static User user3 = new User("testAUser3", "testPassword3", "testEmail3@gmail.com");
	private static User user4 = new User("testUser4", "testPassword4", "testEmail4@gmail.com");

	private static Artist artist1 = new Artist(1, Role.ACTOR, new ArrayList<>(), new ArrayList<>(), 2, true, user1);
	private static Artist artist2 = new Artist(2, Role.ACTOR, new ArrayList<>(), new ArrayList<>(), 2, true, user2);
	private static Artist artist3 = new Artist(3, Role.ACTOR, new ArrayList<>(), new ArrayList<>(), 2, false, user3);
	private static Artist artist4 = new Artist(4, Role.ACTOR, new ArrayList<>(), new ArrayList<>(), 2, false, user4);

	private static List<Artist> artistList = Arrays.asList(artist1, artist2, artist3, artist4);
	private static List<Artist> proArtistList = Arrays.asList(artist1, artist2);
	private static List<Artist> noProArtistList = Arrays.asList(artist3, artist4);

	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void listTest() throws Exception {
		BDDMockito.given(artistService.list()).willReturn(artistList);
		BDDMockito.given(artistService.listProArtist()).willReturn(proArtistList);
		BDDMockito.given(artistService.listNoProArtist()).willReturn(noProArtistList);

		mockMvc.perform(get("/artists/list"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("artists"))
		.andExpect(model().attributeExists("artistsPro"))
		.andExpect(model().attributeExists("artistsNoPro"))
		.andExpect(model().attributeExists("roles"))
		.andExpect(model().attributeExists("artistsFiltered"))

		.andExpect(model().attribute("artists", artistList))
		.andExpect(model().attribute("artistsPro", proArtistList))
		.andExpect(model().attribute("artistsNoPro", noProArtistList))
		.andExpect(model().attribute("artistsFiltered", new Artist()))

		.andExpect(view().name("artists/listArtist"));
		
	}

	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void filteredListTest() throws Exception {
		BDDMockito.given(artistService.list()).willReturn(artistList);
		BDDMockito.given(artistService.listProArtist()).willReturn(proArtistList);
		BDDMockito.given(artistService.listNoProArtist()).willReturn(noProArtistList);
		
		
		mockMvc.perform(post("/artists/list").with(csrf())
				.param("user.username", "A"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("artists"))
		.andExpect(model().attributeExists("artistsPro"))
		.andExpect(model().attributeExists("artistsNoPro"))
		.andExpect(model().attributeExists("roles"))
		.andExpect(model().attributeExists("artistsFiltered"))

		.andExpect(model().attribute("artists", artistList))
		.andExpect(model().attribute("artistsPro", Arrays.asList(artist1)))
		.andExpect(model().attribute("artistsNoPro", Arrays.asList(artist3)))
		.andExpect(model().attribute("roles", Arrays.asList(Role.values())))

		.andExpect(view().name("artists/listArtist"));
		
		
	}
	

	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void showArtist() throws Exception {
		Integer artistId = 1;
		
		BDDMockito.given(artistService.findArtistById(artistId)).willReturn(artist1);
		BDDMockito.given(artistService.isActualArtist(artistId)).willReturn(true);
		BDDMockito.given(artistService.findMyProjects(artistId)).willReturn(new ArrayList<>());
		BDDMockito.given(artistService.leftProjects(artistId)).willReturn(10);
		BDDMockito.given(artistService.findMyUser(artistId)).willReturn(user1);
		BDDMockito.given(userService.isAdmin()).willReturn(false);

		mockMvc.perform(get("/artists/show/"+artistId))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("projectsLeft"))
		.andExpect(model().attributeExists("myProjects"))
		.andExpect(model().attributeExists("artistUsername"))
		.andExpect(model().attributeExists("artistId"))
		.andExpect(model().attributeExists("artist"))
		.andExpect(model().attributeExists("showButton"))
		.andExpect(model().attributeExists("userDisabled"))
		.andExpect(model().attributeExists("isAdmin"))


		.andExpect(model().attribute("projectsLeft", 10))
		.andExpect(model().attribute("myProjects", new ArrayList<> ()))
		.andExpect(model().attribute("artistUsername", "testAUser1"))
		.andExpect(model().attribute("artistId", 1))
		.andExpect(model().attribute("artist", artist1))
		.andExpect(model().attribute("showButton", true))
		.andExpect(model().attribute("userDisabled", false))
		.andExpect(model().attribute("isAdmin", false))

		.andExpect(view().name("artists/showArtist"));
		
	}	

	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void initFormCreateArtist() throws Exception {
		
		mockMvc.perform(get("/artists/create"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("user"))
		.andExpect(model().attributeExists("artist"))
		.andExpect(model().attributeExists("roles"))


		.andExpect(model().attribute("user", new User()))
		.andExpect(model().attribute("artist", new Artist ()))
		.andExpect(model().attribute("roles", Arrays.asList(Role.values())))

		.andExpect(view().name("artists/createOrUpdateArtistForm"));
	}

	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void createArtistTest() throws Exception {
		
		mockMvc.perform(post("/artists/create").with(csrf())
				.param("user.username", "creatingUser")
				.param("user.password", "creatingUserPass")
				.param("user.email", "creatingUser@email.com")
				.param("name", "Pedro")
				.param("surName", "Pedrito")
				.param("description", "Description very long yes")
				.param("photo", "http://www.google.com")
				.param("role", "CAMARA"))

		.andExpect(status().is3xxRedirection())

		.andExpect(view().name("redirect:/login"));
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void createArtistWithErrorsTest() throws Exception {
		
		mockMvc.perform(post("/artists/create").with(csrf())
				.param("user.username", "creatingUser")
				.param("user.password", "creatingUserPass")
				.param("user.email", "creatingUser@email.com")
				.param("name", "Pedro")
				.param("surName", "Pedrito")
				.param("description", "Description very long yes")
				.param("photo", "www.google.com")
				.param("role", "CAMARA"))

		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("roles"))
		.andExpect(model().attribute("roles", Arrays.asList(Role.values())))

		.andExpect(model().attributeHasFieldErrors("artist", "photo"))
		
		.andExpect(view().name("artists/createOrUpdateArtistForm"));
	
	}

	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void initFormUpdateArtistTest() throws Exception {
		Integer artistId = 1;
		
		BDDMockito.given(artistService.isActualArtist(artistId)).willReturn(true);
		BDDMockito.given(artistService.findArtistById(artistId)).willReturn(artist1);
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		
		mockMvc.perform(get("/artists/update/"+artistId))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("artistId"))
		.andExpect(model().attributeExists("artist"))
		.andExpect(model().attributeExists("roles"))


		.andExpect(model().attribute("artistId", artistId))
		.andExpect(model().attribute("artist", artist1))
		.andExpect(model().attribute("roles", Arrays.asList(Role.values())))

		.andExpect(view().name("artists/updateArtist"));
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void initFormUnauthorizedUpdateArtistTest() throws Exception {
		Integer artistId = 1;
		
		BDDMockito.given(artistService.isActualArtist(artistId)).willReturn(false);
		BDDMockito.given(artistService.findArtistById(artistId)).willReturn(artist1);
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		
		mockMvc.perform(get("/artists/update/"+artistId))
		.andExpect(status().is2xxSuccessful())

		.andExpect(view().name("error/error-403"));
	}


	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void updateArtistTest() throws Exception {
		Integer artistId = 1;
		
		BDDMockito.given(artistService.isActualArtist(artistId)).willReturn(true);
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		
		mockMvc.perform(post("/artists/update/"+artistId).with(csrf())
				.param("user.username", "editingUser")
				.param("user.email", "editingUser@email.com")
				.param("user.password", "editingUserPass")
				.param("name", "Pedro")
				.param("surName", "Pedrito")
				.param("description", "Description very long yes")
				.param("photo", "http://www.google.com")
				.param("role", "CAMARA"))

		.andExpect(status().is3xxRedirection())
		
		.andExpect(view().name("redirect:/artists/show/{artistId}"));
	
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void updateUnauthorizedArtistTest() throws Exception {
		Integer artistId = 1;
		
		BDDMockito.given(artistService.isActualArtist(artistId)).willReturn(false);
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		
		mockMvc.perform(post("/artists/update/"+artistId).with(csrf())
				.param("user.username", "editingUser")
				.param("user.email", "editingUser@email.com")
				.param("user.password", "editingUserPass")
				.param("name", "Pedro")
				.param("surName", "Pedrito")
				.param("description", "Description very long yes")
				.param("photo", "http://www.google.com")
				.param("role", "CAMARA"))

		.andExpect(status().is2xxSuccessful())
		
		.andExpect(view().name("error/error-403"));
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void updateArtistWithErrorsTest() throws Exception {
		Integer artistId = 1;
		
		BDDMockito.given(artistService.isActualArtist(artistId)).willReturn(true);
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		
		mockMvc.perform(post("/artists/update/"+artistId).with(csrf())
				.param("user.username", "editingUser")
				.param("user.email", "editingUser@email.com")
				.param("user.password", "editingUserPass")
				.param("name", "Pedro")
				.param("surName", "Pedrito")
				.param("description", "Description very long yes")
				.param("photo", "WRONG")
				.param("role", "CAMARA"))

		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeHasFieldErrors("artist", "photo"))
		
		.andExpect(view().name("artists/updateArtist"));
	}
	
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void deleteArtist() throws Exception {
		Integer artistId = 1;
		BDDMockito.given(artistService.isActualArtist(artistId)).willReturn(true);
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		
		mockMvc.perform(get("/artists/delete/"+artistId))
		.andExpect(status().is3xxRedirection())

		.andExpect(view().name("redirect:/"));
		
	}
	

	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void deleteArtistUnauthorized() throws Exception {
		Integer artistId = 1;
		BDDMockito.given(artistService.isActualArtist(artistId)).willReturn(false);
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		
		mockMvc.perform(get("/artists/delete/"+artistId))
		.andExpect(status().is2xxSuccessful())

		.andExpect(view().name("error/error-403"));
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void activateArtistTest() throws Exception {
		Integer artistId = 1;
		BDDMockito.given(userService.isAdmin()).willReturn(true);
		
		mockMvc.perform(get("/artists/activate/"+artistId))
		.andExpect(status().is3xxRedirection())

		.andExpect(view().name("redirect:/"));
		
	}
	
	@WithMockUser(username = "user1", authorities = { "artist" })
	@Test
	public void activateArtistUnauthorizedTest() throws Exception {
		Integer artistId = 1;
		BDDMockito.given(userService.isAdmin()).willReturn(false);
		
		mockMvc.perform(get("/artists/activate/"+artistId))
		.andExpect(status().is2xxSuccessful())

		.andExpect(view().name("error/error-403"));
		
		
	}

}
