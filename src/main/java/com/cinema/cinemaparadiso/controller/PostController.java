package com.cinema.cinemaparadiso.controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/posts")
@Slf4j
public class PostController {

    @Autowired
    private PostService postService;
    

    
    @GetMapping("/create/{projectId}")
	public String initFormCreatePost(Model model,@PathVariable("projectId") Integer projectId) {
    	//Comprobamos que la persona que accede pertenece al project
    	
    	try{
    		this.postService.pertenecesAlProyecto(projectId);
    		}
    	catch(NoSuchElementException ex) {
    		return "error/error-403";
    	}
		Post post = new Post();
		
		model.addAttribute("post", post);
		return "posts/createPostForm";
	}

	@PostMapping("/create/{projectId}")
	public String createPost(@PathVariable("projectId") Integer projectId,@ModelAttribute("post") @Valid Post post,BindingResult result, Model model){
	
		if(!result.hasErrors()) {
			this.postService.createPost(post, projectId);
		}else {
			return "posts/createPostForm";
		}
		return "redirect:/projects/show/"+projectId;
	}
    


}
