package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Role;

@Repository
public interface ArtistRepository extends CrudRepository<Artist,Integer>{
	
	
	
	
	@Query("SELECT artist FROM Artist artist WHERE artist.user.username =: username")
	public Artist findByUsername(@Param("username") String username);
	
	@Query("SELECT artist FROM Artist artist WHERE artist.pro = 1")
	public List<Artist> findProArtists();
	
	@Query("SELECT artist FROM Artist artist WHERE artist.pro = 0")
	public List<Artist> findNoProArtists();
	
	@Query("SELECT artist FROM Artist artist WHERE artist.role =: filterRole AND artist.user.username LIKE '%filterName%'")
	public List<Artist> findArtistByRoleAndUsername(@RequestParam("filterRole") Role filterRole,@RequestParam("filterName") String filterName);
    
}
