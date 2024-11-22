package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.Role;
import co.edu.cue.ParkSloth.mapping.dtos.RoleDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class RoleMapper {
    public static RoleDto mapFrom(Role source) {
        return RoleDto.builder()
                .idRole(source.getIdRole())
                .name(source.getName())
                .status(source.getStatus())
                .build();
    }

    public static Role mapFrom(RoleDto source) {
        return Role.builder()
                .idRole(source.idRole())
                .name(source.name())
                .status(source.status())
                .build();
    }

    public static List<RoleDto> mapFrom(List<Role> source) {
        return source.stream().map(RoleMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<Role> mapToEntities(List<RoleDto> source) {
        return source.stream().map(RoleMapper::mapFrom).collect(Collectors.toList());
    }
}
