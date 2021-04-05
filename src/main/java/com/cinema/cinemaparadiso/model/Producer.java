package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="producers")
@Getter
@Setter
public class Producer extends Person {
	
	@NotEmpty(message = "El campo NIF no puede estar vacio")
	@Column(name="nif")
	private String nif;
	
	@OneToOne()
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

	@Override
	public String toString() {
		return "Producer [nif=" + nif + ", description=" + description + ", user=" + user + "]";
	}
	
	
  
}
