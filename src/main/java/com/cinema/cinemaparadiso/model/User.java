package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
	
    @Id
    @Column(name = "username")
	@NotNull
    private String username;
    @Column(name = "password")
	@NotNull
    private String password;
    @Column(name = "enabled")
	@NotNull
    private boolean enabled;
    @Email
    @Column(name = "email")
	@NotNull
    private String email;
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public User() {}
    
 
}
