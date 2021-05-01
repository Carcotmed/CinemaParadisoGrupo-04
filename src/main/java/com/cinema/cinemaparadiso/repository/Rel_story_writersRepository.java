package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_story_writers;



	public interface Rel_story_writersRepository extends CrudRepository<Rel_story_writers,Integer>{
	
	@Query("SELECT rel_story_writers FROM Rel_story_writers rel_story_writers WHERE (rel_story_writers.writer_id = ?1 and rel_story_writers.story_id = ?2)")
	public Rel_story_writers findRelacion(Integer writerId, Integer storytId) throws DataAccessException;

	@Transactional
	@Modifying
	@Query("DELETE FROM Rel_story_writers rel where rel.story_id= :storyId")
	public void deleteByStoryId(@Param("storyId") Integer storyId);
	
	@Query("SELECT rel_story_writers FROM Rel_story_writers rel_story_writers WHERE rel_story_writers.writer_id = :writerId")
	public List<Rel_story_writers> listRelationsWriterStories(@Param("writerId") Integer writerId);

}