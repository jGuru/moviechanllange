package com.backbase.assignment.moviecatalogapi;

import com.backbase.assignment.moviecatalogapi.service.MovieDetailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogApiApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public MovieDetailService getMovieDetailService(){
		return new MovieDetailService();
	}
}
