package com.cinema.cinemaparadiso.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "authorities")
public class Authorities {
	@Id
	String username;
	String authority;

	public Authorities(){
		
	}
	
	public Authorities(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}
}
