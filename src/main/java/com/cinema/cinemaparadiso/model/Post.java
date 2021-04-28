package com.cinema.cinemaparadiso.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="posts")
@Getter
@Setter
public class Post extends BaseEntity{
	
	@Column(name = "title")
	@Size(min=5,max=30,message="El título debe tener un tamaño entre 5 y 30 carácteres")
	private String title;
	
	@Column(name = "body")
	@Size(min=5,max=140,message="El cuerpo debe tener un tamaño entre 5 y 140 carácteres")
	private String body;
	
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH")
	private String date;
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "artist_id")
	private Artist artist;
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "producer_id")
	private Producer producer;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "project_id")
	private Project project;
	
	@Column(name = "username")
	private String username;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Post other = (Post) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public Post() {}
	
	public Post(
			String title, String body, String date, Artist artist,
			Producer producer, Project project, String username) {
		super();
		this.title = title;
		this.body = body;
		this.date = date;
		this.artist = artist;
		this.producer = producer;
		this.project = project;
		this.username = username;
	}
	
	
	
}
