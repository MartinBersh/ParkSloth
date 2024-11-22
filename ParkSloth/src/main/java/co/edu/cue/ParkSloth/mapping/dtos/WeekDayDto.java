package co.edu.cue.ParkSloth.mapping.dtos;

import lombok.Builder;

@Builder
public record WeekDayDto(int idWeekDay,
                         int dayNumber,
                         String dayName,
                         Character status) {
}
