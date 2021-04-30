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
import java.util.stream.Collectors;

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
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.Role;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.ArtistService;
import com.cinema.cinemaparadiso.service.UserService;
//import org.springframework.test.web.servlet.ResultMatcher;
import com.cinema.cinemaparadiso.service.exceptions.UserUniqueException;

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
				.param("username", "A"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(model().attributeExists("artists"))
		.andExpect(model().attributeExists("artistsPro"))
		.andExpect(model().attributeExists("artistsNoPro"))
		.andExpect(model().attributeExists("roles"))
		.andExpect(model().attributeExists("artistsFiltered"))

		.andExpect(model().attribute("artists", Arrays.asList(artist1, artist3)))
		.andExpect(model().attribute("artistsPro", Arrays.asList(artist1)))
		.andExpect(model().attribute("artistsNoPro", Arrays.asList(artist3)))

		.andExpect(view().name("artists/listArtist"));
		
		
	}
	
//
//	@GetMapping(value = { "/show/{artistId}" })
//	public String showArtist(@PathVariable("artistId") int artistId, Model model) {
//		Artist artist = artistService.findArtistById(artistId);
//		Boolean showButton = artistService.isActualArtist(artistId) || userService.isAdmin();
//		List<Project> myProjects = artistService.findMyProjects(artistId);
//		Integer projectsLeft = artistService.leftProjects(artistId);
//		Boolean disabled = !artistService.findMyUser(artistId).isEnabled();
//		model.addAttribute("projectsLeft",projectsLeft);
//		model.addAttribute("myProjects",myProjects);
//		model.addAttribute("artistUsername", artist.getUser().getUsername());
//		model.addAttribute("artistId", artistId);
//		model.addAttribute("artist", artist);
//		model.addAttribute("showButton",showButton);
//		model.addAttribute("userDisabled",disabled);
//		model.addAttribute("isAdmin",userService.isAdmin());
//		return "artists/showArtist";
//	}	
//
//	@GetMapping("/create")
//	public String initFormCreateArtist(Model model) {
//		Artist artist = new Artist();
//		User user = new User();
//		List<Role> role = Arrays.asList(Role.values());
//		
//		model.addAttribute("user",user);
//		model.addAttribute("artist", artist);
//		model.addAttribute("roles", role);
//
//		return "artists/createOrUpdateArtistForm";
//	}
//
//	@PostMapping("/create")
//	public String createArtist(@Valid Artist artist, BindingResult result, Model model) throws UserUniqueException{
//		List<Role> role = Arrays.asList(Role.values());
//		model.addAttribute("roles", role);
//		if(!result.hasErrors()) {
//			//Unique artist exception
//			try{
//				
//				this.artistService.createArtist(artist);
//			}
//			catch(UserUniqueException ex) {
//				result.rejectValue("user.username", "unique", "Este usuario ya existe, pruebe con otro");
//				return "artists/createOrUpdateArtistForm";
//			}
//			log.info("Artist Created Successfully");
//		} else {
//			return "artists/createOrUpdateArtistForm";
//		}
//		return "redirect:/login";
//	}
//
//	@GetMapping("/update/{artistId}")
//	public String initFormUpdateArtist(Model model, @PathVariable("artistId") Integer artistId) {
//		if(!artistService.isActualArtist(artistId) && !userService.isAdmin()) {
//			return "error/error-403";
//		}
//		Artist artist = artistService.findArtistById(artistId);
//		List<Role> roles = Arrays.asList(Role.values());
//		model.addAttribute("artistId", artistId);
//		model.addAttribute("artist", artist);
//		model.addAttribute("roles",roles);
//		return "artists/updateArtist";
//	}
//
//
//	@PostMapping("/update/{artistId}")
//	public String updateArtist(@ModelAttribute("artist") @Valid Artist artist, BindingResult result,Model model, @PathVariable("artistId") Integer artistId) {
//		artist.setId(artistId);
//		if(!artistService.isActualArtist(artistId) && !userService.isAdmin()) {
//			return "error/error-403";
//		}
//		List<Role> roles = Arrays.asList(Role.values());
//		model.addAttribute("roles",roles);
//		if(!result.hasErrors()) {
//			artistService.editArtist(artist);
//			return "redirect:/artists/show/{artistId}";
//		}else {
//			return "artists/updateArtist";
//		}
//	}
//	@GetMapping("/delete/{artistId}")
//	public String deleteArtist(@PathVariable("artistId") Integer artistId) {
//		if(!artistService.isActualArtist(artistId) && !userService.isAdmin()) {
//			return "error/error-403";
//		}
//		try {
//			artistService.deleteArtist(artistId);
//			if(!userService.isAdmin())
//				SecurityContextHolder.clearContext();
//			log.info("Artist Deleted Successfully");
//		} catch (Exception e) {
//			log.error("Error Deleting Artist", e);
//		}
//		return "redirect:/";
//	}
//	@GetMapping("/activate/{artistId}")
//	public String activateArtist(@PathVariable("artistId") Integer artistId) {
//		if(!userService.isAdmin()) {
//			return "error/error-403";
//		}
//		try {
//			artistService.activateArtist(artistId);
//			if(!userService.isAdmin())
//				SecurityContextHolder.clearContext();
//			log.info("Artist Activated Successfully");
//		} catch (Exception e) {
//			log.error("Error Activating Artist", e);
//		}
//		return "redirect:/";
//	}

}
