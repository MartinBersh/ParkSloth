package co.edu.cue.ParkSloth.repositories;

import co.edu.cue.ParkSloth.domain.entities.ParkingLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Integer> {
}
