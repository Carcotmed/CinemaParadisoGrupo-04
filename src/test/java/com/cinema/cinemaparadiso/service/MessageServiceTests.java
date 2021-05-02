package com.cinema.cinemaparadiso.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	public ProjectService projectService;

	@Autowired
	public UserService userService;

	@Autowired
	public Rel_projects_storyService rel_projects_storyService;

	@Autowired
	public Rel_projects_artistsService rel_projects_artistsService;

	@Autowired
	public Rel_projects_producersService rel_projects_producersService;

	@Test
	public void findByIdTest() {

		Integer messageId = 1;
		Message retrievedMessage = messageService.findById(messageId);
		assertEquals("Test Body 1", retrievedMessage.getBody());
		assertEquals("autoCreatedTestUser3", retrievedMessage.getEmisor().getUsername());
		assertEquals("autoCreatedTestUser4", retrievedMessage.getReceptor().getUsername());
		assertEquals("Test Issue 1", retrievedMessage.getIssue());

	}

	@Test
	public void findByEmisorUsernameTest() {

		String username = "autoCreatedTestUser3";
		List<Message> retrievedMessages = new ArrayList<>();
		messageService.findByEmisorUsername(username).forEach(x -> retrievedMessages.add(x));

		assertEquals(2, retrievedMessages.size());
		Message message1 = retrievedMessages.get(0);
		Message message2 = retrievedMessages.get(1);

		assertEquals("Test Body 1", message1.getBody());
		assertEquals("autoCreatedTestUser3", message1.getEmisor().getUsername());
		assertEquals("autoCreatedTestUser4", message1.getReceptor().getUsername());
		assertEquals("Test Issue 1", message1.getIssue());

		assertEquals("Test Body 2", message2.getBody());
		assertEquals("autoCreatedTestUser3", message2.getEmisor().getUsername());
		assertEquals("autoCreatedTestUser4", message2.getReceptor().getUsername());
		assertEquals("Test Issue 2", message2.getIssue());

	}

	@Test
	public void findByReceptorUsernameTest() {

		String username = "autoCreatedTestUser4";
		List<Message> retrievedMessages = new ArrayList<>();
		messageService.findByReceptorUsername(username).forEach(x -> retrievedMessages.add(x));

		assertEquals(2, retrievedMessages.size());
		Message message1 = retrievedMessages.get(0);
		Message message2 = retrievedMessages.get(1);

		assertEquals("Test Body 1", message1.getBody());
		assertEquals("autoCreatedTestUser3", message1.getEmisor().getUsername());
		assertEquals("autoCreatedTestUser4", message1.getReceptor().getUsername());
		assertEquals("Test Issue 1", message1.getIssue());

		assertEquals("Test Body 2", message2.getBody());
		assertEquals("autoCreatedTestUser3", message2.getEmisor().getUsername());
		assertEquals("autoCreatedTestUser4", message2.getReceptor().getUsername());
		assertEquals("Test Issue 2", message2.getIssue());

	}

	@Test
	public void createTest() {
		User user1 = userService.getUserByUsername("autoCreatedTestUser1");
		User user2 = userService.getUserByUsername("autoCreatedTestUser2");

		Message message = new Message("Created Test Issue", "Created Test Body", Date.from(Instant.now()), user2,
				user1);

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
	public void requestAlreadyExistArtistTestTrue() {
		Integer projectId = 1;
		Integer artistId = 2;

		assertTrue(messageService.requestAlreadyExistArtist(projectId, artistId));
	}

	@Test
	public void requestAlreadyExistArtistTestFalse() {
		Integer projectId = 1;
		Integer artistId = 1;

		assertFalse(messageService.requestAlreadyExistArtist(projectId, artistId));
	}

	@Test
	public void requestAlreadyExistProducerTrue() {

		Integer projectId = 1;
		Integer producerId = 1;

		assertTrue(messageService.requestAlreadyExistProducer(projectId, producerId));
	}

	@Test
	public void requestAlreadyExistProducerFalse() {

		Integer projectId = 2;
		Integer producerId = 1;

		assertFalse(messageService.requestAlreadyExistProducer(projectId, producerId));
	}

	@Test
	public void requestToEnterProjectArtist() {
		Integer projectId = 2;
		Integer artistId = 2;

		List<Message> sentMessages = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser2").forEach(x -> sentMessages.add(x));
		assertNotEquals("Me gustaría entrar en su proyecto llamado Producciones Sevilla 2. Mi rol es CAMARA.",
				sentMessages.get(sentMessages.size() - 1).getBody());

		messageService.requestToEnterProjectArtist(projectId, artistId);

		List<Message> sentMessagesUpdated = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser2").forEach(x -> sentMessagesUpdated.add(x));
		assertEquals("Me gustaría entrar en su proyecto llamado Producciones Sevilla 2. Mi rol es CAMARA.",
				sentMessagesUpdated.get(sentMessagesUpdated.size() - 1).getBody());

	}

	@Test
	public void requestToEnterProjectStory() {
		Integer projectId = 1;
		Integer storyId = 1;
		String expectedMessageBody = "Me gustaría usar su historia en mi proyecto Producciones Sevilla.";

		List<Message> sentMessages = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser2").forEach(x -> sentMessages.add(x));
		assertNotEquals(expectedMessageBody, sentMessages.get(sentMessages.size() - 1).getBody());

		messageService.requestToEnterProjectStory(projectId, storyId);

		List<Message> sentMessagesUpdated = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser2").forEach(x -> sentMessagesUpdated.add(x));
		assertEquals(expectedMessageBody, sentMessagesUpdated.get(sentMessagesUpdated.size() - 1).getBody());

	}

	@Test
	public void requestToEnterProjectProducerTest() {
		Integer projectId = 2;
		Integer producerId = 2;
		String expectedMessageBody = "Me gustaría entrar en su proyecto llamado Producciones Sevilla 2. Mi rol es Productor.";

		List<Message> sentMessages = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser3").forEach(x -> sentMessages.add(x));
		assertNotEquals(expectedMessageBody, sentMessages.get(sentMessages.size() - 1).getBody());

		messageService.requestToEnterProjectProducer(projectId, producerId);

		List<Message> sentMessagesUpdated = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser3").forEach(x -> sentMessagesUpdated.add(x));
		assertEquals(expectedMessageBody, sentMessagesUpdated.get(sentMessagesUpdated.size() - 1).getBody());

	}

	@Test
	public void acceptRequestStoryTest() {
		Integer messageId = 6;
		Integer projectId = 1;
		Integer storyId = 1;

		// assertThrows(NoSuchElementException.class, () ->
		// rel_projects_storyService.findByProjectId(projectId));
		// NO DEBERÍA SER ASÍ, EL METODO findByProjectId EN VEZ DE DEVOLVER UNA LISTA Y
		// HACER GET 0, LA QUERY DEBERÍA DEVOLVER UN SOLO ELEMENTO
		assertThrows(IndexOutOfBoundsException.class, () -> rel_projects_storyService.findByProjectId(projectId));

		messageService.acceptRequestStory(messageId);

		assertNotNull(rel_projects_storyService.findByProjectId(projectId));
		assertEquals(storyId, rel_projects_storyService.findByProjectId(projectId).getStory_id());
		assertEquals(projectId, rel_projects_storyService.findByProjectId(projectId).getProject_id());
	}

	@Test
	public void rejectRequestStory() {
		Integer messageId = 6;
		String expectedMessageBody = "El admin de Producciones Sevilla ha rechazado su solicitud.";

		List<Message> sentMessages = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser2").forEach(x -> sentMessages.add(x));
		assertNotEquals(expectedMessageBody, sentMessages.get(sentMessages.size() - 1).getBody());

		messageService.rejectRequestArtist(messageId);

		List<Message> sentMessagesUpdated = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser2").forEach(x -> sentMessagesUpdated.add(x));
		assertEquals(expectedMessageBody, sentMessagesUpdated.get(sentMessagesUpdated.size() - 1).getBody());
	}

	@Test
	public void acceptRequestArtistTest() {
		Integer messageId = 7;
		Integer projectId = 1;
		Integer artistId = 3;

		assertNull(rel_projects_artistsService.findRelation(artistId, projectId));

		messageService.acceptRequestArtist(messageId);

		assertNotNull(rel_projects_artistsService.findRelation(artistId, projectId));

	}

	@Test
	public void rejectRequestArtistTest() {
		Integer messageId = 7;
		String expectedMessageBody = "El admin de Producciones Sevilla ha rechazado su solicitud.";

		List<Message> sentMessages = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser2").forEach(x -> sentMessages.add(x));
		assertNotEquals(expectedMessageBody, sentMessages.get(sentMessages.size() - 1).getBody());

		messageService.rejectRequestArtist(messageId);

		List<Message> sentMessagesUpdated = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser2").forEach(x -> sentMessagesUpdated.add(x));
		assertEquals(expectedMessageBody, sentMessagesUpdated.get(sentMessagesUpdated.size() - 1).getBody());

	}

	@Test
	public void acceptRequestProducerTest() {
		Integer messageId = 8;
		Integer projectId = 1;
		Integer producerId = 3;

		assertNull(rel_projects_producersService.findRelation(producerId, projectId));

		messageService.acceptRequestProducer(messageId);

		assertNotNull(rel_projects_producersService.findRelation(producerId, projectId));

	}

	@Test
	public void rejectRequestProducerTest() {
		Integer messageId = 8;
		String expectedMessageBody = "El admin de Producciones Sevilla ha rechazado su solicitud.";

		List<Message> sentMessages = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser2").forEach(x -> sentMessages.add(x));
		assertNotEquals(expectedMessageBody, sentMessages.get(sentMessages.size() - 1).getBody());

		messageService.rejectRequestProducer(messageId);

		List<Message> sentMessagesUpdated = new ArrayList<>();
		messageService.findByEmisorUsername("autoCreatedTestUser2").forEach(x -> sentMessagesUpdated.add(x));
		assertEquals(expectedMessageBody, sentMessagesUpdated.get(sentMessagesUpdated.size() - 1).getBody());

	}

	@Test
	public void findAllReceivedMessagesTest() {
		String username = "userWithMessages2";
		List <Message> messages = messageService.findAllReceivedMessages(username);
		
		
		assertEquals(2, messages.size());
		assertEquals("Test Created Body 1", messages.get(0).getBody());
		assertEquals("Test Created Body 2", messages.get(1).getBody());
	}

	@Test
	public void findAllSentsMessagesTest() {
		String username = "userWithMessages1";
		List <Message> messages = messageService.findAllSentsMessages(username);
		
		
		assertEquals(2, messages.size());
		assertEquals("Test Created Body 1", messages.get(0).getBody());
		assertEquals("Test Created Body 2", messages.get(1).getBody());
	}

	@Test
	public void deleteAllByStoryIdTest() {
		Integer storyId = 2;
		Integer messageId1 = 11;
		Integer messageId2 = 12;
		
		//assertNotNull(messageService.findById(messageId1));
		//assertNotNull(messageService.findById(messageId2));

		//assertEquals(storyId, messageService.findById(messageId1).getStory().getId());
		//assertEquals(storyId, messageService.findById(messageId2).getStory().getId());

		messageService.deleteAllByStoryId(storyId);
		
		assertThrows(NoSuchElementException.class, () -> messageService.findById(messageId1));
		assertThrows(NoSuchElementException.class, () -> messageService.findById(messageId2));
		
	}

	@Test
	public void checkMessageTest() {
		String username = "userWithMessages4";
		
		assertTrue(messageService.checkMessage(username));
	}

	@Test
	public void checkSeenTest() {
		Integer messageId = 12;
		
		//assertFalse(messageService.findById(messageId).isSeen());
		
		messageService.checkSeen(messageId);
		
		assertTrue(messageService.findById(messageId).isSeen());
		
	}

}
