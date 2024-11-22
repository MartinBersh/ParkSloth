package co.edu.cue.ParkSloth.repositories;

import co.edu.cue.ParkSloth.domain.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
}
