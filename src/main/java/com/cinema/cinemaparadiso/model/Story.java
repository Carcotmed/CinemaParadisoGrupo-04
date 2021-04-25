package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stories")
@Getter
@Setter
public class Story extends BaseEntity {
	
	@Column(name = "title")
	@Size(min=3,max=50,message="El titulo tiene que tener entre 3 y 50 caracteres")
    @NotBlank(message="No puedes dejarlo vacío")
	@Pattern(regexp = "[a-zA-Z0-9 ]*", message = "Utiliza solo numeros y letras sin tildes")
	private String title;
	
	@Column(name = "body")
	@Size(min=10,max=1500,message="El resumen debe tener entre 10 y 1500 caracteres")
    @NotBlank(message="No puedes dejarlo vacío")
	private String body;
	
	//@ElementCollection(targetClass=Genre.class)
	@Enumerated(EnumType.STRING)
	@Column(name="genre")
	@NotNull(message="Seleccione un género")
    private Genre genre;
	
	@Column(name="storylength")
    private Integer storylength;
	
	@Column(name="isSponsored", columnDefinition="bool default false")
	private Boolean isSponsored;
	
	@Column(name="photo")
    @NotBlank(message="No puedes dejarlo vacío")
	@URL(message = "Debe indicar una URL")
	@Size(min=1,max=200,message="La foto debe tener como máximo 200 caracteres")
	private String photo;

	public Story() {}
	
	
	
	@Override
	public String toString() {
		return "Story [title=" + title + ", body=" + body + ", genre=" + genre + "]";
	}



	public Story(Integer id, String title,String body,Genre genre, Integer storylength, String photo) {
		this.title = title;
		this.body = body;
		this.genre = genre;
		this.storylength = storylength;
		this.isSponsored = false;
		this.id = id;
		this.setPhoto(photo);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((isSponsored == null) ? 0 : isSponsored.hashCode());
		result = prime * result + ((storylength == null) ? 0 : storylength.hashCode());
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
		Story other = (Story) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (genre != other.genre)
			return false;
		if (isSponsored == null) {
			if (other.isSponsored != null)
				return false;
		} else if (!isSponsored.equals(other.isSponsored))
			return false;
		if (storylength == null) {
			if (other.storylength != null)
				return false;
		} else if (!storylength.equals(other.storylength))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
