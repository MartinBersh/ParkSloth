package co.edu.cue.ParkSloth.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reservations", schema = "public")
public class Reservation {

    // Identificador único de la reservación, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;

    // Fecha en la que se realiza la reservación.
    private Date reservationDate;

    // Fecha en la que se realiza el pago de la reservación.
    private Date paymentDate;

    // Fecha de inicio de la reserva.
    private Date startDate;

    // Fecha de fin de la reserva.
    private Date endDate;

    // Relación muchos-a-uno con la entidad User, clave foránea (id_user).
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    // Relación muchos-a-uno con la entidad PaymentMethod, clave foránea (id_payment_method).
    @ManyToOne
    @JoinColumn(name = "id_payment_method")
    private PaymentMethod paymentMethod;

    // Relación muchos-a-uno con la entidad Slot, clave foránea (id_slot).
    @ManyToOne
    @JoinColumn(name = "id_slot")
    private Slot slot;

    // Relación muchos-a-uno con la entidad Fee, clave foránea (id_fee).
    @ManyToOne
    @JoinColumn(name = "id_fee")
    private Fee fee;

    // Estado de la reservación (activo/inactivo), representado por un carácter.
    private Character status;
}
