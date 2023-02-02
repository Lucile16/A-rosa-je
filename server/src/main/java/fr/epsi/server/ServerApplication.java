package fr.epsi.server;

import fr.epsi.server.dal.AnnonceDAO;
import fr.epsi.server.entities.Adresse;
import fr.epsi.server.entities.Annonce;
import fr.epsi.server.entities.Plante;
import fr.epsi.server.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication{
	public static void main(String[] args) {

		SpringApplication.run(ServerApplication.class, args);

	}
}
