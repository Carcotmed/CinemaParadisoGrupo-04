package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Comment;
import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.model.Story;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Integer>{

	@Query("SELECT comment from Comment comment WHERE comment.masterComment = null ORDER BY comment.date DESC")
	public List<Comment> findMasterComments();

	@Query("SELECT comment from Comment comment WHERE comment.masterComment = :id")
	public List<Comment> findAnswers(@Param("id")Integer id);
}
