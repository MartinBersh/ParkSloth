package co.edu.cue.ParkSloth.services.impl;

import co.edu.cue.ParkSloth.domain.entities.PaymentMethod;
import co.edu.cue.ParkSloth.mapping.dtos.PaymentMethodDto;
import co.edu.cue.ParkSloth.mapping.mappers.PaymentMethodMapper;
import co.edu.cue.ParkSloth.repositories.PaymentMethodRepository;
import co.edu.cue.ParkSloth.services.PaymentMethodServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PaymentMethodServicesImpl implements PaymentMethodServices {

    private final PaymentMethodRepository repository;

    public PaymentMethodServicesImpl(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PaymentMethodDto> list() {
        return PaymentMethodMapper.mapFrom((List<PaymentMethod>) repository.findAll());
    }

    @Override
    public Optional<PaymentMethodDto> getPaymentMethodById(int id) {
        return repository.findById(id).map(PaymentMethodMapper::mapFrom);
    }

    @Override
    public PaymentMethodDto save(PaymentMethodDto paymentMethod) {
        return PaymentMethodMapper.mapFrom( repository.save(PaymentMethodMapper.mapFrom(paymentMethod)));
    }

    @Override
    public PaymentMethodDto update(PaymentMethodDto paymentMethod) {
        return PaymentMethodMapper.mapFrom( repository.save(PaymentMethodMapper.mapFrom(paymentMethod)));
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void updateStatus(int id, Character status) {
        PaymentMethod paymentMethod = repository.findById(id).orElseThrow();
        paymentMethod.setStatus(status);
        repository.save(paymentMethod);

    }
}
