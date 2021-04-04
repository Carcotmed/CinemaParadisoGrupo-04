package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="producers")
@Getter
@Setter
public class Producer extends Person {
	
	@NotBlank
	@Pattern(regexp = "^[0-9]{8}[A-Z]$")
	// Falta poner patrón que conste de 9 números seguido de una letra, no deja poner la anotación @Pattern (regx =)
	@Column(name="nif")
	private String nif;
	
	@NotBlank
	@Column(name="description")
	private String description;
	
	@OneToOne
	@NotNull
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

	@Override
	public String toString() {
		return "Producer (" + id + ") [nif=" + nif + ", description=" + description + ", user=" + user + "]";
	}
	
	
  
}
