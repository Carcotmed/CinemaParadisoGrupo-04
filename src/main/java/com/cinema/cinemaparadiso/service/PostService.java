package com.cinema.cinemaparadiso.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.repository.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private ArtistService artistService;
    
    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private UserService userService;

    public Optional<Post> findById(Integer id){
        return postRepository.findById(id);
    }

    public List<Post> listPostOfProject(Integer projectId){
    	List<Post> posts = this.postRepository.listPostOfProject(projectId);
		//Ordenamos por fecha
		//posts.stream().sorted(Comparator.comparing(Post::getDate));
		return posts;
    }

    @Transactional
    public Post createPost(Post post, Integer projectId) throws IllegalArgumentException{
		String username = this.userService.getPrincipal().getUsername();
		Optional<Artist> optionalArtist = this.userService.findArtistByUserUsername(username);
    	Optional<Producer> optionalProducer = this.userService.findProducerByUserUsername(username);
    	if(optionalArtist.isPresent()) {
    		post.setArtist(optionalArtist.get());
    	}else {
    		post.setProducer(optionalProducer.get());
    	}
		post.setProject(this.projectService.findProjectById(projectId));
    	post.setDate(new Date());
        return postRepository.save(post);
    }

}
