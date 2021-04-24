package com.cinema.cinemaparadiso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_projects_artists;
import com.cinema.cinemaparadiso.model.Rel_projects_producers;
import com.cinema.cinemaparadiso.model.Rel_projects_story;
import com.cinema.cinemaparadiso.model.Rel_story_writers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@Sql("/db/testing-data/rel_projects_storyServiceTests/testing-data.sql")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
public class Rel_projects_storyServiceTests {
	
	@Autowired
	Rel_projects_storyService rel_projects_storyService;
	
	@Test
	@Order(1)
	public void shouldDelete() throws DataAccessException{
		Integer rel_projects_storyId = 1;
		
		assertNotNull(rel_projects_storyService.findById(rel_projects_storyId));
		rel_projects_storyService.delete(rel_projects_storyId);
		assertThrows(NoSuchElementException.class,()->rel_projects_storyService.findById(rel_projects_storyId));
	}

	@Test
	@Order(2)
	public void shouldFindById() throws DataAccessException {
		Integer rel_projects_storyId = 2;
		Rel_projects_story rel = rel_projects_storyService.findById(rel_projects_storyId);
		assertEquals(2, rel.getStory_id());
		assertEquals(2, rel.getProject_id());

	}
	
	@Test
	@Order(3)
	public void shouldFindByProjectId() throws DataAccessException {
		Integer projectId = 2;
		Rel_projects_story rel = rel_projects_storyService.findByProjectId(projectId);
		assertEquals(2, rel.getStory_id());
		assertEquals(2, rel.getProject_id());

	}
	
	@Test
	@Order(4)
	public void shouldindRelation(){
		Integer storyId = 2;
		Integer projectId = 2;
		
		assertEquals(2, rel_projects_storyService.findRelation(storyId, projectId).getId());
	}
	
	@Test
	@Order(5)
	public void shouldCount(){		
		assertEquals(4L, rel_projects_storyService.count());
	}

	@Test
	@Order(6)
	public void shouldCountByProjectId() {
		Integer projectId = 2;
		assertEquals(1, rel_projects_storyService.countByProjectId(projectId));
	}

	@Test
	@Order(7)
	public void shouldDeleteByProjectId() {
		Integer projectId = 3;
		assertNotNull(rel_projects_storyService.findById(2));
		rel_projects_storyService.deleteByProjectId(projectId);
		assertThrows(NoSuchElementException.class,()->rel_projects_storyService.findById(3));
	}
	
	@Test
	@Order(8)
	public void shouldDeleteByStoryId() {
		Integer storyId = 3;
		assertNotNull(rel_projects_storyService.findById(2));
		rel_projects_storyService.deleteByStoryId(storyId);
		assertThrows(NoSuchElementException.class,()->rel_projects_storyService.findById(4));
	}
	
	@Test
	@Order(9)
	public void shouldSave() {
		Rel_projects_story rel = new Rel_projects_story();
		rel.setStory_id(2);
		rel.setProject_id(3);
		
		rel_projects_storyService.save(rel);
		
		assertEquals(rel, rel_projects_storyService.findRelation(2, 3));
	}
	
	@Test
	@Order(10)
	public void shouldCreate(){
		Rel_projects_story rel = new Rel_projects_story();
		rel.setStory_id(1);
		rel.setProject_id(2);
		rel_projects_storyService.create(rel);
		
		assertEquals(rel, rel_projects_storyService.findRelation(1, 2));
	}
	
}
