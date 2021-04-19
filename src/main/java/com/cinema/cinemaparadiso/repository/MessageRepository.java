package com.cinema.cinemaparadiso.repository;


import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message,Integer>{

	@Query("SELECT ALL m FROM Message m WHERE m.emisor.username = :usernameQuery")
	public Iterable<Message> findByEmisorUsername(@Param("usernameQuery") String username);

	@Query("SELECT ALL m FROM Message m WHERE m.receptor.username = :usernameQuery")
	public Iterable<Message> findByReceptorUsername(@Param("usernameQuery") String username);

	@Query("SELECT m From Message m WHERE (m.body = ?1 AND m.receptor.username = ?2 AND m.emisor.username = ?3)")
	public Optional<Message> requestExist(@Param("body") String body,@Param("receptor") String receptor,@Param("emisor") String emisor);

	
	@Query("SELECT m FROM Message m WHERE m.emisor.username = :usernameQuery")
	public List<Message> findAllMessagesSents(@Param("usernameQuery") String username);
	
	@Query("SELECT m FROM Message m WHERE m.receptor.username = :usernameQuery")
	public List<Message> findAllMessagesReceived(@Param("usernameQuery") String username);

	@Transactional
	@Modifying
	@Query("DELETE FROM Message m WHERE m.story.id = :storyId")
	public Object deleteAllByStoryId(@Param("storyId") Integer storyId);
	
}
