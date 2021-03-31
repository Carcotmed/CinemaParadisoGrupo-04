package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Integer>{
    

	@Query("SELECT project FROM Project project WHERE project.pro = 1")
	public List<Project> listProProjects();
	
	@Query("SELECT project FROM Project project WHERE project.pro = 0")
	public List<Project> listNoProProjects();
	
	@Query("SELECT project FROM Project project WHERE project.genre =: filterGenre AND project.title LIKE '%filterTitle%'")
	public List<Project> findProjectByGenreAndTitle(@RequestParam("filterGenre") Genre filterGenre,@RequestParam("filterTitle") String title);
}
