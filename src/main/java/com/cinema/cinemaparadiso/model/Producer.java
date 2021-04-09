package com.cinema.cinemaparadiso.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

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
	
  
}
