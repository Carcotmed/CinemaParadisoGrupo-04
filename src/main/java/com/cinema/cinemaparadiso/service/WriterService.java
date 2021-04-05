package com.cinema.cinemaparadiso.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.model.Writer;
import com.cinema.cinemaparadiso.repository.UserRepository;
import com.cinema.cinemaparadiso.repository.WriterRepository;

@Service
public class WriterService {
	@Autowired
	private WriterRepository writerRepository;
	
	

	@Autowired
	private UserRepository userRepository;

	@Autowired
	public WriterService(WriterRepository writerRepository) {
		this.writerRepository = writerRepository;
	}

	public Iterable<Writer> list() {
		return writerRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Writer findWriterById(int id) throws DataAccessException {
		return writerRepository.findById(id).get();
	}

	public void createWriter(Writer writer){
		User user= new User();
    	user.setEmail(writer.getUser().getEmail());
    	user.setEnabled(true);
    	user.setPassword(writer.getUser().getPassword());
    	user.setUsername(writer.getUser().getUsername());
    	userRepository.save(user);
	    writerRepository.save(writer);
	        

	    }
}
