package com.cinema.cinemaparadiso.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "writers")
@Getter
@Setter
public class Writer extends Person {

	@OneToOne()
	@Valid
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Writer other = (Writer) obj;
		if(this.user.equals(other.user) && this.description.equals(other.description)
			&& this.id.equals(other.id) && this.surName.equals(other.surName)
			&& this.name.equals(other.name) && this.getPhoto().equals(other.getPhoto())) {
			return true;
		}else {
			return false;
		}
	}
	
	public Writer() {}

	public Writer(User user, String name, String description, Integer id, String surName, String photo) {
		this.user = user;
		this.description = description;
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.setPhoto(photo);
	}

	@Override
	public String toString() {
		return "Writer (" + id + ") [user=" + user + ", description=" + description + "]";
	}
  

}