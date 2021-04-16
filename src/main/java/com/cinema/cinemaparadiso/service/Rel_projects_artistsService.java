package com.cinema.cinemaparadiso.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_projects_artists;
import com.cinema.cinemaparadiso.repository.Rel_projects_artistsRepository;

@Service
public class Rel_projects_artistsService {

	private Rel_projects_artistsRepository rel_projects_artistsRepository;

	@Autowired
	public Rel_projects_artistsService(Rel_projects_artistsRepository rel_projects_artistsRepository) {
		this.rel_projects_artistsRepository = rel_projects_artistsRepository;
	}
	



	public void create(Rel_projects_artists rel_projects_artists){
		if(rel_projects_artists.getArtist_id()==null || rel_projects_artists.getProject_id()==null) {
			throw new IllegalAccessError();
		}else {
	       save(rel_projects_artists);
		}
	}

	@Transactional
	public void save(Rel_projects_artists rel_projects_artists) throws DataAccessException{
		System.out.println("*************************************************************************************2");
		System.out.println(rel_projects_artists.getId()+"-"+rel_projects_artists.getArtist_id()+"-"+rel_projects_artists.getProject_id());
			rel_projects_artistsRepository.save(rel_projects_artists);	
	}
	
	@Transactional
	public void delete(Integer rel_projects_artistsId) throws DataAccessException{
			rel_projects_artistsRepository.deleteById(rel_projects_artistsId);	
		
	}

	@Transactional(readOnly = true)
	public Rel_projects_artists findById(int id) throws DataAccessException {
		return rel_projects_artistsRepository.findById(id).get();
	}
	
	public Rel_projects_artists findRelation(Integer artistId, Integer projectId){
		Rel_projects_artists relacion = rel_projects_artistsRepository.findRelacion(artistId, projectId);
	       return relacion;
	}
	
	@Transactional
	public Long count(){
		return this.rel_projects_artistsRepository.count();
	}

	public Long count(Integer projectId) {
		return this.rel_projects_artistsRepository.countRelationsProject(projectId);
	}


}
