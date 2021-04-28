package com.cinema.cinemaparadiso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.Rel_projects_artists;
import com.cinema.cinemaparadiso.model.Rel_projects_producers;
import com.cinema.cinemaparadiso.service.exceptions.ProjectLimitException;
import com.cinema.cinemaparadiso.service.exceptions.UserUniqueException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


@SpringBootTest
@Sql("/db/testing-data/postServiceTests/testing-data.sql")
@Transactional
public class PostServiceTests {
	
	@Autowired
	PostService postService;
	
	@Autowired
	ArtistService artistService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	UserService userService;

    @Test
    @Order(1)
    public void shouldListByProjectId(){
		assertThat(postService.listPostOfProject(1).size()).isEqualTo(3);
    }

    @Test
    @Order(2)
    @WithMockUser(username="artistUser1",authorities={"artist"})
    public void shouldCreate(){
    	Post post = new Post("Title", "Bodyyy", "2021/04/28 19:00", artistService.findArtistById(1), null, projectService.findProjectById(1), "artistUser1");
    	try {
			postService.createPost(post, 1);
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			assertTrue(false);
		}
    	assertTrue(postService.listPostOfProject(1).contains(post));
    }

    @Test
    @Order(3)
    @WithMockUser(username="artistUser1",authorities={"artist"})
    public void shouldPerteneAlProyecto(){
    	assertTrue(postService.pertenecesAlProyecto(1));
    }
}
