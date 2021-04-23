package com.cinema.cinemaparadiso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.repository.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

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
    public Post createPost(Post post) throws IllegalArgumentException{
        return postRepository.save(post);
    }

}
