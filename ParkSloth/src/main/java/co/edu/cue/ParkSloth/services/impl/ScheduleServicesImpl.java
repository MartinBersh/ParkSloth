package co.edu.cue.ParkSloth.services.impl;

import co.edu.cue.ParkSloth.domain.entities.Schedule;
import co.edu.cue.ParkSloth.domain.entities.User;
import co.edu.cue.ParkSloth.mapping.dtos.ScheduleDto;
import co.edu.cue.ParkSloth.mapping.mappers.ScheduleMapper;
import co.edu.cue.ParkSloth.repositories.ScheduleRepository;
import co.edu.cue.ParkSloth.services.ScheduleServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServicesImpl implements ScheduleServices {

    private final ScheduleRepository repository;

    public ScheduleServicesImpl(ScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ScheduleDto> list() {
        return ScheduleMapper.mapFrom((List<Schedule>) repository.findAll());
    }

    @Override
    public ScheduleDto getScheduleById(int id) {
        return ScheduleMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public ScheduleDto save(ScheduleDto schedule) {
        return ScheduleMapper.mapFrom(
                repository.save(ScheduleMapper.mapFrom(schedule))
        );
    }

    @Override
    public ScheduleDto update(ScheduleDto schedule) {
        return ScheduleMapper.mapFrom(
                repository.save(ScheduleMapper.mapFrom(schedule))
        );    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
    @Override
    public void updateStatus(int id, Character status) {
        Schedule schedule = repository.findById(id).orElseThrow();
        schedule.setStatus(status);
        repository.save(schedule);
    }
}
