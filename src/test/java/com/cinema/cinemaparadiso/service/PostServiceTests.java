package com.cinema.cinemaparadiso.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Post;


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
