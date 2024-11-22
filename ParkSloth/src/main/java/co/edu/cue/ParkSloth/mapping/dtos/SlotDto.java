package co.edu.cue.ParkSloth.mapping.dtos;

import co.edu.cue.ParkSloth.domain.entities.ParkingLot;
import co.edu.cue.ParkSloth.domain.entities.VehicleType;
import lombok.Builder;

@Builder
public record SlotDto(int idSlot,
                      int slotNumber,
                      ParkingLot parkingLot,
                      VehicleType vehicleType,
                      Character status) {
}
