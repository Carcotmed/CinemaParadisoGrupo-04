package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Integer>{
    

	@Query("SELECT project FROM Project project WHERE project.pro = 1")
	public List<Project> listProProjects();
	
	
}
