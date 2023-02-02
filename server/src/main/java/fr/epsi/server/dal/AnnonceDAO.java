package fr.epsi.server.dal;

import fr.epsi.server.entities.Annonce;
import org.springframework.data.repository.CrudRepository;

public interface AnnonceDAO extends CrudRepository<Annonce, Integer> {
}
