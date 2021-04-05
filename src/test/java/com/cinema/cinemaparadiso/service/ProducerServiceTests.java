package com.cinema.cinemaparadiso.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Producer;

@SpringBootTest
@Sql("/db/test.sql")
@Transactional
public class ProducerServiceTests {
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private UserService userService;

	/*
    @Test
    public void shouldExistProducerWithUsername(){
		assertThat(producerService.existeProducerByUsername("adminTest")).isTrue();
    }
    @Test
    public void shouldNotExistProducerWithUsername(){
		assertThat(producerService.existeProducerByUsername("fakeUser")).isFalse();
    }

    @Test
    public void shouldCountProducers(){
        long count = producerService.countProducers();
		assertThat(count).isEqualTo(3L);
    }

    @Test
    public void shouldListProducers(){
        List<Producer> list = (List<Producer>) producerService.list();
		assertThat(list.size()).isEqualTo(3);
		assertThat(list.stream().anyMatch(p -> p.getUser().getUsername().equals("adminTest") &&
				p.getDescription().equals("Productor exitoso y feliz con ganas de trabajar con un equipo de trabajo apasionado por el cine de terror") &&
				p.getNif().equals("12345678D")
				)).isEqualTo(true);
    }
    
    @Test
    public void shouldFindProducerByNif() {
    	Producer producer = producerService.getProducerByNif("12345678D");
    	assertThat(producer.getUser().getUsername()).isEqualTo("adminTest");
    	assertThat(producer.getDescription()).isEqualTo("Productor exitoso y feliz con ganas de trabajar con un equipo de trabajo apasionado por el cine de terror");
    }
    
    @Test
    public void shouldFindProducerByUsername() {
    	Producer producer = producerService.getProducerByUsername("adminTest");
    	assertThat(producer.getUser().getUsername()).isEqualTo("adminTest");
    	assertThat(producer.getDescription()).isEqualTo("Productor exitoso y feliz con ganas de trabajar con un equipo de trabajo apasionado por el cine de terror");
    }
    /*
    @Test
    public void shouldSaveProducer() {
    	Producer producer = new Producer();
    	producer.setDescription("Description");
    	producer.setNif("87654321P");
    	producer.setUser(userService.getUserByUsername("admin"));
    	assertThat(producerService.countProducers()).isEqualTo(3);
    	producerService.saveProducer(producer);
    	assertThat(producerService.countProducers()).isEqualTo(4);
    	assertThat(producerService.getProducerByUsername("admin").getNif()).isEqualTo("87654321P");
    }
    
    @Test
    public void shouldNotSaveIncorrectProducer() {
    	Producer producer = new Producer();
    	producer.setDescription("Description");
    	producer.setNif("876543P1");
    	producer.setUser(userService.getUserByUsername("admin"));
    	Boolean errorHappened = false;
    	assertThat(producerService.countProducers()).isEqualTo(3);
    	try {
    		producerService.saveProducer(producer);
    		}catch(RuntimeException e) {errorHappened=true;};
    	assertThat(errorHappened).isTrue();
    }
    
    @Test
    public void shouldDeleteProducer() {
    	assertThat(producerService.countProducers()).isEqualTo(3);
    	producerService.deleteProducer(producerService.getProducerByUsername("adminTest"));
    	assertThat(producerService.countProducers()).isEqualTo(2);
    	assertThat(((List<Producer>)producerService.list()).stream().filter(p->p.getUser().getUsername().equals("adminTest")).count()).isEqualTo(0);
    }
*/
}
