package com.cinema.cinemaparadiso.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cinema.cinemaparadiso.service.PostService;


@WebMvcTest(controllers = PostController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
classes = WebSecurityConfigurer.class),excludeAutoConfiguration= com.cinema.cinemaparadiso.configuration.SecurityConfiguration.class)
public class PostControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PostService postService;
    
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldInitCreatePosts() throws Exception {
    	BDDMockito.given(postService.pertenecesAlProyecto(1)).willReturn(true);
    	
		mockMvc.perform(get("/posts/create/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("post"))
                .andExpect(MockMvcResultMatchers.view().name("posts/createPostForm"));
    }
    
    @WithMockUser(username="admin",authorities= {"admin"})
	@Test
	void shouldProcessCreatePosts() throws Exception {
    	BDDMockito.given(postService.pertenecesAlProyecto(1)).willReturn(true);
    	
		mockMvc.perform(MockMvcRequestBuilders.post("/posts/create/1")
				.param("title", "title1").param("body", "bodyyyyyyy1").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/projects/show/1"));
    }
   
}
