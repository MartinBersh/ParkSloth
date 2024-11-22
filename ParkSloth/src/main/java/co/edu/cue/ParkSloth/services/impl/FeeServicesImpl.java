package co.edu.cue.ParkSloth.services.impl;

import co.edu.cue.ParkSloth.domain.entities.Fee;
import co.edu.cue.ParkSloth.domain.entities.Schedule;
import co.edu.cue.ParkSloth.mapping.dtos.FeeDto;
import co.edu.cue.ParkSloth.mapping.mappers.FeeMapper;
import co.edu.cue.ParkSloth.repositories.FeeRepository;
import co.edu.cue.ParkSloth.services.FeeServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeeServicesImpl implements FeeServices {

    private final FeeRepository repository;

    public FeeServicesImpl(FeeRepository repository) {this.repository = repository;}
    @Override
    public List<FeeDto> list() {
        return FeeMapper.mapFrom((List<Fee>) repository.findAll());
    }

    @Override
    public Optional<FeeDto> getFeeById(int id) {
        return repository.findById(id).map(FeeMapper::mapFrom);

    }

    @Override
    public FeeDto save(FeeDto fee) {
        return FeeMapper.mapFrom(
                repository.save(FeeMapper.mapFrom(fee))
        );
    }

    @Override
    public FeeDto update(FeeDto fee) {
        return FeeMapper.mapFrom(
                repository.save(FeeMapper.mapFrom(fee))
        );    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    @Override
    public void updateStatus(int id, Character status) {
        Fee fee = repository.findById(id).orElseThrow();
        fee.setStatus(status);
        repository.save(fee);
    }
}
