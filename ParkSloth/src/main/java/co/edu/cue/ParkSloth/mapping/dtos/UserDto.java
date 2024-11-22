package co.edu.cue.ParkSloth.mapping.dtos;

import co.edu.cue.ParkSloth.domain.entities.Role;
import lombok.Builder;

@Builder
public record UserDto(int idUser,
                      String username,
                      String password,
                      String name,
                      String phoneNumber,
                      String identification,
                      String email,
                      Role role,
                      Character status) {
}
