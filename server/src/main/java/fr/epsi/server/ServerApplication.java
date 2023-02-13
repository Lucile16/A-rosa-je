package fr.epsi.server;

import fr.epsi.server.dal.AnnonceDAO;
import fr.epsi.server.entities.Adresse;
import fr.epsi.server.entities.Annonce;
import fr.epsi.server.entities.Plante;
import fr.epsi.server.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ServerApplication {

	@Configuration(proxyBeanMethods = false)
	public class MyCorsConfiguration {

		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {

				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**").allowedOrigins("http://localhost:8080");
				}

			};
		}

	}

	public static void main(String[] args) {

		SpringApplication.run(ServerApplication.class, args);

	}
}
