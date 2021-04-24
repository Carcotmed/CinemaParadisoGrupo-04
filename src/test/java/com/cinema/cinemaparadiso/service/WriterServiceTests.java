package com.cinema.cinemaparadiso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.service.exceptions.UserUniqueException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@Sql("/db/testing-data/writerServiceTests/testing-data.sql")
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WriterServiceTests {
	
	@Autowired
	WriterService writerService;

	@Test
	@Order(1)
	public void shouldList() {
		assertThat(writerService.list().size()).isEqualTo(2);
	}

	@Test
	@Order(2)
	public void shouldFindWriterById() {
		assertThat(writerService.findWriterById(1)).isEqualTo(new Writer(
    					new User("GradyManning",
    					"$2a$10$U9tzLPiS43F9SNtgGoYS5ekMLDj1BqxpcJNPeJrkvx59h1AWCFa",
    					"odio.a@musAeneaneget.co.uk")
    				,"Rebecca",
    				"Aficionado a la escritura desde que era pequeños",
    				1,"Bullock","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXLauXHp8NfrusbSPOfujsPJgxe6KIgQjiVw&usqp=CAU"));
	}

	@Test
	@Order(3)
	public void shouldBeUniqueUsername() {
    	assertTrue(writerService.isUniqueUsername("usernameInventado"));
	}

	@Test
	@Order(4)
	public void shouldCreateWriter() {
		Writer writer = new Writer(
				new User("UserNuevo",
				"$2a$10$U9tzLPiS43F9SNtgGoYS5ekMLDj1BqxpcJNPeJrkvx59h1AWCFa",
				"od.a@musAeneaneget.co.uk")
			,"Prueba",
			"Aficionado a la escritura desde que era pequeños",
			3,"Prueba","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXLauXHp8NfrusbSPOfujsPJgxe6KIgQjiVw&usqp=CAU");
		try {
			writerService.createWriter(writer);
			assertTrue(true);
		} catch (UserUniqueException e) {
			assertTrue(false);
		}
		assertThat(writerService.findWriterById(3)).isEqualTo(writer);
	}

	@Test
	@Order(5)
	public void shouldSaveWriter() {
		Writer writer = writerService.findWriterById(2);
    	assertThat(writer.getDescription()).isEqualTo("Aficionado a la escritura desde que era pequeños");
    	writer.setDescription("Descripcion de prueba para crear");
    	writerService.saveWriter(writer);
    	assertThat(writerService.findWriterById(2).getDescription()).isEqualTo("Descripcion de prueba para crear");
	}

	@Test
	@Order(6)
	public void shouldFindMyStories() {
		assertThat(writerService.findMyStories(1).size()).isEqualTo(5);
	}

	@Test
	@Order(7)
	@WithMockUser(username="GradyManning", authorities = {"writer"})
	public void shouldGetPrincipal() {
    	assertThat(writerService.getPrincipal()).isEqualTo(
    			new Writer(
    					new User("GradyManning",
    					"$2a$10$U9tzLPiS43F9SNtgGoYS5ekMLDj1BqxpcJNPeJrkvx59h1AWCFa",
    					"odio.a@musAeneaneget.co.uk")
    				,"Rebecca",
    				"Aficionado a la escritura desde que era pequeños",
    				1,"Bullock","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXLauXHp8NfrusbSPOfujsPJgxe6KIgQjiVw&usqp=CAU"));
    }

	@Test
	@Order(8)
	public void shouldEditWriter() {
	}

	@Test
	@Order(9)
	@WithMockUser(username="GradyManning", authorities = {"writer"})
	public void shouldBeActualWriter() {
    	assertThat(writerService.isActualWriter(1)).isTrue();
	}

	@Test
	@Order(10)
	public void shouldFindMyUser() {
    	assertThat(writerService.findMyUser(1)).isEqualTo(
    			new User("GradyManning",
    					"$2a$10$U9tzLPiS43F9SNtgGoYS5ekMLDj1BqxpcJNPeJrkvx59h1AWCFa",
    					"odio.a@musAeneaneget.co.uk"));
    }

	@Test
	@Order(11)
	public void shouldDeleteWriter() {
	}

	@Test
	@Order(12)
	public void shouldActivateWriter() {
    	assertThat(writerService.findWriterById(2).getUser().isEnabled()).isFalse();
    	writerService.activateWriter(2);
    	assertThat(writerService.findWriterById(2).getUser().isEnabled()).isTrue();
    }
}
