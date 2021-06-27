package com.backbase.webapp.webmodulemoviecatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class WebModuleMovieCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebModuleMovieCatalogApplication.class, args);
	}

}
