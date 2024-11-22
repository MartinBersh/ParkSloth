package co.edu.cue.ParkSloth.repositories;

import co.edu.cue.ParkSloth.domain.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ScheduleDayRepository extends CrudRepository<ScheduleDay, Integer> {

}

