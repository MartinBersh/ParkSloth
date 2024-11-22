package co.edu.cue.ParkSloth.services.impl;


import co.edu.cue.ParkSloth.domain.entities.User;
import co.edu.cue.ParkSloth.mapping.dtos.UserDto;
import co.edu.cue.ParkSloth.mapping.mappers.UserMapper;
import co.edu.cue.ParkSloth.repositories.UserRespository;
import co.edu.cue.ParkSloth.services.UserServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRespository respository;

    public UserServicesImpl(UserRespository respository) {
        this.respository = respository;
    }

    @Override
    public List<UserDto> list() {
        return UserMapper.mapFrom((List<User>) respository.findAll());
    }

    @Override
    public UserDto getUserById(int id) {
        return UserMapper.mapFrom(respository.findById(id).orElseThrow());
    }

    @Override
    public UserDto save(UserDto user) {
        return UserMapper.mapFrom(
                respository.save(UserMapper.mapFrom(user))
        );
    }

    @Override
    public UserDto update(UserDto user) {
        //respository.findById(user.idUser()).orElseThrow();
        return UserMapper.mapFrom(respository.save(UserMapper.mapFrom(user))
        );    }

    @Override
    public void delete(int id) {
        respository.deleteById(id);
    }

    @Override
    public void updateStatus(int id, Character status) {
        User user = respository.findById(id).orElseThrow();
        user.setStatus(status);
        respository.save(user);
    }

    @Override
    public UserDto getUserByUsernameAndPassword(String username, String password) {
        return UserMapper.mapFrom(respository.findByUsernameAndPassword(username,password));
    }
}
