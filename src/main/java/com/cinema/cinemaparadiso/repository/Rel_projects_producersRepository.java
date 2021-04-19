package com.cinema.cinemaparadiso.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_projects_producers;

	public interface Rel_projects_producersRepository extends CrudRepository<Rel_projects_producers,Integer>{
	
	@Query("SELECT rel_projects_producers FROM Rel_projects_producers rel_projects_producers WHERE (rel_projects_producers.producer_id = ?1 and rel_projects_producers.project_id = ?2)")
	public Rel_projects_producers findRelacion(Integer producerId, Integer projectId) throws DataAccessException;
	
	@Query("SELECT COUNT(rel_projects_producers) FROM Rel_projects_producers rel_projects_producers WHERE rel_projects_producers.project_id = :idProject")
	public Long countRelationsProject(@Param("idProject") Integer idProject);

	@Transactional
	@Modifying
	@Query("DELETE FROM Rel_projects_producers rel where rel.project_id= :projectId")
	public void deleteByProjectId(@Param("projectId") Integer projectId);

}
	
