package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.User;
import co.edu.cue.ParkSloth.mapping.dtos.UserDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
@Builder
public class UserMapper {
    public static UserDto mapFrom(User source) {
        return UserDto.builder()
                .idUser(source.getIdUser())
                .username(source.getUsername())
                .password(source.getPassword())
                .name(source.getName())
                .phoneNumber(source.getPhoneNumber())
                .identification(source.getIdentification())
                .email(source.getEmail())
                .role(source.getRole())
                .status(source.getStatus())
                .build();
    }

    public static User mapFrom(UserDto source) {
        return User.builder()
                .idUser(source.idUser())
                .username(source.username())
                .password(source.password())
                .name(source.name())
                .phoneNumber(source.phoneNumber())
                .identification(source.identification())
                .email(source.email())
                .role(source.role())
                .status(source.status())
                .build();
    }

    public static List<UserDto> mapFrom(List<User> source) {
        return source.stream().map(UserMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<User> mapToEntities(List<UserDto> source) {
        return source.stream().map(UserMapper::mapFrom).collect(Collectors.toList());
    }
}
