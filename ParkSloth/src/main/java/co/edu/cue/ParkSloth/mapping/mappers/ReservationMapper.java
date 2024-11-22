package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.Reservation;
import co.edu.cue.ParkSloth.mapping.dtos.ReservationDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
@Builder
public class ReservationMapper {
    public static ReservationDto mapFrom(Reservation source) {
        return ReservationDto.builder()
                .idReservation(source.getIdReservation())
                .reservationDate(source.getReservationDate())
                .paymentDate(source.getPaymentDate())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .user(source.getUser())
                .paymentMethod(source.getPaymentMethod())
                .slot(source.getSlot())
                .fee(source.getFee())
                .status(source.getStatus())
                .build();
    }

    public static Reservation mapFrom(ReservationDto source) {
        return Reservation.builder()
                .idReservation(source.idReservation())
                .reservationDate(source.reservationDate())
                .paymentDate(source.paymentDate())
                .startDate(source.startDate())
                .endDate(source.endDate())
                .user(source.user())
                .paymentMethod(source.paymentMethod())
                .slot(source.slot())
                .fee(source.fee())
                .status(source.status())
                .build();
    }

    public static List<ReservationDto> mapFrom(List<Reservation> source) {
        return source.stream().map(ReservationMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<Reservation> mapToEntities(List<ReservationDto> source) {
        return source.stream().map(ReservationMapper::mapFrom).collect(Collectors.toList());
    }
}
