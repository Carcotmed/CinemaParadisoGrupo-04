package com.cinema.cinemaparadiso.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post extends BaseEntity{
	
	@Column(name = "title")
	@NotNull(message="El titulo no puede ser nulo")
	@Size(min=5,max=30,message="El título debe tener un tamaño entre 5 y 30 carácteres")
	private String title;
	
	@Column(name = "body")
	@NotNull(message="El cuerpo no puede ser nulo")
	@Size(min=5,max=140,message="El cuerpo debe tener un tamaño entre 5 y 140 carácteres")
	private String body;
	
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private Date date;
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "artist_id")
	private Artist artist;
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "producer_id")
	private Producer producer;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "project_id")
	private Project project;
	
}
