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
	private Rel_projects_storyService rel_projects_storyService;


	@Autowired
	public StoryService(StoryRepository storyRepository) {
		this.storyRepository = storyRepository;
	}
	
	@Transactional
	public void editStory(Story story) throws DataAccessException{
			Story story2 = findStoryById(story.getId());
			story2.setId(story.getId());
			story2.setTitle(story.getTitle());
			story2.setBody(story.getBody());
			story2.setGenre(story.getGenre());
			System.out.println(story2);
			saveStory(story2);	
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
	@Transactional
	public Boolean isMyWriter(Integer storyId) {
		Writer writerHistory = findMyWriter(storyId);
		Writer actualWriter = writerService.getPrincipal();
		
		return writerHistory.equals(actualWriter);
	}
	
	@Transactional
	public void deleteStory(Integer storyId) {
		rel_story_writersService.deleteByStoryId(storyId);
		rel_projects_storyService.deleteByStoryId(storyId);
		storyRepository.delete(findStoryById(storyId));
	}
	

}
