package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.Writer;

@Repository
public interface WriterRepository extends CrudRepository<Writer,Integer>{
	
	
	@Query("SELECT story FROM Story story INNER JOIN Rel_story_writers rel_story_writers ON story.id = rel_story_writers.story_id AND rel_story_writers.writer_id = :writerId")
	public List<Story> findMyStories(@Param("writerId") Integer writerId);
}