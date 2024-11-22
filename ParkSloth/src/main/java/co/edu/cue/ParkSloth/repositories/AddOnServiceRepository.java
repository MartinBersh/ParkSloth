package co.edu.cue.ParkSloth.repositories;

import co.edu.cue.ParkSloth.domain.entities.AddOnService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddOnServiceRepository extends CrudRepository<AddOnService, Integer> {
}
