package com.cinema.cinemaparadiso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.RelUserStory;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.repository.RelUserStoryRepository;

@Service
public class RelUserStoryService {

	@Autowired
	private RelUserStoryRepository relUserStoryRepository;
	@Autowired
	private StoryService storyService;


	





	@Transactional
	public void save(RelUserStory relUserStory) throws DataAccessException{
				relUserStoryRepository.save(relUserStory);
				Story s = storyService.findStoryById(relUserStory.getStory_id());
				s.setNumLikes(count(s.getId()));
	}
	
	@Transactional
	public void deleteLike(RelUserStory rel) throws DataAccessException{
			Integer storyId = rel.getStory_id();
			relUserStoryRepository.delete(rel);
			Story s = storyService.findStoryById(storyId);
			s.setNumLikes(count(s.getId()));


	}

	public Long count(Integer idStory) {
		try {
			Story s = storyService.findStoryById(idStory);
			s.setNumLikes(relUserStoryRepository.countLikes(s.getId()));
			return relUserStoryRepository.countLikes(idStory);
		}catch (Exception e) {
			return 0L;
		}
		
	}


	public RelUserStory findRelationByUsernameAndId(String username, Integer storyId) {
		
		return relUserStoryRepository.findRelation(username, storyId);
	}
	public Boolean actualUserLiked(Integer idStory,String username) {
		

		return relUserStoryRepository.findRelation(username, idStory)==null?false:true;
		
	}
	
	@Transactional
    public void deleteRelationsUserStories(String username) {
    	List<RelUserStory> relationsUserStories = this.relUserStoryRepository.listRelationsUserStories(username);
    	relationsUserStories.stream().forEach(r -> this.relUserStoryRepository.delete(r));
    }

	public void deleteRelationsUserStoriesByStory(Integer storyId) {
    	List<RelUserStory> relationsUserStories = this.relUserStoryRepository.listRelationsUserStoriesByStory(storyId);
    	relationsUserStories.stream().forEach(r -> this.relUserStoryRepository.delete(r));
	}


}
