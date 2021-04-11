package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
	
    @Id
    @Column(name = "username")
	@NotEmpty(message = "El usuario no puede estar vacío")
    private String username;
    
    @Column(name = "password")
	@NotEmpty(message = "La contraseña no puede estar vacía")
    private String password;
    
    @Column(name = "enabled")
    private boolean enabled;
    
    @Email
    @Column(name = "email")
	@NotEmpty(message = "El correo no puede estar vacío")
    private String email;
    
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
}
