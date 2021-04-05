package com.cinema.cinemaparadiso.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_story_writers;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.repository.StoryRepository;

@Service
public class StoryService {

	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	private WriterService writerService;
	
	@Autowired
	private Rel_story_writersService rel_story_writersService;


	@Autowired
	public StoryService(StoryRepository storyRepository) {
		this.storyRepository = storyRepository;
	}
	
	@Transactional
	public void editStory(Integer storyId) throws DataAccessException{
			Story story = findStoryById(storyId);
			storyRepository.save(story);	
  }

	public void createStory(Story story){
	       saveStory(story);
	       
	       Integer idWriter = writerService.getPrincipal().getId();
	       Integer idStory = story.getId();
	       Rel_story_writers rel = new Rel_story_writers();
	       rel.setStory_id(idStory);
	       rel.setWriter_id(idWriter);
	       
	       rel_story_writersService.save(rel);
	       
	       
	       
	}
	
	@Transactional
	public void saveStory(Story story) throws DataAccessException{
			storyRepository.save(story);	
	}
	@Transactional
	public Writer findMyWriter(Integer storyId) {
		return this.storyRepository.findMyWriter(storyId);
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
