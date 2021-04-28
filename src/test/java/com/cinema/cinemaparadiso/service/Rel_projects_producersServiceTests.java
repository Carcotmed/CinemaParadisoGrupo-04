package com.cinema.cinemaparadiso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_projects_producers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@Sql("/db/testing-data/rel_projects_producersServiceTests/testing-data.sql")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
public class Rel_projects_producersServiceTests {
	
	@Autowired
	Rel_projects_producersService rel_projects_producersService;
	
	@Test
	@Order(1)
	public void shouldDelete() throws DataAccessException{
		Integer rel_projects_producersId = 1;
		
		assertNotNull(rel_projects_producersService.findById(rel_projects_producersId));
		rel_projects_producersService.delete(rel_projects_producersId);
		assertThrows(NoSuchElementException.class,()->rel_projects_producersService.findById(rel_projects_producersId));
	}

	@Test
	@Order(2)
	public void shouldFindById() throws DataAccessException {
		Integer rel_projects_producersId = 1;
		Rel_projects_producers rel = rel_projects_producersService.findById(rel_projects_producersId);
		assertEquals(1, rel.getProducer_id());
		assertEquals(1, rel.getProject_id());

	}
	
	@Test
	@Order(3)
	public void shouldFindRelation(){
		Integer producerId = 2;
		Integer projectId = 1;
		
		assertEquals(2, rel_projects_producersService.findRelation(producerId, projectId).getId());
	}
	
	@Test
	@Order(4)
	public void shouldCount(){		
		assertEquals(2L, rel_projects_producersService.count());
	}

	@Test
	@Order(5)
	public void shouldCountByProject() {
		Integer projectId = 1;
		assertEquals(2L, rel_projects_producersService.count(projectId));
	}
	
	@Test
	@Order(6)
	public void shouldSave() {
		Rel_projects_producers rel = new Rel_projects_producers();
		rel.setProducer_id(1);
		rel.setProject_id(3);
		
		rel_projects_producersService.save(rel);
		
		assertEquals(rel, rel_projects_producersService.findRelation(1, 3));
	}
	
	@Test
	@Order(7)
	public void shouldCreate(){
		Rel_projects_producers rel = new Rel_projects_producers();
		rel.setProducer_id(3);
		rel.setProject_id(2);
		rel_projects_producersService.create(rel);
		
		assertEquals(rel, rel_projects_producersService.findRelation(3, 2));
	}

	@Test
	@Transactional
	@Order(8)
	public void shouldDeleteByProjectId() {
		Integer projectId = 1;
		rel_projects_producersService.deleteByProjectId(projectId);
		assertThrows(NoSuchElementException.class, () -> rel_projects_producersService.findById(2));
		
	}

	
}
