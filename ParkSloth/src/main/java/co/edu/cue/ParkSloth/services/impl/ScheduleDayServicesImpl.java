package co.edu.cue.ParkSloth.services.impl;

import co.edu.cue.ParkSloth.domain.entities.ScheduleDay;
import co.edu.cue.ParkSloth.mapping.dtos.ScheduleDayDto;
import co.edu.cue.ParkSloth.mapping.mappers.ScheduleDayMapper;
import co.edu.cue.ParkSloth.repositories.ParkingLotRepository;
import co.edu.cue.ParkSloth.repositories.ScheduleDayRepository;
import co.edu.cue.ParkSloth.repositories.ScheduleRepository;
import co.edu.cue.ParkSloth.repositories.WeekDayRepository;
import co.edu.cue.ParkSloth.services.ScheduleDayServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleDayServicesImpl implements ScheduleDayServices {

    private final ScheduleDayRepository repository;

    public ScheduleDayServicesImpl(ScheduleDayRepository repository) {
        this.repository = repository;

    }

    @Override
    public List<ScheduleDayDto> list() {
        return ScheduleDayMapper.mapFrom((List<ScheduleDay>) repository.findAll());
    }


    @Override
    public ScheduleDayDto save(ScheduleDayDto scheduleDay) {
        return ScheduleDayMapper.mapFrom(
                repository.save(ScheduleDayMapper.mapFrom(scheduleDay))
        );
    }

    @Override
    public ScheduleDayDto update(ScheduleDayDto scheduleDay) {
        return ScheduleDayMapper.mapFrom(
                repository.save(ScheduleDayMapper.mapFrom(scheduleDay))
        );    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void updateStatus(int id, Character status) {
        ScheduleDay scheduleDay = repository.findById(id).orElseThrow();
        scheduleDay.setStatus(status);
        repository.save(scheduleDay);
    }


}
