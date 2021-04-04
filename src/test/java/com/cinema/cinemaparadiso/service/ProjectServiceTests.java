package com.cinema.cinemaparadiso.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/db/test.sql")
@Transactional
public class ProjectServiceTests {
	
	@Autowired
	private ProjectService projectService;
	
	@Test
    public void shouldListTotalProject(){
        Integer totalProject = this.projectService.list().size();
		assertThat(totalProject).isEqualTo(13);
   }
	
	@Test
    public void shouldListProProject(){
        Integer proProjects = this.projectService.listProProjects().size();
		assertThat(proProjects).isEqualTo(6);
   }
	
	@Test
    public void shouldListNoProProject(){
        Integer noProProjects = this.projectService.listNoProProjects().size();
		assertThat(noProProjects).isEqualTo(7);
   }
	
//	@Test
//	public void shouldProjectFiltered() {
//		Genre genre = Genre.HUMORISTIC;
//		String title = "Humor";
//		Integer filteredProject = this.projectService.projectFiltered(genre, title).size();
//		assertThat(filteredProject).isEqualTo(1);
//
//	}
	
	@Test
    public void shouldfindProjectById() {
		Integer id = 1;
		Project projectCreated = new Project();
		projectCreated.setDescription("De miedo");
		projectCreated.setGenre(Genre.TERROR);
		projectCreated.setId(id);
		projectCreated.setPhoto("https://i.pinimg.com/originals/73/09/3f/73093ff700637e9ce2aed290b9be255c.jpg");
		projectCreated.setPro(true);
		projectCreated.setTitle("Miedo");
		projectCreated.setVersion(0);
		
		Project projectBDD = this.projectService.findProjectById(id);
		assertThat(projectCreated.getDescription()).isEqualTo(projectBDD.getDescription());
		assertThat(projectCreated.getGenre()).isEqualTo(projectBDD.getGenre());
		assertThat(projectCreated.getId()).isEqualTo(projectBDD.getId());
		assertThat(projectCreated.getPhoto()).isEqualTo(projectBDD.getPhoto());
		assertThat(projectCreated.getPro()).isEqualTo(projectBDD.getPro());
		assertThat(projectCreated.getTitle()).isEqualTo(projectBDD.getTitle());
		assertThat(projectCreated.getVersion()).isEqualTo(projectBDD.getVersion());
	}
	
//// SACA LA ID DEL USUARIO AUTENTICADO Y DEL PROYECTO QUE LE PONGAMOS	
//	@Test
//	//HAY QUE PONER UNA ANOTACION QUE PERMITA LOGUEARSE EN EL TEST
//	public void shouldDeleteRelation() {
//		Integer projectId = 1;
//		.
//		.
//		.
//	}
//	
	
//AQUI TAMBIEN HAY QUE AUTENTICARSE	POR ESO FALLA
//	@Test
//	public void shouldCreateProject() {
//		Integer id = 15;
//		Project projectCreated = new Project();
//		projectCreated.setDescription("De miedo");
//		projectCreated.setGenre(Genre.TERROR);
//		projectCreated.setId(id);
//		projectCreated.setPhoto("https://i.pinimg.com/originals/73/09/3f/73093ff700637e9ce2aed290b9be255c.jpg");
//		projectCreated.setPro(true);
//		projectCreated.setTitle("Miedo");
//		projectCreated.setVersion(0);	
//		
//		this.projectService.createProject(projectCreated);
//		Project projectBDD = this.projectService.findProjectById(15);
//		assertThat(projectCreated.getDescription()).isEqualTo(projectBDD.getDescription());
//		assertThat(projectCreated.getGenre()).isEqualTo(projectBDD.getGenre());
//		assertThat(projectCreated.getId()).isEqualTo(projectBDD.getId());
//		assertThat(projectCreated.getPhoto()).isEqualTo(projectBDD.getPhoto());
//		assertThat(projectCreated.getPro()).isEqualTo(projectBDD.getPro());
//		assertThat(projectCreated.getTitle()).isEqualTo(projectBDD.getTitle());
//		assertThat(projectCreated.getVersion()).isEqualTo(projectBDD.getVersion());
//	}
	
	//save() no se prueba porque va incorporado en create y update
	
	@Test
	public void shouldEditProject() {
		Integer id = 1;
		Project projectCreated = new Project();
		projectCreated.setDescription("De miedooooooooooooooo");
		projectCreated.setGenre(Genre.TERROR);
		projectCreated.setId(id);
		projectCreated.setPhoto("https://i.pinimg.com/originals/73/09/3f/73093ff700637e9ce2aed290b9be255c.jpg");
		projectCreated.setPro(true);
		projectCreated.setTitle("Miedooooooooooo");
		projectCreated.setVersion(0);	
		
		this.projectService.editProject(projectCreated);
		Project projectBDD = this.projectService.findProjectById(1);
		assertThat(projectCreated.getDescription()).isEqualTo(projectBDD.getDescription());
		assertThat(projectCreated.getTitle()).isEqualTo(projectBDD.getTitle());
	}
	
	


}
