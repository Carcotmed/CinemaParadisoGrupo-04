package com.cinema.cinemaparadiso.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @Size(min=1,max=30,message="El usuario debe tener como máximo 30 caracteres")
    @NotBlank(message="No puedes dejarlo vacío")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "Utiliza solo numeros y letras sin tildes y sin espacios")
    private String username;
    
    @Column(name = "password")
    @Size(min=1,max=150,message="La password debe tener como máximo 150 caracteres")
    @NotBlank(message="No puedes dejarlo vacío")
    private String password;
    
    @Column(name = "enabled")
    private boolean enabled;
    
    @Email
    @Column(name = "email")
    @Size(min=1,max=80,message="El email debe tener como máximo 80 caracteres")
    @NotBlank(message="No puedes dejarlo vacío")
    private String email;
    

	@JoinTable(
			name = "rel_user_story",
			joinColumns = @JoinColumn(name = "username"),
			inverseJoinColumns = @JoinColumn(name = "story_id")
			)
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Story> likes;

    public User() {}
    
    public User(String username,String password,String email) {
    	this.username = username;
    	this.enabled = true;
    	this.password = password;
    	this.email=email;
    }

    
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled != other.enabled)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
