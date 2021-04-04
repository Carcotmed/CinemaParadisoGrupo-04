package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.cinemaparadiso.model.Artist;
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
	
	@Query("SELECT artist FROM Artist artist INNER JOIN Rel_projects_artists rel_projects_artists ON artist.id = rel_projects_artists.artist_id AND rel_projects_artists.project_id = :projectId")
	public List<Artist> findMembers(@Param("projectId") Integer projectId);
}