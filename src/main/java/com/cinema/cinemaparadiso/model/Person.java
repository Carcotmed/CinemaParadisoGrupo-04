package com.cinema.cinemaparadiso.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;


import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Table(name="persons")
@Getter
@Setter
public class Person extends BaseEntity  {

	@Column(name = "name")
	@NotEmpty(message = "El nombre no puede estar vacío")
	protected String name;
	
	@Column(name = "surName")
	@NotEmpty(message = "El apellido no puede estar vacío")
	protected String surName;
	
	@ElementCollection(targetClass=Skill.class, fetch = FetchType.EAGER)
	@Column(name = "skills")
	protected List<Skill> skills;
	
	@Column(name = "description")
	@NotEmpty(message = "Indique una descripion propia")
	protected String description;
	
  @Column(name="photo")
  @URL(message = "Debe indicar una URL")
  private String photo;
}
