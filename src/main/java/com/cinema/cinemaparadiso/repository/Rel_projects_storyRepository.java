package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_projects_story;



	public interface Rel_projects_storyRepository extends CrudRepository<Rel_projects_story,Integer>{

		@Query("SELECT rel_projects_story FROM Rel_projects_story rel_projects_story WHERE (rel_projects_story.project_id = ?1 and rel_projects_story.story_id = ?2)")
		public Rel_projects_story findRelacion(Integer projectId, Integer storytId) throws DataAccessException;
		
		@Query("SELECT rel_projects_story FROM Rel_projects_story rel_projects_story WHERE rel_projects_story.project_id = ?1")
		public List<Rel_projects_story> findRelacionesByProject(Integer projectId) throws DataAccessException;

		@Transactional
		@Modifying
		@Query("DELETE FROM Rel_projects_story rel where rel.project_id= :projectId")
		public void deleteByProjectId(@Param("projectId") Integer projectId);

		@Transactional
		@Modifying
		@Query("DELETE FROM Rel_projects_story rel where rel.story_id= :storyId")
		public void deleteByStoryId(@Param("storyId") Integer storyId);

}