package co.edu.cue.ParkSloth.mapping.dtos;

import co.edu.cue.ParkSloth.domain.entities.Fee;
import co.edu.cue.ParkSloth.domain.entities.PaymentMethod;
import co.edu.cue.ParkSloth.domain.entities.Slot;
import co.edu.cue.ParkSloth.domain.entities.User;
import lombok.Builder;

import java.util.Date;

@Builder
public record ReservationDto(int idReservation,
                             Date reservationDate,
                             Date paymentDate,
                             Date startDate,
                             Date endDate,
                             User user,
                             PaymentMethod paymentMethod,
                             Slot slot,
                             Fee fee,
                             Character status) {
}
