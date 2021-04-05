package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stories")
@Getter
@Setter
public class Story extends BaseEntity {
	
	@Column(name = "title")
	@NotNull
	private String title;
	
	@Column(name = "body")
	@NotNull
	private String body;
	
	//@ElementCollection(targetClass=Genre.class)
	@Column(name="genre")
	@NotNull
    private Genre genre;
	
	@Column(name="storylength")
    private Integer storylength;

}
