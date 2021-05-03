package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Integer>{
	
	@Query("SELECT post FROM Post post WHERE post.project.id = :projectId")
	public List<Post> listPostOfProject(@Param("projectId") Integer projectId);
    
	@Query("SELECT post FROM Post post WHERE post.username = :username")
	public List<Post> listPostOfAnUser(@Param("username") String username);
}
