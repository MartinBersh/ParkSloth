package co.edu.cue.ParkSloth.repositories;

import co.edu.cue.ParkSloth.domain.entities.Slot;
import org.springframework.data.repository.CrudRepository;

public interface SlotRepositoy extends CrudRepository<Slot, Integer> {
}
