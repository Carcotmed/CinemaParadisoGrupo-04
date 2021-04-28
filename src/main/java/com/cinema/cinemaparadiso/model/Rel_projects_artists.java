package com.cinema.cinemaparadiso.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rel_projects_artists")
@Getter
@Setter
public class Rel_projects_artists{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
	
	@Column(name="artist_id")
	@NotNull
	private Integer artist_id;
	
	@Column(name="project_id")
	@NotNull
	private Integer project_id;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist_id == null) ? 0 : artist_id.hashCode());
		result = prime * result + ((project_id == null) ? 0 : project_id.hashCode());
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
		Rel_projects_artists other = (Rel_projects_artists) obj;
		if (artist_id == null) {
			if (other.artist_id != null)
				return false;
		} else if (!artist_id.equals(other.artist_id))
			return false;
		if (project_id == null) {
			if (other.project_id != null)
				return false;
		} else if (!project_id.equals(other.project_id))
			return false;
		return true;
	}
	
	
  
}