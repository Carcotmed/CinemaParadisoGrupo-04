package com.cinema.cinemaparadiso.service;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_projects_artists;
import com.cinema.cinemaparadiso.model.Rel_projects_story;
import com.cinema.cinemaparadiso.repository.Rel_projects_artistsRepository;
import com.cinema.cinemaparadiso.repository.Rel_projects_storyRepository;

@Service
public class Rel_projects_storyService {

	private Rel_projects_storyRepository rel_projects_storyRepository;

	@Autowired
	public Rel_projects_storyService(Rel_projects_storyRepository rel_projects_storyRepository) {
		this.rel_projects_storyRepository = rel_projects_storyRepository;
	}
	



	public void create(Rel_projects_story rel_projects_story){
		if(rel_projects_story.getProject_id()==null || rel_projects_story.getProject_id()==null) {
			throw new IllegalAccessError();
		}else {
	       save(rel_projects_story);
		}
	}

	@Transactional
	public void save(Rel_projects_story rel_projects_story) throws DataAccessException{
			rel_projects_storyRepository.save(rel_projects_story);	
	}
	
	@Transactional
	public void delete(Integer rel_projects_storyId) throws DataAccessException{
			rel_projects_storyRepository.deleteById(rel_projects_storyId);	
		
	}

	@Transactional(readOnly = true)
	public Rel_projects_story findById(int id) throws DataAccessException {
		return rel_projects_storyRepository.findById(id).get();
	}
	
	public Rel_projects_story findRelation(Integer storyId, Integer projectId){
		Rel_projects_story relacion = rel_projects_storyRepository.findRelacion(projectId, storyId);
	       return relacion;
	}
	
	@Transactional
	public Integer countByProjectId(Integer projectId){
		return this.rel_projects_storyRepository.findRelacionesByProject(projectId).size();
	}
	
	@Transactional
	public Rel_projects_story findByProjectId(Integer projectId){
		return this.rel_projects_storyRepository.findRelacionesByProject(projectId).get(0);
	}
	
	@Transactional
	public Long count(){
		return this.rel_projects_storyRepository.count();
	}



}
