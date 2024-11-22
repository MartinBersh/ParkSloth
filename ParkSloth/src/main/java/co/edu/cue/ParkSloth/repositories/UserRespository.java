package co.edu.cue.ParkSloth.repositories;

import co.edu.cue.ParkSloth.domain.entities.User;
import co.edu.cue.ParkSloth.mapping.dtos.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
