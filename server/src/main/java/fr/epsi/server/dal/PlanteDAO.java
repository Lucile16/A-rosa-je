package fr.epsi.server.dal;

import fr.epsi.server.entities.Plante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface PlanteDAO extends CrudRepository<Plante,Integer> {
}
