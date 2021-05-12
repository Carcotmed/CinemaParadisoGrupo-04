package com.cinema.cinemaparadiso.service;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Project;
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
	private RelUserStoryService relUserStoryService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;


	@Autowired
	public StoryService(StoryRepository storyRepository) {
		this.storyRepository = storyRepository;
	}
	
	@Transactional
	public void editStory(Story story){
			Story story2 = findStoryById(story.getId());
			story2.setId(story.getId());
			story2.setTitle(story.getTitle());
			story2.setBody(story.getBody());
			story2.setGenre(story.getGenre());
			story2.setPhoto(story.getPhoto());
			saveStory(story2);	
  }
	

	public void createStory(Story story){
		   story.setNumLikes(relUserStoryService.count(story.getId()));
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
		relUserStoryService.deleteRelationsUserStoriesByStory(storyId);
		messageService.deleteAllByStoryId(storyId);
		commentService.deleteByStory(storyId);
		storyRepository.delete(findStoryById(storyId));
	}

	@Transactional
	@Modifying
	public void makeStorySponsored(Integer storyID) {
		storyRepository.makeStorySponsored(storyID);
	}

	public List<Story> findAllSponsoredStories() {
		return storyRepository.findAllSponsoredStories();
	}
	

	public Iterable<Story> sortByLikes(Iterable<Story> stories){
		Map<Story,Long> storyLikes = new HashMap<>();
		for(Story s : stories) {
			
			storyLikes.put(s, relUserStoryService.count(s.getId()));
		}
		LinkedHashMap<Story, Long> sortedMap = new LinkedHashMap<>();
		storyLikes.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		
		Iterable<Story> res = sortedMap.keySet();
		
		return res;
		
		
	}
	
	public List<Story> sortByLikesList(List<Story> stories){
		Map<Story,Long> storyLikes = new HashMap<>();
		for(Story s : stories) {
			
			storyLikes.put(s, relUserStoryService.count(s.getId()));
		}
		LinkedHashMap<Story, Long> sortedMap = new LinkedHashMap<>();
		storyLikes.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		
		List<Story> res = new ArrayList<>();
		for(Story s : sortedMap.keySet()) {
			res.add(s);
		}
		
		return res;
		
		
	}

	@Transactional
	public List<Project> findMyProjects(Integer storyId) {
		return this.storyRepository.findMyProjects(storyId);
	}

	public void transferStoriesByWriterId(Integer writerId) {
		List<Rel_story_writers> rels = rel_story_writersService.findByWriterId(writerId);
		Integer deletedWriterId = userService.findWriterByUserUsername("DeletedUser").get().getId();
		rels.forEach(r->{
			r.setWriter_id(deletedWriterId);
			System.out.println(r);
			rel_story_writersService.save(r);
		});
	}



}
