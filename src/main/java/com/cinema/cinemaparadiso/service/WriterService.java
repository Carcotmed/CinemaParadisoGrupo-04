package com.cinema.cinemaparadiso.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.Message;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.repository.AuthoritiesRepository;
import com.cinema.cinemaparadiso.repository.MessageRepository;
import com.cinema.cinemaparadiso.repository.UserRepository;
import com.cinema.cinemaparadiso.repository.WriterRepository;
import com.cinema.cinemaparadiso.service.exceptions.UserUniqueException;

@Service
public class WriterService {
	@Autowired
	private WriterRepository writerRepository;
	

	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@Autowired
	private MessageRepository messageRepository;

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	@Autowired
	private StoryService storyService;

	@Autowired
	private MessageService messageService;

	@Autowired
	public WriterService(WriterRepository writerRepository) {
		this.writerRepository = writerRepository;
	}

	public List<Writer> list() {
		List<Writer> writers = new ArrayList<>();
		writerRepository.findAll().forEach(w -> writers.add(w));
		List<Writer> writersEnabled = writers.stream().filter(w->w.getUser().isEnabled()).collect(Collectors.toList());
		return writersEnabled;
	}

	@Transactional(readOnly = true)
	public Writer findWriterById(int id) throws DataAccessException {
		return writerRepository.findById(id).get();
	}
	
	public Boolean isUniqueUsername(String username) {
		Boolean res = null;
		Optional<User> optionalUser = this.writerRepository.findUserByWriterUsername(username);
		res = !optionalUser.isPresent();
		return res;
	}
	
	@Transactional(rollbackFor = UserUniqueException.class)
	public void createWriter(Writer writer) throws UserUniqueException {
		User user = writer.getUser();
		String nuevoUsername = user.getUsername();
		if(!isUniqueUsername(nuevoUsername)) {
			throw new UserUniqueException();
		}
		else {
		userService.createUser(user);
		Authorities authorities = new Authorities(user.getUsername(), "writer");
		authoritiesRepository.save(authorities);
		saveWriter(writer);
		}

	}

	@Transactional
	public void saveWriter(Writer writer) throws DataAccessException {

		writerRepository.save(writer);

	}

	@Transactional
	public List<Story> findMyStories(Integer writerId) {
		return this.writerRepository.findMyStories(writerId);
	}

	@Transactional(readOnly = true)
	public Writer getPrincipal() {
		Writer res = null;

		User currentUser = userService.getPrincipal();
		if (currentUser != null) {
			Optional<Writer> optionalWriter = writerRepository.findByUserUsername(currentUser.getUsername());
			if (optionalWriter.isPresent()) {
				res = optionalWriter.get();
			}
		}
		return res;
	}

	@Transactional
	public void editWriter(Writer writer) throws DataAccessException {
		Writer writer2 = findWriterById(writer.getId());
		writer2.setId(writer.getId());
		writer2.setName(writer.getName());
		writer2.setSurName(writer.getSurName());
		writer2.setDescription(writer.getDescription());
		writer2.setPhoto(writer.getPhoto());
		writer2.setUser(findMyUser(writer.getId()));
		saveWriter(writer2);
	}

	@Transactional
	public Boolean isActualWriter(Integer writerId) {
		Writer writer = findWriterById(writerId);
		Writer actualWriter = getPrincipal();

		return writer.equals(actualWriter);
	}

	@Transactional
	public User findMyUser(Integer writerId) {

		return writerRepository.findUserByWriterUsername(findWriterById(writerId).getUser().getUsername()).get();
	}

	@Transactional
	public void deleteWriter(Integer writerId) {

		User user = findMyUser(writerId);
		user.setEnabled(false);
	}

}
