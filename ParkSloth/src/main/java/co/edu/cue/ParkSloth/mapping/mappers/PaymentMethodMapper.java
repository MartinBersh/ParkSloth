package co.edu.cue.ParkSloth.mapping.mappers;

import co.edu.cue.ParkSloth.domain.entities.PaymentMethod;
import co.edu.cue.ParkSloth.mapping.dtos.PaymentMethodDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;
@Builder
public class PaymentMethodMapper {
    public static PaymentMethodDto mapFrom(PaymentMethod source) {
        return PaymentMethodDto.builder()
                .idPaymentMethod(source.getIdPaymentMethod())
                .name(source.getName())
                .status(source.getStatus())
                .build();
    }

    public static PaymentMethod mapFrom(PaymentMethodDto source) {
        return PaymentMethod.builder()
                .idPaymentMethod(source.idPaymentMethod())
                .name(source.name())
                .status(source.status())
                .build();
    }

    public static List<PaymentMethodDto> mapFrom(List<PaymentMethod> source) {
        return source.stream().map(PaymentMethodMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<PaymentMethod> mapToEntities(List<PaymentMethodDto> source) {
        return source.stream().map(PaymentMethodMapper::mapFrom).collect(Collectors.toList());
    }
}
