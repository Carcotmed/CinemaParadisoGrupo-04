package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
	private String title;
	
	@Column(name = "body")
	@Size(min=10,max=1500,message="El resumen debe tener entre 10 y 1500 caracteres")
	private String body;
	
	//@ElementCollection(targetClass=Genre.class)
	@Enumerated(EnumType.STRING)
	@Column(name="genre")
	@NotNull(message="Seleccione un género")
    private Genre genre;
	
	@Column(name="storylength")
    private Integer storylength;

}
