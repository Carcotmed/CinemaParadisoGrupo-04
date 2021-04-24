package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Project;
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

	@Query("SELECT story from Story story WHERE story.isSponsored = TRUE")
	public List<Story> findAllSponsoredStories();
	
	@Query("SELECT project FROM Project project INNER JOIN Rel_projects_story rel_projects_story ON project.id = rel_projects_story.project_id AND rel_projects_story.story_id = :storyId")
	public List<Project> findMyProjects(@Param("storyId") Integer storyId);
}
