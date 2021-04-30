package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Table(name = "persons")
@Getter
@Setter
public class Person extends BaseEntity {

	@Column(name = "name")
	@NotBlank(message = "No puedes dejarlo vacío")
	@Size(min = 1, max = 30, message = "El nombre debe tener como máximo 30 caracteres")
	@Pattern(regexp = "[a-zA-Z0-9 ]*", message = "Utiliza solo numeros y letras sin tildes")
	protected String name;

	@Column(name = "surName")
	@NotBlank(message = "No puedes dejarlo vacío")
	@Size(min = 1, max = 30, message = "El apellido debe tener como máximo 30 caracteres")
	@Pattern(regexp = "[a-zA-Z0-9 ]*", message = "Utiliza solo numeros y letras sin tildes")
	protected String surName;

	@Column(name = "description")
	@NotBlank(message = "No puedes dejarlo vacío")
	@Size(min = 1, max = 150, message = "El resumen debe tener como máximo 150 caracteres")
	protected String description;

	@Column(name = "photo")
	@NotBlank(message = "No puedes dejarlo vacío")
	@URL(message = "Debe indicar una URL")
	@Size(min = 1, max = 200, message = "La foto debe tener como máximo 200 caracteres")
	private String photo;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}

}
