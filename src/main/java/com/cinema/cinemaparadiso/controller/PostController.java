package com.cinema.cinemaparadiso.controller;

import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.service.PostService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
@Slf4j
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/find")
    public String list(Model model, Integer id){
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        log.info("Showing Post..."+post.toString());
        return "posts/showPost";
    }

    @GetMapping("/list")
    public String list(Model model){
        Iterable<Post> posts = postService.list();
        model.addAttribute("posts", posts);
        log.info("Listing Posts..."+posts.toString());
        return "posts/listPost";
    }

    @GetMapping("/create")
    public String create(Model model, Post post){
    	try {
    		postService.createUpdate(post);
    		model.addAttribute("Estado", "Exito");
    	}catch (IllegalArgumentException e) {
    		model.addAttribute("Estado", "Error, entidad incorrecta");
		}
        log.info("Creating Posts..."+post.toString());
        return "posts/createPost";
    }

    @GetMapping("/update")
    public String update(Model model, Post post){
    	try {
    		postService.createUpdate(post);
    		model.addAttribute("Estado", "Exito");
    	}catch (IllegalArgumentException e) {
    		model.addAttribute("Estado", "Error, entidad incorrecta");
		}
        log.info("Updating Posts..."+post.toString());
        return "posts/updatePost";
    }

    @GetMapping("/delete")
    public String delete(Model model, Post post){
    	try {
    		postService.delete(post);
    		model.addAttribute("Estado", "Exito");
    	}catch (IllegalArgumentException e) {
    		model.addAttribute("Estado", "Error, entidad incorrecta");
		}
        log.info("Deleting Posts..."+post.toString());
        return "posts/deletePost";
    }
}
