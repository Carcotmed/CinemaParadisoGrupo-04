package com.cinema.cinemaparadiso.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Rel_projects_producers;
import com.cinema.cinemaparadiso.repository.Rel_projects_producersRepository;

@Service
public class Rel_projects_producersService {

	private Rel_projects_producersRepository rel_projects_producersRepository;

	@Autowired
	public Rel_projects_producersService(Rel_projects_producersRepository rel_projects_producersRepository) {
		this.rel_projects_producersRepository = rel_projects_producersRepository;
	}
	



	public void create(Rel_projects_producers rel_projects_producers){
		if(rel_projects_producers.getProducer_id()==null || rel_projects_producers.getProject_id()==null) {
			System.out.println("*************************************************************************************");
			throw new IllegalAccessError();
		}else {
	       save(rel_projects_producers);
		}
	}

	@Transactional
	public void save(Rel_projects_producers rel_projects_producers) throws DataAccessException{
		System.out.println("*************************************************************************************2");
			System.out.println(rel_projects_producers.getId()+"-"+rel_projects_producers.getProducer_id()+"-"+rel_projects_producers.getProject_id());
			rel_projects_producersRepository.save(rel_projects_producers);	
		System.out.println("*************************************************************************************3");

	}
	
	@Transactional
	public void delete(Integer rel_projects_producersId) throws DataAccessException{
			rel_projects_producersRepository.deleteById(rel_projects_producersId);	
		
	}

	@Transactional(readOnly = true)
	public Rel_projects_producers findById(int id) throws DataAccessException {
		System.out.println("*************************************************************************************4");

		return rel_projects_producersRepository.findById(id).get();
		
	}
	
	public Rel_projects_producers findRelation(Integer producerId, Integer projectId){
		System.out.println("*************************************************************************************5");

		Rel_projects_producers relacion = rel_projects_producersRepository.findRelacion(producerId, projectId);
		System.out.println("*************************************************************************************6");

	       return relacion;
	}
	
	@Transactional
	public Long count(){
		return this.rel_projects_producersRepository.count();
	}

	public Long count(Integer projectId) {
		System.out.println("*************************************************************************************7");

		return this.rel_projects_producersRepository.countRelationsProject(projectId);
		
	}


	public void deleteByProjectId(Integer projectId) {
		rel_projects_producersRepository.deleteByProjectId(projectId);
	}



}
