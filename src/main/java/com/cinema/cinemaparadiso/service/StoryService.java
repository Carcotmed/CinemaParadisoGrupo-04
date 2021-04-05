package com.cinema.cinemaparadiso.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.repository.StoryRepository;

@Service
public class StoryService {

	private StoryRepository storyRepository;

	@Autowired
	public StoryService(StoryRepository storyRepository) {
		this.storyRepository = storyRepository;
	}

	public void createStory(Story story){
	       saveStory(story);
	}
	
	@Transactional
	public void saveStory(Story story) throws DataAccessException{

			storyRepository.save(story);	
		
	}

	public List<Story> list() {
		List<Story> story = new ArrayList<>();
		storyRepository.findAll().forEach(s->story.add(s));
		return story;
	}
	
	@Transactional(readOnly = true)
	public Story findStoryById(int id) throws DataAccessException {
		return storyRepository.findById(id).get();
	}

}
