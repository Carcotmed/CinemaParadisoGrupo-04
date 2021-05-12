package com.cinema.cinemaparadiso.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WholeComment {
	Comment comment;
	List<Comment> answers;
	public WholeComment(Comment comment, List<Comment> answers) {
		this.comment = comment;
		this.answers = answers;
	}
}
