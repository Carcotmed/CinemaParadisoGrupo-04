package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Integer>{
    

	@Query("SELECT project FROM Project project WHERE project.pro = 1")
	public List<Project> listProProjects();
	
	@Query("SELECT project FROM Project project WHERE project.pro = 0")
	public List<Project> listNoProProjects();
	
	@Query("SELECT artist FROM Artist artist INNER JOIN Rel_projects_artists rel_projects_artists ON artist.id = rel_projects_artists.artist_id AND rel_projects_artists.project_id = :projectId")
	public List<Artist> findMembers(@Param("projectId") Integer projectId);
	
	@Query("SELECT producer FROM Producer producer INNER JOIN Rel_projects_producers rel_projects_producers ON producer.id = rel_projects_producers.producer_id AND rel_projects_producers.project_id = :projectId")
	public List<Producer> findProducers(@Param("projectId") Integer projectId);

	@Transactional
	@Modifying
	@Query("UPDATE Project project SET project.isSponsored = TRUE WHERE project.id = :projectID")
	public void makeProjectSponsored(Integer projectID);

	
}