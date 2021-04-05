package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    
    @Id
	@Column(name="username")
    private String username;
	@Column(name="password")
    private String password;
	@Column(name="enabled")
    private boolean enabled;
    @Email
	@Column(name="email")
    private String email;
    
 
}
