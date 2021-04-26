package com.cinema.cinemaparadiso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Story;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@Sql("/db/testing-data/storyServiceTests/testing-data.sql")
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoryServiceTests {
	
	@Autowired
	StoryService storyService;

	@Test
	@Order(1)
	public void shouldEditStory(){
		Story story = this.storyService.findStoryById(1);
		assertThat(story.getBody()).isEqualTo("En esta historia el protagonista decide abandonar su hogar y explorar el mundo");
		story.setBody("Este es un body recien editado para pruebas");
		storyService.editStory(story);
		assertThat(story.getBody()).isEqualTo("Este es un body recien editado para pruebas");
	}

	@Test
	@Order(2)
	@WithMockUser(username = "GradyManning", authorities = {"writer"})
	public void shouldCreateStory(){
		Story story = new Story(9, "Titulo de prueba", "Body de prueba para objeto recien creado", Genre.ACCION, 1000, "https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE=");
		storyService.createStory(story);
		assertThat(storyService.findStoryById(9)).isEqualTo(story);
	}

	@Test
	@Order(3)
	public void shouldSaveStory(){
		Story story = storyService.findStoryById(1);
		assertThat(story.getTitle()).isEqualTo("The Fault in Our Stars");
		story.setTitle("Titulo de prueba para guardar");
		storyService.saveStory(story);
		assertThat(storyService.findStoryById(1).getTitle()).isEqualTo("Titulo de prueba para guardar");
		
	}
	
	/*@Test
	@Order(4)
	public void shouldFindMyWriter() {
		assertThat(storyService.findMyWriter(6)).isEqualTo(new Writer(
				new User("KyleConway",
				"$2y$10$Q4zXt8COaMdM07hnNRu4n.084uQMoCOHFV9pAn/fcHzksA/eolnFe",
				"non@enim.net"),
			"Libby",
			"Aficionado a la escritura desde que era pequeños",
			2,"Vaughan","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXLauXHp8NfrusbSPOfujsPJgxe6KIgQjiVw&usqp=CAU"));
	}*/

	@Test
	@Order(5)
	public void shouldList() {
		assertThat(storyService.list().size()).isEqualTo(8);
	}

	@Test
	@Order(6)
	public void shouldFindStoryById(){
		assertThat(storyService.findStoryById(2)).isEqualTo(new Story(2, "Gone Girl", "En esta historia el protagonista decide abandonar su hogar y explorar el mundo", Genre.ACCION, 1000, "https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE="));
	}

	/*@Test
	@Order(7)
	@WithMockUser(username = "GradyManning", authorities = {"writer"})
	public void shouldBeMyWriter() {
		assertThat(storyService.isMyWriter(2)).isTrue();
	}*/

	@Test
	@Order(8)
	public void shouldDeleteStory() {
		storyService.deleteStory(4);
		try {
			storyService.findStoryById(4);
			assertThat(true).isFalse();
		}catch(NoSuchElementException e) {
			assertThat(true).isTrue();
		}
	}
/*
	@Test
	@Order(9)
	public void shouldMakeStorySponsored() {
		assertFalse(storyService.findStoryById(2).getIsSponsored());
		storyService.makeStorySponsored(2);
		assertTrue(storyService.findStoryById(2).getIsSponsored());
	}*/

	@Test
	@Order(10)
	public void shouldFindAllSponsoredStories() {
		assertThat(storyService.findAllSponsoredStories().size()).isEqualTo(4);
	}
}
