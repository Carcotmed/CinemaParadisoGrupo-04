package com.cinema.cinemaparadiso.repository;


import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Post;
import com.cinema.cinemaparadiso.model.Rel_projects_artists;

	public interface Rel_projects_artistsRepository extends CrudRepository<Rel_projects_artists,Integer>{
	
	@Query("SELECT rel_projects_artists FROM Rel_projects_artists rel_projects_artists WHERE (rel_projects_artists.artist_id = ?1 and rel_projects_artists.project_id = ?2)")
	public Rel_projects_artists findRelacion(Integer artistId, Integer projectId) throws DataAccessException;

	
	@Query("SELECT COUNT(rel_projects_artists) FROM Rel_projects_artists rel_projects_artists WHERE rel_projects_artists.project_id = :idProject")
	public Long countRelationsProject(@Param("idProject") Integer idProject);

	@Transactional
	@Modifying
	@Query("DELETE FROM Rel_projects_artists rel where rel.project_id= :projectId")
	public void deleteByProjectId(@Param("projectId") Integer projectId);
	
	@Query("SELECT rel_projects_artists FROM Rel_projects_artists rel_projects_artists WHERE rel_projects_artists.artist_id = :artistId")
	public List<Rel_projects_artists> listRelationsArtistProjects(@Param("artistId") Integer artistId);
	

}
