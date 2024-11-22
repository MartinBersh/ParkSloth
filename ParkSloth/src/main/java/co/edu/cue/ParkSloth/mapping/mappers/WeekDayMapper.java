package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.WeekDay;
import co.edu.cue.ParkSloth.mapping.dtos.WeekDayDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
@Builder
public class WeekDayMapper {
    public static WeekDayDto mapFrom(WeekDay source) {
        return WeekDayDto.builder()
                .idWeekDay(source.getIdWeekDay())
                .dayNumber(source.getDayNumber())
                .dayName(source.getDayName())
                .status(source.getStatus())
                .build();
    }

    public static WeekDay mapFrom(WeekDayDto source) {
        return WeekDay.builder()
                .idWeekDay(source.idWeekDay())
                .dayNumber(source.dayNumber())
                .dayName(source.dayName())
                .status(source.status())
                .build();
    }

    public static List<WeekDayDto> mapFrom(List<WeekDay> source) {
        return source.stream().map(WeekDayMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<WeekDay> mapToEntities(List<WeekDayDto> source) {
        return source.stream().map(WeekDayMapper::mapFrom).collect(Collectors.toList());
    }
}
