package com.cinema.cinemaparadiso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Project;

@Repository
public interface ArtistRepository extends CrudRepository<Artist,Integer>{
	
	
	
	
	@Query("SELECT artist FROM Artist artist WHERE artist.user.username =: username")
	public Artist findByUsername(@Param("username") String username);
	
	@Query("SELECT project FROM Project project INNER JOIN Rel_projects_artists rel_projects_artists ON project.id = rel_projects_artists.project_id AND rel_projects_artists.artist_id = :artistId")
	public List<Project> findMyProjects(@Param("artistId") Integer artistId);
	
	//COMPROBAR ARTISTA LOGUEADO
	
	@Query("SELECT artist FROM Artist artist WHERE artist.user.username = :username")
	public Optional<Artist> findByUserUsername(String username);
    
}
