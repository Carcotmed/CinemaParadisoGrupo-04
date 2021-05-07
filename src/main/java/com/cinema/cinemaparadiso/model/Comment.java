package com.cinema.cinemaparadiso.model;

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
@Table(name="comments")
@Getter
@Setter
public class Comment extends BaseEntity{
	
	@Column(name = "body")
	@Size(min=5,max=140,message="El cuerpo debe tener un tamaño entre 5 y 140 carácteres")
	private String body;
	
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private String date;
	
	private String username;
	
	@Column(name = "master_comment")
	private Integer masterComment;
	
	private Integer story;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((masterComment == null) ? 0 : masterComment.hashCode());
		result = prime * result + ((story == null) ? 0 : story.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
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
		if (masterComment == null) {
			if (other.masterComment != null)
				return false;
		} else if (!masterComment.equals(other.masterComment))
			return false;
		if (story == null) {
			if (other.story != null)
				return false;
		} else if (!story.equals(other.story))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [body=" + body + ", date=" + date + ", username=" + username + ", masterComment="
				+ masterComment + ", story=" + story + "]";
	}
	
}
