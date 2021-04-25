package com.cinema.cinemaparadiso.service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		List<Post> postsOrdenadosFecha = posts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
		return postsOrdenadosFecha;
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
    
    public Boolean pertenecesAlProyecto (Integer projectId) {
		String username = this.userService.getPrincipal().getUsername();
    	Optional<Artist> optionalArtist = this.userService.findArtistByUserUsername(username);
    	Optional<Producer> optionalProducer = this.userService.findProducerByUserUsername(username);
    	Boolean res = false;
    	List<String> membersUsernames = this.projectService.findAllMembersUsername(projectId);
    	
    	if(optionalArtist.isPresent()) {
    		res = membersUsernames.contains(optionalArtist.get().getUser().getUsername());
    		
    	}else {
    		res = membersUsernames.contains(optionalProducer.get().getUser().getUsername());
    		
    	}
		
    	return res;
    }

}
