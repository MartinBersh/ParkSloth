package co.edu.cue.ParkSloth.mapping.dtos;

import lombok.Builder;

@Builder
public record RoleDto(int idRole,
                      String name,
                      Character status) {
}
