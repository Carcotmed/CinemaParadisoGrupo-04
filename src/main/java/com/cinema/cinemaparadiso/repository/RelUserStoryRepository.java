package com.cinema.cinemaparadiso.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cinema.cinemaparadiso.model.RelUserStory;

	public interface RelUserStoryRepository extends CrudRepository<RelUserStory,Integer>{


	
	@Query("SELECT COUNT(rel_user_story) FROM RelUserStory rel_user_story WHERE rel_user_story.story_id = :idStory")
	public Long countLikes(@Param("idStory") Integer idStory);
	
	@Query("SELECT rel_user_story FROM RelUserStory rel_user_story WHERE rel_user_story.username= ?1 AND rel_user_story.story_id = ?2")
	public RelUserStory findRelation(String username,Integer idStory);
	
	@Query("SELECT relUserStory FROM RelUserStory relUserStory WHERE relUserStory.username = :username")
	public List<RelUserStory> listRelationsUserStories(@Param("username") String username);

	@Query("SELECT relUserStory FROM RelUserStory relUserStory WHERE relUserStory.story_id = :storyId")
	public List<RelUserStory> listRelationsUserStoriesByStory(@Param("storyId")Integer storyId);

	

}
