package co.edu.cue.ParkSloth.mapping.dtos;

import lombok.Builder;

@Builder
public record ScheduleDto(int idSchedule,
                          int startSchedule,
                          int endSchedule,
                          Character status) {
}
