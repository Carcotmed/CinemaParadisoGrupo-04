package com.cinema.cinemaparadiso.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.repository.ArtistRepository;
import com.cinema.cinemaparadiso.repository.AuthoritiesRepository;
import com.cinema.cinemaparadiso.repository.UserRepository;

@Service
public class ArtistService {
	@Autowired
	private ArtistRepository artistRepository;

	@Autowired
    private UserRepository userRepository;
	 
	@Autowired
    private AuthoritiesRepository authoritiesRepository;
	
	@Autowired
    private UserService userService;

	@Autowired
	public ArtistService(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	public List<Artist> list() {
		List<Artist> artist = new ArrayList<>();
		artistRepository.findAll().forEach(a -> artist.add(a));
		return artist;
	}
	
	public List<Artist> listProArtist() {
		List<Artist> artistasPro = new ArrayList<>();
		artistasPro = artistRepository.findProArtists();
		return artistasPro;
	}
	
	public List<Artist> listNoProArtist() {
		List<Artist> artistasNoPro = new ArrayList<>();
		artistasNoPro = artistRepository.findNoProArtists();
		return artistasNoPro;
	}

	//FUTURA MEJORA
	public List<Project> projectHistory(Integer id) {
		List<Project> projectsHistory = new ArrayList<>();
		projectsHistory = artistRepository.findProjectsHistory(id);
		return projectsHistory;
	}


public void createArtist(Artist artist){
		userService.createUser(artist.getUser());
		 Authorities authorities = new Authorities(artist.getUser().getUsername(),"artist");
	     authoritiesRepository.save(authorities);
	     artist.setPro(false);
	    saveArtist(artist);
	       

	    }
	
	public List<Project> findMyProjects(Integer artistId){
		List<Project> myProjects = new ArrayList<>();
		myProjects = artistRepository.findMyProjects(artistId);
		return myProjects;
	}
	
	@Transactional
	public void saveArtist(Artist artist) throws DataAccessException{

			artistRepository.save(artist);	
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
	
	//COMPROBAR ARTISTA LOGUEADO
	
	@Transactional(readOnly = true)
	public Artist getPrincipal(){
		Artist res = null;
		
		User currentUser = userService.getPrincipal();
		if(currentUser != null) {
			Optional<Artist> optionalArtist = artistRepository.findByUserUsername(currentUser.getUsername());
			if(optionalArtist.isPresent()) {
				res = optionalArtist.get();
			}
		}
		return res;
	}
	
	@Transactional(readOnly = true)
	public Boolean isPrincipalArtist() {
		return getPrincipal() != null;
	}

	public long count() {
		return this.artistRepository.count();
	}

}
