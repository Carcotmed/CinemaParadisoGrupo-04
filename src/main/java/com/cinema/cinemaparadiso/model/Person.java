package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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

	
	@Column(name = "description")
	@NotEmpty(message = "Indique una descripion propia")
	protected String description;
	
	@Column(name="photo")
	@URL(message = "Debe indicar una URL")
	@NotEmpty(message="Debe rellenar el campo")
	private String photo;
}
