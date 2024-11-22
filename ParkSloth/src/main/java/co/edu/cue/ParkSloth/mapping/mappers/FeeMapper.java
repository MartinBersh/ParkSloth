package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.Fee;
import co.edu.cue.ParkSloth.mapping.dtos.FeeDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
@Builder
public class FeeMapper {
    public static FeeDto mapFrom(Fee source) {
        return FeeDto.builder()
                .idFee(source.getIdFee())
                .name(source.getName())
                .price(source.getPrice())
                .parkingLot(source.getParkingLot())
                .vehicleType(source.getVehicleType())
                .status(source.getStatus())
                .build();
    }

    public static Fee mapFrom(FeeDto source) {
        return Fee.builder()
                .idFee(source.idFee())
                .name(source.name())
                .price(source.price())
                .parkingLot(source.parkingLot())
                .vehicleType(source.vehicleType())
                .status(source.status())
                .build();
    }

    public static List<FeeDto> mapFrom(List<Fee> source) {
        return source.stream().map(FeeMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<Fee> mapToEntities(List<FeeDto> source) {
        return source.stream().map(FeeMapper::mapFrom).collect(Collectors.toList());
    }
}
