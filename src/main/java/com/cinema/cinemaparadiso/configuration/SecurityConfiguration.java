package com.cinema.cinemaparadiso.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/resources/**","/webjars/**","/h2-console/**","/error/**").permitAll()
				.antMatchers(HttpMethod.GET, "/","/oups").permitAll()

				.antMatchers("/users/create").permitAll()
				//PRODUCER
				.antMatchers("/producers/list").permitAll()
				.antMatchers("/producers/create").permitAll()
				.antMatchers("/producers/show/**").permitAll()
				.antMatchers("/producers/update/**").permitAll()
				.antMatchers("/producers/delete/**").permitAll()
				//ARTISTA
				.antMatchers("/artists/list").permitAll()
				.antMatchers("/artists/create").permitAll()
				.antMatchers("/artists/update/{artistId}").permitAll()
				.antMatchers("/artists/delete/{artistId}").permitAll()
				.antMatchers("/artists/show/{artistId}").permitAll()
				//MESSAGES
				.antMatchers("/messages/listReceived").authenticated()
				.antMatchers("/messages/listSend").authenticated()
				.antMatchers("/messages/show/{messageId}").authenticated()
				.antMatchers("/messages/create/{userId}").authenticated()
				.antMatchers("/messages/delete/{messageId}").authenticated()
				.antMatchers("/messages/show/{messageId}/acceptRequest").authenticated()
				.antMatchers("/messages/show/{messageId}/rejectRequest").authenticated()
				//USER
				.antMatchers("/users/list").hasAnyAuthority("admin")
				.antMatchers("/users/select").permitAll()
				//POST
				.antMatchers("/posts/list").permitAll()//hasAnyAuthority("authenticated")
				.antMatchers("/posts/find/{postId}").permitAll()//hasAnyAuthority("authenticated")
				.antMatchers("/posts/create/{projectId}").permitAll()//hasAnyAuthority("authenticated")
				.antMatchers("/posts/update/{postId}").permitAll()//hasAnyAuthority("authenticated")
				.antMatchers("/posts/delete/{postId}").permitAll()//hasAnyAuthority("authenticated")
		     //WRITERS
		    .antMatchers("/writers/list").permitAll()
		    .antMatchers("/writers/create").permitAll()
			.antMatchers("/writers/show/{writerId}").permitAll()
			.antMatchers("/writers/update/{writerId}").permitAll()
			.antMatchers("/writers/delete/{writerId}").permitAll()
		     //STORIES
				.antMatchers("/stories/list").permitAll()
				.antMatchers("/stories/show/{storyId}").permitAll()
				.antMatchers("/stories/create").permitAll()
				.antMatchers("/stories/update/{storyId}").permitAll()
				.antMatchers("/stories/delete/{storyId}").permitAll()
				
				//PROJECTS
				.antMatchers("/projects/list").permitAll()
				.antMatchers("/projects/create").permitAll()
				.antMatchers("/projects/update/{projectId}").permitAll()
				.antMatchers("/projects/delete/{projectId}").permitAll()
				.antMatchers("/projects/show/{projectId}").permitAll()
				.antMatchers("/projects/join/{projectId}").permitAll()
				.anyRequest().denyAll()
				.and()
				 	.formLogin()
				 	/*.loginPage("/login")*/
				 	.failureUrl("/login-error")
				.and()
					.logout()
						.logoutSuccessUrl("/"); 
                // Configuración para que funcione la consola de administración 
                // de la BD H2 (deshabilitar las cabeceras de protección contra
                // ataques de tipo csrf y habilitar los framesets si su contenido
                // se sirve desde esta misma página.
                http.csrf().ignoringAntMatchers("/h2-console/**");
                http.headers().frameOptions().sameOrigin();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery(
	       "select username,password,enabled "
	        + "from users "
	        + "where username = ?")
	      .authoritiesByUsernameQuery(
	       "select username, authority "
	        + "from authorities "
	        + "where username = ?")	      	      
	      .passwordEncoder(passwordEncoder());	
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {	
	    return new BCryptPasswordEncoder();
	}

}
