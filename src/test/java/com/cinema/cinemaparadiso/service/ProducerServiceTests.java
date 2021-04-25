package com.cinema.cinemaparadiso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Producer;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.User;
import com.cinema.cinemaparadiso.service.exceptions.UserUniqueException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@SpringBootTest
@Sql("/db/testing-data/producerServiceTests/testing-data.sql")
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProducerServiceTests {
	
	@Autowired
	ProducerService producerService;

    @Test
    @Order(1)
    public void shouldList(){
		assertThat(producerService.list().size()).isEqualTo(5);
    }

    @Test
    @Order(2)
    public void shouldFindProducerById() {
		assertThat(producerService.findProducerById(1)).isEqualTo(
			new Producer(
				new User("FrancisHolder",
				"$2y$10$UN0qXXYHTvg7wH.4hJntxOUuGcyamkkZmlzyHOWiVa.GEjbZ95Pai",
				"lacus.Nulla@ametultricies.ca")
			,"Leonard Photography",
			"Empresa productora de peliculas, buscamos artistas nuevos en el sector",
			1,"Horton","https://image.flaticon.com/icons/png/512/183/183349.png"));
    }

    @Test
    @Order(3)
    public void shouldBeUniqueUsername() {
    	assertTrue(producerService.isUniqueUsername("usernameInventado"));
    }

    @Test
    @Order(4)
    public void shouldCreateProducer() {
    	Producer producer = new Producer(
				new User("producerCreado",
				"$2y$10$UN0qXXYHTvg7wH.4hJntxOUuGcyamkkZmlzyHOWiVa.GEjbZ95Pai",
				"lacus.Nulla@ametultricies.ca")
			,"Leonard Photography",
			"Empresa productora de peliculas, buscamos artistas nuevos en el sector",
			6,"Horton","https://image.flaticon.com/icons/png/512/183/183349.png");
    	try {
			producerService.createProducer(producer);
			assertTrue(true);
		} catch (UserUniqueException e) {
			assertTrue(false);
		}
    	assertThat(producerService.findProducerByUsername("producerCreado")).isEqualTo(producer);
    }

    @Test
    @Order(5)
    public void shouldSaveProducer() {
    	Producer producer = producerService.findProducerById(1);
    	String name = "nombre de prueba";
    	producer.setName(name);
    	producerService.saveProducer(producer);
    	assertThat(producerService.findProducerById(1)).isEqualTo(producer);
    }

    @Test
    @Order(6)
	@WithMockUser(username="HayesBenton",authorities={"producer"})
    public void shouldGetPrincipal() {
    	assertThat(producerService.getPrincipal()).isEqualTo(
    			new Producer(
    					new User("HayesBenton",
    					"$2y$10$fuJyFOVeQ0ubEhss.tAh1OnEcEDEU6IaNyHNobGV/7rzxCYSlRsgK",
    					"dolor@erat.com")
    				,"Gatfield Photography",
    				"Empresa productora de peliculas, buscamos artistas nuevos en el sector",
    				5,"Kline","https://image.flaticon.com/icons/png/512/183/183349.png"));
    }

    @Test
    @Order(7)
    public void shouldEditProducer() {
    	Producer producer = producerService.findProducerById(2);
    	String name = "nombre de prueba";
    	producer.setName(name);
    	producerService.editProducer(producer);
    	assertThat(producerService.findProducerById(2)).isEqualTo(producer);
    }

    @Test
    @Order(8)
    public void shouldfindMyprojects() {
    	assertThat(producerService.findMyprojects(1)).contains(
			new Project("Producciones Sevilla", "Creando contenido desde hace 17 años, buscamos nuevos miembros", Genre.ACCION, 1, "JarrodHuffman", "https://media.istockphoto.com/vectors/project-management-icon-flat-design-vector-id585291474?b=1&k=6&m=585291474&s=170667a&w=0&h=PsqYKLdR6SBC4bmLmhPCx3vvzvHiaKlR15FgyPNVQaE="));
    }

    @Test
    @Order(9)
	@WithMockUser(username="FrancisHolder",authorities={"producer"})
    public void shouldBeActualProducer() {
    	assertThat(producerService.isActualProducer(1)).isTrue();
    }

    @Test
    @Order(10)
	@WithMockUser(username="FrancisHolder",authorities={"producer"})
    public void shouldFindMyUser() {
    	assertThat(producerService.findMyUser(1)).isEqualTo(
			new User("FrancisHolder", "$2y$10$UN0qXXYHTvg7wH.4hJntxOUuGcyamkkZmlzyHOWiVa.GEjbZ95Pai", "lacus.Nulla@ametultricies.ca"));
    }

    @Test
    @Order(11)
    public void shouldDeleteProducer() {
    	assertThat(producerService.findProducerById(1).getUser().isEnabled()).isTrue();
    	producerService.deleteProducer(1);
    	assertThat(producerService.findProducerById(1).getUser().isEnabled()).isFalse();
    }

    @Test
    @Order(12)
    public void shouldActivateProducer() {
    	assertThat(producerService.findProducerById(3).getUser().isEnabled()).isFalse();
    	producerService.activateProducer(3);
    	assertThat(producerService.findProducerById(3).getUser().isEnabled()).isTrue();
    }

    @Test
    @Order(13)
    public void shouldFindProducerByUsername() {
    	assertThat(producerService.findProducerByUsername("HayesBenton")).isEqualTo(
    			new Producer(
    					new User("HayesBenton",
    					"$2y$10$fuJyFOVeQ0ubEhss.tAh1OnEcEDEU6IaNyHNobGV/7rzxCYSlRsgK",
    					"dolor@erat.com")
    				,"Gatfield Photography",
    				"Empresa productora de peliculas, buscamos artistas nuevos en el sector",
    				5,"Kline","https://image.flaticon.com/icons/png/512/183/183349.png"));
    }
}
