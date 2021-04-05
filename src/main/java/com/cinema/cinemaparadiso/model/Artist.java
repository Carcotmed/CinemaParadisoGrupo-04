package com.cinema.cinemaparadiso.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="artists")
@Getter
@Setter
public class Artist extends Person {
	
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	@NotNull(message = "Debes escoger un rol")
	private Role role;

	@Column(name="projects")
	@ManyToMany(mappedBy = "team", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Project> projects;
	
	@Column(name="projects_history")
	@ManyToMany(mappedBy = "team")
	private List<Project> projectsHistory;
	

	@Column(name="summary")
	private String summary;
	

	
	@Column(name="pro")
//	@NotNull(message = "Elige una opción")
	private Boolean pro;
	
	
  @OneToOne()
  @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;
}