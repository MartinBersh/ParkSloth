package co.edu.cue.ParkSloth.services.impl;

import co.edu.cue.ParkSloth.domain.entities.Reservation;
import co.edu.cue.ParkSloth.domain.entities.Schedule;
import co.edu.cue.ParkSloth.mapping.dtos.ReservationDto;
import co.edu.cue.ParkSloth.mapping.mappers.ReservationMapper;
import co.edu.cue.ParkSloth.repositories.ReservationRepository;
import co.edu.cue.ParkSloth.services.ReservationServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServicesImpl implements ReservationServices {

    private final ReservationRepository repository;

    public ReservationServicesImpl(ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ReservationDto> list() {
        return ReservationMapper.mapFrom((List<Reservation>) repository.findAll());
    }

    @Override
    public ReservationDto getReservationById(int id) {
        return ReservationMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public ReservationDto save(ReservationDto reservation) {
        return ReservationMapper.mapFrom(
                repository.save(ReservationMapper.mapFrom(reservation))
        );
    }

    @Override
    public ReservationDto update(ReservationDto reservation) {
        return ReservationMapper.mapFrom(
                repository.save(ReservationMapper.mapFrom(reservation))
        );    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
    @Override
    public void updateStatus(int id, Character status) {
        Reservation reservation = repository.findById(id).orElseThrow();
        reservation.setStatus(status);
        repository.save(reservation);
    }
}
