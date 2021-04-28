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
@Table(name="rel_user_story")
@Getter
@Setter
public class RelUserStory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name="story_id")
    private Integer story_id;

    @Column(name="username")
    private String username;

	@Override
	public String toString() {
		return "RelUserStory [id=" + id + ", story_id=" + story_id + ", username=" + username + "]";
	}

	
    
    
}
