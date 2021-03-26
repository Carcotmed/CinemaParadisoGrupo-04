package com.cinema.cinemaparadiso.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="artists")
@Getter
@Setter
public class Artist extends Person {
	
	//@ElementCollection(targetClass=Role.class)
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	@NotNull
	private Role role;
	

	@Column(name="projects")
	@ManyToMany(mappedBy = "team")
	private List<Project> projects;
	

	@Column(name="summary")
	private String summary;
	
	@Column(name="pro")
	@NotNull
	private Boolean pro;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;
  
}
