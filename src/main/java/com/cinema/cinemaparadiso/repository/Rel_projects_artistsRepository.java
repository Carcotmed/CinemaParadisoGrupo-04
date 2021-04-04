package com.cinema.cinemaparadiso.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cinema.cinemaparadiso.model.Rel_projects_artists;

	public interface Rel_projects_artistsRepository extends CrudRepository<Rel_projects_artists,Integer>{
	
	@Query("SELECT rel_projects_artists FROM Rel_projects_artists rel_projects_artists WHERE (rel_projects_artists.artist_id = ?1 and rel_projects_artists.project_id = ?2)")
	public Rel_projects_artists findRelacion(Integer artistId, Integer projectId) throws DataAccessException;
}
