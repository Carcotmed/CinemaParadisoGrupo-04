package com.cinema.cinemaparadiso.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @NotBlank(message="No puedes dejarlo vacío.")
	@Pattern(regexp = "[a-zA-Z0-9 ]*", message = "Utiliza solo numeros y letras sin tildes")
    private String title;

	@Enumerated(EnumType.STRING)
	@Column(name="genre")
	@NotNull (message = "Es necesario seleccionar un género")
    private Genre genre;
	
	@Column(name="description")
	@Size(max=900,message="Use una descripción con menos de 900 carácteres")
    @NotBlank(message="No puedes dejarlo vacío.")
    private String description;

	@JoinTable(
			name = "rel_projects_artists",
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "artist_id")
			)
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Artist> team;
	
	@JoinTable(
			name = "rel_projects_producers",
			joinColumns = @JoinColumn(name = "project_id"),
			inverseJoinColumns = @JoinColumn(name = "producer_id")
			)
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Producer> team2;
	
	@Column(name="pro")
	private Boolean pro;
	
	@URL(message = "Debe ser una url válida")
    @NotBlank(message="No puedes dejarlo vacío.")
	@Size(max=200,message="Use una url con menos de 200 caracteres")
	@Column(name="photo")
	private String photo;	
	
	@Column(name="my_admin")
	private String myAdmin;
	
	@Column(name="isSponsored", columnDefinition="bool default false")
	private Boolean isSponsored;
	
	public Project() {}
	public Project(String title, String description, Genre genre, Integer id, String myAdmin, String photo) {
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.id = id;
		this.isSponsored = false;
		this.myAdmin = myAdmin;
		this.photo = photo;
		this.pro = false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((isSponsored == null) ? 0 : isSponsored.hashCode());
		result = prime * result + ((myAdmin == null) ? 0 : myAdmin.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((pro == null) ? 0 : pro.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Project other = (Project) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genre != other.genre)
			return false;
		if (isSponsored == null) {
			if (other.isSponsored != null)
				return false;
		} else if (!isSponsored.equals(other.isSponsored))
			return false;
		if (myAdmin == null) {
			if (other.myAdmin != null)
				return false;
		} else if (!myAdmin.equals(other.myAdmin))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (pro == null) {
			if (other.pro != null)
				return false;
		} else if (!pro.equals(other.pro))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Project (" + id + ")[title=" + title + ", genre=" + genre + ", description=" + description + ", pro=" + pro
				+ ", photo=" + photo + ", myAdmin=" + myAdmin + ", isSponsored=" + isSponsored + "]";
	}
	
	
 
}