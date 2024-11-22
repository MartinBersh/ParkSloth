package co.edu.cue.ParkSloth.repositories;

import co.edu.cue.ParkSloth.domain.entities.User;
import co.edu.cue.ParkSloth.domain.entities.WeekDay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekDayRepository extends CrudRepository<WeekDay, Integer> {
}
