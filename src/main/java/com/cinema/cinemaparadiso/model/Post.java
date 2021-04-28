package com.cinema.cinemaparadiso.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="posts")
@Getter
@Setter
public class Post extends BaseEntity{
	
	@Column(name = "title")
	@Size(min=5,max=30,message="El título debe tener un tamaño entre 5 y 30 carácteres")
	private String title;
	
	@Column(name = "body")
	@Size(min=5,max=140,message="El cuerpo debe tener un tamaño entre 5 y 140 carácteres")
	private String body;
	
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH")
	private String date;
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "artist_id")
	private Artist artist;
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "producer_id")
	private Producer producer;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "project_id")
	private Project project;
	
	@Column(name = "username")
	private String username;
	
}
