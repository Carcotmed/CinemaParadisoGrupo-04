package com.cinema.cinemaparadiso.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cinema.cinemaparadiso.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,String>{
	
	List<User> findByEnabled(Boolean enabled);
    
}
