package com.cinema.cinemaparadiso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rel_story_writers")
@Getter
@Setter
public class Rel_story_writers {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name="story_id")
    private Integer story_id;

    @Column(name="writer_id")
    private Integer writer_id;

    public Rel_story_writers() {}
    
	public Rel_story_writers(Integer id, Integer story_id, Integer writer_id) {
		this.id = id;
		this.story_id = story_id;
		this.writer_id = writer_id;
	}

	@Override
	public String toString() {
		return "Rel_story_writers (" + id + ") [story_id=" + story_id + ", writer_id=" + writer_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((story_id == null) ? 0 : story_id.hashCode());
		result = prime * result + ((writer_id == null) ? 0 : writer_id.hashCode());
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
		Rel_story_writers other = (Rel_story_writers) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (story_id == null) {
			if (other.story_id != null)
				return false;
		} else if (!story_id.equals(other.story_id))
			return false;
		if (writer_id == null) {
			if (other.writer_id != null)
				return false;
		} else if (!writer_id.equals(other.writer_id))
			return false;
		return true;
	}

	
    
    
}
