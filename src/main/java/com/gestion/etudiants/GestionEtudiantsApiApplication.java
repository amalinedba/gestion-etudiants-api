package com.gestion.etudiants;

import config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfig.class)
public class GestionEtudiantsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEtudiantsApiApplication.class, args);
	}

}
