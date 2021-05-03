package com.cinema.cinemaparadiso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_story_writers;
import com.cinema.cinemaparadiso.repository.Rel_story_writersRepository;

@Service
public class Rel_story_writersService {

	private Rel_story_writersRepository rel_story_writersRepository;

	@Autowired
	public Rel_story_writersService(Rel_story_writersRepository rel_story_writersRepository) {
		this.rel_story_writersRepository = rel_story_writersRepository;
	}

	public void create(Rel_story_writers rel_story_writers) {
		if (rel_story_writers.getWriter_id() == null || rel_story_writers.getStory_id() == null) {
			throw new IllegalAccessError();
		} else {
			save(rel_story_writers);
		}
	}

	@Transactional
	public void save(Rel_story_writers rel_story_writers) throws DataAccessException {
		rel_story_writersRepository.save(rel_story_writers);
	}

	@Transactional
	public void delete(Integer rel_story_writersId) throws DataAccessException {
		rel_story_writersRepository.deleteById(rel_story_writersId);

	}

	@Transactional(readOnly = true)
	public Rel_story_writers findById(int id) throws DataAccessException {
		return rel_story_writersRepository.findById(id).get();
	}

	public Rel_story_writers findRelation(Integer writerId, Integer storyId) {
		Rel_story_writers relacion = rel_story_writersRepository.findRelacion(writerId, storyId);
		return relacion;
	}

	@Transactional
	public Long count() {
		return this.rel_story_writersRepository.count();
	}


	public void deleteByStoryId(Integer storyId) {
		rel_story_writersRepository.deleteByStoryId(storyId);
	}
	
	@Transactional
    public void deleteRelationsWriterStories(Integer writerId) {
    	List<Rel_story_writers> relationsWriterStories = this.rel_story_writersRepository.listRelationsWriterStories(writerId);
    	relationsWriterStories.stream().forEach(r -> this.rel_story_writersRepository.delete(r));
    }

}