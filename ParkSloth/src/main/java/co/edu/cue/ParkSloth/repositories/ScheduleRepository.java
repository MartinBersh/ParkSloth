package co.edu.cue.ParkSloth.repositories;

import co.edu.cue.ParkSloth.domain.entities.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
}
