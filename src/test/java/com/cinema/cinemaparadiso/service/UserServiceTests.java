package com.cinema.cinemaparadiso.service;

import static org.assertj.core.api.Assertions.assertThat;
import com.cinema.cinemaparadiso.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private UserService userService;
	
	// Cuando se termine de hacer la funcionalidad y se concrete mejor el data
	// se descomenta estos comentarios 

    @Test
    public void shouldCountUsers(){
		/* 
        long count = userService.countUsers();
		assertThat(count).isEqualTo(5L);
		*/
    }

	@Test
	public void shouldCreateUser() {
		/*
        User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setEnabled(true);
        userService.createUser(user);
		assertThat(userService.countUsers()).isEqualTo(5L);
		*/
	}

}
