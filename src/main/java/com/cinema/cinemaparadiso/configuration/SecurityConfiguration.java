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
				.antMatchers("/resources/**","/webjars/**","/h2-console/**").permitAll()
				.antMatchers(HttpMethod.GET, "/","/oups").permitAll()
				.antMatchers("/users/create").permitAll()
				//artist
				.antMatchers("/artists/list").permitAll()
				.antMatchers("/artists/create").permitAll()
				.antMatchers("/artists/listFiltered").permitAll()
				.antMatchers("/mensaje").permitAll()
				.antMatchers("/messages/list").permitAll() //hasAnyAuthority("authenticated")
				.antMatchers("/messages/create/{userId}").permitAll() //hasAnyAuthority("authenticated")
				.antMatchers("/messages/delete/{messageId}").permitAll() //hasAnyAuthority("authenticated")
				.antMatchers("/artists/update/{artistId}").permitAll()
				.antMatchers("/artists/delete/{artistId}").permitAll()
				.antMatchers("/artists/show/{artistId}").permitAll()
				.antMatchers("/users/list").hasAnyAuthority("admin")
				.antMatchers("/posts/list").permitAll()//hasAnyAuthority("authenticated")
				.antMatchers("/posts/find/{postId}").permitAll()//hasAnyAuthority("authenticated")
				.antMatchers("/posts/create/{projectId}").permitAll()//hasAnyAuthority("authenticated")
				.antMatchers("/posts/update/{postId}").permitAll()//hasAnyAuthority("authenticated")
				.antMatchers("/posts/delete/{postId}").permitAll()//hasAnyAuthority("authenticated")
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


