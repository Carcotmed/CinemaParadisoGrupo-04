package com.cinema.cinemaparadiso.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Artist;
import com.cinema.cinemaparadiso.model.Authorities;
import com.cinema.cinemaparadiso.model.Role;
import com.cinema.cinemaparadiso.model.Skill;
import com.cinema.cinemaparadiso.model.User;


@SpringBootTest
@Sql("/db/data.sql")
@Transactional
public class ArtistServiceTests {
	
	@Autowired
	private ArtistService artistService;

	@Autowired
	private UserService userService;
	
	/*
	@Test
    public void shouldListTotalArtist(){
        Integer totalArtist = this.artistService.list().size();
		assertThat(totalArtist).isEqualTo(8);
   }
	
	@Test
    public void shouldListTotalArtistWithError(){
        Integer totalArtist = this.artistService.list().size();
		assertThat(totalArtist).isNotEqualTo(12);
   }
	
	@Test
    public void shouldListProArtist(){
        Integer proArtists = this.artistService.listProArtist().size();
		assertThat(proArtists).isEqualTo(4);
   }
	
	@Test
    public void shouldListProArtisttWithError(){
        Integer proArtists = this.artistService.listProArtist().size();
		assertThat(proArtists).isNotEqualTo(2);
   }
	
	@Test
    public void shouldListNoProArtist(){
        Integer noProArtists = this.artistService.listNoProArtist().size();
		assertThat(noProArtists).isEqualTo(4);
   }
	
	@Test
    public void shouldListNoProArtistWithError(){
        Integer noProArtists = this.artistService.listNoProArtist().size();
		assertThat(noProArtists).isNotEqualTo(3);
   }

	@Test
    public void shouldfindArtistById() {
		Integer id = 1;
		
		User userCreated = new User();
		userCreated.setUsername("admin0");
		userCreated.setPassword("$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu");
		userCreated.setEnabled(true);
		
		Authorities authorityCreated = new Authorities();
		authorityCreated.setUsername("admin0");
		authorityCreated.setAuthority("admin");
		
		Artist artistCreated = new Artist();
		artistCreated.setDescription("pepitod");
		artistCreated.setName("pepito1");
		artistCreated.setSurName("pepito1sur");
		artistCreated.setId(id);
		artistCreated.setPro(true);
		artistCreated.setSummary("pepito1sum");
		artistCreated.setRole(Role.CAMARA);
		artistCreated.setUser(userCreated);
		
		Artist artistBDD = this.artistService.findArtistById(id);
		assertThat(artistCreated.getDescription()).isEqualTo(artistBDD.getDescription());
		assertThat(artistCreated.getName()).isEqualTo(artistBDD.getName());
		assertThat(artistCreated.getId()).isEqualTo(artistBDD.getId());
		assertThat(artistCreated.getSurName()).isEqualTo(artistBDD.getSurName());
		assertThat(artistCreated.getPro()).isEqualTo(artistBDD.getPro());
		assertThat(artistCreated.getSummary()).isEqualTo(artistBDD.getSummary());
		assertThat(artistCreated.getRole()).isEqualTo(artistBDD.getRole());
		assertThat(artistCreated.getUser().getUsername()).isEqualTo(artistBDD.getUser().getUsername());
	}
	
	
	@Test
    public void shouldfindArtistByIdWithError() {
		
		Integer id = 222;	
		
		Assertions.assertThrows(java.util.NoSuchElementException.class, ()-> this.artistService.findArtistById(id));
		
	}
	
	@Test
	public void shouldDisableArtist(){
		Integer idArtista = 1;
		Artist artistDisabled = this.artistService.findArtistById(idArtista);
		User userDisabled = artistDisabled.getUser();
		
		assertThat(userDisabled.isEnabled()).isEqualTo(true);
		this.userService.disableUser(userDisabled.getUsername());
		assertThat(userDisabled.isEnabled()).isEqualTo(false);
		
	}
	
	@Test
	public void shouldDisableArtistWithError(){
		Integer idArtista = 12131;
		
		Assertions.assertThrows(java.util.NoSuchElementException.class, ()-> this.artistService.findArtistById(idArtista));
	}
	
	

	@Test
	public void shouldCreateArtist() {
		Integer id = 9;
		
		User userCreated = this.userService.findUser("admin0").get();
		
		Artist artistCreated = new Artist();
		artistCreated.setName("Manolo");
		artistCreated.setSurName("Doblado");
		List<Skill> skills = new ArrayList<>();
		skills.add(Skill.DOBLE);
		artistCreated.setSkills(skills);
		artistCreated.setDescription("Amante del cine tailandés");
		artistCreated.setPhoto("https://dam.ngenespanol.com/wp-content/uploads/2019/03/luna-colores-nuevo.png");
		artistCreated.setId(id);
		artistCreated.setRole(Role.ACTOR);
		artistCreated.setSummary("Fervoroso amante de peliculas de combate karateka");
		artistCreated.setPro(true);
		artistCreated.setUser(userCreated);	

		assertThat(this.artistService.count()).isEqualTo(8L);
		this.artistService.saveArtist(artistCreated);
		assertThat(this.artistService.count()).isEqualTo(9L);
	}
	
	@Test
	public void shouldCreateArtistWithError() {
		Integer id = 9;
		
		User userCreated = new User();
		userCreated.setUsername("mdoblado");
		userCreated.setPassword("$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu");
		userCreated.setEnabled(true);
		
		Authorities authorityCreated = new Authorities();
		authorityCreated.setUsername("mdoblado");
		authorityCreated.setAuthority("admin");
		
		Artist artistCreated = new Artist();
		artistCreated.setDescription("Amante del cine tailandés");
		artistCreated.setName("");
		artistCreated.setSurName("Doblado");
		artistCreated.setId(id);
		artistCreated.setPro(true);
		artistCreated.setSummary("Fervoroso amante de peliculas de combate karateka");
		artistCreated.setRole(Role.ACTOR);
		artistCreated.setUser(userCreated);		

		Assertions.assertThrows(javax.validation.ConstraintViolationException.class, ()-> this.artistService.saveArtist(artistCreated));
	}
	
//	@Test
//	public void shouldEditArtist() {
//		Integer id = 1;
//		
//		User userCreated = new User();
//		userCreated.setUsername("admin0");
//		userCreated.setPassword("$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu");
//		userCreated.setEnabled(true);
//		
//		Authorities authorityCreated = new Authorities();
//		authorityCreated.setUsername("admin0");
//		authorityCreated.setAuthority("admin");
//		
//		Artist artistCreated = new Artist();
//		artistCreated.setDescription("pepitoooooood");
//		artistCreated.setName("pepitooooooooo1");
//		artistCreated.setSurName("pepito1sur");
//		artistCreated.setId(id);
//		artistCreated.setPro(true);
//		artistCreated.setSummary("pepito1sum");
//		artistCreated.setRole(Role.CAMERA);
//		artistCreated.setUser(userCreated);
//		
//		Artist artistBDDBeforeUpdate = this.artistService.findArtistById(id);
//		this.artistService.editArtist(id);
//		Artist artistBDDAfterUpdate = this.artistService.findArtistById(id);
//		assertThat(artistBDDBeforeUpdate.getName()).isNotEqualTo(artistBDDAfterUpdate.getName());
//		assertThat(artistBDDBeforeUpdate.getSurName()).isNotEqualTo(artistBDDAfterUpdate.getSurName());
//		assertThat(artistBDDAfterUpdate.getName()).isEqualTo(artistCreated.getName());
//		assertThat(artistBDDAfterUpdate.getSurName()).isEqualTo(artistCreated.getSurName());
//
//	}

	
	@Test
	public void shouldEditArtistWithError() {		
		User userCreated = new User();
		userCreated.setUsername("admin0");
		userCreated.setPassword("$2a$10$gn.RKrqUiPZuOhBeht0amudVq6eDxe4RB5ARGHa5SLJXig4b7Ollu");
		userCreated.setEnabled(true);
		
		Authorities authorityCreated = new Authorities();
		authorityCreated.setUsername("admin0");
		authorityCreated.setAuthority("admin");
		
		Artist artistCreated = new Artist();
		artistCreated.setDescription("pepitoooooood");
		artistCreated.setName("pepitooooooooo1");
		artistCreated.setSurName("pepito1sur");
		artistCreated.setPro(true);
		artistCreated.setSummary("pepito1sum");
		artistCreated.setRole(Role.CAMARA);
		artistCreated.setUser(userCreated);	
		
		
		Assertions.assertThrows(java.lang.NullPointerException.class, ()-> this.artistService.editArtist(artistCreated.getId()));
	}*/


}
