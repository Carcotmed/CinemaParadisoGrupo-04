package com.cinema.cinemaparadiso.repository;

import com.cinema.cinemaparadiso.model.Authorities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AuthoritiesRepository extends CrudRepository<Authorities,Integer>{

	@Query("SELECT authority FROM Authorities authority WHERE authority.username = :usernameQuery")
	Authorities findByUsername(@Param("usernameQuery")String username);
    
}
