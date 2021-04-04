package com.cinema.cinemaparadiso.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rel_projects_artists")
@Getter
@Setter
public class Rel_projects_artists{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
	
	@Column(name="artist_id")
	@NotNull
	private Integer artist_id;
	
	@Column(name="project_id")
	@NotNull
	private Integer project_id;
  
}