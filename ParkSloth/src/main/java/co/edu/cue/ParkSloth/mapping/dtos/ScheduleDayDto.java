package co.edu.cue.ParkSloth.mapping.dtos;

import co.edu.cue.ParkSloth.domain.entities.ParkingLot;
import co.edu.cue.ParkSloth.domain.entities.Schedule;
import co.edu.cue.ParkSloth.domain.entities.ScheduleDay;
import co.edu.cue.ParkSloth.domain.entities.WeekDay;
import lombok.Builder;

@Builder
public record ScheduleDayDto(int scheduleDayId,
                             Schedule schedule,
                             WeekDay weekDay,
                             ParkingLot parkingLot,
                             Character status) {
}
