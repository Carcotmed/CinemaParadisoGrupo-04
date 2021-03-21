package com.cinema.cinemaparadiso.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist,Integer>{
	
	
	
	
	@Query("SELECT artist FROM Artist artist WHERE artist.user.username =: username")
	public Artist findByUsername(@Param("username") String username);
    
}
