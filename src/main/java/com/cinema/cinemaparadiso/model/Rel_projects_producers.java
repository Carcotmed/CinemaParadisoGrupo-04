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
@Table(name="rel_projects_producers")
@Getter
@Setter
public class Rel_projects_producers{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
	
	@Column(name="producer_id")
	@NotNull
	private Integer producer_id;
	
	@Column(name="project_id")
	@NotNull
	private Integer project_id;
  
}