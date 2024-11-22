package co.edu.cue.ParkSloth.mapping.dtos;

import lombok.Builder;

@Builder
public record PaymentMethodDto(int idPaymentMethod,
                               String name,
                               Character status) {
}
