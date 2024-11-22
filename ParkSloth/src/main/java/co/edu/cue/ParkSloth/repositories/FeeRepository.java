package co.edu.cue.ParkSloth.repositories;

import co.edu.cue.ParkSloth.domain.entities.Fee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends CrudRepository<Fee, Integer> {
}
