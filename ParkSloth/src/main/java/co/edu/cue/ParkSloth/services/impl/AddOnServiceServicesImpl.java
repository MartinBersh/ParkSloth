package co.edu.cue.ParkSloth.services.impl;

import co.edu.cue.ParkSloth.domain.entities.AddOnService;
import co.edu.cue.ParkSloth.domain.entities.Schedule;
import co.edu.cue.ParkSloth.mapping.dtos.AddOnServiceDto;
import co.edu.cue.ParkSloth.mapping.mappers.AddOnServiceMapper;
import co.edu.cue.ParkSloth.repositories.AddOnServiceRepository;
import co.edu.cue.ParkSloth.services.AddOnServiceServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddOnServiceServicesImpl implements AddOnServiceServices {

    private final AddOnServiceRepository repository;

    public AddOnServiceServicesImpl(AddOnServiceRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<AddOnServiceDto> list() {
        return AddOnServiceMapper.mapFrom((List<AddOnService>)repository.findAll());
    }

    @Override
    public Optional<AddOnServiceDto> getAddOnServiceById(int id) {
        return repository.findById(id).map(AddOnServiceMapper::mapFrom);
    }

    @Override
    public AddOnServiceDto save(AddOnServiceDto addOnService) {
        return AddOnServiceMapper.mapFrom(
                repository.save(AddOnServiceMapper.mapFrom(addOnService))
        );
    }

    @Override
    public AddOnServiceDto update(AddOnServiceDto addOnService) {
        return AddOnServiceMapper.mapFrom(
                repository.save(AddOnServiceMapper.mapFrom(addOnService))
        );
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }
    @Override
    public void updateStatus(int id, Character status) {
        AddOnService addOnService = repository.findById(id).orElseThrow();
        addOnService.setStatus(status);
        repository.save(addOnService);
    }
}
