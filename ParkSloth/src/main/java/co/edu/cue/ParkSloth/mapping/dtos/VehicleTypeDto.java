package co.edu.cue.ParkSloth.mapping.dtos;

import lombok.Builder;

@Builder
public record VehicleTypeDto(int idVehicleType,
                             String name,
                             Character status) {
}
