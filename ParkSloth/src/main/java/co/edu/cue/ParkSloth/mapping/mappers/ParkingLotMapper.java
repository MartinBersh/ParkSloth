package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.ParkingLot;
import co.edu.cue.ParkSloth.mapping.dtos.ParkingLotDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
@Builder
public class ParkingLotMapper {
    public static ParkingLotDto mapFrom(ParkingLot source) {
        return ParkingLotDto.builder()
                .idParkingLot(source.getIdParkingLot())
                .name(source.getName())
                .address(source.getAddress())
                .phoneNumber(source.getPhoneNumber())
                .nit(source.getNit())
                .coordX(source.getCoordX())
                .coordY(source.getCoordY())
                .user(source.getUser())
                .status(source.getStatus())
                .build();
    }

    public static ParkingLot mapFrom(ParkingLotDto source) {
        return ParkingLot.builder()
                .idParkingLot(source.idParkingLot())
                .name(source.name())
                .address(source.address())
                .phoneNumber(source.phoneNumber())
                .nit(source.nit())
                .coordX(source.coordX())
                .coordY(source.coordY())
                .user(source.user())
                .status(source.status())
                .build();
    }

    public static List<ParkingLotDto> mapFrom(List<ParkingLot> source) {
        return source.stream().map(ParkingLotMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<ParkingLot> mapToEntities(List<ParkingLotDto> source) {
        return source.stream().map(ParkingLotMapper::mapFrom).collect(Collectors.toList());
    }
}
