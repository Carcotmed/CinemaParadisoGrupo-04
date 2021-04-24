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
		Artist pro1 = proList.get(0);
		assertEquals("Pro User 1", pro1.getName());
		
		Artist pro2 = proList.get(1);
		assertEquals("Pro User 2", pro2.getName());
		
		//assertEquals(2L, proList.size());
	}
	
	@Test
	public void shouldListNoProArtist() {
		
		List <Artist> noProList = this.artistService.listNoProArtist();
		Artist noPro1 = noProList.get(0);
		assertEquals("No Pro User 1", noPro1.getName());
		
		Artist noPro2 = noProList.get(1);
		assertEquals("No Pro User 2", noPro2.getName());
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
		Artist artist;
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
	
	@Test
	public void shouldGetPrincipal(){
		
	}
	
	@Test
	public void shouldGetPrincipalArtist() {
		
	}
	
	@Test
	public void shouldGetCount() {
		
	}
	
	@Test
	public void checkIfIsActualArtist() {
		Integer artistId;
	}
	
	@Test
	public void shouldFindMyUser() {
		Integer artistId;
	}
	
	@Test
	public void shouldDeleteArtist() {
		Integer artistId;
	}
	
	@Test
	public void shouldActivateArtist() {
		Integer artistId;
	}
	
	@Test
	public void shouldGetLeftProjects() {
		Integer artistId;
	}
	
	@Test
	public void shouldIncrementLeftProjects() {
		Integer artistID;
		Integer addingAmount;
	}
	@Test
	public void shouldMakePro() {
		Integer artistID;
	}

}
