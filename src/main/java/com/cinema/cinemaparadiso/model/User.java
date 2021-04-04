package com.cinema.cinemaparadiso.model;

import javax.persistence.Entity;
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
    private String username;
    private String password;
    private boolean enabled;
    @Email
    private String email;
    
 
}
