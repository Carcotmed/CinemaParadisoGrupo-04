package com.cinema.cinemaparadiso.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="producers")
@Getter
@Setter
public class Producer extends Person {
	
	@OneToOne
	@Valid
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

	@Column(name="projects")
	@ManyToMany(mappedBy = "team2", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Project> projects = new ArrayList<>();
	
	public Producer() {}
	
	public Producer(User user, String name, String description, Integer id, String surName, String photo) {
		this.user = user;
		this.description = description;
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.setPhoto(photo);
	}
	
	public Producer(User user, String name, String description, Integer id, String surName, String photo, List<Project> projects) {
		this.user = user;
		this.description = description;
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.setPhoto(photo);
		this.projects = projects;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Producer (" + id + ") " + ", description=" + description + ", user=" + user + "]";
	}

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
		Producer other = (Producer) obj;
		if(this.user.equals(other.user) && this.description.equals(other.description)
			&& this.id.equals(other.id) && this.surName.equals(other.surName)
			&& this.name.equals(other.name) && this.getPhoto().equals(other.getPhoto())) {
			return true;
		}else {
			return false;
		}
	}

	
	
  
}
