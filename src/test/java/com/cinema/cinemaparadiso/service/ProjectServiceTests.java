package com.cinema.cinemaparadiso.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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


}
