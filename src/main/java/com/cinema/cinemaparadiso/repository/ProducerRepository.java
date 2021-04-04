package com.cinema.cinemaparadiso.repository;

import com.cinema.cinemaparadiso.model.Producer;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends CrudRepository<Producer,String>{
	
	@Query("SELECT producer FROM Producer producer WHERE producer.user.username = :usernameQuery")
	Producer findByUser(@Param("usernameQuery") String username);

	//List<User> findByEnabled(Boolean enabled);

	Optional<Producer> findByNif(String nif);
    
}
