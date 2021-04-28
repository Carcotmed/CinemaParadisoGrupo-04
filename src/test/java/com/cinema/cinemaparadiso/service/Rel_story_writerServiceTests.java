package com.cinema.cinemaparadiso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_story_writers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@Sql("/db/testing-data/rel_story_writerServiceTests/testing-data.sql")
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Rel_story_writerServiceTests {
	
	@Autowired
	Rel_story_writersService rel_story_writerService;

	@Test
	@Order(1)
	public void shouldCreate() {
		Rel_story_writers rel = new Rel_story_writers(10, 9, 2);
		rel_story_writerService.create(rel);
		assertThat(rel_story_writerService.findById(10)).isEqualTo(rel);
	}

	@Test
	@Order(2)
	public void shouldSave() {
		Rel_story_writers rel = rel_story_writerService.findById(1);
		rel.setWriter_id(2);
		rel_story_writerService.save(rel);
		assertThat(rel_story_writerService.findById(1)).isEqualTo(rel);
	}

	@Test
	@Order(3)
	public void shouldDelete() {
		rel_story_writerService.delete(2);
		try {
			rel_story_writerService.findById(2);
			assertTrue(false);
		}catch (NoSuchElementException e) {
			assertTrue(true);
		}
	}

	@Test
	@Order(4)
	public void shouldFindById() {
		assertThat(rel_story_writerService.findById(3)).isEqualTo(new Rel_story_writers(3,3,1));
	}

	@Test
	@Order(5)
	public void shouldFindRelation() {
		try {
			rel_story_writerService.findRelation(1, 3);
			assertTrue(true);
		}catch (NoSuchElementException e) {
			assertTrue(false);
		}
	}

	@Test
	@Order(6)
	public void shouldCount() {
		assertThat(rel_story_writerService.count()).isEqualTo(8);
	}

	@Test
	@Order(7)
	public void shouldDeleteByStoryId() {
		rel_story_writerService.deleteByStoryId(4);
		try {
			rel_story_writerService.findById(4);
			assertTrue(false);
		}catch (NoSuchElementException e) {
			assertTrue(true);
		}
	}
}
