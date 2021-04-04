package com.cinema.cinemaparadiso.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="projects")
@Getter
@Setter
public class Project extends BaseEntity {
    
	@Column(name="title")
	@Size(min=3,max=30,message="Es necesario que el título tenga entre 3 y 30 caracteres")
    private String title;
	
	@Column(name="genre")
	@NotNull (message = "Es necesario seleccionar un género")
    private Genre genre;
	
	@Column(name="description")
	@Size(max=900,message="Use una url con menos de 900 caracteres")
    private String description;

	@JoinTable(
			name = "rel_projects_artists",
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "artist_id")
			)
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Artist> team;
	
	@Column(name="pro")
	private Boolean pro;
	
	@URL(message = "Debe ser una url válida")
	@NotEmpty(message = "Debe introducir una url")
	@Size(max=200,message="Use una url con menos de 200 caracteres")
	@Column(name="photo")
	private String photo;	
	
 
}
