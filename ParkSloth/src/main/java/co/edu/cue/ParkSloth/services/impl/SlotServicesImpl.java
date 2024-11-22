package co.edu.cue.ParkSloth.services.impl;

import co.edu.cue.ParkSloth.domain.entities.Slot;
import co.edu.cue.ParkSloth.domain.entities.User;
import co.edu.cue.ParkSloth.mapping.dtos.SlotDto;
import co.edu.cue.ParkSloth.mapping.mappers.SlotMapper;
import co.edu.cue.ParkSloth.repositories.SlotRepositoy;
import co.edu.cue.ParkSloth.services.SlotServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotServicesImpl implements SlotServices {

    private final SlotRepositoy repository;

    public SlotServicesImpl(SlotRepositoy repository) {
        this.repository = repository;
    }

    @Override
    public List<SlotDto> list() {
        return SlotMapper.mapFrom((List<Slot>) repository.findAll());
    }

    @Override
    public SlotDto getSlotById(int id) {
        return SlotMapper.mapFrom(repository.findById(id).orElseThrow());
    }

    @Override
    public SlotDto save(SlotDto slot) {
        return SlotMapper.mapFrom(
                repository.save(SlotMapper.mapFrom(slot))
        );
    }

    @Override
    public SlotDto update(SlotDto slot) {
        return SlotMapper.mapFrom(
                repository.save(SlotMapper.mapFrom(slot))
        );    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
    @Override
    public void updateStatus(int id, Character status) {
        Slot slot = repository.findById(id).orElseThrow();
        slot.setStatus(status);
        repository.save(slot);
    }
}
