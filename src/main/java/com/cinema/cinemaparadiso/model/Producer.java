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
	
	@OneToOne()
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

	@Override
	public String toString() {
		return "Producer [nif=" + nif + ", description=" + description + ", user=" + user + "]";
	}
	
	
  
}
