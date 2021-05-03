package com.cinema.cinemaparadiso.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "artists")
@Getter
@Setter
public class Artist extends Person {

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	@NotNull(message = "Debes escoger un rol")
	private Role role;

	@Column(name = "projects")
	@ManyToMany(mappedBy = "team", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Project> projects;

	@Column(name = "projects_history")
	@ManyToMany(mappedBy = "team")
	private List<Project> projectsHistory;

	@Column(name = "left_projects")
	private Integer leftProjects;

	@Column(name = "pro")
//	@NotNull(message = "Elige una opción")
	private Boolean pro;

	@OneToOne()
	@Valid
	@JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

	public Artist(Integer id, @NotNull(message = "Debes escoger un rol") Role role, List<Project> projects,
			List<Project> projectsHistory, Integer leftProjects, Boolean pro, @Valid User user) {
		super();
		this.id = id;
		this.role = role;
		this.projects = projects;
		this.projectsHistory = projectsHistory;
		this.leftProjects = leftProjects;
		this.pro = pro;
		this.user = user;
	}

	public Artist() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((leftProjects == null) ? 0 : leftProjects.hashCode());
		result = prime * result + ((pro == null) ? 0 : pro.hashCode());
		result = prime * result + ((projects == null) ? 0 : projects.hashCode());
		result = prime * result + ((projectsHistory == null) ? 0 : projectsHistory.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Artist other = (Artist) obj;
		if (leftProjects == null) {
			if (other.leftProjects != null)
				return false;
		} else if (!leftProjects.equals(other.leftProjects))
			return false;
		if (pro == null) {
			if (other.pro != null)
				return false;
		} else if (!pro.equals(other.pro))
			return false;
		if (projects == null) {
			if (other.projects != null)
				return false;
		} else if (!projects.equals(other.projects))
			return false;
		if (projectsHistory == null) {
			if (other.projectsHistory != null)
				return false;
		} else if (!projectsHistory.equals(other.projectsHistory))
			return false;
		if (role != other.role)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}