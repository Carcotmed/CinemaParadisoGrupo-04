package com.cinema.cinemaparadiso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.repository.AuthoritiesRepository;
import com.cinema.cinemaparadiso.repository.ProducerRepository;

@Service
public class ProducerService {
    
    @Autowired
    private ProducerRepository producerRepository;
    
    @Autowired
	private AuthoritiesRepository authoritiesRepository;
    
    @Autowired
    private UserService userService;
    
    public List<Producer> list() {
		List<Producer> producers = new ArrayList<>();
		producerRepository.findAll().forEach(w -> producers.add(w));
		return producers;
	}

	@Transactional(readOnly = true)
	public Producer findProducerById(int id) throws DataAccessException {
		return producerRepository.findById(id).get();
	}

	public void createProducer(Producer producer) {
		userService.createUser(producer.getUser());
		Authorities authorities = new Authorities(producer.getUser().getUsername(), "producer");
		authoritiesRepository.save(authorities);
		saveProducer(producer);

	}

	@Transactional
	public void saveProducer(Producer producer) throws DataAccessException {
		producerRepository.save(producer);
	}

	@Transactional(readOnly = true)
	public Producer getPrincipal() {
		Producer res = null;

		User currentUser = userService.getPrincipal();
		if (currentUser != null) {
			Optional<Producer> optionalProducer = producerRepository.findByUserUsername(currentUser.getUsername());
			if (optionalProducer.isPresent()) {
				res = optionalProducer.get();
			}
		}
		return res;
	}

	@Transactional
	public void editProducer(Producer producer) throws DataAccessException {
		Producer producer2 = findProducerById(producer.getId());
		producer2.setId(producer.getId());
		producer2.setName(producer.getName());
		producer2.setSurName(producer.getSurName());
		producer2.setSkills(producer.getSkills());
		producer2.setDescription(producer.getDescription());
		producer2.setPhoto(producer.getPhoto());
		producer2.setUser(findMyUser(producer.getId()));
		saveProducer(producer2);
	}

	@Transactional
	public Boolean isActualProducer(Integer producerId) {
		Producer producer = findProducerById(producerId);
		Producer actualProducer = getPrincipal();

		return producer.equals(actualProducer);
	}

	@Transactional
	public User findMyUser(Integer producerId) {

		return producerRepository.findUserByProducerUsername(findProducerById(producerId).getUser().getUsername()).get();
	}

	@Transactional
	public void deleteProducer(Integer producerId) {
		User user = findMyUser(producerId);
		producerRepository.delete(findProducerById(producerId));
		userService.deleteUser(user);
	}

    

}

