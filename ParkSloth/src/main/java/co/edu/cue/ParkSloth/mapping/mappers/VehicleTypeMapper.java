package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.VehicleType;
import co.edu.cue.ParkSloth.mapping.dtos.VehicleTypeDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
@Builder
public class VehicleTypeMapper {
    public static VehicleTypeDto mapFrom(VehicleType source) {
        return VehicleTypeDto.builder()
                .idVehicleType(source.getIdVehicleType())
                .name(source.getName())
                .status(source.getStatus())
                .build();
    }

    public static VehicleType mapFrom(VehicleTypeDto source) {
        return VehicleType.builder()
                .idVehicleType(source.idVehicleType())
                .name(source.name())
                .status(source.status())
                .build();
    }

    public static List<VehicleTypeDto> mapFrom(List<VehicleType> source) {
        return source.stream().map(VehicleTypeMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<VehicleType> mapToEntities(List<VehicleTypeDto> source) {
        return source.stream().map(VehicleTypeMapper::mapFrom).collect(Collectors.toList());
    }
}
