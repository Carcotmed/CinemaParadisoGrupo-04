package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Table(name="persons")
@Getter
@Setter
public class Person extends BaseEntity  {

	@Column(name = "name")
	@Size(min=1,max=30,message="El nombre debe tener como máximo 30 caracteres y no ser vacío")
	protected String name;
	
	@Column(name = "surName")
	@Size(min=1,max=30,message="El apellido debe tener como máximo 30 caracteres y no ser vacío")
	protected String surName;

	
	@Column(name = "description")
	@Size(min=1,max=150,message="El resumen debe tener como máximo 150 caracteres y no ser vacía")
	protected String description;
	
	@Column(name="photo")
	@URL(message = "Debe indicar una URL")
	@Size(min=1,max=150,message="La foto debe tener como máximo 150 caracteres y no ser vacía")
	private String photo;
}
