package co.edu.cue.ParkSloth.mapping.dtos;

import co.edu.cue.ParkSloth.domain.entities.ParkingLot;
import lombok.Builder;

@Builder
public record AddOnServiceDto(int idAddOnService,
                              String name,
                              int price,
                              ParkingLot parkingLot,
                              Character status) {
}
