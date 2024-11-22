package co.edu.cue.ParkSloth.mapping.dtos;

import co.edu.cue.ParkSloth.domain.entities.ParkingLot;
import co.edu.cue.ParkSloth.domain.entities.VehicleType;
import lombok.Builder;

@Builder
public record FeeDto(int idFee,
                     String name,
                     int price,
                     ParkingLot parkingLot,
                     VehicleType vehicleType,
                     Character status) {
}
