package com.cinema.cinemaparadiso.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.validator.constraints.URL;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Table(name="persons")
@Getter
@Setter
public class Person extends BaseEntity  {

	@Column(name = "name")
	@NotNull
	protected String name;
	
	@Column(name = "surName")
	@NotNull
	protected String surName;
	
	@ElementCollection(targetClass=Skill.class)
	@Column(name = "skills")
	@NotNull
	protected List<Skill> skills;
	
	@Column(name = "description")
	@NotNull
	protected String description;
	
	@Column(name="photo")
	@URL
	private String photo;

}
