package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
	
    @Id
    @Column(name = "username")
    @Size(min=1,max=30,message="El usuario debe tener como máximo 30 caracteres y no ser vacío")
    @NotBlank(message="No puedes dejarlo vacío")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "Utiliza solo numeros y letras sin tildes y sin espacios")
    private String username;
    
    @Column(name = "password")
    @Size(min=1,max=150,message="La password debe tener como máximo 150 caracteres y no ser vacía")
    @NotBlank(message="No puedes dejarlo vacío.")
    private String password;
    
    @Column(name = "enabled")
    private boolean enabled;
    
    @Email
    @Column(name = "email")
    @Size(min=1,max=80,message="El email debe tener como máximo 80 caracteres y no ser vacío")
    @NotBlank(message="No puedes dejarlo vacío.")
    private String email;
    
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
}
