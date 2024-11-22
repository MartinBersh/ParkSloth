package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.Slot;
import co.edu.cue.ParkSloth.mapping.dtos.SlotDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
@Builder
public class SlotMapper {
    public static SlotDto mapFrom(Slot source) {
        return SlotDto.builder()
                .idSlot(source.getIdSlot())
                .slotNumber(source.getSlotNumber())
                .parkingLot(source.getParkingLot())
                .vehicleType(source.getVehicleType())
                .status(source.getStatus())
                .build();
    }

    public static Slot mapFrom(SlotDto source) {
        return Slot.builder()
                .idSlot(source.idSlot())
                .slotNumber(source.slotNumber())
                .parkingLot(source.parkingLot())
                .vehicleType(source.vehicleType())
                .status(source.status())
                .build();
    }

    public static List<SlotDto> mapFrom(List<Slot> source) {
        return source.stream().map(SlotMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<Slot> mapToEntities(List<SlotDto> source) {
        return source.stream().map(SlotMapper::mapFrom).collect(Collectors.toList());
    }
}
