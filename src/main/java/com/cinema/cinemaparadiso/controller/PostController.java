package com.cinema.cinemaparadiso.controller;

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
import com.cinema.cinemaparadiso.service.ArtistService;
import com.cinema.cinemaparadiso.service.PostService;
import com.cinema.cinemaparadiso.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/posts")
@Slf4j
public class PostController {

    @Autowired
    private PostService postService;
    
    @Autowired
    private ArtistService artistService;
    
    @Autowired
    private ProjectService projectService;
    
    @GetMapping("/create/{projectId}")
	public String initFormCreatePost(Model model,@PathVariable("projectId") Integer projectId) {
    	//Comprobamos que la persona que accede pertenece al project
		Post post = new Post();
		post.setArtist(this.artistService.getPrincipal());
		post.setProject(this.projectService.findProjectById(projectId));
		model.addAttribute("post", post);
		return "posts/createPostForm";
	}

	@PostMapping("/create/{projectId}")
	public String createPost(@ModelAttribute("post") @Valid Post post,@PathVariable("projectId") Integer projectId
			, BindingResult result, Model model){

		if(!result.hasErrors()) {
			this.postService.createPost(post);
		}else {
			return "posts/createPostForm";
		}
		return "redirect:/projects/show/"+projectId;
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
