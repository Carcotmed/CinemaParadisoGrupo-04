package com.cinema.cinemaparadiso.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.Story;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.repository.AuthoritiesRepository;
import com.cinema.cinemaparadiso.repository.WriterRepository;

@Service
public class WriterService {
	@Autowired
	private WriterRepository writerRepository;
	
	@Autowired
    private AuthoritiesRepository authoritiesRepository;

	@Autowired
	private UserService userService;

	@Autowired
	public WriterService(WriterRepository writerRepository) {
		this.writerRepository = writerRepository;
	}

	public List<Writer> list() {
		List<Writer> writers = new ArrayList<>();
		writerRepository.findAll().forEach(w->writers.add(w));
		return writers;
	}
	
	@Transactional(readOnly = true)
	public Writer findWriterById(int id) throws DataAccessException {
		return writerRepository.findById(id).get();
	}

	public void createWriter(Writer writer){
		userService.createUser(writer.getUser());
		 Authorities authorities = new Authorities(writer.getUser().getUsername(),"writer");
	     authoritiesRepository.save(authorities);
	    saveWriter(writer);
	        

	    }
	@Transactional
	public void saveWriter(Writer writer) throws DataAccessException{

			writerRepository.save(writer);	
		
	}
	
	@Transactional
	public List<Story> findMyStories(Integer writerId){
		return this.writerRepository.findMyStories(writerId);
	}
	
	@Transactional(readOnly = true)
	public Writer getPrincipal(){
		Writer res = null;
		
		User currentUser = userService.getPrincipal();
		if(currentUser != null) {
			Optional<Writer> optionalWriter = writerRepository.findByUserUsername(currentUser.getUsername());
			if(optionalWriter.isPresent()) {
				res = optionalWriter.get();
			}
		}
		return res;
	}
	
	@Transactional
	public void editWriter(Writer writer) throws DataAccessException{
			Writer writer2 = findWriterById(writer.getId());
			writer2.setId(writer.getId());
			writer2.setName(writer.getName());
			writer2.setSurName(writer.getSurName());
			writer2.setSkills(writer.getSkills());
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
		
		
		return writerRepository.findUserByWriterUsername(findWriterById(writerId)
				.getUser().getUsername()).get();
	}
	
	
	

}

