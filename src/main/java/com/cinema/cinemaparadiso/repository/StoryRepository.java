package com.cinema.cinemaparadiso.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.Writer;

@Repository
public interface StoryRepository extends CrudRepository<Story,Integer>{

	
	@Query("SELECT writer FROM Writer writer INNER JOIN Rel_story_writers rel_story_writers ON writer.id = rel_story_writers.writer_id AND rel_story_writers.story_id = :storyId")
	public Writer findMyWriter(@Param("storyId") Integer storyId);

	@Transactional
	@Modifying
	@Query("UPDATE Story story SET story.isSponsored = TRUE WHERE story.id = :storyID")
	public void makeStorySponsored(Integer storyID);
}
