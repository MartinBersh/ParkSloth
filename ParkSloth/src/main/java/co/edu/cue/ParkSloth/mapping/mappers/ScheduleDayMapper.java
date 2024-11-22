package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.ScheduleDay;
import co.edu.cue.ParkSloth.mapping.dtos.ScheduleDayDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class ScheduleDayMapper {

    public static ScheduleDayDto mapFrom(ScheduleDay source) {
        return ScheduleDayDto.builder()
                .scheduleDayId(source.getScheduleDayId())
                .schedule(source.getSchedule())
                .weekDay(source.getWeekDay())
                .parkingLot(source.getParkingLot())
                .status(source.getStatus())
                .build();
    }

    public static ScheduleDay mapFrom(ScheduleDayDto source) {
        return ScheduleDay.builder()
                .scheduleDayId(source.scheduleDayId())
                .schedule(source.schedule())
                .weekDay(source.weekDay())
                .parkingLot(source.parkingLot())
                .status(source.status())
                .build();
    }

    public static List<ScheduleDayDto> mapFrom(List<ScheduleDay> source) {
        return source.stream().map(ScheduleDayMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<ScheduleDay> mapToEntities(List<ScheduleDayDto> source) {
        return source.stream().map(ScheduleDayMapper::mapFrom).collect(Collectors.toList());
    }
}
