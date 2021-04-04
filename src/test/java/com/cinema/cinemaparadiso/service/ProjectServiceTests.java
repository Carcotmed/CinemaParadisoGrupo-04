package com.cinema.cinemaparadiso.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.cinemaparadiso.model.Genre;
import com.cinema.cinemaparadiso.model.Project;
import com.cinema.cinemaparadiso.model.Rel_projects_artists;


@SpringBootTest
@Sql("/db/test.sql")
@Transactional
public class ProjectServiceTests {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private Rel_projects_artistsService rel_projects_artistsService;

	
	@Test
    public void shouldListTotalProject(){
        Integer totalProject = this.projectService.list().size();
		assertThat(totalProject).isEqualTo(13);
   }
	
	@Test
    public void shouldListTotalProjectWithError(){
        Integer totalProject = this.projectService.list().size();
		assertThat(totalProject).isNotEqualTo(15);
   }
	
	@Test
    public void shouldListProProject(){
        Integer proProjects = this.projectService.listProProjects().size();
		assertThat(proProjects).isEqualTo(6);
   }
	
	@Test
    public void shouldListProProjectWithError(){
        Integer proProjects = this.projectService.listProProjects().size();
		assertThat(proProjects).isNotEqualTo(2);
   }
	
	@Test
    public void shouldListNoProProject(){
        Integer noProProjects = this.projectService.listNoProProjects().size();
		assertThat(noProProjects).isEqualTo(7);
   }
	
	@Test
    public void shouldListNoProProjectWithError(){
        Integer noProProjects = this.projectService.listNoProProjects().size();
		assertThat(noProProjects).isNotEqualTo(3);
   }
	
	@Test
	public void shouldFindMembers() {
		Integer numberOfMembers = this.projectService.findMembers(2).size();
		assertThat(numberOfMembers).isEqualTo(4);
	}
	
	@Test
	public void shouldFindMembersWithError() {
		Integer numberOfMembers = this.projectService.findMembers(312).size();
		assertThat(numberOfMembers).isEqualTo(0);
	}
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
	
	
	@Test
    public void shouldfindProjectByIdWithError() {
		
		Integer id = 222;	
		
		Assertions.assertThrows(java.util.NoSuchElementException.class, ()-> this.projectService.findProjectById(id));
		
	}
	
	@Test
	public void shouldDeleteRelation(){
		Integer idrelacion = 1;
		assertThat(this.rel_projects_artistsService.count()).isEqualTo(11);
		this.rel_projects_artistsService.delete(idrelacion);
		assertThat(this.rel_projects_artistsService.count()).isEqualTo(10);
		
	}
	
	@Test
	public void shouldDeleteRelationWithError(){
		Integer idrelacion = 12131;
		
		Assertions.assertThrows(java.util.NoSuchElementException.class, ()-> this.projectService.findProjectById(idrelacion));
	}
	
	

	@Test
	public void shouldCreateProject() {
		Integer id = 14;
		Project projectCreated = new Project();
		projectCreated.setDescription("De mucho miedo");
		projectCreated.setGenre(Genre.TERROR);
		projectCreated.setId(id);
		projectCreated.setPhoto("https://estaticos.muyhistoria.es/media/cache/1140x_thumb/uploads/images/ephemeris/5e04bfc55cafe8c5f6f862fe/mortadelo-filemon_0.jpg");
		projectCreated.setPro(true);
		projectCreated.setTitle("MiedoTest");
		projectCreated.setVersion(0);	

		
		assertThat(this.projectService.count()).isEqualTo(13);
		this.projectService.saveProject(projectCreated);
		assertThat(this.projectService.count()).isEqualTo(14);
		
		Rel_projects_artists rel = new Rel_projects_artists();
		rel.setArtist_id(1);
		rel.setId(12);
		rel.setProject_id(14);
		
		assertThat(this.rel_projects_artistsService.count()).isEqualTo(11);
		this.rel_projects_artistsService.create(rel);
		assertThat(this.rel_projects_artistsService.count()).isEqualTo(12);
	}
	
	@Test
	public void shouldCreateProjectWithErrorInProject() {
		Integer id = 14;
		Project projectCreated = new Project();
		projectCreated.setDescription("De mucho miedo");
		projectCreated.setGenre(Genre.TERROR);
		projectCreated.setId(id);
		projectCreated.setPhoto("https://estaticos.muyhistoria.es/media/cache/1140x_thumb/uploads/images/ephemeris/5e04bfc55cafe8c5f6f862fe/mortadelo-filemon_0.jpg");
		projectCreated.setPro(true);
		
		projectCreated.setTitle("");
		
		projectCreated.setVersion(0);	

		Assertions.assertThrows(javax.validation.ConstraintViolationException.class, ()-> this.projectService.saveProject(projectCreated));
	}
	
	@Test
	public void shouldCreateProjectWithErrorInRel() {
	Rel_projects_artists rel = new Rel_projects_artists();
	
	Assertions.assertThrows(java.lang.IllegalAccessError.class, ()-> this.rel_projects_artistsService.create(rel));
	}
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
	
	
	@Test
	public void shouldEditProjectWithError() {
		Project projectCreated = new Project();
		projectCreated.setDescription("De miedooooooooooooooo");
		projectCreated.setGenre(Genre.TERROR);
		
		projectCreated.setId(null);
		
		projectCreated.setTitle("GOLLLL");
		projectCreated.setPhoto("https://imagen.jpg");
		projectCreated.setPro(true);
		projectCreated.setVersion(0);	
		
		
		Assertions.assertThrows(java.lang.NullPointerException.class, ()-> this.projectService.editProject(projectCreated));
	}


}
