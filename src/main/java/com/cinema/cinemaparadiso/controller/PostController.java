package com.cinema.cinemaparadiso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String create(Model model, Integer projectId, Post post){
    	try {
    		postService.createPost(post);
    		model.addAttribute("Estado", "Exito");
    	}catch (IllegalArgumentException e) {
    		model.addAttribute("Estado", "Error, entidad incorrecta");
		}
        log.info("Creating Posts..."+post.toString());
        return "posts/createPost";
    }
    
//  @GetMapping("/list")
//  public String list(Model model){
//      Iterable<Post> posts = postService.list();
//      model.addAttribute("posts", posts);
//      log.info("Listing Posts..."+posts.toString());
//      return "posts/listPost";
//  }
    
//    @GetMapping("/show/{postId}")
//    public String show(Model model, Integer postId){
//    	try {
//	        Post post = postService.findById(postId);
//	        model.addAttribute("post", post);
//	        log.info("Showing Post..."+post.toString());
//    	}catch (NoSuchElementException e) {
//	        log.error("Error Showing Post..."+postId.toString());
//		}
//        return "posts/showPost";
//    }

}
