package com.cinema.cinemaparadiso.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.repository.ArtistRepository;

@Service
public class ArtistService {

	private ArtistRepository artistRepository;

	@Autowired
	private UserService userService;

	@Autowired
	public ArtistService(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	public Iterable<Artist> list() {
		return artistRepository.findAll();
	}

	public void createArtist(Artist artist){
	       saveArtist(artist);
	        

	    }
	
	@Transactional
	public void saveArtist(Artist artist) throws DataAccessException{

			artistRepository.save(artist);	
		
	}
	
	
	@Transactional
	public void deleteArtist(Integer artistId) throws DataAccessException{
			artistRepository.deleteById(artistId);	
		
	}
	
	@Transactional
	public void editArtist(Integer artistId) throws DataAccessException{
			Artist artist = findArtistById(artistId);
			artistRepository.save(artist);	
		
	}
	
	@Transactional(readOnly = true)
	public Artist findArtistById(int id) throws DataAccessException {
		return artistRepository.findById(id).get();
	}

	@Transactional(readOnly = true)
	public Artist findArtistByUsername(String username) throws DataAccessException {
		return artistRepository.findByUsername(username);
	}

}
