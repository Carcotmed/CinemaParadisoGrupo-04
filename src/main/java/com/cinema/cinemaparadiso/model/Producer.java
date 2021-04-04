package com.cinema.cinemaparadiso.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="producers")
@Getter
@Setter
public class Producer extends Person {
	
	@NotNull
	// Falta poner patrón que conste de 9 números seguido de una letra, no deja poner la anotación @Pattern (regx =)
	@Column(name="nif")
	private String nif;
	
	// Pongo not null aunque no esté en el UML para que tenga que tener una descripción obligatoria el productor.
	@NotNull
	@Column(name="description")
	private String description;
	
	@OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

	@Override
	public String toString() {
		return "Producer [nif=" + nif + ", description=" + description + ", user=" + user + "]";
	}
	
	
  
}
