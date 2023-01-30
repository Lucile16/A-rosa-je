package fr.epsi.server.dal;

import fr.epsi.server.entities.Plante;
import org.springframework.data.repository.CrudRepository;

public interface PlanteDAO extends CrudRepository<Plante,Integer> {
}
