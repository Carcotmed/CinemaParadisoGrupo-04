package com.cinema.cinemaparadiso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinemaparadiso.model.Comment;
import com.cinema.cinemaparadiso.repository.CommentRepository;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;

	public List<Comment> getMasterComments(Integer storyId) {
		List<Comment> comments = new ArrayList<>();
		comments = commentRepository.findMasterComments(storyId);
		return comments;
	}

	public List<Comment> getAnswers(Integer id) {
		List<Comment> comments = new ArrayList<>();
		comments = commentRepository.findAnswers(id);
		return comments;
	}

	public void createComment(Comment comment) {
		commentRepository.save(comment);
	}
	
	public void deleteByUser(String username) {
		List<Comment> comments = commentRepository.findAllByUsername(username);
		comments.forEach(comment->{
			if(comment.getMasterComment()!=null) {
				commentRepository.delete(comment);
			}
		});
		comments = commentRepository.findAllByUsername(username);
		comments.forEach(comment->{
			if(comment.getMasterComment()==null) {
				commentRepository.deleteAnswers(comment.getId());
				commentRepository.delete(comment);
			}
		});
	}
	
	public void deleteByStory(Integer storyId) {
		commentRepository.deleteAnswersByStory(storyId);
		commentRepository.deleteCommentsByStory(storyId);
	}
}
