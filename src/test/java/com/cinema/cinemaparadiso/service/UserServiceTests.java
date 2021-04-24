package com.cinema.cinemaparadiso.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;

@SpringBootTest
@Sql("/db/testing-data/userServiceTests/testing-data.sql")
@Transactional
public class UserServiceTests {

	@Autowired
	UserService userService;

	//Cuando se termine de hacer la funcionalidad y se concrete mejor el data
	//se descomenta estos comentarios 

	@Test
	public void shouldCountUsers() {
		
		//TODO CUANDO ACABE DE POPULAR TESTING DATA

		long count = userService.countUsers();
		assertThat(count).isEqualTo(12L);
	}
	
	@Test
	public void shouldGetUserByUsername() {
		
		String userName = "userToBeRetrieved";
		
		User userToRetrieve = userService.getUserByUsername(userName);
		
		assertEquals(userToRetrieve.getPassword(), "unhashed test password");
		assertEquals(userToRetrieve.getEmail(), "userToBeRetrieved@cinemaparadiso.com");

	}

	@Test
	public void shouldCreateUser() {
		
		String userName = "testUser";
		
		assertThrows(NoSuchElementException.class, () -> {userService.getUserByUsername(userName);});
		
		User user = new User();
		user.setUsername(userName);
		user.setPassword("testUser");
		user.setEmail("testUser@email.com");
		user.setEnabled(true);
		userService.createUser(user);
		
		User retrievedUser = userService.getUserByUsername(userName);
		
		assertNotNull(retrievedUser);
		assertEquals(retrievedUser.getUsername(), user.getUsername());
		assertEquals(retrievedUser.getPassword(), user.getPassword());
		assertEquals(retrievedUser.getEmail(), user.getEmail());
		
	}
	
	@Test
	public void shouldDeleteUser() {
		
		String userName = "userToBeDeleted";
		
		User userToDelete = userService.getUserByUsername(userName);
		
		userService.deleteUser(userToDelete);
		
		assertThrows(NoSuchElementException.class, () -> {userService.getUserByUsername(userName);});
		
	}

	@Test
	public void shouldListUsers() {
		Iterable<User> usersList = userService.list();
		Iterator<User> iterator = usersList.iterator();
		
		User user1 = iterator.next();
		User user2 = iterator.next();
				
		assertEquals(user1.getUsername(), "autoCreatedTestUser1");
		assertEquals(user2.getUsername(), "autoCreatedTestUser2");
	}

	@WithMockUser(username="testAdmin",authorities={"admin"})
	@Test
	public void shouldCheckIsAdmin() {
		assertTrue(userService.isAdmin());
	}
	
	@WithMockUser(username="testNormalUser",authorities={"artist"})
	@Test
	public void shouldCheckIsNotAdmin() {
		assertFalse(userService.isAdmin());
	}

	@Test
	public void shouldGetEnabledUsers() {
		
		List <User> allUsers = new ArrayList<User> ();
		userService.list().forEach(x -> allUsers.add(x));
		
		List <User> enabledUsers = userService.getEnabledUsers();
		
		assertEquals(allUsers.size(), enabledUsers.size() + 2);
		
		List <User> listDifference = new ArrayList<User> ();
		listDifference.addAll(allUsers);
		listDifference.removeAll(enabledUsers);
		
		assertEquals(2, listDifference.size());
		
		User disabledUser = listDifference.get(0);
		
		assertEquals("disabledUser", disabledUser.getUsername());
		
		User userToEnable = listDifference.get(1);
		
		assertEquals("userToEnable", userToEnable.getUsername());
		
	}
	/*

	@Test
	public void shouldChangePassword() throws NoSuchElementException, Exception {
		String userNameToChangePassword = "userToChangePassword";
		//Hashed "oldPassword"		
		
		String oldPassword = "oldPassword";
				
		String newPassword = "newPassword";
		
		userService.changePassword(userNameToChangePassword, oldPassword, newPassword);
		
		//Hashed "newPassword"
		String newHashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt(10));
		
		assertEquals(newHashedPassword, userService.getUserByUsername(userNameToChangePassword).getPassword());
		
	}
	*/

	@Test
	public void shouldEnableUser() {
		String userName = "userToEnable";
		assertFalse(userService.getUserByUsername(userName).isEnabled());
		userService.enableUser(userName);
		assertTrue(userService.getUserByUsername(userName).isEnabled());
	}

	@Test
	public void shouldDisableUser() {
		String userName = "userToDisable";
		assertTrue(userService.getUserByUsername(userName).isEnabled());
		userService.disableUser(userName);
		assertFalse(userService.getUserByUsername(userName).isEnabled());
	}

	@Test
	public void shouldFindArtistByUserUsername() {
		String userName = "testArtist";
		Artist retrievedArtist = userService.findArtistByUserUsername(userName).get();
		
		assertEquals("Test Artist Name", retrievedArtist.getName());
	}

	@Test
	public void shouldFindWriterByUserUsername() {
		String userName = "testWriter";
		Writer retrievedWriter = userService.findWriterByUserUsername(userName).get();
		
		assertEquals("Test Writer Name", retrievedWriter.getName());
	}

	@Test
	public void shouldFindProducerByUserUsername() {
		String userName = "testProducer";
		Producer retrievedProducer = userService.findProducerByUserUsername(userName).get();
		
		assertEquals("Test Producer Name", retrievedProducer.getName());
	}

	//IDUNO
	@WithMockUser(username="testPrincipal",authorities={"admin"})
	@Test
	public void shouldGetPrincipal() {
		String currentUserName = "testPrincipal";
		assertEquals(userService.getUserByUsername(currentUserName), userService.getPrincipal());
	}

}
