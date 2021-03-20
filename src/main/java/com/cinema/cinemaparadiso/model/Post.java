package com.cinema.cinemaparadiso.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post extends BaseEntity{
	
	@Column(name = "title")
	@NotNull
	private String title;
	
	@Column(name = "body")
	@NotNull
	private String body;
	
	@Column(name = "date")
	@NotNull
	//@PastOrPresent
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private Date date;
	
//	@ManyToOne(optional=false)
//	@JoinColumn(name = "artist_id")
//	private Artist artist;
	
//	@ManyToOne(optional=false)
//	@JoinColumn(name = "project_id")
//	private Project project;
	
}
