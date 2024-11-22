package co.edu.cue.ParkSloth.services.impl;

import co.edu.cue.ParkSloth.domain.entities.ParkingLot;
import co.edu.cue.ParkSloth.domain.entities.Schedule;
import co.edu.cue.ParkSloth.mapping.dtos.ParkingLotDto;
import co.edu.cue.ParkSloth.mapping.mappers.ParkingLotMapper;
import co.edu.cue.ParkSloth.repositories.ParkingLotRepository;
import co.edu.cue.ParkSloth.services.ParkingLotServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotServicesImpl implements ParkingLotServices {

    private final ParkingLotRepository repository;

    public ParkingLotServicesImpl(ParkingLotRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ParkingLotDto> list() {
        return ParkingLotMapper.mapFrom((List<ParkingLot>) repository.findAll());
    }

    @Override
    public ParkingLotDto getParkingLotById(int id) {
        return ParkingLotMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public ParkingLotDto save(ParkingLotDto parkingLot) {
        return ParkingLotMapper.mapFrom(
                repository.save(ParkingLotMapper.mapFrom(parkingLot))
        );
    }

    @Override
    public ParkingLotDto update(ParkingLotDto parkingLot) {
        return ParkingLotMapper.mapFrom(
                repository.save(ParkingLotMapper.mapFrom(parkingLot))
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    @Override
    public void updateStatus(int id, Character status) {
        ParkingLot parkingLot = repository.findById(id).orElseThrow();
        parkingLot.setStatus(status);
        repository.save(parkingLot);
    }
}
