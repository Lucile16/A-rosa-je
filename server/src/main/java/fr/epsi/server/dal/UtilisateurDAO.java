package fr.epsi.server.dal;

import fr.epsi.server.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurDAO extends CrudRepository<Utilisateur,Integer> {
}
