package com.cinema.cinemaparadiso.service;

import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.repository.PostRepository;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post findById(Integer id) throws NoSuchElementException{
        return postRepository.findById(id).get();
    }

    public Iterable<Post> list(){
        return postRepository.findAll();
    }

    public Post createUpdate(Post post) throws IllegalArgumentException{
        return postRepository.save(post);
    }

    public void delete(Post post) throws IllegalArgumentException{
        postRepository.delete(post);
    }
}
