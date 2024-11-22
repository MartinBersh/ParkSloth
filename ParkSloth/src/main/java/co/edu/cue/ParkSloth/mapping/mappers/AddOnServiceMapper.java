package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.AddOnService;
import co.edu.cue.ParkSloth.mapping.dtos.AddOnServiceDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class AddOnServiceMapper {
    public static AddOnServiceDto mapFrom(AddOnService source) {
        return AddOnServiceDto.builder()
                .idAddOnService(source.getIdAddOnService())
                .name(source.getName())
                .price(source.getPrice())
                .parkingLot(source.getParkingLot())
                .status(source.getStatus())
                .build();
    }

    public static AddOnService mapFrom(AddOnServiceDto source) {
        return AddOnService.builder()
                .idAddOnService(source.idAddOnService())
                .name(source.name())
                .price(source.price())
                .parkingLot(source.parkingLot())
                .status(source.status())
                .build();
    }

    public static List<AddOnServiceDto> mapFrom(List<AddOnService> source) {
        return source.stream().map(AddOnServiceMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<AddOnService> mapToEntities(List<AddOnServiceDto> source) {
        return source.stream().map(AddOnServiceMapper::mapFrom).collect(Collectors.toList());
    }
}
