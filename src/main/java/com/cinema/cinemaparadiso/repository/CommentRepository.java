package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Comment;
import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.model.Story;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Integer>{

	@Query("SELECT comment from Comment comment WHERE comment.masterComment = null AND comment.story = :storyId ORDER BY comment.date DESC")
	public List<Comment> findMasterComments(@Param("storyId")Integer storyId);

	@Query("SELECT comment from Comment comment WHERE comment.masterComment = :id")
	public List<Comment> findAnswers(@Param("id")Integer id);

	@Query("SELECT comment from Comment comment WHERE comment.username = :username")
	public List<Comment> findAllByUsername(@Param("username")String username);

	@Query("SELECT comment from Comment comment WHERE comment.story = :storyId")
	public List<Comment> findAllByStoryId(@Param("storyId")Integer storyId);

	@Transactional
	@Modifying
	@Query("DELETE FROM Comment comment WHERE comment.masterComment = :commentId")
	public void deleteAnswers(@Param("commentId")Integer commentId);

	@Transactional
	@Modifying
	@Query("DELETE FROM Comment comment WHERE comment.story = :storyId AND comment.masterComment != null")
	public void deleteAnswersByStory(@Param("storyId")Integer storyId);

	@Transactional
	@Modifying
	@Query("DELETE FROM Comment comment WHERE comment.story = :storyId AND comment.masterComment = null")
	public void deleteCommentsByStory(@Param("storyId")Integer storyId);
}
