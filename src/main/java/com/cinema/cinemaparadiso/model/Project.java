package com.cinema.cinemaparadiso.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="projects")
@Getter
@Setter
public class Project extends BaseEntity {
    
	@Column(name="title")
    private String title;
	
	@Column(name="genre")
    private Genre genre;
	
	@Column(name="description")
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
	
	@Column(name="photo")
	private String photo;		
 
}
