package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="producers")
@Getter
@Setter
public class Producer extends Person {
	
	@Pattern(regexp = "^[0-9]{8}[A-Z]$")
	@NotEmpty(message = "El campo NIF no puede estar vacio")
	@Column(name="nif")
	private String nif;
	
	private String photo;
	
	@OneToOne
	@NotNull
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

	@Override
	public String toString() {
		return "Producer (" + id + ") [nif=" + nif + ", description=" + description + ", user=" + user + "]";
	}
	
	public Producer(String nif, String description, User user) {
		this.nif = nif;
		this.description = description;
		this.user = user;
	}
	
	public Producer() {}
	
	
  
}
