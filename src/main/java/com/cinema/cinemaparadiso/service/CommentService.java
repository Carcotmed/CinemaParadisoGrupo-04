package com.cinema.cinemaparadiso.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Comment;
import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.repository.CommentRepository;
import com.cinema.cinemaparadiso.repository.PostRepository;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;

	public List<Comment> getMasterComments() {
		List<Comment> comments = new ArrayList<>();
		comments = commentRepository.findMasterComments();
		return comments;
	}

	public List<Comment> getAnswers(Integer id) {
		List<Comment> comments = new ArrayList<>();
		comments = commentRepository.findAnswers(id);
		return comments;
	}
}
