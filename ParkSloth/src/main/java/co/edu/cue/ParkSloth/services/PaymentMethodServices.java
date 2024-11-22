package co.edu.cue.ParkSloth.services;

import co.edu.cue.ParkSloth.mapping.dtos.ParkingLotDto;
import co.edu.cue.ParkSloth.mapping.dtos.PaymentMethodDto;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodServices {
    List<PaymentMethodDto> list();
    Optional<PaymentMethodDto> getPaymentMethodById(int id);
    PaymentMethodDto save(PaymentMethodDto paymentMethod);
    PaymentMethodDto update(PaymentMethodDto paymentMethod);
    void delete(int id);
    void updateStatus(int id, Character status);
}
