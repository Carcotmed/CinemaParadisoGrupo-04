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

	@Override
	public String toString() {
		return "Story [title=" + title + ", body=" + body + ", genre=" + genre + "]";
	}

}
