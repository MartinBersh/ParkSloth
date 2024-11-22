package co.edu.cue.ParkSloth.mapping.dtos;

import co.edu.cue.ParkSloth.domain.entities.User;
import lombok.Builder;

@Builder
public record ParkingLotDto(int idParkingLot,
                            String name,
                            String address,
                            String phoneNumber,
                            String nit,
                            String coordX,
                            String coordY,
                            User user,
                            Character status) {
}
