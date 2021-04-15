package com.cinema.cinemaparadiso.model;

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

	@Override
	public String toString() {
		return "Producer (" + id + ") " + ", description=" + description + ", user=" + user + "]";
	}
	
	@Column(name="projects")
	@ManyToMany(mappedBy = "team2", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Project> projects;
  
}
