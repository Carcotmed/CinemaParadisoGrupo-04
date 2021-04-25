package com.cinema.cinemaparadiso.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.Role;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.service.exceptions.UserUniqueException;


@SpringBootTest
@Sql("/db/testing-data/artistServiceTests/testing-data.sql")
@Transactional
@TestInstance(Lifecycle.PER_CLASS)
public class ArtistServiceTests {
	
	@Autowired
	ArtistService artistService;
	
	@Autowired
	UserService userService;
	
	@Test
    public void shouldListTotalArtist(){
		List <Artist> allArtists = this.artistService.list();
        Integer totalArtist = allArtists.size();
		//assertThat(totalArtist).isEqualTo(2);
    }
	
	@Test
	public void shouldListProArtist() {
		List <Artist> proList = this.artistService.listProArtist();
		
		assertEquals(5, proList.size());
	}
	
	@Test
	public void shouldListNoProArtist() {
		
		List <Artist> noProList = this.artistService.listNoProArtist();

		assertEquals(4, noProList.size());
	}
	
	@Test
	public void shouldBeUniqueUsername() {
		String username = "uniqueUsername";
				
		assertTrue(artistService.isUniqueUsername(username));
	}
	
	@Test
	public void shouldNotBeUniqueUsername() {
		String username = "existingUserName";
				
		assertFalse(artistService.isUniqueUsername(username));
	}

	@Test
	public void shouldCreateArtist() {
		
		String username = "alreadyExistingUser";
		
		assertNull(artistService.findArtistByUsername(username));
		
		Artist artist = new Artist ();
		
		User existingUser = userService.getUserByUsername(username);
		
		artist.setName("Created Artist");
		artist.setUser(existingUser);
		artist.setPro(false);
		artist.setRole(Role.ACTOR);
		artist.setPhoto("http://photoUrl");
		artist.setDescription("description");
		artist.setSurName("surname");
		
		artistService.saveArtist(artist);
		
		Artist retrievedArtist = artistService.findArtistByUsername(username);
		
		assertEquals("Created Artist", retrievedArtist.getName());
		assertEquals(existingUser, retrievedArtist.getUser());
		assertEquals(false, retrievedArtist.getPro());
		assertEquals(Role.ACTOR, retrievedArtist.getRole());
		assertEquals("http://photoUrl", retrievedArtist.getPhoto());
		assertEquals("description", retrievedArtist.getDescription());
		assertEquals("surname", retrievedArtist.getSurName());
	}

	@Test
	public void shouldFindMyProjects(){
		Integer artistId = 20;
		List <Project> projects = artistService.findMyProjects(artistId);
		Project onlyProject = projects.get(0);
		
		assertEquals("Test Proyect", onlyProject.getTitle());
		assertEquals("Test Description", onlyProject.getDescription());
		
	}
	
	@Test
	public void shouldFindArtistById() {
		Integer id = 20;
		
		Artist retrievedArtist = artistService.findArtistById(id);
		
		assertEquals("existingUserName", retrievedArtist.getUser().getUsername());
		assertEquals("Existing User Name", retrievedArtist.getName());
		assertEquals("Surname 2", retrievedArtist.getSurName());
		assertEquals("https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png", retrievedArtist.getPhoto());
	}
	
	@Test
	public void shouldEditArtist() {
		Artist retrievedArtist = artistService.findArtistByUsername("existingUserName");
		
		assertEquals("Unedited Artist Description", retrievedArtist.getDescription());
		
		retrievedArtist.setDescription("Updated Artist Description");
		
		artistService.saveArtist(retrievedArtist);
		
		assertEquals("Updated Artist Description" ,artistService.findArtistByUsername("existingUserName").getDescription());
		
	}
	
	@Test
	public void shouldFindArtistByUsername() {
		String username = "existingUserName";
		
		Artist retrievedArtist = artistService.findArtistByUsername(username);
		
		assertEquals("existingUserName", retrievedArtist.getUser().getUsername());
		assertEquals("Existing User Name", retrievedArtist.getName());
		assertEquals("Surname 2", retrievedArtist.getSurName());
		assertEquals("https://i.pinimg.com/originals/51/f6/fb/51f6fb256629fc755b8870c801092942.png", retrievedArtist.getPhoto());
	}
	
	@WithMockUser(username="existingUserName",authorities={"artist"})
	@Test
	public void shouldGetPrincipal(){
		
		Artist currentArtist = artistService.getPrincipal();
		
		assertEquals(artistService.findArtistByUsername("existingUserName"), currentArtist);
		
	}
	
	@Test
	public void shouldGetCount() {
		assertEquals(9L, artistService.count());
	}
	
	@Test
	public void shouldFindMyUser() {
		Integer artistId = 20;
		
		User foundUser = artistService.findMyUser(artistId);
		
		assertEquals(userService.findUser("existingUserName").get(), foundUser);
	}
	
	@Test
	public void shouldGetLeftProjects() {
		Integer artistId = 22;
		
		assertEquals(25, artistService.leftProjects(artistId));
	}
	
	@Test
	public void shouldIncrementLeftProjects() {
		Integer artistId = 23;
		Integer addingAmount = (int) Math.rint(10);
		
		assertEquals(5, artistService.leftProjects(artistId));
		
		artistService.incrementLeftProjects(artistId, addingAmount);

		assertEquals(5+addingAmount, artistService.leftProjects(artistId));

	}
	@Test
	public void shouldMakePro() {
		Integer artistId = 24;
		
		//Artist beforePro = artistService.findArtistById(artistId);
		
		//assertFalse(beforePro.getPro());
		
		artistService.makePro(artistId);
		
		Artist afterPro = artistService.findArtistById(artistId);
		
		assertTrue(afterPro.getPro());
	}

}
