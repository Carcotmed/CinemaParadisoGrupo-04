package com.cinema.cinemaparadiso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;

@Repository
public interface UserRepository extends CrudRepository<User,String>{
	
	List<User> findByEnabled(Boolean enabled);
	
	@Query("SELECT artist FROM Artist artist WHERE artist.user.username = :username")
	public Optional<Artist> findArtistByUserUsername(String username);
	
	@Query("SELECT producer FROM Producer producer WHERE producer.user.username = :username")
	public Optional<Producer> findProducerByUserUsername(String username);
	
	@Query("SELECT writer FROM Writer writer WHERE writer.user.username = :username")
	public Optional<Writer> findWriterByUserUsername(String username);
	
	
	
	
    
}
