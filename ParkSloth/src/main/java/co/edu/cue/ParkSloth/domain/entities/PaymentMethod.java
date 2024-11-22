package co.edu.cue.ParkSloth.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment_methods", schema = "public")
public class PaymentMethod {

    // Identificador único del método de pago, generado automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaymentMethod;

    // Nombre del método de pago.
    private String name;

    // Estado del método de pago (activo/inactivo), representado por un carácter.
    private Character status;
}
