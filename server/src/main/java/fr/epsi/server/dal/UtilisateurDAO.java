package fr.epsi.server.dal;

import fr.epsi.server.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface UtilisateurDAO extends CrudRepository<Utilisateur,Integer> {
}
