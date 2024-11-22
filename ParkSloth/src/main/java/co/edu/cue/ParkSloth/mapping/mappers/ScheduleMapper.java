package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.Schedule;
import co.edu.cue.ParkSloth.mapping.dtos.ScheduleDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
@Builder
public class ScheduleMapper {
    public static ScheduleDto mapFrom(Schedule source) {
        return ScheduleDto.builder()
                .idSchedule(source.getIdSchedule())
                .startSchedule(source.getStartSchedule())
                .endSchedule(source.getEndSchedule())
                .status(source.getStatus())
                .build();
    }

    public static Schedule mapFrom(ScheduleDto source) {
        return Schedule.builder()
                .idSchedule(source.idSchedule())
                .startSchedule(source.startSchedule())
                .endSchedule(source.endSchedule())
                .status(source.status())
                .build();
    }

    public static List<ScheduleDto> mapFrom(List<Schedule> source) {
        return source.stream().map(ScheduleMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<Schedule> mapToEntities(List<ScheduleDto> source) {
        return source.stream().map(ScheduleMapper::mapFrom).collect(Collectors.toList());
    }
}
