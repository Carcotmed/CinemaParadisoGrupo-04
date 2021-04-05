package com.cinema.cinemaparadiso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class CinemaparadisoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaparadisoApplication.class, args);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/videos/**")
				.addResourceLocations("file:///C:/resources/static/");
	}

}
