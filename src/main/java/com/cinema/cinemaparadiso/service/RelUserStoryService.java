package com.cinema.cinemaparadiso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.RelUserStory;
import com.cinema.cinemaparadiso.repository.RelUserStoryRepository;

@Service
public class RelUserStoryService {

	@Autowired
	private RelUserStoryRepository relUserStoryRepository;


	





	@Transactional
	public void save(RelUserStory relUserStory) throws DataAccessException{
				relUserStoryRepository.save(relUserStory);	
	}
	
	@Transactional
	public void deleteLike(RelUserStory rel) throws DataAccessException{
			relUserStoryRepository.delete(rel);
		
	}

	public Long count(Integer idStory) {
		try {

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

}
