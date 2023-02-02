package fr.epsi.server.dal;

import fr.epsi.server.entities.Annonce;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface AnnonceDAO extends CrudRepository<Annonce, Integer> {
}
