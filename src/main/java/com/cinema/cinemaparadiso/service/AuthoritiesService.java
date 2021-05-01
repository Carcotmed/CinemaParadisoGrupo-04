package com.cinema.cinemaparadiso.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.repository.AuthoritiesRepository;

@Service
public class AuthoritiesService {
	
	@Autowired
    private AuthoritiesRepository authoritiesRepository;
	
	@Autowired
    private UserService userService;

	@Autowired
	public AuthoritiesService(AuthoritiesRepository authoritiesRepository) {
		this.authoritiesRepository = authoritiesRepository;
	}
	
	@Transactional
	public void deleteAuthorities(String username) {
		Authorities authorities = this.authoritiesRepository.findByUsername(username);
		this.authoritiesRepository.delete(authorities);
	}
	
	@Transactional
	public void createAuthorities(String username, String rol) {
		Authorities authorities = new Authorities();
		authorities.setUsername(username);
		authorities.setAuthority(rol);
		this.authoritiesRepository.save(authorities);
	}

	

}
