package com.cinema.cinemaparadiso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_projects_artists;
import com.cinema.cinemaparadiso.model.Rel_projects_producers;
import com.cinema.cinemaparadiso.model.Rel_story_writers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@Sql("/db/testing-data/rel_projects_artistsServiceTests/testing-data.sql")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
public class Rel_projects_artistsServiceTests {
	
	@Autowired
	Rel_projects_artistsService rel_projects_artistsService;
	
	@Test
	@Order(1)
	public void shouldDelete() throws DataAccessException{
		Integer rel_projects_artistsId = 1;
		
		assertNotNull(rel_projects_artistsService.findById(rel_projects_artistsId));
		rel_projects_artistsService.delete(rel_projects_artistsId);
		assertThrows(NoSuchElementException.class,()->rel_projects_artistsService.findById(rel_projects_artistsId));
	}

	@Test
	@Order(2)
	public void shouldFindById() throws DataAccessException {
		Integer rel_projects_artistsId = 1;
		Rel_projects_artists rel = rel_projects_artistsService.findById(rel_projects_artistsId);
		assertEquals(1, rel.getArtist_id());
		assertEquals(2, rel.getProject_id());

	}
	
	@Test
	@Order(3)
	public void shouldFindRelation(){
		Integer artistId = 1;
		Integer projectId = 2;
		
		assertEquals(1, rel_projects_artistsService.findRelation(artistId, projectId).getId());
	}
	
	@Test
	@Order(4)
	public void shouldCount(){		
		assertEquals(2L, rel_projects_artistsService.count());
	}

	@Test
	@Order(5)
	public void shouldCountByProject() {
		Integer projectId = 2;
		assertEquals(1L, rel_projects_artistsService.count(projectId));
	}

	@Test
	@Transactional
	@Order(6)
	public void shouldDeleteByProjectId() {
		Integer projectId = 4;
		
		assertNotNull(rel_projects_artistsService.findById(2));
		rel_projects_artistsService.deleteByProjectId(projectId);
		assertThrows(NoSuchElementException.class, () -> rel_projects_artistsService.findById(2));
		
	}
	
	@Test
	@Order(7)
	public void shouldSave() {
		Rel_projects_artists rel = new Rel_projects_artists();
		rel.setArtist_id(1);
		rel.setProject_id(3);
		
		rel_projects_artistsService.save(rel);
		
		assertEquals(rel, rel_projects_artistsService.findRelation(1, 3));
	}
	
	@Test
	@Order(8)
	public void shouldCreate(){
		Rel_projects_artists rel = new Rel_projects_artists();
		rel.setArtist_id(1);
		rel.setProject_id(1);
		rel_projects_artistsService.create(rel);
		
		assertEquals(rel, rel_projects_artistsService.findRelation(1, 1));
	}

	
}
