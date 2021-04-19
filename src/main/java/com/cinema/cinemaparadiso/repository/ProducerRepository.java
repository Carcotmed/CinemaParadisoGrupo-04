package com.cinema.cinemaparadiso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.User;

@Repository
public interface ProducerRepository extends CrudRepository<Producer,Integer>{
	
	@Query("SELECT producer FROM Producer producer WHERE producer.user.username = :username")
	public Optional<Producer> findByUserUsername(String username);
	
	@Query("SELECT user FROM User user WHERE user.username = :username")
	public Optional<User> findUserByProducerUsername(String username);
	
	@Query("SELECT project FROM Project project INNER JOIN Rel_projects_producers rel_projects_producers ON project.id = rel_projects_producers.project_id AND rel_projects_producers.producer_id = :producerId")
	public List<Project> findMyProjects(@Param("producerId") Integer producerId);
    
}
