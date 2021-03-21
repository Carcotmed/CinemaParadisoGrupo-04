package com.cinema.cinemaparadiso.repository;

import com.cinema.cinemaparadiso.model.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String>{
	
	List<User> findByEnabled(Boolean enabled);
    
}
