package com.cinema.cinemaparadiso.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Message;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.Rel_projects_story;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;

@SpringBootTest
@Sql("/db/testing-data/messageServiceTests/testing-data.sql")
@Transactional
public class MessageServiceTests {

	@Autowired
	public MessageService messageService;

	@Autowired
	public UserService userService;

	@Test
	public void findByIdTest() {

		Integer messageId = 1;
		Message retrievedMessage = messageService.findById(messageId);
		assertEquals("Test Body 1", retrievedMessage.getBody());
		assertEquals("autoCreatedTestUser1", retrievedMessage.getEmisor().getUsername());
		assertEquals("autoCreatedTestUser2", retrievedMessage.getReceptor().getUsername());
		assertEquals("Test Issue 1", retrievedMessage.getIssue());

	}

	@Test
	public void findByEmisorUsernameTest() {

		String username = "autoCreatedTestUser1";
		List<Message> retrievedMessages = new ArrayList<>();
		messageService.findByEmisorUsername(username).forEach(x -> retrievedMessages.add(x));

		assertEquals(2, retrievedMessages.size());
		Message message1 = retrievedMessages.get(0);
		Message message2 = retrievedMessages.get(1);

		assertEquals("Test Body 1", message1.getBody());
		assertEquals("autoCreatedTestUser1", message1.getEmisor().getUsername());
		assertEquals("autoCreatedTestUser2", message1.getReceptor().getUsername());
		assertEquals("Test Issue 1", message1.getIssue());

		assertEquals("Test Body 2", message2.getBody());
		assertEquals("autoCreatedTestUser1", message2.getEmisor().getUsername());
		assertEquals("autoCreatedTestUser2", message2.getReceptor().getUsername());
		assertEquals("Test Issue 2", message2.getIssue());

	}

	@Test
	public void findByReceptorUsernameTest() {

		String username = "autoCreatedTestUser2";
		List<Message> retrievedMessages = new ArrayList<>();
		messageService.findByReceptorUsername(username).forEach(x -> retrievedMessages.add(x));

		assertEquals(2, retrievedMessages.size());
		Message message1 = retrievedMessages.get(0);
		Message message2 = retrievedMessages.get(1);

		assertEquals("Test Body 1", message1.getBody());
		assertEquals("autoCreatedTestUser1", message1.getEmisor().getUsername());
		assertEquals("autoCreatedTestUser2", message1.getReceptor().getUsername());
		assertEquals("Test Issue 1", message1.getIssue());

		assertEquals("Test Body 2", message2.getBody());
		assertEquals("autoCreatedTestUser1", message2.getEmisor().getUsername());
		assertEquals("autoCreatedTestUser2", message2.getReceptor().getUsername());
		assertEquals("Test Issue 2", message2.getIssue());

	}

	@Test
	public void createTest(){
		User user1 = userService.getUserByUsername("autoCreatedTestUser1");
		User user2 = userService.getUserByUsername("autoCreatedTestUser2");

		Message message = new Message("Created Test Issue", "Created Test Body", Date.from(Instant.now()), user2, user1);
		
		messageService.create(message);
		Integer messageId = message.getId();
		
		Message retrievedMessage = messageService.findById(messageId);
		
		assertNotNull(retrievedMessage);
		assertEquals("Created Test Body", retrievedMessage.getBody());
		assertEquals(user2.getUsername(), retrievedMessage.getEmisor().getUsername());
		assertEquals(user1.getUsername(), retrievedMessage.getReceptor().getUsername());
		assertEquals("Created Test Issue", retrievedMessage.getIssue());
	}

	@Test
	public void deleteTest() {
		Integer messageId = 3;
		Message messageToDelete = messageService.findById(messageId);
		
		assertNotNull(messageToDelete);
		messageService.delete(messageToDelete);
		assertThrows(NoSuchElementException.class, () -> messageService.findById(messageId));
	}

	@Test
	public void requestAlreadyExistArtist() {
		Integer projectId = 1;
		Integer artistId = 1;
		
		
	}

//	@Test
//	public void requestToEnterProjectArtist(Integer projectId, Integer artistId) {
//	}
//
//	@Test
//	public void requestAlreadyExistProducer(Integer projectId, Integer producerId) {
//	}
//
//	@Test
//	public void requestToEnterProjectStory(Integer projectId, Integer storyId) {
//	}
//
//	@Test
//	public void requestToEnterProjectProducer(Integer projectId, Integer producerId) {
//	}
//
//	@Test
//	public void acceptRequestStory(Integer messageId) {
//	}
//
//	@Test
//	public void acceptRequestArtist(Integer messageId) {
//	}
//
//	@Test
//	public void acceptRequestProducer(Integer messageId) {
//	}
//
//	@Test
//	public void rejectRequestArtist(Integer messageId) {
//	}
//
//	@Test
//	public void rejectRequestStory(Integer messageId) {
//	}
//
//	@Test
//	public void rejectRequestProducer(Integer messageId) {
//	}
//
//	@Test
//	public void findAllReceivedMessages(String username) {
//	}
//
//	@Test
//	public void findAllSentsMessages(String username) {
//	}
//
//	@Test
//	public void deleteAllByStoryId(Integer storyId) {
//	}
//
//	@Test
//	public void checkMessage(String username) {
//	}
//
//	@Test
//	public void checkSeen(Integer messageId) {
//	}

}
